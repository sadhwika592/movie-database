import java.sql.*;
import java.sql.Connection;
import java.util.*;
import java.sql.Statement;

public class MovieDetails {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con=DriverManager.getConnection("jdbc:sqlite:mulesoftAsst.db");
			System.out.println("Database Connection opened.");
			Statement st=con.createStatement();
			st.executeUpdate("create table movieData(movieName varchar(20),actor varchar(20),actress varchar(20),relesae varchar(10),director varchar(20))");
			System.out.println("Table Created");
			
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('The Conjuring','Vera Farmiga','2013','James Wan')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('just go with it','adam sandler','2011','Dennis Dugan')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('the shawshank redemption','vishwak sen','1994','Frank Darabont')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('The Dark Knight','christian bale','2008','Christopher Nolan')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('grown ups','adam sandler','2010','Dennis Dugan')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('Avengers: Endgame','Robert Downey','2019','Anthony Russo')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('spider-man','tobey maguire','2002','Sam Raimi')");
			st.executeUpdate("INSERT INTO movieData (movieName,actor,release,director) VALUES ('murder mystery','adam sandler','2019','Kyle Newacheck')");
			
			
			ResultSet rs = st.executeQuery("select * from movieData");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" : " +(rs.getString(2)+" : "+rs.getString(3)+" : "+ rs.getString(4)+" : "+rs.getString(5)));
			}
			
			con.close();
			System.out.println("Connection closed.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
