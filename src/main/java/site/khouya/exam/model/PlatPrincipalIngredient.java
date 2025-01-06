package site.khouya.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatPrincipalIngredient {
    PlatPrincipal platPrincipal;
    Ingredient ingredient;
    int quantite;
}
