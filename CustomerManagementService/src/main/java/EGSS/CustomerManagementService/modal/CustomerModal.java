package EGSS.CustomerManagementService.modal;

import java.sql.Date;

public class CustomerModal {
	
	private int id;
	private String firstName;
	private String lastName;
	private String NIC;
	private String email;
	private String Street;
	private String state;
	private String postalCode;
	private boolean status;
	private int createdBy;
	private Date createdDate;
	private int modifiedBy;
	private Date modifiedDate;
	public CustomerModal() {
		super();
	}
	public CustomerModal(int id, String firstName, String lastName, String nIC, String email, String street,
			String state, String postalCode, boolean status, int createdBy, Date createdDate, int modifiedBy,
			Date modifiedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		NIC = nIC;
		this.email = email;
		Street = street;
		this.state = state;
		this.postalCode = postalCode;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
}
