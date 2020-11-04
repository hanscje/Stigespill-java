import java.util.Random;

public class Terning {
    private static Random terning = new Random();
    public static int sisteTerningkast;

    public static int kastTerning(){
        sisteTerningkast = (int)Math.ceil(terning.nextDouble()*6);
        return sisteTerningkast;
    }
}
