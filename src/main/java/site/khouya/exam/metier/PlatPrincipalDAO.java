package site.khouya.exam.metier;

import site.khouya.exam.model.Ingredient;
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

    private static final Connection connection = SingletonConnexionDB.getConnexion();

    public static PlatPrincipal findById(int id) throws SQLException {
        PlatPrincipal platPrincipal = null;
        String selectPlatPrincipalSQL = "SELECT * FROM platprincipal WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(selectPlatPrincipalSQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    platPrincipal = new PlatPrincipal();
                    platPrincipal.setId(rs.getInt("id"));
                    platPrincipal.setNom(rs.getString("nom"));
                    platPrincipal.setIngredients(findIngredientsByPlatPrincipalId(id));
                }
            }
        }
        return platPrincipal;
    }

    private static List<PlatPrincipalIngredient> findIngredientsByPlatPrincipalId(int id) throws SQLException {
        List<PlatPrincipalIngredient> ingredients = new ArrayList<>();
        String sql = "select * from platprincipal_ingredient pi, ingredient ing where pi.ingredientId = ing.id and pi.platPrincipalId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                PlatPrincipal platPrincipal = new PlatPrincipal();

                if (rs.next()) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setId(rs.getInt("id"));
                    ingredient.setNom(rs.getString("nom"));
                    ingredient.setPrix(rs.getDouble("prix"));

                    ingredients.add(ingredient);
                }
            }
        }
        return ingredients;
    }
}
