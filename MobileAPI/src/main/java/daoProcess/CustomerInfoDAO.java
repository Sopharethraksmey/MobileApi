package daoProcess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbConnection.ClsConnDB;
import model.RegisterInfo;


public class CustomerInfoDAO {
	
	Connection con = null;
	PreparedStatement ps_stmt=null;
	ResultSet rs = null;
	
	String account = "";
	String cid = "";
	String accounttype = "";
	
	public void testOracleConnection() {
		
		try {
			con = ClsConnDB.OpenConnectionToOracleDatabase();			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void tesSqlConnection() {
		try {
			con = ClsConnDB.OpenConnectionToDatabaseSQLServer();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testIbankingConnection() {
		try {
			con = ClsConnDB.OpenConnectionToIBankingOracleDatabase();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<RegisterInfo> verifyAccountNumber(String number) {
		

		ArrayList<RegisterInfo> data = new ArrayList<RegisterInfo>();
			
		String sql = "select ACCOUNT_STR,CID,ACCOUNT_TYPE from ACCOUNTSUMMARY where ACCOUNT_STR=?";
		
		
		try {
			con = ClsConnDB.OpenConnectionToOracleDatabase();
			
			ps_stmt = con.prepareStatement(sql);
			ps_stmt.setString(1, number);
			rs = ps_stmt.executeQuery();
			
			while(rs.next()) {
				
				this.account = rs.getString("ACCOUNT_STR");
				this.cid = rs.getString("CID");
				this.accounttype = rs.getString("ACCOUNT_TYPE");					
							
				data.add(new RegisterInfo(account,cid,accounttype));
						
			}
			
		}catch(Exception e){
							
			System.out.println("=================================>Error here (verifyAccountNumber)<===========================");
			e.printStackTrace();
			
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
    		if (ps_stmt != null) try { ps_stmt.close(); } catch(Exception e) {}
    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return data;
	}
	
	public Boolean verifyMobileBanking(String number) {
		
		String sql = "SELECT * FROM TBMREGISTER WHERE ACCOUNTNUMBER=?";
		Boolean exiting = false;
		
		try {
			con = ClsConnDB.OpenConnectionToIBankingOracleDatabase();
			
			ps_stmt = con.prepareStatement(sql);
			ps_stmt.setString(1, number);
			rs = ps_stmt.executeQuery();
			
			exiting = rs.next();
			
		}catch(Exception e) {
			
			System.out.println("=================================>Error here (verifyMobileBanking)<===========================");
			e.printStackTrace();
			
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
    		if (ps_stmt != null) try { ps_stmt.close(); } catch(Exception e) {}
    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return exiting;
	}
	
	
	
	public void insertObject(List<RegisterInfo> info) {
		
		String sql = "INSERT INTO TBMREGISTER(ID,ACCOUNTNUMBER) VALUES (?,?)";
		
		try {
			
			con = ClsConnDB.OpenConnectionToIBankingOracleDatabase();
			ps_stmt = con.prepareStatement(sql);
			
					
			ps_stmt.setInt(1, 199999999);
			ps_stmt.setString(2, info.get(0).getAccount());
			//ps_stmt.setString(2, "form java");	
			//ps_stmt.setString(3, "inserted");
			ps_stmt.executeUpdate();
			System.out.println("==========================================================Record Inserted===========================================");
			con.commit();
			
		}catch(Exception e) {
			
			System.out.println("=================================>Error here (insertObject)<===========================");
			e.printStackTrace();
			
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
    		if (ps_stmt != null) try { ps_stmt.close(); } catch(Exception e) {}
    		if (con != null) try { con.close(); } catch(Exception e) {}
		}
		
		
	}
	
	
}



















































