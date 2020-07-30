import java.security.InvalidParameterException;

public class Rute {
    public Hinder hinder;

    Rute(){
        hinder = new IntetHinder(this);
    }

    public void setHinder(Hinder hinder) throws Exception{
        if(hinder == null){
            throw new InvalidParameterException();
        }
        if(this.hinder instanceof IntetHinder) {
            this.hinder = hinder;
        } else {
            throw new Exception("Rute har alerede et hinder");
        }
    }

}
