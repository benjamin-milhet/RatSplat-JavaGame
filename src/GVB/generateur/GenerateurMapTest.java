package GVB.generateur;

import org.junit.jupiter.api.Test;
import GVB.fakeGVB;
import static org.junit.jupiter.api.Assertions.*;

class GenerateurMapTest {

    @Test
    void generer() {
        fakeGVB gvb = new fakeGVB();

        GenerateurMap generateurMap = new GenerateurMap(gvb);
        gvb.addItem(generateurMap);
        generateurMap.generer();

        assertEquals(66,gvb.getliseObjetSize());
    }
}