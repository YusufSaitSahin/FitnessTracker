package models;

public class UserProfile {
	private int id;
	private String selectedProgram;
	private double currentWeight;
	private double targetWeight;
	
	public UserProfile(int id ,String selectedProgram , double currentWeight , double targetWeight) {
		this.id = id ; 
		this.selectedProgram = selectedProgram;
		this.currentWeight = currentWeight;
		this.targetWeight  = targetWeight;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelectedProgram() {
		return selectedProgram;
	}

	public void setSelectedProgram(String selectedProgram) {
		this.selectedProgram = selectedProgram;
	}

	public double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public double getTargetWeight() {
		return targetWeight;
	}

	public void setTargetWeight(double targetWeight) {
		this.targetWeight = targetWeight;
	};
	
	
}
