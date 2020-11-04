import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpillerTest {
    Spiller spiller;

    @BeforeEach
    void setup(){
        Brett testBrett = new Brett(12, 4);
        spiller = new Spiller("testNavn", testBrett);
    }

    @Test
    void flyttSpiller() {
    }

    @Test
    void spillersTur_landetPaaStopHinder_kanIkkeGaaVidere() {
        spiller.landetPaaStaaOverRute();
        assertFalse(spiller.spillersTur());
    }

    @Test
    void spillersTur_landetPaaStopHinder_kanIkkeGaaVidereForNesteRunde() {
        spiller.landetPaaStaaOverRute(); //for å sette tilstand hos spiller
        assertFalse(spiller.spillersTur());
        assertTrue(spiller.spillersTur()); //(simulert neste runde)
    }

    @Test
    void spillersTur_spillerKanKaste_skalKunneGaaVidere(){
        assertTrue(spiller.spillersTur());
    }
}