package site.khouya.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatPrincipal {
    private int id;
    private String nom;
    private List<PlatPrincipalIngredient> ingredients;

    public double calculerPrix() {
        double total = 0;
        for (PlatPrincipalIngredient ingredient : ingredients) {
            total += ingredient.getQuantite() * ingredient.getIngredient().getPrix();
        }

        return total;
    }
}
