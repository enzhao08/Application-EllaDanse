import java.util.HashSet;

public class EDT {
    private static int idEDTCounter = 0;
    private int idEDT;
    private HashSet<Professeur> listeProfesseurs = new HashSet<>();
    private HashSet<Cours> listeCours = new HashSet<>();

    public EDT() {
        this.idEDT = idEDTCounter;
        this.idEDTCounter++;
    }

    public void ajouterProfesseur(Professeur professeur) {
        listeProfesseurs.add(professeur);
    }
    public void supprimerProfesseur(Professeur professeur) {
        listeProfesseurs.remove(professeur);
    }

    public void ajouterCours(Cours cours) {
        listeCours.add(cours);
    }
    public void supprimerCours(Cours cours) {
        listeCours.remove(cours);
    }

    public static int getIdEDT() {
        return idEDT;
    }

    public void modifierEDT(Professeur prof, Cours cours) {
        prof.associerProfesseur(cours);
    }
    public void supprimerProf(Professeur prof, Cours cours) {
        if (prof == null || cours == null) {
            System.out.println("Erreur: Professeur ou Cours est null.");
            return;
        }
        else if (!listeProfesseurs.contains(prof)) {
            System.out.println("Erreur: Professeur non trouvé dans l'EDT.");
            return;
        }
        else if (!listeCours.contains(cours)) {
            System.out.println("Erreur: Cours non trouvé dans l'EDT.");
            return;
        }
        else { 
            prof.desassocierProfesseur(cours);
        }
    }

    public void affiche() {
        System.out.println("ID de l'EDT: " + idEDT);
        System.out.println("Liste des professeurs dans l'EDT:");
        for (Professeur professeur : listeProfesseurs) {
            System.out.println(" - " + professeur.getNom());
        }
        System.out.println("Liste des cours dans l'EDT:");
        for (Cours cours : listeCours) {
            System.out.println(" - " + cours.getNom() + " à " + cours.getHeure());
        }
    }

    public void afficherEDT() {
        for (Professeur prof : listeProfesseurs) {
            if (prof == null) {
                System.out.println("Professeur null.");
                return;
            }
            else if (prof.getListeCours().isEmpty()) {
                System.out.println("Professeur: " + prof.getNom() + " n'a pas de cours.");
            }
            else {
                System.out.println("Professeur: " + professeur.getNom());
                for (Cours cours : professeur.getListeCours()) {
                    System.out.println("  Cours: " + cours.getNom() + ", Heure: " + cours.getHeure());
                }
            }
        }
        for (Cours cours : listeCours) {
            if (cours.getProfesseur() == null) {
                System.out.println("Cours: " + cours.getNom() + " n'a pas de professeur associé.");
            } 
        }
    }
}
