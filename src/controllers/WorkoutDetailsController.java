package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import models.WorkoutSet;
import utils.DatabaseConnection;

public class WorkoutDetailsController {

	
	@FXML private Label lblWorkoutTitle;
	@FXML private TextField txtSearchExercise;
	@FXML private ListView<String> listExerciseSuggestions;
    @FXML private TextField txtReps;
    @FXML private TextField txtWeight;
    @FXML private Button btnAddSet;
    @FXML private Button btnReadyRoutine;
    
    private List<String> masterExerciseList = new ArrayList<>();
    @FXML
    private TableView<WorkoutSet> tableSets;
    @FXML
    private TableColumn<WorkoutSet, String> colExercise;
    @FXML
    private ObservableList<WorkoutSet> tableData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<WorkoutSet, Integer> colSetNum;
    @FXML
    private TableColumn<WorkoutSet, Integer> colReps;
    @FXML
    private TableColumn<WorkoutSet, Double> colWeight;
	private int currentSessionId;
	@FXML private Label lblLastRecord;
	
	private void fetchLastRecord(String exerciseName) {
		String sql = "SELECT weight, reps FROM workout_details WHERE exercise_name = ? ORDER BY detail_id DESC LIMIT 1";
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
		
			pstmt.setString(1, exerciseName);
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					double lastWeight = rs.getDouble("weight");
	                int lastReps = rs.getInt("reps");
	                
	                lblLastRecord.setText("Last time: " + lastWeight + "kg x " + lastReps);
				}
				else {
	                lblLastRecord.setText("Last Record: None");
			}
		}
			
	}
		catch(SQLException e) {
			System.out.println("Geçmiş rekor çekilirken veritabanı hatası oluştu!");
	        e.printStackTrace();
	        lblLastRecord.setText("Last Record: Error");
		}
	}
	private void loadExercisesFromDatabase() {
		String sql = "SELECT exercise_name FROM exercises ORDER BY exercise_name ASC";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
		
			
			while(rs.next()) {
				masterExerciseList.add(rs.getString("exercise_name"));
			}
			System.out.println("Hareket kütüphanesi yüklendi! Toplam hareket: " + masterExerciseList.size());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void initialize() {
		loadExercisesFromDatabase();
		
		colExercise.setCellValueFactory(new PropertyValueFactory<>("exercise"));
		colSetNum.setCellValueFactory(new PropertyValueFactory<>("setNum"));
		colReps.setCellValueFactory(new PropertyValueFactory<>("reps"));
		colWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));
		
		tableSets.setItems(tableData);
		
		txtSearchExercise.textProperty().addListener((observable, oldValue, newValue) -> {
	        if (newValue.trim().isEmpty()) {
	            listExerciseSuggestions.setVisible(false);
	        } else {
	           List<String> filteredList = new ArrayList<>();
	            
	            for (String exercise : masterExerciseList) {
	              
	                if (exercise.toLowerCase().contains(newValue.toLowerCase())) {
	                    filteredList.add(exercise); 
	                }
	            }
	            listExerciseSuggestions.getItems().setAll(filteredList);
	            listExerciseSuggestions.setVisible(true);
	          
	        }
	    });
		listExerciseSuggestions.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
		    if (newVal != null) {
		        
		        // Tüm işlemleri JavaFX'in kendi tıklama animasyonları bittikten sonraya (sıraya) erteliyoruz.
		        javafx.application.Platform.runLater(() -> {
		            
		            // 1. Yazıyı değiştir (Eğer bu işlem arka planda listeyi boşaltıyorsa bile artık çökmeyecek)
		            txtSearchExercise.setText(newVal);
		            
		            // 2. Son rekoru getir
		            fetchLastRecord(newVal);
		            
		            // 3. Seçimi kaldır ve gizle
		            listExerciseSuggestions.getSelectionModel().clearSelection(); 
		            listExerciseSuggestions.setVisible(false); 
		        });
		    }
		});
	}
	
	public void setSessionData(int sessionId, String workoutType) {
		
		this.currentSessionId = sessionId;
		lblWorkoutTitle.setText(workoutType + " WORKOUT");
		System.out.println("Yeni sayfaya ID başarıyla ulaştı: " + currentSessionId);
	}
	@FXML
	public void handleAddSet(ActionEvent event) {
		String exercise = txtSearchExercise.getText();
	    
	    // Set numarasını kullanıcının girdiği kutudan almak yerine tablodan otomatik sayıyoruz
	    int setNum = 1; 
	    for (WorkoutSet w : tableData) {
	        // Eğer tablodaki hareket adı, şu anki hareket adıyla aynıysa seti 1 artır
	        if (w.getExercise().equals(exercise)) {
	            setNum++;
	        }
	    }
			int reps = Integer.parseInt(txtReps.getText());
			double weight = Double.parseDouble(txtWeight.getText());
			
			String sql = "INSERT INTO workout_details (session_id, exercise_name, set_number, reps, weight) VALUES (?, ?, ?, ?, ?)";
			
			try (Connection conn = DatabaseConnection.getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				pstmt.setInt(1, currentSessionId);
				pstmt.setString(2, exercise);
				pstmt.setInt(3, setNum);
				pstmt.setInt(4, reps);
				pstmt.setDouble(5, weight);
				
				pstmt.executeUpdate();
				System.out.println("Başarılı: " + setNum + ". Set kaydedildi!");
				
				WorkoutSet yeniSet = new WorkoutSet(exercise, setNum, reps, weight);
				tableData.add(yeniSet);
				txtReps.setText("");
				txtWeight.setText("");
	          
	            
	            pstmt.close();
	            conn.close();
			}
			catch (NumberFormatException e) {
	            System.out.println("Hata: Lütfen set, tekrar ve ağırlık kısımlarına sadece sayı girin!");
	        } catch (SQLException e) {
	            System.out.println("Veritabanı Hatası: Set kaydedilemedi.");
	            e.printStackTrace();
	        }
	}
	
	public void openActiveRoutine(ActionEvent event) {
try {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ActiveRoutine.fxml"));
    Parent root = loader.load();
    
    ActiveRoutineController controller = loader.getController();
    
    controller.loadRoutineData("PUSH");
    
    BorderPane mainPane = (BorderPane) btnReadyRoutine.getScene().getRoot();
    mainPane.setCenter(root);
   
}
catch (Exception e) {
    e.printStackTrace();
}
	}
	
	@FXML
    public void handleFinish(ActionEvent event) {
		int totalSets = tableData.size();
		double totalVolume = 0;
		
		for (WorkoutSet set : tableData) {
	        totalVolume += (set.getReps() * set.getWeight());
	    }
		Alert alert = new javafx.scene.control.Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Workout Summary");
	    alert.setHeaderText("Congratulations! Great workout.");
	    alert.setContentText("Total Sets Completed: " + totalSets + "\nTotal Volume Lifted: " + totalVolume + " kg");
	    alert.showAndWait();
		
        System.out.println("Tebrikler! Antrenman başarıyla tamamlandı.");
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Dashboard.fxml"));
        Parent view = loader.load();
        Scene currentScene = ((Node) event.getSource()).getScene();
        
        currentScene.setRoot(view);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
