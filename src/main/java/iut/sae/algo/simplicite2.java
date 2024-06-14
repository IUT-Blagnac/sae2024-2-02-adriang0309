package iut.sae.algo;

public class simplicite2 {

    public static String RLE(String in) {
        // On verifie que la chaine a lentree n'est pas null
        if (in.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

    int count = 1;
    char lastChar = in.charAt(0);

    for (int i = 1; i < in.length(); i++) {
        if (in.charAt(i) == lastChar) {
            count++;
        } else {
            sb.append(count).append(lastChar);
            count = 1;
            lastChar = in.charAt(i);
        }
    }

    // Append the last sequence
    sb.append(count).append(lastChar);

    return sb.toString();

    }

    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration == 1 || in.isEmpty()) {
            return RLE(in);
        } else {
            return RLE(RLE(in, 1), iteration - 1);
        }
    }

    public static String unRLE(String in) throws AlgoException {
        // On vérifie que la chaîne d'entrée n'est pas vide
        if (in.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < in.length(); i++) {
            char cptCaractere = in.charAt(i);
            int cpt = Character.getNumericValue(cptCaractere);
            char caractere = in.charAt(++i);
            for (int j = 0; j < cpt; j++) {
                sb.append(caractere);
            }
        }
        return sb.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException {

        if (iteration == 1 || in.isEmpty()) {
            return unRLE(in);
        } else {
            return unRLE(unRLE(in, 1), iteration - 1);
        }

    }

}