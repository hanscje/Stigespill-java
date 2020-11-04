public class Spill {
    BrukerGrensesnitt brukerGrensesnitt;
    Spiller spillere[];
    Brett brett;
    boolean noenHarVunnet = false;


    public static void main(String[] args) {
        Spill spill = new Spill();
    }

    Spill() {
        brukerGrensesnitt = new EnkeltUI();
        try{
            brukerGrensesnitt.lagVindu();
        } catch (Exception e){}
        System.exit(0);
        spillSetup();
        spillLoekke();
    }

    /*private*/ void spillSetup() {
        int brettSize = brukerGrensesnitt.faaBrettStorelse();
        int antallBarrierer = brukerGrensesnitt.faaAntallBarrierer();
        lagBrett(brettSize, antallBarrierer);
        lagSpillere(brukerGrensesnitt.faaSpillernavn());
    }

    void lagBrett(int brettSize, int antallBarrierer){
        brett = new Brett(brettSize, antallBarrierer);
    }

    void lagSpillere(String[] navneListe) throws IllegalArgumentException{
        if(navneListe.length == 0){
            throw new IllegalArgumentException("Ingen spillere som vil spille");
        }
        spillere = new Spiller[navneListe.length];
        for (int i = 0; i < navneListe.length; i++) {
            Spiller nySpiller = new Spiller(navneListe[i], brett);
            spillere[i] = nySpiller;
        }

    }

    //TODO: Se på listner i java
    private void spillLoekke() {
        while(!noenHarVunnet){
            spillRunde();
        }
    }

    private void spillRunde() {
        for (Spiller spiller: spillere) {
            spiller.spillersTur();
            brukerGrensesnitt.skrivUtSpillersRunde(spiller);
            if(spiller.hentRute() instanceof VinnerRute){
                noenHarVunnet = true;
            }
        }

    }

    public int hentAntallSpillere(){
        return spillere.length;
    }

}
