package advance_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class program3 {
	public static void main(String agrs[]) {
		        String url = "jdbc:mysql://localhost:3306/adi"; // Replace with your DB name
		        String user = "root"; 
		        String password = "root"; // Replace with your MySQL password

		        try {
		            // Step 1: Load MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish database connection
		            Connection conn = DriverManager.getConnection(url, user, password);

		            // Step 3: Create a statement object
		            Statement stmt = conn.createStatement();

		            // Step 4: Write SELECT query
		            String query = "SELECT * FROM student";

		            // Step 5: Execute the query and store result in ResultSet
		            ResultSet rs = stmt.executeQuery(query);

		            // Step 6: Display result
		            System.out.println("Employee Records:");
		            System.out.println("------------------------------");
		            System.out.println("ID\tName\t\tPosition\t\tSalary");

		            while (rs.next()) {
		                int id = rs.getInt("id");
		                String name = rs.getString("name");
		                String position = rs.getString("position");
		                double salary = rs.getDouble("salary");

		                System.out.printf("%d\t%-10s\t%-10s\t%.2f%n", id, name, position, salary);
		            }

		            // Step 7: Close resources
		            rs.close();
		            stmt.close();
		            conn.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}