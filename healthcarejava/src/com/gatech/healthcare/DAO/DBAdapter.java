package com.gatech.healthcare.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Doris
 *
 */
public class DBAdapter {
	/**
	 * Establishes a connection to DB
	 * @return Connection connection to database
	 */

	private Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		try {
			connection = DriverManager.getConnection(GlobalConstants.DBURL,
					GlobalConstants.USER_NAME, GlobalConstants.PASSWORD);

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return connection;
	}

	public ArrayList<Occur>  GetOccurVre() {
		/**
		 * Queries data from table VRE_Hospital 
		 */
		Connection connection = connect();
		ArrayList<Occur> occList = new ArrayList<Occur>();
		boolean success = false;
		try {

			String query = "SELECT * FROM IDCY ";
				

			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery(query);
			
			
			while (rs.next()) {
				Occur occ = new Occur();
				occ.case_Mix_Index = rs.getString("Case_Mix_Index");
				occ.compared_To_Pooled_Mean_Rate = rs.getString("Compared_To_Pooled_Mean_Rate");
				occ.facilityName = rs.getString("Facility_Name1");
				occ.Incidence_Rate = rs.getString("Incidence_Rate");
				occ.p95_Lower  = rs.getString("p95_Lower");
				occ.p95_Upper = rs.getString("p95_Upper");
				
				occList.add(occ);
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return occList;
	}


}
