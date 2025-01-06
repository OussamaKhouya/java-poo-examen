//
//
//// Classe site.khouya.exam.model.PlatPrincipal
//public class PlatPrincipal {
//    private int id;
//    private String nom;
//    private double prixBase;
//
//    public PlatPrincipal(int id, String nom, double prixBase) {
//        this.id = id;
//        this.nom = nom;
//        this.prixBase = prixBase;
//    }
//
//    public double calculerPrix(double composition) {
//        return prixBase + composition;
//    }
//
//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public double getPrixBase() {
//        return prixBase;
//    }
//
//    public void setPrixBase(double prixBase) {
//        this.prixBase = prixBase;
//    }
//}
//
//// Classe site.khouya.exam.model.Ingredient
//public class Ingredient {
//    private int id;
//    private String nom;
//    private double prix;
//
//    public Ingredient(int id, String nom, double prix) {
//        this.id = id;
//        this.nom = nom;
//        this.prix = prix;
//    }
//
//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public double getPrix() {
//        return prix;
//    }
//
//    public void setPrix(double prix) {
//        this.prix = prix;
//    }
//}
//
//// Classe site.khouya.exam.model.Supplement
//public class Supplement {
//    private int id;
//    private String nom;
//    private double prix;
//
//    public Supplement(int id, String nom, double prix) {
//        this.id = id;
//        this.nom = nom;
//        this.prix = prix;
//    }
//
//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public double getPrix() {
//        return prix;
//    }
//
//    public void setPrix(double prix) {
//        this.prix = prix;
//    }
//}
//
//// Classe site.khouya.exam.model.Repas
//import java.util.List;
//
//public class Repas {
//    private PlatPrincipal platPrincipal;
//    private List<Ingredient> ingredients;
//    private List<Supplement> supplements;
//
//    public Repas(PlatPrincipal platPrincipal, List<Ingredient> ingredients, List<Supplement> supplements) {
//        this.platPrincipal = platPrincipal;
//        this.ingredients = ingredients;
//        this.supplements = supplements;
//    }
//
//    public double calculerTotal() {
//        double total = platPrincipal.getPrixBase();
//        for (Ingredient ingredient : ingredients) {
//            total += ingredient.getPrix();
//        }
//        for (Supplement supplement : supplements) {
//            total += supplement.getPrix();
//        }
//        return total;
//    }
//
//    // Getters et Setters
//    public PlatPrincipal getPlatPrincipal() {
//        return platPrincipal;
//    }
//
//    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
//        this.platPrincipal = platPrincipal;
//    }
//
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public List<Supplement> getSupplements() {
//        return supplements;
//    }
//
//    public void setSupplements(List<Supplement> supplements) {
//        this.supplements = supplements;
//    }
//}
//
//// Classe site.khouya.exam.model.Commande
//import java.util.List;
//
//public class Commande {
//    private int id;
//    private Client client;
//    private List<Repas> repas;
//
//    public Commande(int id, Client client, List<Repas> repas) {
//        this.id = id;
//        this.client = client;
//        this.repas = repas;
//    }
//
//    public double calculerTotalCommande() {
//        double total = 0;
//        for (Repas repas : this.repas) {
//            total += repas.calculerTotal();
//        }
//        return total;
//    }
//
//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    public List<Repas> getRepas() {
//        return repas;
//    }
//
//    public void setRepas(List<Repas> repas) {
//        this.repas = repas;
//    }
//}
//
