package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.DatabaseConnection;

public class ExercisesController {
	@FXML private TextField txtSearch;
	@FXML private ListView<String> listExercises;
	@FXML private Label lblExerciseName;
	@FXML private Label lblMuscleGroup;
	@FXML private Label lblInstructions;
	@FXML private ImageView imgExerciseGif;

public void initialize() {
	loadExercisesFromDB();
	
	setupSearchFilter();
	
	listExercises.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            
            showExerciseDetails(newValue);
        }
    });
}

private void loadExercisesFromDB() {
	ObservableList<String> exerciseList = FXCollections.observableArrayList();
	String sql = "SELECT exercise_name FROM exercises ORDER BY exercise_name ASC" ;
	
	try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			exerciseList.add(rs.getString("exercise_name"));
		}
		listExercises.setItems(exerciseList);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

private void setupSearchFilter() {
	FilteredList<String> filteredData = new FilteredList<>(listExercises.getItems(), p -> true);
	
	txtSearch.textProperty().addListener((obsevable , oldValue, newValue)->{
		
		filteredData.setPredicate(exercise -> {		
			if (newValue == null || newValue.trim().isEmpty()) {
                return true;
            }
			String lowerCaseFilter = newValue.toLowerCase();
			
			if (exercise.toLowerCase().contains(lowerCaseFilter)) {
                return true; 
            }
			
			return false;
		});
	});
	listExercises.setItems(filteredData);
}

private void showExerciseDetails(String exerciseName) {
	lblExerciseName.setText(exerciseName);
	
	String sql = "SELECT muscle_group, description, tips FROM exercises WHERE exercise_name = ?";
	
	try(Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
		
		pstmt.setString(1, exerciseName);
		
		try (ResultSet rs = pstmt.executeQuery()) {
			
            if (rs.next()) {
           
            	String muscleGroup = rs.getString("muscle_group");
                lblMuscleGroup.setText(muscleGroup != null ? muscleGroup : "-");
                
                String description = rs.getString("description");
                String tips = rs.getString("tips");
                
                if (description == null) description = "Bu hareket için açıklama eklenmemiş.";
                if (tips == null) tips = "Bu hareket için ipucu eklenmemiş.";
                
                lblInstructions.setText(description + "\n\n İpucu: " + tips);
            } else {
             
                lblMuscleGroup.setText("-");
                lblInstructions.setText("Hareket detayları bulunamadı.");
            }
        }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	lblInstructions.setText(exerciseName + " hareketi için doğru duruş formu, nefes kontrolü ve uygulanması gereken teknik detaylar yakında eklenecektir.");
	
	String formattedName = exerciseName.toLowerCase().replace(" ", "_");

		
			String gifPath = "/gifs/" + formattedName + ".gif";
			try {
				Image exerciseGif = new Image(getClass().getResourceAsStream(gifPath));
				imgExerciseGif.setImage(exerciseGif);
			} catch (Exception e) {
			    imgExerciseGif.setImage(null); 
			}
}


}
