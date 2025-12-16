import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedDemo {

	public static void main(String[] args) throws Exception {
		
		String sql = "insert into people values (?,?,?)";
		
		Connection conn = JdbcFactory.getConnection();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, args[0]);
		stmt.setInt(2, Integer.parseInt(args[1]));
		stmt.setString(3, args[2]);
		
		int rows = stmt.executeUpdate();
		System.out.println(rows + " rows updated");
	}
}
