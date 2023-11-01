import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class Connect
{
	String url="jdbc:mysql://localhost:3306/voterdetails";
	String userName="root";
	String password="root";
	
	
	void readDB() throws Exception
	{ 
		String q1="select * from student";
		Connection con=DriverManager.getConnection(url,userName,password);
		PreparedStatement ps=con.prepareStatement(q1);
		ResultSet rs=ps.executeQuery(); 
		
		Map<String, String> credentials = new HashMap<>();
		while(rs.next()) {
			
			String name=rs.getString(2);
			String password=rs.getString(3);
	        credentials.put(name,password);
		}
		System.out.print(credentials);
		
	}
	
	public static Map<String, String> Details() throws Exception {
        
		Map<String, String> credentials = new HashMap<>();
		String q1="select * from student";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voterdetails","root","root");
		PreparedStatement ps=con.prepareStatement(q1);
		ResultSet rs=ps.executeQuery(); 
		while(rs.next()) {
			
			String name=rs.getString(2);
			String password=rs.getString(3);
	        credentials.put(name,password);
		}
       
        return credentials; // Return the map as the result of the method
    }

public Map<String, String> AdminDetails() throws Exception {
        
		Map<String, String> credentials = new HashMap<>();
		String q1="select * from adminlogin";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voterdetails","root","root");
		PreparedStatement ps=con.prepareStatement(q1);
		ResultSet rs=ps.executeQuery(); 
		while(rs.next()) {
			
			String name=rs.getString(2);
			String password=rs.getString(3);
	        credentials.put(name,password);
		}
       
        return credentials; // Return the map as the result of the method
    }

	
	
	void g(int sn) throws Exception{
		String q1="select * from countvote where No=?";
		Connection con=DriverManager.getConnection(url,userName,password);
		PreparedStatement ps=con.prepareStatement(q1);
		ps.setInt(1, sn);
		
		ResultSet rs=ps.executeQuery(); 
		
		while(rs.next()) {
		int vote= rs.getInt("Votes");
		System.out.println();
		System.out.println(vote);
		
	}}
	void UpdateCount(int sn) throws Exception {
	    String q1 = "update countvote set Votes = Votes + 1 where No = ?";
	    Connection con = DriverManager.getConnection(url, userName, password);
	    PreparedStatement ps = con.prepareStatement(q1);
	    ps.setInt(1, sn);

	    int rowsAffected = ps.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Update successful.");
	    } else {
	        System.out.println("No rows were updated.");
	    }

	    // Close resources properly when done.
	    ps.close();
	    con.close();
	}

	void ExitReset(int sn) throws Exception {
	    String q1 = "update countvote set Votes = 0 where No = ?";
	    Connection con = DriverManager.getConnection(url, userName, password);
	    PreparedStatement ps = con.prepareStatement(q1);
	    ps.setInt(1, sn);

	    int rowsAffected = ps.executeUpdate();
	    
	    if (rowsAffected > 0) {
	        System.out.println("Update successful.");
	    } else {
	        System.out.println("No rows were updated.");
	    }

	    // Close resources properly when done.
	    ps.close();
	    con.close();
	}
	
	
	
	int[] getResult() throws Exception{
		
		int[] votearray = new int[4];
		int i = 0;
		String q1="select * from countvote";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voterdetails","root","root");
		PreparedStatement ps=con.prepareStatement(q1);
		ResultSet rs=ps.executeQuery(); 
		while(rs.next() && i <4) {
			int totalVotes=rs.getInt(3);
			votearray[i] = totalVotes;
			i+=1;
		
		}
		
		return votearray;
	}
	
}

class DBconnect{
	public static void main(String args[]) throws Exception {
		Connect d=new Connect();
		d.readDB();	
		
	
	}
}