package mcd2;

public class Mcd2 {

    public static void main(String[] args) {
        try {
            System.out.println(mcd(21, 21));
        } catch (ExceptionMinore e) {
            System.out.println(e);
        }
    }

    public static int mcd(int a, int b) throws ExceptionMinore {
        int mcd;
        if (b == 0) {
            return a;
        } else {
            if (a >= b) {
                mcd = mcd(b, a % b);
            } else {
                throw new ExceptionMinore("b deve essere > di a");
            }
        }
        return mcd;
    }
}

class ExceptionMinore extends Exception {

    public ExceptionMinore(String s) {
        System.out.println(s);
        System.exit(1);
    }
}
