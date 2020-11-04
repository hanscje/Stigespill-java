public class StoppHinder extends Hinder {

    StoppHinder(Rute rute){
        super(rute);
    }

    @Override
    public void aktiver(Spiller spiller) {
        spiller.landetPaaStaaOverRute();
    }
}
