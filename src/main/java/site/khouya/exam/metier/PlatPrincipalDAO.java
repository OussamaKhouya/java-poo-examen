package site.khouya.exam.metier;

import site.khouya.exam.model.PlatPrincipal;
import site.khouya.exam.model.PlatPrincipalIngredient;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PlatPrincipalDAO {

    private final Connection connection = SingletonConnexionDB.getConnexion();

    public PlatPrincipal findById(int id) throws SQLException {
        PlatPrincipal platPrincipal = null;
        String selectPlatPrincipalSQL = "SELECT * FROM platprincipal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(selectPlatPrincipalSQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    platPrincipal = new PlatPrincipal();
                    platPrincipal.setId(rs.getInt("id"));
                    platPrincipal.setNom(rs.getString("nom"));
                    List<PlatPrincipalIngredient> ingredients = findIngredientsByPlatPrincipalId(id);
                }
            }
        }
        return platPrincipal;
    }

    private List<PlatPrincipalIngredient> findIngredientsByPlatPrincipalId(int id) {
        List<PlatPrincipalIngredient> ingredients = new ArrayList<>();
        String selectPlatPrincipalIngredientSQL = "SELECT * FROM platprincipal WHERE id = ?";
    }
}
