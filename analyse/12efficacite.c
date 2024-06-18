#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

char* RLE(const char* chaine) {
    if (chaine == NULL || strlen(chaine) == 0) {
        return "";
    }

    int len = strlen(chaine);
    char* resultat = (char*)malloc(len * 2 + 1);
    int index = 0;
    int cpt = 1;
    char premierCaractere = chaine[0];

    for (int i = 1; i < len; i++) {
        if (chaine[i] == premierCaractere) {
            cpt++;
            if (cpt == 9) {
                index += sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
                cpt = 0;
            }
        } else {
            if (cpt > 0) {
                index += sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
            }
            premierCaractere = chaine[i];
            cpt = 1;
        }
    }

    if (cpt > 0) {
        sprintf(&resultat[index], "%d%c", cpt, premierCaractere);
    }

    return resultat;
}

char* unRLE(const char* chaine) {
    if (chaine == NULL || strlen(chaine) == 0) {
        return "";
    }

    int len = strlen(chaine);
    char* resultat = (char*)malloc(len * 9 + 1);
    int index = 0;
    int i = 0;

    while (i < len) {
        if (isdigit(chaine[i])) {
            int nombre = chaine[i] - '0';
            char caractereSuivant = chaine[i + 1];
            for (int j = 0; j < nombre; j++) {
                resultat[index++] = caractereSuivant;
            }
            i += 2;
        } else {
            resultat[index++] = chaine[i];
            i++;
        }
    }

    resultat[index] = '\0';
    return resultat;
}

char* RLE_Recursif(const char* chaine, int iteration) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < iteration; i++) {
        char* temp = RLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}

char* unRLE_Recursif(const char* chaine, int iteration) {
    char* resultat = strdup(chaine);
    for (int i = 0; i < iteration; i++) {
        char* temp = unRLE(resultat);
        free(resultat);
        resultat = temp;
    }
    return resultat;
}