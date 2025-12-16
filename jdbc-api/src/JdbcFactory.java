import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public final class JdbcFactory {

	private JdbcFactory() {
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		DriverManager.registerDriver(new OracleDriver());
		
		Connection conn = DriverManager.getConnection(url, "zubair", "oracle");
		
		return conn;
	}
}
