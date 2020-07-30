import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class RuteTest {
    Rute rute;
    @BeforeEach
    void setup(){
        this.rute = new Rute();
    }

    @Test
    void setHinder_nullpointer_InvalidParameterException(){
        assertThrows(InvalidParameterException.class, () -> {
            rute.setHinder(null);
        });
    }

    @Test
    void setHinder_gyldigHinder_hinderSatt(){
        Hinder hinder = new StoppHinder(rute);
        assertDoesNotThrow(() -> {
            rute.setHinder(hinder);
        });
        assertEquals(hinder, rute.hinder);
    }

    @Test
    void setHinder_ingenHinder_IngenException(){

        assertDoesNotThrow(() -> {
            rute.setHinder(new IntetHinder(rute));
        });
    }

    @Test
    void setHinder_HinderSatt_KasterException(){
        assertDoesNotThrow(() -> {
            rute.setHinder(new StoppHinder(rute));
        });

        assertThrows(Exception.class, () -> {
            rute.setHinder(new IntetHinder(rute));
        });
    }
}