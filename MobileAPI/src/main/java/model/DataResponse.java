package model;

import java.util.List;

public class DataResponse {
	
	public String success;
	public String respCode;
	public List<RegisterInfo> info;
	

	
	public void setSuccess(String sucess) { 
		this.success = sucess;
	}
	
	public void setResponsecode(String respCode) {
		this.respCode = respCode;
	}
	
	public String setSuccess() {
		return success;
	}
	
	public String setRespcode() {
		return respCode;
	}
	

	public void setModel (List<RegisterInfo> infor){
		this.info = infor;
	}
	
//	public List<RegisterInfo> getModel() {
//		return info;
//	}
	
//	public DataResponse(String succ,String resp,List<RegisterInfo> info) {
//		this.success = succ;
//		this.respCode = resp;
//		this.info = info;
//	}

}
