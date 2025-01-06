package site.khouya.exam.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repas {
    private int id;
    private String nom;
    private PlatPrincipal platPrincipal;
    private List<Ingredient> ingredients;
    private List<Supplement> supplements;

    public double calculerTotal() {
        double total = platPrincipal.calculerPrix();
        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrix();
        }
        for (Supplement supplement : supplements) {
            total += supplement.getPrix();
        }
        return total;
    }
}
