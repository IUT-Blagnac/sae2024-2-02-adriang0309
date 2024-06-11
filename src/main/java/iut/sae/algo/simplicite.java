package iut.sae.algo;

public class simplicite {

    public static String RLE(String in) {
        // On verifie que la chaine a lentree n'est pas null
        if (in.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int cpt = 1;

        for (int i = 1; i < in.length(); i++) {
            if (in.charAt(i) == in.charAt(i - 1)) {
                if (cpt < 9) {
                    cpt++;
                } else {
                    sb.append(9).append(in.charAt(i - 1));
                    cpt = 1;
                }
            } else {
                sb.append(cpt).append(in.charAt(i - 1));
                cpt = 1;
            }
        }
        sb.append(cpt).append(in.charAt(in.length() - 1));
        return sb.toString();

    }

    public static String RLE(String in, int iteration) throws AlgoException {
        // Provide your algo here
        return "NotYetImplemented";
    }

    public static String unRLE(String in) throws AlgoException {
        // Provide your algo here
        return "NotYetImplemented";

    }

    public static String unRLE(String in, int iteration) throws AlgoException {
        // Provide your algo here
        return "NotYetImplemented";

    }

}