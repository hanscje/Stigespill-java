import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StigeHinderTest {
    Hinder hinder;

    @BeforeEach
    public void setup(){
        Rute startRute = new Rute();
        Rute sluttRute = new Rute();
        hinder = new StigeHinder(startRute, sluttRute);
    }
}