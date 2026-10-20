package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.WorkoutSet;
import utils.DatabaseConnection;

public class ActiveRoutineController {
	@FXML private TableView<WorkoutSet> tableRoutine;
	@FXML private TableColumn<WorkoutSet, String> colExercise;
    @FXML private TableColumn<WorkoutSet, Integer> colSet;
    @FXML private TableColumn<WorkoutSet, Integer> colReps;
    @FXML private TableColumn<WorkoutSet, Double> colWeight;
    
    @FXML private Button btnFinishWorkout;
    
    public void initialize() {
    	colExercise.setCellValueFactory(new PropertyValueFactory<>("exercise"));
		colSet.setCellValueFactory(new PropertyValueFactory<>("setNum"));
		 
		tableRoutine.setEditable(true);
		
		colReps.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		colWeight.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		
		
    }
    
    public void finishWorkout(ActionEvent event) {
    
    }
    
    public void loadRoutineData(String routineType) {
    	ObservableList<WorkoutSet> routineList = FXCollections.observableArrayList();
    	
    	String sql = "";
    	
    	if(routineType.equals("PUSH")) {
    		sql ="SELECT exercise_name FROM exercises WHERE exercise_name IN ('Chest Press Machine', 'Pec Deck Fly', 'Incline Dumbbell', 'Shoulder Press', 'Lateral Raise', 'Cable Rear Delt Fly', 'Straight Arm Pulldown', 'Dips Machine')";
    		
    	}
    	else if(routineType.equals("PULL")) {
    		sql = "SELECT exercise_name FROM exercises WHERE exercise_name IN ('Lat Pull Down', 'Seated Cable Row', 'Dumbbell Row', 'Straight Arm Pulldown', 'Rope Hammer Curl', 'Dumbbell Curl', 'Scott Curl')";
    	}
    	try(Connection conn = DatabaseConnection.getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql)){
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			String name = rs.getString("exercise_name");
    			for (int i = 1; i <= 2; i++) {   		       
    		        routineList.add(new WorkoutSet(name, i, 0, 0));
    		    }
    		}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	tableRoutine.setItems(routineList);
    }
}
