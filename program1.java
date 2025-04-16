package advance_java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

			if (con == null) {

				System.out.println("JDBC connection is not established");

				return;

			}

			else {

				System.out.println("Congratualtions," + "JDBC connection is established successfully");

			}

			Statement stmt = con.createStatement();
			System.out.println("sending queries");
			stmt.executeUpdate(null);

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}