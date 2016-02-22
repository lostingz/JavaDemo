/*********************************************/
public class Test7 extends Test6 {

    public static int j = Test6.i;

    static {
        j++;
    }

    {
        j++;
    }
}