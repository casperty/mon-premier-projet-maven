import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alexandre on 01/04/2014.
 */
public class TestCase {
    private Etudiant e;
    private Cours c1,c2,c3, c4;
    // liste des types de matiere
    private String [] listeTypeMatiere={"Cours","TD","TP"};
    @Before
    public void before(){
        // etudiant
        e=new Etudiant("Alexandre", "Ravaux", 20);
        // cours
        c1=new Cours("Java",listeTypeMatiere[0]);
        c2=new Cours("Java",listeTypeMatiere[1]);
        c3=new Cours("Java",listeTypeMatiere[2]);
        c4=new Cours("Anglais",listeTypeMatiere[0]);
    }

    /**
     * Casual tests
     * @throws Exception
     */

    /* display student */
    @Test
    public void testEtudiant() throws Exception {
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        String output=e.toString();
        // Then
        assertEquals("Etudiant{prenom=Alexandre, nom=Ravaux, age=20, lesCours=[Cours{Nom de la matiere : =Java, Type  : =Cours}, Cours{Nom de la matiere : =Java, Type  : =TD}, Cours{Nom de la matiere : =Java, Type  : =TP}]}", output);
    }

    /* display course */
    @Test
    public void testCours() throws Exception {
        // Given

        // When
        String output=c1.toString();
        // Then
        assertEquals("Cours{Nom de la matiere : =Java, Type  : =Cours}", output);
    }

    /* display item from list */
    @Test
    public void testgetItem() throws Exception {
        // Given
        e.add(c1);
        // When
        String output=""+e.get(0);
        // Then
        assertEquals("Cours{Nom de la matiere : =Java, Type  : =Cours}", output);
    }

    /* display list */
    @Test
    public void testgetList() throws Exception {
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        String output=""+e.getList();
        assertThat(e.getList()).containsExactly(c1, c2, c3);
        assertThat(e.getList()).extracting("nomMatiere").containsOnly("Java");
        assertThat(e.getList()).extracting("typeMatiere").contains("Cours", "TD", "TP");

        // Then
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =Cours}, Cours{Nom de la matiere : =Java, Type  : =TD}, Cours{Nom de la matiere : =Java, Type  : =TP}]", output);
    }

    /**
     * Specific tests
     */

    /* test reversing list */
    @Test
    public void testReverse() throws Exception {
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        List<Cours> lesCours2 = Lists.reverse(e.getList());
        String output=""+lesCours2;
        // Then
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =TP}, Cours{Nom de la matiere : =Java, Type  : =TD}, Cours{Nom de la matiere : =Java, Type  : =Cours}]", output);
    }

    /* partitionning */
    @Test
    public void testPartition() throws Exception {
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        int taille = 2;
        int tailleList0 = 2;
        int tailleList1 = 1;
        List<List <Cours>> lesCours3 = Lists.partition(e.getList(), taille);
        String output=""+lesCours3;
        String output2=""+lesCours3.get(0);
        String output3=""+lesCours3.get(1);
        // Then
        /* Display */
        assertEquals("[[Cours{Nom de la matiere : =Java, Type  : =Cours}, Cours{Nom de la matiere : =Java, Type  : =TD}], [Cours{Nom de la matiere : =Java, Type  : =TP}]]", output);
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =Cours}, Cours{Nom de la matiere : =Java, Type  : =TD}]", output2);
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =TP}]", output3);
        /* Size */
        assertEquals(taille, lesCours3.size());
        assertEquals(tailleList0, lesCours3.get(0).size());
        assertEquals(tailleList1,lesCours3.get(1).size());
    }
    /* filtering the list with predicates */
    public void testFiltering() throws Exception {
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        int nb=3, nb2=1;
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
        List<Cours> l = Lists.newArrayList(Iterables.filter(e.getList(), coursPredicate));
        List<Cours> l2 = Lists.newArrayList(Iterables.filter(e.getList(), coursPredicate2));
        // Then
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =Cours}, Cours{Nom de la matiere : =Java, Type  : =TD}, Cours{Nom de la matiere : =Java, Type  : =TP}]", "" + l);
        assertEquals("[Cours{Nom de la matiere : =Java, Type  : =Cours}]",""+l2);
        assertEquals(nb,l.size());
        assertEquals(nb2,l2.size());
    }
    /* predicates */
    public void testPredicates() throws Exception{
        // Given
        e.add(c1);
        e.add(c2);
        e.add(c3);
        // When
        final boolean isIn = Predicates.in(e.getList()).apply(c1);
        final boolean isNotIn = Predicates.in(e.getList()).apply(c4);
        // Then
        assertEquals(true,isIn);
        assertEquals(false,isNotIn);
    }

}
