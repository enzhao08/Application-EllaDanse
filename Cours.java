import java.util.Date;
import java.util.*;

public class Cours {
    private static int idCoursCounter = 0;
    private int idCours;
    private String nomCours;
    private Date dateCours;
    private String typeDanse;
    private int niveau;
    private String lieux;
    private Boolean estPasser = false;
    private Professeur professeur;

    public Cours(String nomCours, Date dateCours, String typeDanse, int niveau, String lieux, Professeur professeur) {
        this.nomCours = nomCours;
        this.dateCours = dateCours;
        this.typeDanse = typeDanse;
        this.niveau = niveau;
        this.lieux = lieux;
        this.professeur = professeur;
        this.idCours = idCoursCounter;
        this.idCoursCounter++;
    }

    public Cours(String nomCours, Date dateCours, String typeDanse, int niveau, String lieux) {
        this.nomCours = nomCours;
        this.dateCours = dateCours;
        this.typeDanse = typeDanse;
        this.niveau = niveau;
        this.lieux = lieux;
        this.idCours = idCoursCounter;
        this.idCoursCounter++;
    }

    public int getIdCours(){
        return this.idCours;
    }

    public String getNomCours(){
        return this.nomCours;
    }
    public void setNomCours(String nomCours){
        this.nomCours = nomCours;
    }

    public String getDateCours(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = dateFormat.format(this.dateCours);
        return formattedDate;
    }
    public String getHeureCours(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(this.dateCours);
        return formattedTime;
    }
    public void setDateCours(Date dateCours){
        this.dateCours = dateCours;
    }

    public String getTypeDanse(){
        return this.typeDanse;
    }
    public void setTypeDanse(String typeDanse){
        this.typeDanse = typeDanse;
    }

    public int getNiveau(){
        return this.niveau;
    }
    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    public String getLieux(){
        return this.lieux;
    }
    public void setLieux(String lieux){
        this.lieux = lieux;
    }

    public Professeur getProfesseur(){
        return this.professeur;
    }
    public void setProfesseur(Professeur professeur){
        this.professeur = professeur;
    }

    public Boolean getCoursPasser(){
        return this.estPasser;
    }
    public void leCoursEstPasse(){
        this.estPasser = !this.estPasser;
    }

    /*Affichage des informations d'un cours (toString + affichage) */
    public String toString(){
        String message = this.getNomCours() + ", identifiant du cours : "+this.getIdCours()+
        "\nCe cours à lieu le "+ this.getDateCours()+" à "+this.getHeureCours()+" à l'endroit suivant : "+this.getLieux()+
        "\nLa danse de ce cours est "+this.getTypeDanse()+" de niveau "+this.getNiveau();
        return message;
    }
    public void affiche(){
        System.out.println(this.toString());
    }
}
