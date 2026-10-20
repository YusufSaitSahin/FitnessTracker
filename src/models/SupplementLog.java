package models;
import java.time.LocalDate;

public class SupplementLog {
	private int id;
    private LocalDate logDate;
    private boolean wheyTaken;
    private boolean creatineTaken;
    private boolean vitDTaken;
    private boolean fishOilTaken;
    
	public SupplementLog(int id, LocalDate logDate, boolean wheyTaken, boolean creatineTaken, boolean vitDTaken,
			boolean fishOilTaken) {
		this.id = id;
		this.logDate = logDate;
		this.wheyTaken = wheyTaken;
		this.creatineTaken = creatineTaken;
		this.vitDTaken = vitDTaken;
		this.fishOilTaken = fishOilTaken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getLogDate() {
		return logDate;
	}

	public void setLogDate(LocalDate logDate) {
		this.logDate = logDate;
	}

	public boolean isWheyTaken() {
		return wheyTaken;
	}

	public void setWheyTaken(boolean wheyTaken) {
		this.wheyTaken = wheyTaken;
	}

	public boolean isCreatineTaken() {
		return creatineTaken;
	}

	public void setCreatineTaken(boolean creatineTaken) {
		this.creatineTaken = creatineTaken;
	}

	public boolean isVitDTaken() {
		return vitDTaken;
	}

	public void setVitDTaken(boolean vitDTaken) {
		this.vitDTaken = vitDTaken;
	}

	public boolean isFishOilTaken() {
		return fishOilTaken;
	}

	public void setFishOilTaken(boolean fishOilTaken) {
		this.fishOilTaken = fishOilTaken;
	}
	
    
}
