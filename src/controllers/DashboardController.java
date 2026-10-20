package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DashboardController {

	@FXML
    private Button btnDashboard;
    @FXML
    private Button btnNewWorkout;
    @FXML
    private Button btnSupplements;
    @FXML
    private Button btnSettings;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button btnHistory;
    @FXML
    private Button btnExercises;
    
   public void initialize() {
	   try{
   		Parent view = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
       	mainPane.setCenter(view);
   	}
   	catch(Exception e) {
   		e.printStackTrace();
   	}
       System.out.println("Dashboard ekranı açılıyor...");
   }
    
public void handleMenuClick(ActionEvent event) {
        
       
        if (event.getSource() == btnDashboard) {
        	
        	try{
        		Parent view = FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
            	mainPane.setCenter(view);
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
            System.out.println("Dashboard ekranı açılıyor...");
          
            
        } else if (event.getSource() == btnNewWorkout) {
            try {
            	Parent view = FXMLLoader.load(getClass().getResource("/views/NewWorkout.fxml"));
            	mainPane.setCenter(view);
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            
        } else if (event.getSource() == btnSupplements) {
        	try {
        		Parent view = FXMLLoader.load(getClass().getResource("/views/Supplements.fxml"));
        		mainPane.setCenter(view);
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
            
        } else if (event.getSource() == btnSettings) {
            System.out.println("Ayarlar ekranı açılıyor...");
        }
        
        else if (event.getSource() == btnHistory) { 
            try {
                Parent view = FXMLLoader.load(getClass().getResource("/views/History.fxml"));
                mainPane.setCenter(view);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(event.getSource() == btnExercises) {
        	try {
        		Parent view = FXMLLoader.load(getClass().getResource("/views/Exercises.fxml"));
                mainPane.setCenter(view);
        	}
        	 catch(Exception e) {
                 e.printStackTrace();
             }
        }
    }

	
}
