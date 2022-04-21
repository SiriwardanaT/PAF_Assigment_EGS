package EGSS.CunsumptionManagementSystem.modal;

public class Consumption {
	
	private String id;
	private double units;
	private String date;
	private double unitPrice;
	private int lastReading;
	private int curruntReading;
	private String macc;
	private int status;
	private int createBy;
	private String createDate;
	private int modifiedBy;
	private String modifiedDate;
	
	
	

	public Consumption() {
		super();
		
	}

	public Consumption(String id, double units, String date, double unitPrice, int lastReading, int curruntReading,
			String macc, int status, int createBy, String createDate, int modifiedBy, String modifiedDate) {
		super();
		this.id = id;
		this.units = units;
		this.date = date;
		this.unitPrice = unitPrice;
		this.lastReading = lastReading;
		this.curruntReading = curruntReading;
		this.macc = macc;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public Consumption(double units, String date, double unitPrice, int lastReading, int curruntReading, String macc,
			int status, int createBy, String createDate, int modifiedBy, String modifiedDate) {
		super();
		this.units = units;
		this.date = date;
		this.unitPrice = unitPrice;
		this.lastReading = lastReading;
		this.curruntReading = curruntReading;
		this.macc = macc;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getLastReading() {
		return lastReading;
	}

	public void setLastReading(int lastReading) {
		this.lastReading = lastReading;
	}

	public int getCurruntReading() {
		return curruntReading;
	}

	public void setCurruntReading(int curruntReading) {
		this.curruntReading = curruntReading;
	}

	public String getMacc() {
		return this.macc;
	}

	public void setMacc(String macc) {
		this.macc = macc;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	
	

}
