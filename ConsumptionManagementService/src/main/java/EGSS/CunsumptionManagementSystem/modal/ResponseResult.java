package EGSS.CunsumptionManagementSystem.modal;

public class ResponseResult {
     private String output;
     private int Statuscode;
	public ResponseResult(String output, int statuscode) {
		super();
		this.output = output;
		Statuscode = statuscode;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public int getStatuscode() {
		return Statuscode;
	}
	public void setStatuscode(int statuscode) {
		Statuscode = statuscode;
	}
	
     
     
}
