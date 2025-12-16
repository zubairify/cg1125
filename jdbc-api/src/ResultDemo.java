import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) throws Exception {
		String sql = "select * from people";
		Connection conn = JdbcFactory.getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		ResultSetMetaData meta = rs.getMetaData();
		for(int i=1; i<=meta.getColumnCount(); i++)
			System.out.print(meta.getColumnName(i) + "\t");
		System.out.println();
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + 
					rs.getInt("age") + " " + 
					rs.getString(3));
		}
	}
}
