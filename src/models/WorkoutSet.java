package models;

public class WorkoutSet {

	private String exercise;
	private int setNum;
	private int reps;
	private double weight;
	
	public WorkoutSet(String exercise ,int setNum, int reps, double weight ) {
		this.exercise = exercise;
		this.setNum = setNum;
		this.reps = reps;
		this.weight = weight;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public int getSetNum() {
		return setNum;
	}

	public void setSetNum(int setNum) {
		this.setNum = setNum;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
