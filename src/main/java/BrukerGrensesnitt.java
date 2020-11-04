import java.io.IOException;

public abstract class BrukerGrensesnitt {

    public int faaBrettStorelse() {
        return 9;
    }

    public int faaAntallBarrierer() {
        return 4;
    }

    public String[] faaSpillernavn() {
        return new String[] {"Gunnar", "Berit", "Ahmed", "Sara" };
    }

    public abstract void skrivUtSpillersRunde(Spiller spiller);
    public abstract void lagVindu() throws IOException;


}
