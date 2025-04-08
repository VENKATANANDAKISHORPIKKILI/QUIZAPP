import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/Kishore";
		String username="root";
		String password="Kishor@123";
		ResultSet rst=null;
		Statement stmt=null;
		int i=0;
		try {
			Scanner sc= new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded and registerd the driver");
			Connection con= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established successfully");
			System.out.println("Enter the operation to be performed");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Update");
			System.out.println("4. Select");
			int ans=sc.nextInt();
			switch(ans) {
			case 1:
				System.out.println("Please enter the id of the peroson:");
				int id=sc.nextInt();
				System.out.println("Please enter the name of the peroson:");
				String name=sc.next();
				System.out.println("Please enter the age of the peroson:");
				int age=sc.nextInt();
				String insert_query="insert into jspider values("+id+",'"+name+"',"+age+");";
				stmt = con.createStatement();
				i=stmt.executeUpdate(insert_query);
				System.out.println("records inserted successfully "+i);
				//System.out.println("Values inserted");
				break;
			
			case 2:
				System.out.println("Please enter the id of the peroson to be deleted:");
				int id1=sc.nextInt();
				String delete_query="delete from jspider where id="+id1+";";
				stmt = con.createStatement();
				i=stmt.executeUpdate(delete_query);
				System.out.println("records deleted successfully "+i);
				break;
				
			case 3:
				System.out.println("Please enter the id of the peroson to be deleted:");
				int id2=sc.nextInt();
				String update_query="update jspider";
				stmt = con.createStatement();
				i=stmt.executeUpdate(update_query);
				System.out.println("records deleted successfully "+i);
				break;
				
			case 4:
				String select_query="Select * from jspider;";
				//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				stmt = con.createStatement();
				rst = stmt.executeQuery(select_query);
				//rst.afterLast();
				System.out.println("-------------------------------");
				System.out.println("|id |"+"name  |"+"age  |");
				while(rst.next()){
					System.out.println("-------------------------------");
					System.out.println(rst.getInt(1)+"|    "+rst.getString(2)+"|   "+rst.getInt(3));
					System.out.println("-------------------------------");
					//System.out.println(" ");
				}
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
