package covid;
import java.sql.*;
import java.util.HashMap;
/**
 * 
 * @author	Kattamuri Venkatesh
 * @email	venkateshkattamuri98@gmail.com
 * @github URL	https://github.com/venkatesh559/CovidExercise
 *
 */
public class CovidData {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		int totalCount = 0;
		
		String dbUrl = "jdbc:mysql://localhost:3306/covid";
		String user = "venkatesh";		
		String pass = "Venkatesh@123";

		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// Statement creation
			myStmt = myConn.createStatement();

			// Execute SQL query
			myRs = myStmt.executeQuery("select distinct(state) from covidData");
			
			// Processing the result set
			System.out.println("Information about CORONA infected patients\n");
			while (myRs.next()) {
				String state = myRs.getString("state");				
				totalCount = totalCount + printData(myConn,state);			
			}
			System.out.println("Total no. of patients (TN + AP + Kerela) : "+totalCount );
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			// Closing connection
			close(myConn, myStmt, myRs);
		}
	}
	
	//Method to print the data
	private static int printData(Connection myConn, String state) throws SQLException {
		Statement myStmt = null;
		ResultSet myRs = null;
		String male,female;
		int stateTotal =0;
		HashMap<String,Integer> total = new HashMap<String,Integer>();
		total.put("totalMale",0);
		total.put("totalFemale",0);
		try {
			
			myStmt = myConn.createStatement();
			String query = "select male,female from covidData where state = "+"\""+state+"\"";
			myRs = myStmt.executeQuery(query);
			while (myRs.next()) {
				male  = myRs.getString("male");
				female  = myRs.getString("female");
				total.put("totalMale",total.get("totalMale")+Integer.parseInt(male));
				total.put("totalFemale",total.get("totalFemale")+Integer.parseInt(female));			
			}
			System.out.println("------"+state+" State Information------");
			stateTotal = total.get("totalFemale")+total.get("totalMale");
			System.out.println(state +" Total : " +stateTotal);
			System.out.println("Male Total: "+total.get("totalMale"));
			System.out.println("Female Total: "+total.get("totalFemale")+"\n");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}
		return stateTotal;
	}
	
	//Method to close connections
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}	
}
