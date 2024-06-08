package iut.sae.algo;

import java.util.regex.Pattern;

public class efficacite {
    public static String compress(String texte) {
        StringBuilder sb = new StringBuilder();
        // On lit les caractères puis on cherche les occurrences consecutif de cette meme lettre grace au \\2*
        Pattern pattern = Pattern.compile("(([a-zA-Z])\\2*)");
        // Ici on cherche les meme caracteres du input texte pour les compter
        pattern.matcher(texte).results().forEach(resultat -> {
            int rep = resultat.group(1).length();
            
             // Si le nombre d'occurrences est supérieur à 9, le diviser en plusieurs groupes de 9
            while (rep > 9) {
                sb.append(resultat.group(2)).append(9);
                rep -= 9;
            }
            sb.append(resultat.group(2)).append(rep);
        });
        return sb.toString();
    }
}