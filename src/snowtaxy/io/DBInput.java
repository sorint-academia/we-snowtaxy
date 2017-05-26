package snowtaxy.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import snowtaxy.ComponentCreationException;
import snowtaxy.Transformer;
import snowtaxy.Utente;
import snowtaxy.messages.MessageQueue;

public class DBInput extends Input
{

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private Transformer<ResultSet, Utente> transformer;

	// static {
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// } catch (ClassNotFoundException e) {
	// throw new RuntimeException(e);
	// }
	// }

	public DBInput(MessageQueue messageQueue, String connectionString, String table,
			Transformer<ResultSet, Utente> transformer) throws ComponentCreationException
	{
		super(messageQueue);

		this.transformer = transformer;

		String sql = "SELECT * FROM " + table;
		try
		{
			conn = DriverManager.getConnection(connectionString);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e)
		{
			try
			{
				close();
			} catch (InputReadException e1)
			{
			}
			throw new ComponentCreationException(e);
		}

	}

	@Override
	protected Utente read() throws InputReadException
	{
		try
		{
			if (!rs.next())
			{
				return null;
			}
		} catch (SQLException e)
		{
			throw new InputReadException(e);
		}
		return transformer.transform(rs);
	}

	@Override
	public void close() throws InputReadException
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		} catch (SQLException e)
		{
			throw new InputReadException(e);
		} finally
		{
			try
			{
				if (stmt != null)
				{
					stmt.close();
				}
			} catch (SQLException e)
			{
				throw new InputReadException(e);
			} finally
			{
				try
				{
					if (conn != null)
					{
						conn.close();
					}
				} catch (SQLException e)
				{
					throw new InputReadException(e);
				}
			}
		}
	}

}
