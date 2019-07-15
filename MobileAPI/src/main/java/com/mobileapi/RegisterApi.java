package com.mobileapi;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import daoProcess.CustomerInfoDAO;

import model.DataResponse;
import model.RegisterInfo;
import operationProcess.EncodeDecode;


@Controller
public class RegisterApi {
	
	Date d = new Date();
	
	@RequestMapping(value="/Hello", method = RequestMethod.GET)
	@ResponseBody
	public String TestApi(){		
		///test new branch	and new office 
		/// new branch
		
		return "HelloWorld";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/Mobileapi/getInfo", method = RequestMethod.POST)
	public DataResponse info (@RequestParam("PhoneNum") String PhoneNum,
									@RequestParam("Imei") String Imei) throws Exception{
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(d.toString()+ ": --->Request getAccountInfo =" + PhoneNum );
		
		
		ArrayList<RegisterInfo> data = new ArrayList<RegisterInfo>();
		data.add(new RegisterInfo(Imei,PhoneNum));
	
		
		DataResponse responsemodel = new DataResponse();		
		responsemodel.setResponsecode("00");
		responsemodel.setSuccess("Successful");
		responsemodel.setModel(data);
		
		return responsemodel;
	}
	
	@ResponseBody
	@RequestMapping(value="/Mobileapi/getInformation/", method = RequestMethod.POST)
	public DataResponse information(@RequestParam("AccNumber") String accnumber) throws Exception{
		
		
		
		EncodeDecode code = new EncodeDecode();
		String acc = code.decryptText(accnumber);
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(d.toString()+ ": ------------------------------>Request Account No : " + accnumber );
		
		
		CustomerInfoDAO dao = new CustomerInfoDAO();
		DataResponse responsemodel = new DataResponse();
		
		List<RegisterInfo> register = new ArrayList<RegisterInfo>();
		register = dao.verifyAccountNumber(acc);
		
		if (dao.verifyMobileBanking(acc) != true) {
			
			if (register.isEmpty() != true) {
				
				dao.insertObject(register);
						
				responsemodel.setResponsecode("00");
				responsemodel.setSuccess("succesful");
				responsemodel.setModel(register);
				
				System.out.println(d.toString()+ ": ------------------------------>Request Account No : " + acc );
				
			}else {
				
				responsemodel.setResponsecode("01");
				responsemodel.setSuccess("Account Not corrrect");
				responsemodel.setModel(register);
				
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println(d.toString()+ ": ------------------------>Request Account Not correct :" + " " + acc.toString());
			}
			
		}else {
			
			responsemodel.setResponsecode("02");
			responsemodel.setSuccess("Account existing");
			responsemodel.setModel(register);
			
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println(d.toString()+ ": ------------------------>Request Account existing :" + " " + acc.toString());
		}
		
		return responsemodel;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/MobileAPI/OracleConnection")
	public String getConnectionOracle() {
		
		
		CustomerInfoDAO info = new CustomerInfoDAO();	
		
		try {
			info.testOracleConnection();
			System.out.println("--------------------------------- Connection Oracle open --------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();			
		}
		
		return "Connection oracle open";
	}
	
	@ResponseBody
	@RequestMapping(value="/MobileAPI/sqlConnection")
	public String getConnectionSQL() {
		
		CustomerInfoDAO info = new CustomerInfoDAO();
		
		try {
			info.tesSqlConnection();
			System.out.println("--------------------------------- Connection Sql open --------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("--------------------------------- Connection Error --------------------------------------------------");
		}
		
		return "Connection sql open";
	}
	
	@ResponseBody
	@RequestMapping(value="/MobileAPI/IbankingConnection")
	public String getIbankingOracle() {
		
		CustomerInfoDAO info = new CustomerInfoDAO();
		
		try {
			info.testIbankingConnection();
			System.out.println("--------------------------------- Connection I-banking open --------------------------------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "Connection I-banking open";
	}
	
}











































