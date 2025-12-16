import java.sql.Connection;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) throws Exception {
		String sql = "insert into people values ('Polo', 21, 'Pune')";
		
		Connection conn = JdbcFactory.getConnection();
		
		Statement stmt = conn.createStatement();
		int rows = stmt.executeUpdate(sql);
		System.out.println(rows + " row(s) updated..");
	}
}
