package EGSS.CustomerManagementService.modal;

import java.sql.Date;

public class CustomerModal {
	
	public int id;
	private String firstName;
	private String lastName;
	private String nic;
	public String email;
	private String Street;
	private String state;
	private String postalCode;
	private boolean status;
	private int createBy;
	private String createDate;
	private int modifiedBy;
	private String modifiedDate;
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	private String role;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerModal() {
		super();
	}
	public CustomerModal(int id, String firstName, String lastName, String nic, String email, String Street,
			String state, String postalCode, boolean status, int createBy, String createDate, int modifiedBy,
			String modifiedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.email = email;
		this.Street = Street;
		this.state = state;
		this.postalCode = postalCode;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	
	
	public CustomerModal(int id) {
		super();
		this.id = id;
	}
	public CustomerModal(String firstName, String lastName, String nic, String email, String Street, String state,
			String postalCode, boolean status) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.email = email;
		this.Street = Street;
		this.state = state;
		this.postalCode = postalCode;
		this.status = status;
		// TODO Auto-generated constructor stub
	}
	
	public CustomerModal(int id , String firstName, String lastName, String nic, String email, String Street, String state,
			String postalCode) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.email = email;
		this.Street = Street;
		this.state = state;
		this.postalCode = postalCode;
		this.status = status;
	}
	
	
	public CustomerModal(int id, String role) {
		super();
		this.id = id;
		this.role = role;
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
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
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
	public void setStreet(String Street) {
		this.Street = Street;
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
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreatedDate(String createDate) {
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
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole() {
		
		return role;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
