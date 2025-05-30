import java.util.ArrayList;

public class Professeur {
    private static int idProfesseurCounter = 0;
    private int idProfesseur;
    private String nom;
    private String prenom;
    private String specialite;
    private int nombreCoursPrevu;
    private int nombreCoursReel;
    private ArrayList<Cours> listeCours = new ArrayList<Cours>();

    public Professeur(String nom, String prenom, String specialite, int nombreCoursPrevu, int nombreCoursReel){
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.nombreCoursPrevu = nombreCoursPrevu;
        this.nombreCoursReel = nombreCoursReel;
        this.idProfesseur = idProfesseurCounter;
        this.idProfesseurCounter++;
    }

    public int getIdProfesseur(){
        return this.idProfesseur;
    }
    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return this.prenom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getSpecialite(){
        return this.specialite;
    }
    public void setSpecialite(String specialite){
        this.specialite = specialite;
    }

    public int getNombreCoursPrevu(){
        return this.nombreCoursPrevu;
    }
    public void setNombreCoursPrevu(int nombreCoursPrevu){
        this.nombreCoursPrevu = nombreCoursPrevu;
    }

    public int getNombreCoursReel(){
        return this.nombreCoursReel;
    }
    public void setNombreCoursReel(int nombreCoursReel){
        this.nombreCoursReel = nombreCoursReel;
    }

    public ArrayList<Cours> getListeCours(){
        return this.listeCours;
    }

    /*toString + affichage*/
    public String toString(){
        String message = "Professeur "+this.getPrenom()+" "+this.getNom()+"d'identifiant "+this.getIdProfesseur()+
        "\nLe professeur a "+this.getNombreCoursReel()+" cours réels et "+this.getNombreCoursPrevu()+" cours prévus en spécalité"+this.getSpecialite();
        return message;
    }
    public void affiche(){
        System.out.println(this.toString());
    }

    public void associerProfesseur(Cours cours) {
        if (cours.getProfesseur() == null) {
            cours.setProfesseur(this);
            listeCours.add(cours);
            System.out.println("Le cours \"" + cours.getNomCours() + "\" du " + cours.getDateCours() + " à " + cours.getHeureCours() +
                               " a été associé au professeur " + this.nom + " " + this.prenom + ".");
        } else {
            System.out.println("Le cours \"" + cours.getNomCours() + "\" est déjà associé à un autre professeur.");
        }
    }

    public void desassocierProfesseur(Cours cours) {
        if(cours.getProfesseur() == null){
            listeCours.remove(cours);
            System.out.println("Le cours \"" + cours.getNomCours() + "\" du " + cours.getDateCours() + " à " + cours.getHeureCours() +
                               " a été désassocié au professeur " + this.nom + " " + this.prenom + ".");
        } else {
            System.out.println("Le cours \"" + cours.getNomCours() + "\"a déjà été désassocié.");
        }
    }

    public void afficherNombreCours(){
        int compteurReel = 0, compteurPrevu = 0;
        for (Cours cours : listeCours) {
            if (cours.estPasser()) {
                compteurReel++;
            } else {
                compteurPrevu++;
            }
        }
        System.out.println("Le professeur " + this.nom + " " + this.prenom + " a " + compteurReel + " cours réels et " + compteurPrevu + " cours prévus.");
    }
}
