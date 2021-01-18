package A84_1_DProvider_To_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Add_Referring_To_DB_usingDataProvider {

	
	String FilePath="D:/eclips/Work_Space/PaxeraHealth/ReadFrom";
	String ExcelFileName= "Doctors.xlsx";
	String ExcelSheetName= "Sheet2";
	
	@DataProvider(name = "DoctorList")
	public Object [][] dataProvider() throws Exception {

		utils.ReadExcelFile_To_Array_Title_Enter_RC_Count Excel1 = new utils.ReadExcelFile_To_Array_Title_Enter_RC_Count();
		return Excel1.readExcel(FilePath, ExcelFileName, ExcelSheetName, 2610, 3);

	}
	@Test(dataProvider = "DoctorList")
	public void To_DB(String ID, String EnglishName, String Customer) throws ClassNotFoundException, SQLException {
	
		String userName = "sa";
		String password = "PXDBPass2015";
		String ServerName= "192.168.5.183\\SQLEXPRESS";
		String DBName="MIGlobal";
//		String TableName="referring_physician";

		// JDBC Driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		// Creating a connection to the database. //like(Connection conn = DriverManager.getConnection("DatabaseURL","UserName", "Password");
		// String url ="jdbc:sqlserver://DESKTOP-1TGL11O;databaseName=NORTHWND"; //"jdbc:sqlserver://[servername];databaseName=MYDB";
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://"+ServerName+";databaseName="+DBName+"",userName, password);

		// Executing SQL queries-
		Statement stmt = null;
		stmt = conn.createStatement();
		
		// query
//		use ("+ +") to be abel to ad defined variable. Use '' for to add iternal value as string in SQL statement
		String sql = "INSERT INTO referring_physician (ref_phy_id, ref_phy_name, Customer_Name)VALUES ('"+ID+"', '"+EnglishName+"','"+ Customer+"')";
		
		// (executeUpdate)for update statement
		int result = stmt.executeUpdate(sql);
	
		System.out.println(result);
		
//	System.out.println(ID + " " + EnglishName + " " + Customer);
			

				stmt.close();
				conn.close();
	}

}
