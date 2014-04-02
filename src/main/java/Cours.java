import static com.google.common.base.Objects.toStringHelper;

/**
 * Created by alexandre on 01/04/2014.
 */
public class Cours {
    private String nomMatiere, typeMatiere;

    public Cours(String matiere, String typeMatiere) {
        this.nomMatiere = matiere;
        this.typeMatiere = typeMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getTypeMatiere() {
        return typeMatiere;
    }

    public void setTypeMatiere(String typeMatiere) {
        this.typeMatiere = typeMatiere;
    }


    /* display informations about course */
    @Override
    public String toString() {
        return toStringHelper(this)
                .add("Nom de la matiere : ", nomMatiere)
                .add("Type  : ", typeMatiere)
                .toString();
    }
}
