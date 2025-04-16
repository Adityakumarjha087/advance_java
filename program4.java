package advance_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class program4 {
			public static void main(String[] args) {
				// SQL query to create employee table
				String createTableSQL = "CREATE TABLE IF NOT EXISTS employ ( eno INT PRIMARY KEY,\r\n"
						+ "    ename VARCHAR(100),\r\n"
						+ "    department VARCHAR(50),\r\n"
						+ "    sal DOUBLE)";

				// Establish connection and create table
				try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adi", "root", "root");
						Statement stmt = conn.createStatement()) {

					// Execute the SQL query
					stmt.executeUpdate(createTableSQL);
					System.out.println("Employee table created successfully!");
					
					// Step 2: Insert 3 records
		            String insert1 = "INSERT INTO employ VALUES (104, 'Alice', 'IT', 60000)";
		            String insert2 = "INSERT INTO employ VALUES (105, 'Bob', 'CSE', 55000)";
		            String insert3 = "INSERT INTO employ VALUES (106, 'Charlie', 'IT', 70000)";

		            stmt.executeUpdate(insert1);
		            stmt.executeUpdate(insert2);
		            stmt.executeUpdate(insert3);

		            System.out.println("3 records inserted successfully!");
		            
		         // SQL query to select employees from IT department
		            String query = "SELECT eno, ename, department, sal FROM employ WHERE department = ?";
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, "IT"); // Set department = 'IT'

		            ResultSet rs = pstmt.executeQuery();

		            // Display result
		            System.out.println("Employ in IT Department:");
		            System.out.println("-------------------------------------------");
		            System.out.println("ENO\tENAME\t\tDEPT\tSALARY");

		            while (rs.next()) {
		                int eno = rs.getInt("eno");
		                String ename = rs.getString("ename");
		                String dept = rs.getString("department");
		                double sal = rs.getDouble("sal");

		                System.out.printf("%d\t%-10s\t%-5s\t%.2f%n", eno, ename, dept, sal);
		            }


				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}