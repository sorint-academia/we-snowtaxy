package snowtaxy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadFromDB {
	
	public Utente[] getUserFromTable(Connection conn, String tableName) throws SQLException{
		return (readTable(conn,tableName));
	}
	
	private static Utente[] readTable(Connection conn, String tableName) throws SQLException {
		
		Statement stt = null;
		StringBuilder sQuery = null;
		
		stt = conn.createStatement();
		sQuery.append("Select ").append("name").append(",").append("surname").append(",").append("role").append(" FROM ")
				.append(tableName);
		
		ResultSet results = stt.executeQuery(sQuery.toString());
		Utente[] readUserArray = new Utente[getNumberOfLines(results)];
		
		for(int j = 0;j<=readUserArray.length-1;j++){
			String name = results.getString("name");
			String surname = results.getString("surname");
			String role = results.getString("role");
			Utente user = new Utente(name,surname,role);
			readUserArray[j]=user;
		}
		return readUserArray;

	}
	private static int getNumberOfLines(ResultSet rs) throws SQLException{
		int lineNumber= 0;
		while(rs.next()){
			lineNumber++;
		}
		return lineNumber;
	}
}
