package com.company;

import DAO.BDConnection;
import DAO.DAOInternship;
import POJO.Internship;
import java.sql.Connection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by BinaryTree on 2017/1/16.
 */
@Path("/data")
public class RestDataPush {
    DAOInternship dao = new DAOInternship(BDConnection.getInstance());

    @GET
    @Path("/internships")
    @Produces("application/xml")
    public ArrayList<Internship> getInternships(){
        Connection connection =  BDConnection.getInstance();
        dao = new DAOInternship(BDConnection.getInstance());
        return dao.getAllInternships();
    }
    @GET
    @Path("/internship/{internshipID}")
    @Produces("application/xml")
    public  Internship getInternship(@PathParam("internshipID") int ID){
        dao = new DAOInternship(BDConnection.getInstance());
        return dao.find(ID);
    }
    @GET
    @Path("/test")
    @Produces("text/plain")
    public String test(){
        return "hello world";
    }
}
