package advance_java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class program5 {

		    public static void main(String[] args) {
		        // Database details
		        String url = "jdbc:mysql://localhost:3306/adi";  // Replace with your DB name
		        String user = "root";                                // Replace with your DB username
		        String password = "root";                    // Replace with your DB password

		        Scanner sc = new Scanner(System.in);

		        try {
		            // Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Establish connection
		            Connection conn = DriverManager.getConnection(url, user, password);

		            // SQL INSERT query with placeholders
		            String sql = "INSERT INTO employ (eno, ename, department, sal) VALUES (?, ?, ?, ?)";

		            // Create PreparedStatement object
		            PreparedStatement pstmt = conn.prepareStatement(sql);

		            // Get user input
		            System.out.print("Enter Employee No: ");
		            int eno = sc.nextInt();
		            sc.nextLine(); // consume leftover newline

		            System.out.print("Enter Employee Name: ");
		            String ename = sc.nextLine();

		            System.out.print("Enter Department: ");
		            String dept = sc.nextLine();

		            System.out.print("Enter Salary: ");
		            double sal = sc.nextDouble();

		            // Set values in PreparedStatement
		            pstmt.setInt(1, eno);
		            pstmt.setString(2, ename);
		            pstmt.setString(3, dept);
		            pstmt.setDouble(4, sal);

		            // Execute the insert
		            int rows = pstmt.executeUpdate();

		            if (rows > 0) {
		                System.out.println("Record inserted successfully!");
		            } else {
		                System.out.println("Record insertion failed.");
		            }

		            // Close resources
		            pstmt.close();
		            conn.close();
		            sc.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}
