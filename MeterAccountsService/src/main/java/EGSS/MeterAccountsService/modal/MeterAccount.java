package EGSS.MeterAccountsService.modal;

public class MeterAccount {
	private String accNo;
	private String install_address;
	private String install_date;
	private String macc;
	private int status;
	private int createBy;
	private int userId;
	
	
	public MeterAccount(String accNo, String install_address, String install_date, String macc, int status,
			int createBy, int userId, String createDate, int modifiedBy, String modifiedDate) {
		super();
		this.accNo = accNo;
		this.install_address = install_address;
		this.install_date = install_date;
		this.macc = macc;
		this.status = status;
		this.createBy = createBy;
		this.userId = userId;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	private String createDate;
	private int modifiedBy;
	private String modifiedDate;

	public MeterAccount() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MeterAccount(String accNo, String install_address, String install_date, String macc, int status,
			int createBy, String createDate, int modifiedBy, String modifiedDate) {
		super();
		this.accNo = accNo;
		this.install_address = install_address;
		this.install_date = install_date;
		this.macc = macc;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getInstall_address() {
		return install_address;
	}

	public void setInstall_address(String install_address) {
		this.install_address = install_address;
	}

	public String getInstall_date() {
		return install_date;
	}

	public void setInstall_date(String install_date) {
		this.install_date = install_date;
	}

	public String getMacc() {
		return macc;
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
