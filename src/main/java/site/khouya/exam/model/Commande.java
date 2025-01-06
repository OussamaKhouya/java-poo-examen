package site.khouya.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
    private int id;
    private Client client;
    private List<Repas> repas;

    public double calculerTotalCommande() {
        double total = 0;
        for (Repas repas : this.repas) {
            total += repas.calculerTotal();
        }
        return total;
    }
}
