package mcd2;

public class Mcd2 {

    public static void main(String[] args) {
        try {
            System.out.println(mcd(45, 21));
        } catch (ExceptionMinore e) {
//            NO SE DEVO CONSEGNARE AD UN UNTENTE!!!!!
            System.exit(45);
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
                
                if (mcd < 0) {
                    throw new ExceptionMinore(3);
                }
                if (!(a % mcd == 0 && b % mcd == 0)) {
                    throw new ExceptionMinore(4);
                }
            } else {
//                postcondizioni
                mcd = mcd(a, b % a);
                if (mcd < 0) {
                    throw new ExceptionMinore(3);
                }
                if (!(a % mcd == 0 && b % mcd == 0)) {
                    throw new ExceptionMinore(4);
                }
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
                case 3:
                    System.out.println("Metodo MCD: valore mcd negativo"); 
                    System.exit(46);
                    break;
                case 4:
                    System.out.println("Metodo MCD: Resto diverso da 0");
                    System.exit(54);
                    break;
                default:
                    s = "Eccezione non getita";
            }
            System.out.println("Metodo MCD: " + s);
        }
    }

}
