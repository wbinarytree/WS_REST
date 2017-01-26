package DAO;


import POJO.Internship;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOInternship extends DAO {

	public DAOInternship(Connection connection) {
		super(connection);		
	}

	@Override
	public Internship find(int id) {
		Internship intern = null;
		 try {
		           ResultSet result = this.connect.createStatement(
		              ResultSet.TYPE_SCROLL_INSENSITIVE, 
		              ResultSet.CONCUR_READ_ONLY
		            ).executeQuery("SELECT * FROM internship WHERE id = " + id);
		      
		     if(result.first())
		    	 intern = new Internship(result.getLong("id"),result.getString("id_company"),
			               result.getString("title"), result.getString("description"),result.getLong("duration"));
		    } catch (SQLException e) {
		      e.printStackTrace();
		 }
		return intern;
	}

	@Override
	public ArrayList<Internship> getAllInternships() {
		
		ArrayList<Internship> list = new ArrayList<>();
		try {
	        ResultSet result = this.connect.createStatement(
	            ResultSet.TYPE_SCROLL_INSENSITIVE, 
	            ResultSet.CONCUR_READ_ONLY
	           ).executeQuery("SELECT * FROM internship");
	      
	     while(result.next())
	       {
	    	 Internship inter = new Internship(result.getLong("id"),result.getString("id_company"),
						   result.getString("title"), result.getString("description"),result.getLong("duration"));
	    	  list.add(inter);  
	       }
	         
	    } catch (SQLException e) {
	      e.printStackTrace();
	 }
		return list;
	}
	/*public ArrayList<InternshipOffer> getOffers(){
		ArrayList<InternshipOffer> list = new ArrayList<>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY
			).executeQuery("SELECT * FROM internship");

			while(result.next())
			{
				InternshipOffer inter = new InternshipOffer();
				inter.setDescription(result.getString("description"));
				inter.setDuration(result.getInt("duration"));
				//// TODO: 2017/1/6 specify those table who need to be add
				list.add(inter);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}*/
	public static void main(String[] args) {
		new DAOInternship(BDConnection.getInstance()).getAllInternships();
	}
}
