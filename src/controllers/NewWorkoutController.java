package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import utils.DatabaseConnection;

public class NewWorkoutController  {
@FXML 
private DatePicker datePicker;
@FXML
private Button btnPush;
@FXML
private Button btnPull;
@FXML
private Button btnLegs;
@FXML
private Button btnFullBody;


public void handleWorkoutSelection(ActionEvent event){
	LocalDate selectedDate = datePicker.getValue();
    if (selectedDate == null) {
        System.out.println("Lütfen önce bir tarih seçin!");
        return;
    }
    
    Button clickedButton = (Button) event.getSource();
    String workoutType = clickedButton.getText();
    int sessionId = -1;
    
    System.out.println("Seçilen Tarih: " + selectedDate);
    System.out.println("Seçilen Antrenman: " + workoutType);
    
    String sql = "INSERT INTO workout_sessions (log_date, workout_type) VALUES (?, ?)";
    
    try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)){
    	
    	pstmt.setDate(1, java.sql.Date.valueOf(selectedDate));
    	pstmt.setString(2, workoutType);
    	
    	pstmt.executeUpdate();
    	System.out.println("Entry is successful");
    	
    	
    	
    	ResultSet rs = pstmt.getGeneratedKeys();
    	if (rs.next()) {
    	    sessionId = rs.getInt(1); 
    	    System.out.println("Harika! Bu antrenmanın ID'si: " + sessionId);
    	}
    	rs.close();
        pstmt.close();
        conn.close();
    }
    catch(Exception e){
    	System.out.println("Database Error: " + e.getMessage());
    	return;
    }
    if (sessionId != -1) {
        try {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/WorkoutDetails.fxml"));
            Parent view = loader.load();

     
            WorkoutDetailsController detailsController = loader.getController();
            detailsController.setSessionData(sessionId, workoutType);

       
            Scene currentScene = ((Node) event.getSource()).getScene();
            BorderPane mainPane = (BorderPane) currentScene.getRoot();
            mainPane.setCenter(view);

        } catch (Exception e) {
            System.out.println("FXML Yükleme Hatası: Ekran açılamadı!");
            e.printStackTrace();
        }
    }
}

}
