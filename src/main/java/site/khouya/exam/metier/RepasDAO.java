package site.khouya.exam.metier;

import site.khouya.exam.model.Ingredient;
import site.khouya.exam.model.PlatPrincipal;
import site.khouya.exam.model.Repas;
import site.khouya.exam.model.Supplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepasDAO {

    private final Connection connection = SingletonConnexionDB.getConnexion();

    public List<Repas> getAll() throws SQLException {
        List<Repas> repasList = new ArrayList<>();
        String selectRepasSQL = "SELECT * FROM repas";
        try (PreparedStatement stmt = connection.prepareStatement(selectRepasSQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Repas repas = new Repas();
                repas.setId(rs.getInt("id"));
                repas.setNom(rs.getString("nom"));
                int platPrincipalId = rs.getInt("platPrincipalId");
//                PlatPrincipal platPrincipal = findPlatPrincipalById(platPrincipalId);
//                List<Ingredient> ingredients = findIngredientsByRepasId(repasId);
//                List<Supplement> supplements = findSupplementsByRepasId(repasId);
                System.out.println(repas);
                repasList.add(repas);
            }
        }
        System.out.println(repasList);
        return repasList;
    }
}
