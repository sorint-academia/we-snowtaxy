package snowtaxy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteToDB
{
	// need a control if those strings exist, and if we really really require
	// if we really really require we can hold a logFile which lines couldn't be
	// inserted
	// due to the lack of information
	public static void insertDataIntoTable(Connection conn, String tableName, Utente[] userArray) throws SQLException
	{
		Statement stt = conn.createStatement();
		String sQuery = null;

		for (int j = 0; j <= userArray.length - 1; j++)
		{
			Utente user = userArray[j];
			if (!(user.getNome().equals(null)) && (user.getCognome().equals(null) && user.getRuolo().equals(null)))
			{
				sQuery = "Insert INTO " + tableName + " VALUES ( '" + user.getNome() + "', '" + user.getCognome()
						+ "','" + user.getRuolo() + "')";
			} else
			{
				// we can log the user here into a file

			}

		}
	}
}
