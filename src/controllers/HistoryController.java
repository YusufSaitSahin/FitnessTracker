package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.WorkoutSet;
import utils.DatabaseConnection;

public class HistoryController {
	@FXML DatePicker datePicker;
	@FXML
    private TableView<WorkoutSet> tableHistory;
    @FXML
    private TableColumn<WorkoutSet, String> colExercise;
    @FXML
    private TableColumn<WorkoutSet, Integer> colSetNum;
    @FXML
    private TableColumn<WorkoutSet, Integer> colReps;
    @FXML
    private TableColumn<WorkoutSet, Double> colWeight;
    @FXML
    private ObservableList<WorkoutSet> historyData = FXCollections.observableArrayList();
    
    public void initialize() {
		colExercise.setCellValueFactory(new PropertyValueFactory<>("exercise"));
		colSetNum.setCellValueFactory(new PropertyValueFactory<>("setNum"));
		colReps.setCellValueFactory(new PropertyValueFactory<>("reps"));
		colWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
		
		tableHistory.setItems(historyData);
	}
   public void handleSearch(ActionEvent event) {
	   LocalDate selectedDate = datePicker.getValue();
	   if (selectedDate == null) {
	        System.out.println("Lütfen önce bir tarih seçin!");
	        return;
	    }
	   
	   String sql = "SELECT d.exercise_name, d.set_number, d.reps, d.weight " +
	             "FROM workout_sessions s " +
	             "JOIN workout_details d ON s.session_id = d.session_id " +
	             "WHERE s.log_date = ?";
	   
	   try (Connection conn = DatabaseConnection.getConnection();
               PreparedStatement pstmt = conn.prepareStatement(sql)){
		   pstmt.setDate(1, java.sql.Date.valueOf(selectedDate));
		  
		   ResultSet rs = pstmt.executeQuery();
		   historyData.clear();
		   
		   while(rs.next()) {
			   String exercise = rs.getString("exercise_name");
			    int setNum = rs.getInt("set_number");
			    int reps = rs.getInt("reps");
			    double weight = rs.getDouble("weight");
			    
			    WorkoutSet gecmisSet = new WorkoutSet(exercise, setNum, reps, weight);
			    historyData.add(gecmisSet);
			    
		   }
	   }
	   
	   catch(Exception e) {
		   
	   }
   }
}
