package model;

public class RegisterInfo {
	String account,imei,phone,cid,acc_type;
	
	
	public String getAccount() {
		return account;
	}
	
	public String getImei() {
		return imei;
	}
	
	public String getPhone() {
		return phone;
	}
	
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	public void setPhone(String phone) { this.phone = phone;}
	
	public String getCID() {
		return this.cid;
	}
	
	public void setCID(String cid) {
		this.cid = cid;
	}
	
	public String getAcctype() {
		return this.acc_type;
	}
	
	public void setAcctype(String type) {
		this.acc_type = type;
	}
	
	public RegisterInfo(String imei,String phone) {
		this.imei = imei;
		this.phone = phone;
	}
	
	
	public RegisterInfo(String account,String cid,String acctype) {
		this.account = account;
		this.cid = cid;
		this.acc_type = acctype;
	}
	
}
