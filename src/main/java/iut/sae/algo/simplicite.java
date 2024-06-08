package iut.sae.algo;

public class simplicite {
    public static String compress(String texte) {
        StringBuilder sb = new StringBuilder();
        for (int texteIndex = 0; texteIndex < texte.length(); texteIndex++) {
            int cpt = 1;
            // Tant que le caractère suivant est le même, incrémenter le compteur
            while (texteIndex < texte.length() - 1 && texte.charAt(texteIndex) == texte.charAt(texteIndex + 1)) {
                cpt++;
                texteIndex++;
            }

            // Si le nombre d'occurrences est supérieur à 9, le diviser en plusieurs groupes de 9
            while (cpt > 9) {
                sb.append(texte.charAt(texteIndex)).append(9);
                cpt -= 9;
            }

            // Ajouter le caractère et son nombre d'occurrences au StringBuilder
            sb.append(texte.charAt(texteIndex)).append(cpt);
        }
        return sb.toString();
    }
}