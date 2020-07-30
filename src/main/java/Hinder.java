abstract class Hinder {
    protected Rute hinderPlassering;

    Hinder(Rute rute){
        this.hinderPlassering = rute;
    }
    public abstract void aktiver(Spiller spiller);

}

