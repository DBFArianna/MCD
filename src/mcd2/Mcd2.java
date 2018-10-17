package mcd2;

public class Mcd2 {

    public static void main(String[] args) {
        try {
            System.out.println(mcd(0, 21));
        } catch (ExceptionMinore e) {
            System.out.println(e);
        }
    }

    public static int mcd(int a, int b) throws ExceptionMinore {
        int mcd;
        if (a < 0 || b < 0) {
            throw new ExceptionMinore("I dati non possono essere minori di 0");
        }
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        } else {
            if (a >= b) {
                mcd = mcd(b, a % b);
            } else {
                mcd = mcd(a, b % a);
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
