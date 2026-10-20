package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class SupplementController {
	@FXML
	private DatePicker datePicker;
	@FXML
    private CheckBox chkWhey;
    @FXML
    private CheckBox chkCreatine;
    @FXML
    private CheckBox chkVitD;
    @FXML
    private CheckBox chkFishOil;
	
	public void handleSave(ActionEvent event) {
		LocalDate selectedDate = datePicker.getValue();
		if(selectedDate == null) {
			System.out.println("Please select a date!");
			return;
		}
		boolean whey = chkWhey.isSelected();
        boolean creatine = chkCreatine.isSelected();
        boolean vitD = chkVitD.isSelected();
        boolean fishOil = chkFishOil.isSelected();
        
        String sql = "INSERT INTO supplement_log (log_date, whey_taken, creatine_taken, vit_d_taken, fish_oil_taken) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
        	
        	pstmt.setDate(1, java.sql.Date.valueOf(selectedDate));
            pstmt.setBoolean(2, whey);
            pstmt.setBoolean(3, creatine);
            pstmt.setBoolean(4, vitD);
            pstmt.setBoolean(5, fishOil);
            
            pstmt.executeUpdate();
            System.out.println("Entry is Successful");
        }
        
        catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
	}
	
}
