package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClsConnDB {
	
	public static final Connection OpenConnectionToDatabaseSQLServer(){

		String  conStr = "jdbc:sqlserver://192.168.0.156:1433;databaseName=CABIB";
		Connection con=null;
			String user="sa";
			String password="123456";
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(conStr, user, password);
			} catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;		
		}
	
	public static final Connection OpenConnectionToOracleDatabase(){
		
		// Read data from Core-banking system
		
		String  conStr = "jdbc:oracle:thin:@192.168.0.157:1521:cab";

		Connection con=null;
			String user="cab";
			String password="cab";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(conStr, user, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;		
		}
	
	public static final Connection OpenConnectionToIBankingOracleDatabase() {
		
		String  conStr = "jdbc:oracle:thin:@192.168.0.157:1521:cab";

		Connection con=null;
			String user="mbankcab";
			String password="mbankcab";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(conStr, user, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;				
	}
}





















