package models;
import java.time.LocalDate;

public class TrainingLog {

	private int id;
    private LocalDate trainingDate; 
    private String dayName;
    private String muscleGroup;
	private String exerciseName;
    private int setCount;
    private double liftedWeight;
    
    public TrainingLog(int id, LocalDate trainingDate, String dayName, String muscleGroup, String exerciseName,
			int setCount, double liftedWeight) {
		super();
		this.id = id;
		this.trainingDate = trainingDate;
		this.dayName = dayName;
		this.muscleGroup = muscleGroup;
		this.exerciseName = exerciseName;
		this.setCount = setCount;
		this.liftedWeight = liftedWeight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(LocalDate trainingDate) {
		this.trainingDate = trainingDate;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public int getSetCount() {
		return setCount;
	}

	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	public double getLiftedWeight() {
		return liftedWeight;
	}

	public void setLiftedWeight(double liftedWeight) {
		this.liftedWeight = liftedWeight;
	}
    
    
}


