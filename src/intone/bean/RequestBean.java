package intone.bean;

public class RequestBean {
	private int reqid;
	private int userid;
	private String requestdate;
	private int requestedspace;
	private int allocatedspace;
	private String request;
	
	public int getReqid() {
		return reqid;
	}
	public void setReqid(int reqid) {
		this.reqid = reqid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	public int getRequestedspace() {
		return requestedspace;
	}
	public void setRequestedspace(int requestedspace) {
		this.requestedspace = requestedspace;
	}
	public int getAllocatedspace() {
		return allocatedspace;
	}
	public void setAllocatedspace(int allocatedspace) {
		this.allocatedspace = allocatedspace;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	
	
	

}
