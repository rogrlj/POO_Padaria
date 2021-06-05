package dominio.padario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO implements IGenericDAO {
	
	private Connection c;

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=sigpDB;namedPipes=true",
                "sigp", "1234567890");
        System.out.println("Conexão Ok!");
        return c;
    }

}
