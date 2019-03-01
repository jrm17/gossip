package es.mango;

public class MangoUtil {

    public int randomWithRange(int min, int max) throws Exception {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }


}
