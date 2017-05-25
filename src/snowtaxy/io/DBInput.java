package snowtaxy.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.BlockingQueue;

import snowtaxy.ComponentCreationException;
import snowtaxy.Transformer;
import snowtaxy.Utente;

@Deprecated
public class DBInput extends Input {

    // static {
    // try {
    // Class.forName("com.mysql.jdbc.Driver");
    // } catch (ClassNotFoundException e) {
    // throw new RuntimeException(e);
    // }
    // }

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DBInput(BlockingQueue<Utente> messageQueue, String connectionString, String table,
            Transformer<ResultSet, Utente> transformer) throws ComponentCreationException {
        super(messageQueue);

        try {
            connection = DriverManager.getConnection(connectionString);
            statement = connection.createStatement();

        } catch (SQLException e) {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e1) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e1) {
                }
            }
            throw new ComponentCreationException(e);
        }
    }

    @Override
    protected Utente read() throws InputReadException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() throws InputReadException {
        // TODO Auto-generated method stub

    }

}
