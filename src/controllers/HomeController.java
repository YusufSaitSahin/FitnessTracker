package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeController {
	 	@FXML private VBox paneOverview;
	 	@FXML private HBox paneStats;
	    @FXML private Button btnTabOverview;
	    @FXML private Button btnTabStats;
	    @FXML private Label lblLastWorkoutType;
	    @FXML private Label lblLastWorkoutVolume;
	    @FXML private LineChart<?, ?> progressChart;
	    
	    public void switchTab(ActionEvent event) {
			if(event.getSource() == btnTabOverview) {
				paneOverview.setVisible(true);
				paneStats.setVisible(false);
				btnTabOverview.getStyleClass().add("tab-button-active");
				btnTabStats.getStyleClass().remove("tab-button-active");
			}
			else if(event.getSource() == btnTabStats) {
				paneOverview.setVisible(false);
				paneStats.setVisible(true);
				btnTabOverview.getStyleClass().remove("tab-button-active");
				btnTabStats.getStyleClass().add("tab-button-active");
			}
			
		}
}
