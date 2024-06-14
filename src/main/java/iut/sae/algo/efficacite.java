package iut.sae.algo;

import java.util.regex.Pattern;

public class efficacite {
    
    public static String RLE(String in){
        StringBuilder sb = new StringBuilder();
        // On lit les caractères puis on cherche les occurrences consécutives de cette même lettre grâce au \\2*
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        // Ici on cherche les mêmes caractères du texte d'entrée pour les compter
        pattern.matcher(in).results().forEach(resultat -> {
            int rep = resultat.group(1).length();

            // Si le nombre d'occurrences est supérieur à 9, le diviser en plusieurs groupes de 9
            while (rep > 9) {
                sb.append(9).append(resultat.group(2));
                rep -= 9;
            }
            sb.append(rep).append(resultat.group(2));
        });
        return sb.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration == 1 || in.isEmpty()) {
            return RLE(in);
        } else {
            return RLE(RLE(in, 1), iteration - 1);
        }
    }

    public static String unRLE(String in) throws AlgoException{
        if (in.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < in.length(); i++) {
            int cpt = in.charAt(i) - '0'; // Convertir le caractère numérique en valeur entière
            char caractere = in.charAt(++i);
            for (int j = 0; j < cpt; j++) {
                sb.append(caractere);
            }
        }
        return sb.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        return "NotYetImplemented";

    }
}