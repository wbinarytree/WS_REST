package DAO;

import POJO.Internship;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO {

	protected Connection connect = null;
	 
	 public DAO(Connection connection) {
		    this.connect = connection;
		}
	 
//	 public abstract boolean add(Internship obj);
//	 public abstract boolean delete(Internship obj);
//	 public abstract boolean update(Internship obj);
	 public abstract   Internship find(int id);
	 public abstract ArrayList<Internship> getAllInternships(); 
}
