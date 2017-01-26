package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {

//    private static String url = "jdbc:mysql://localhost/test";
    private static String url = "jdbc:mysql://localhost:3306/Entreprise";
    private static String user = "test";
    private static String passwd = "test";
    private static Connection connect;


    private BDConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé");
        }

        try {
            connect = DriverManager.getConnection(url, user, passwd);
            //System.out.println("Connection ok");
        } catch (SQLException e) {
            System.out.println("erreur de Connection (il peut etre un probleme de password et user)");
        }
    }

    public static Connection getInstance() {
        if (connect == null) {
            new BDConnection();
        }
        return connect;
    }



}
