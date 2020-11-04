public class Spiller {
    String spillersNavn;
    Rute spillersPlassering;
    private boolean staaOverNesteKast = false;
    Brett spilleBrett;


    Spiller(String spillersNavn, Brett spilleBrett) {
        this.spilleBrett = spilleBrett;
        this.spillersNavn = spillersNavn;
        this.spillersPlassering = spilleBrett.faaStartRute();
    }

    public void flyttSpiller(Rute nyRute) {
        spillersPlassering = nyRute;
        spillersPlassering.hinder.aktiver(this);
    }


    public boolean spillersTur() {
        if (staaOverNesteKast) {
            staaOverNesteKast = false;
            return false;
        }
        int terningskast = Terning.kastTerning();
        Rute gaaTilRute = spilleBrett.finnSpillersNesteRute(this.spillersPlassering, terningskast);
        flyttSpiller(gaaTilRute);

        return true;
    }


    public int hentSpillersRutePlassering() {
        int ruteplassering = -1;
        try {
            ruteplassering = spilleBrett.finnRuteIndex(spillersPlassering);
        } catch (IndexOutOfBoundsException e){}
        return ruteplassering;
    }
    public void landetPaaStaaOverRute() {
        staaOverNesteKast = true;
    }

    public Rute hentRute(){
        return this.spillersPlassering;
    }

    public String getSpillersNavn(){
        return spillersNavn;
    }
}
