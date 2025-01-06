package site.khouya.exam.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    static Connection connection;
    public static Connection getConnexion() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2024", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur de connexion");
            }
        }
        return connection;
    }
}
