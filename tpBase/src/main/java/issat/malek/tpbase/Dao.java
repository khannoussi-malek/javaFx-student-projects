package issat.malek.tpbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    // charging drive
    String nomDriver = "com.mysql.cj.jdbc.Driver";
    //connection to database
    String url = "jdbc:mysql://localhost/tpjava";
    String user = "root";
    String password = "";
    Connection connection = null;


    public Connection getConnection() {
        try {
            Class.forName(nomDriver);
            System.out.println("Driver chargé avec succès");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver non chargé: "+e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie avec succès");

        } catch ( SQLException e) {
            e.printStackTrace();
            System.out.println("Connexion non établie: "+e.getMessage());
        }
        return connection;
    }

}
