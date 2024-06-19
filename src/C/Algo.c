#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Fonction RLE
char* RLE(char* text) {
    char lettre = text[0];
    char* chaineFinale = (char*)malloc(strlen(text) * 2 + 1);
    int compteurLettre = 0;
    int indexChaineFinale = 0;

    for (int i = 0; i < strlen(text); i++) {
        if (lettre == text[i] && compteurLettre < 9) {
            compteurLettre++;
        } else {
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2;
            compteurLettre = 1;
            lettre = text[i];
        }

        if (compteurLettre == 9) {
            sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
            indexChaineFinale += 2;
            if (i < strlen(text) - 1) {
                lettre = text[i + 1];
            }
            compteurLettre = 0;
        }
    }

    if (compteurLettre > 0) {
        sprintf(chaineFinale + indexChaineFinale, "%d%c", compteurLettre, lettre);
    }

    return chaineFinale;
}

// Fonction RLE récursive
char* RLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < nombre; i++) {
        char* temp = RLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}

// Fonction unRLE
char* unRLE(const char* chaine) {
    int length = strlen(chaine);
    char* result = malloc(length * sizeof(char));
    int index = 0;

    for (int i = 0; i < length; i += 2) {
        int nombre = chaine[i] - '0';
        char caractere = chaine[i + 1];

        for (int j = 0; j < nombre; j++) {
            result[index++] = caractere;
        }
    }
    result[index] = '\0';  // Null-terminate the string
    return result;
}

// Fonction unRLE récursive
char* unRLE_recursif(const char* chaine, int nombre) {
    char* resultat = strdup(chaine);

    for (int i = 0; i < nombre; i++) {
        char* temp = unRLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}

// Tests unitaires
void test_RLE() {
    char* result;

    result = RLE("");
    printf("RLE(\"\") -> %s\n", result);
    free(result);

    result = RLE("abc");
    printf("RLE(\"abc\") -> %s\n", result);
    free(result);

    result = RLE("abbccc");
    printf("RLE(\"abbccc\") -> %s\n", result);
    free(result);

    result = RLE("aaabaa");
    printf("RLE(\"aaabaa\") -> %s\n", result);
    free(result);

    result = RLE("aAa");
    printf("RLE(\"aAa\") -> %s\n", result);
    free(result);

    result = RLE("WWWWWWWWWWWWW");
    printf("RLE(\"WWWWWWWWWWWWW\") -> %s\n", result);
    free(result);
}

void test_RLE_rec() {
    char* result;

    result = RLE_recursif("", 1);
    printf("RLE_recursif(\"\", 1) -> %s\n", result);
    free(result);

    result = RLE_recursif("", 3);
    printf("RLE_recursif(\"\", 3) -> %s\n", result);
    free(result);

    result = RLE_recursif("abc", 1);
    printf("RLE_recursif(\"abc\", 1) -> %s\n", result);
    free(result);

    result = RLE_recursif("abbccc", 1);
    printf("RLE_recursif(\"abbccc\", 1) -> %s\n", result);
    free(result);

    result = RLE_recursif("aaabaa", 1);
    printf("RLE_recursif(\"aaabaa\", 1) -> %s\n", result);
    free(result);

    result = RLE_recursif("aAa", 1);
    printf("RLE_recursif(\"aAa\", 1) -> %s\n", result);
    free(result);

    result = RLE_recursif("abc", 2);
    printf("RLE_recursif(\"abc\", 2) -> %s\n", result);
    free(result);

    result = RLE_recursif("abc", 3);
    printf("RLE_recursif(\"abc\", 3) -> %s\n", result);
    free(result);
}

void test_unRLE() {
    char* result;

    result = unRLE("");
    printf("unRLE(\"\") -> %s\n", result);
    free(result);

    result = unRLE("1a1b1c");
    printf("unRLE(\"1a1b1c\") -> %s\n", result);
    free(result);

    result = unRLE("1a2b3c");
    printf("unRLE(\"1a2b3c\") -> %s\n", result);
    free(result);

    result = unRLE("3a1b2a");
    printf("unRLE(\"3a1b2a\") -> %s\n", result);
    free(result);

    result = unRLE("1a1A1a");
    printf("unRLE(\"1a1A1a\") -> %s\n", result);
    free(result);

    result = unRLE("9W4W");
    printf("unRLE(\"9W4W\") -> %s\n", result);
    free(result);
}

void test_unRLE_rec() {
    char* result;

    result = unRLE_recursif("", 1);
    printf("unRLE_recursif(\"\", 1) -> %s\n", result);
    free(result);

    result = unRLE_recursif("", 3);
    printf("unRLE_recursif(\"\", 3) -> %s\n", result);
    free(result);

    result = unRLE_recursif("1a1b1c", 1);
    printf("unRLE_recursif(\"1a1b1c\", 1) -> %s\n", result);
    free(result);

    result = unRLE_recursif("1a2b3c", 1);
    printf("unRLE_recursif(\"1a2b3c\", 1) -> %s\n", result);
    free(result);

    result = unRLE_recursif("3a1b2a", 1);
    printf("unRLE_recursif(\"3a1b2a\", 1) -> %s\n", result);
    free(result);

    result = unRLE_recursif("1a1A1a", 1);
    printf("unRLE_recursif(\"1a1A1a\", 1) -> %s\n", result);
    free(result);

    result = unRLE_recursif("111a111b111c", 2);
    printf("unRLE_recursif(\"111a111b111c\", 2) -> %s\n", result);
    free(result);

    result = unRLE_recursif("311a311b311c", 3);
    printf("unRLE_recursif(\"311a311b311c\", 3) -> %s\n", result);
    free(result);
}

int main() {
    test_RLE();
    test_RLE_rec();
    test_unRLE();
    test_unRLE_rec();

    return 0;
}
