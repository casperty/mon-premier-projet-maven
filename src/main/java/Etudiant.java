import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

/**
 * Created by alexandre on 01/04/2014.
 */
public class Etudiant {
    private String prenom, nom;
    private int age;
    private List<Cours> lesCours = Lists.newArrayList();

    public Etudiant(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /* add an item into the list */
    public boolean add(Cours cours) {
        return lesCours.add(cours);
    }

    /* return an item from the list */
    public Cours get(int index) {
        return lesCours.get(index);
    }

    /* return the whole list */
    public List<Cours> getList(){
        return lesCours;
    }

    /* display informations about the student */
    @Override
    public String toString() {
        return toStringHelper(this)
                .add("prenom", prenom)
                .add("nom", nom)
                .add("age", age)
                .add("lesCours", lesCours)
                .toString();
    }
}
