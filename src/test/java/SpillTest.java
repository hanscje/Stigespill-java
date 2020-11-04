import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpillTest {
    String navneList[] = {"Gunnar", "Berit", "Ahmed", "Sara" };
    Spill spill;

    @BeforeEach
    void setup() {
        spill = new Spill();
    }

    @Test
    void main() {
    }




    @Test
    void lagSpillere_spillerNavn_harLagtTilSpillere () {
        assertDoesNotThrow(() -> {
            spill.lagSpillere (navneList);
        });

        assertEquals(navneList.length, spill.hentAntallSpillere());
    }

    @Test
    void lagSpillere_spillerNavnTomList_kasterInvalidArgumentException () {
        String[] tomNavneListe = {};
        assertThrows(IllegalArgumentException.class, () ->{
            spill.lagSpillere(tomNavneListe);
        });
    }

    @Test
    void lagBrett_spilleBrett_harLagtTilSpilleBrett() {
        int brettStorrelse = 12;
        int antallBarrierer = 4;

        assertDoesNotThrow(()->{
            spill.lagBrett(brettStorrelse, antallBarrierer);
        });
    }



    @Test
    void spillLoekke() {

    }

    @Test
    void spillRunde() {

    }
}