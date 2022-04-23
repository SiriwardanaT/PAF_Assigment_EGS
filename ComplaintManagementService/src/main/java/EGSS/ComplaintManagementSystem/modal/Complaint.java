package EGSS.ComplaintManagementSystem.modal;

public class Complaint {

	private String id;
	private String subject;
	private String content;
	private int uid;
	private String status;
	private int createBy;
	private String createDate;
	private int modifiedBy;
	private String modifiedDate;
	
	public Complaint() {
		super();
	}
		
	public Complaint(String id, String subject, String content, int uid, String status, int createBy, String createDate, int modifiedBy, String modifiedDate)
	{
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.uid = uid;
		this.status = status;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

