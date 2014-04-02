import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * Created by alexandre on 01/04/2014.
 */
public class Main {
    public static void main(String[] args) {

        // liste des types de matiere
        String [] listeTypeMatiere={"Cours","TD","TP"};

        // etudiant
        Etudiant e=new Etudiant("Alexandre","Ravaux",20);


        // cours
        Cours c1=new Cours("Java",listeTypeMatiere[0]);
        Cours c2=new Cours("Java",listeTypeMatiere[1]);
        Cours c3=new Cours("Java",listeTypeMatiere[2]);
        Cours c4=new Cours("Anglais",listeTypeMatiere[0]);


        e.add(c1);
        e.add(c2);
        e.add(c3);

        System.out.println("e : "+e);
        System.out.println("eO.get(0) : " + e.get(0));
        System.out.println("e.getList() : "+e.getList());

        /* REVERSING */
        List<Cours> lesCours2 = Lists.reverse(e.getList());
        System.out.println("lesCours2 : "+lesCours2);

        /*  PARTITIONING  */
        int taille = 2;
        List<List <Cours>> lesCours3 = Lists.partition(e.getList(), taille);
        System.out.println("lesCours3 : "+lesCours3);
        System.out.println("lesCours3.get(0) : "+lesCours3.get(0));
        System.out.println("lesCours3.get(1) : "+lesCours3.get(1));
        System.out.println("lesCours3.size() : "+lesCours3.size());
        System.out.println("lesCours3.get(0).size() : "+lesCours3.get(0).size());
        System.out.println("lesCours3.get(1).size() : "+lesCours3.get(1).size());


        /* FILTERING WITH PREDICATES */

        final Predicate<Cours> coursPredicate = new Predicate<Cours>() {
            @Override
            public boolean apply(Cours c) {
                return c.getNomMatiere().equals("Java");
            }
        };
        final Predicate<Cours> coursPredicate2 = new Predicate<Cours>() {
            @Override
            public boolean apply(Cours c) {
                return c.getTypeMatiere().equals("Cours");
            }
        };


        List<Cours> lesCours4 = Lists.newArrayList(Iterables.filter(e.getList(), coursPredicate));

        System.out.println(lesCours4);
        System.out.println(lesCours4.size());

        lesCours4 = Lists.newArrayList(Iterables.filter(e.getList(), coursPredicate2));

        System.out.println(lesCours4);
        System.out.println(lesCours4.size());


        final boolean isIn = Predicates.in(e.getList()).apply(c1);
        System.out.println(isIn);

        final boolean isNotIn = Predicates.in(e.getList()).apply(c4);
        System.out.println(isNotIn);

    }
}
