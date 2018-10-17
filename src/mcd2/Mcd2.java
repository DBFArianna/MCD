package mcd2;

public class Mcd2 {

    public static void main(String[] args) {
        try {
            System.out.println(mcd(45, 21));
        } catch (ExceptionMinore e) {

        }
    }

    public static int mcd(int a, int b) throws ExceptionMinore {
        int mcd;
        if (a < 0) {
            throw new ExceptionMinore(1);
        }
        if (b < 0) {
            throw new ExceptionMinore(2);
        }
        if (b == 0) {
            return a;
        } else if (a == 0) {
            return b;
        } else {
            if (a >= b) {
//                postcondizioni
                mcd = mcd(b, a % b);
                assert mcd >= 0 : "Errore di calcolo interno: Mcd negativo";
                assert a % mcd == 0 && b % mcd == 0 : "Errore: l'mcd non è nemmeno un divisore";
            } else {
//                postcondizioni
                mcd = mcd(a, b % a);
                assert mcd >= 0 : "Errore di caloclo interno: Mcd negativo";
                assert a % mcd == 0 && b % mcd == 0 : "Errore: l'mcd non è nemmeno un divisore";
            }
        }
        return mcd;
    }

    private static class ExceptionMinore extends Exception {

        public ExceptionMinore(int nError) {
            String s = "";
            switch (nError) {
                case 1:
                    s = "Primo parametro negativo";
                    break;
                case 2:
                    s = "secondo parametro negativo";
                    break;
                default:
                    s = "Eccezione non getita";
            }
            System.out.println("Metodo MCD: " + s);
        }
    }

}
