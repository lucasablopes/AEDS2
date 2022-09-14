#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char* phrase){
    if(strlen(phrase) == 4 && phrase[0] == 'F' && phrase[1] == 'I' && phrase[2] == 'M')
        return false;
    else 
        return true;
}

bool isVowel(char* phrase){
    bool answ = true;
    for(int i=0; i<strlen(phrase)-1; i++)
        if(!(((int)phrase[i] == 'A' || (int)phrase[i] == 'a') || ((int)phrase[i] == 'E' || (int)phrase[i] == 'e') || ((int)phrase[i] == 'I' || (int)phrase[i] == 'i') || ((int)phrase[i] == 'O' || (int)phrase[i] == 'o') || ((int)phrase[i] == 'U' || (int)phrase[i] == 'u')))
            answ = false;

    return answ;
}

bool isConsonant(char* phrase){
    bool answ = true;
    for(int i=0; i<strlen(phrase)-1; i++){
        if(!(((int)phrase[i] >= 65 && (int)phrase[i] <= 90) || ((int)phrase[i] >= 97 && (int)phrase[i] <= 122))) {
            answ = false;
        }
        if((((int)phrase[i] == 'A' || (int)phrase[i] == 'a') || ((int)phrase[i] == 'E' || (int)phrase[i] == 'e') || ((int)phrase[i] == 'I' || (int)phrase[i] == 'i') || ((int)phrase[i] == 'O' || (int)phrase[i] == 'o') || ((int)phrase[i] == 'U' || (int)phrase[i] == 'u')))
            answ = false;
    }
    return answ;
}

bool isInteiro(char* phrase){
    bool answ = true;

    for(int i=0; i<strlen(phrase)-1; i++)
        if((int)phrase[i] < 47 || (int)phrase[i] > 57)
            answ = false;


    return answ;
}

bool isReal(char* phrase){
    bool answ = true;
    int cont = 0;

    for(int i=0; i<strlen(phrase)-1; i++){
        if(((int)phrase[i] < 47 && (int)phrase[i] != ',' && (int)phrase[i] != '.') || (int)phrase[i] > 57)
            answ = false;
        if((int)phrase[i] == '.' || (int)phrase[i] == ',')
            ++cont;
    }

    if(cont > 1)
        answ = false;

    return answ;
}

int main(){
    char phrase[150];
    bool array[4];

    fgets(phrase, sizeof(phrase), stdin);

    while(isFim(phrase)){
        
        setbuf(stdin, NULL);

        array[0] = isVowel(phrase);
        array[1] = isConsonant(phrase);
        array[2] = isInteiro(phrase);
        array[3] = isReal(phrase);

        for(int i=0; i<4; i++){
            if(array[i])
                printf("SIM ");
            else
                printf("NAO ");
        }
        printf("\n");

        fgets(phrase, sizeof(phrase), stdin);
    }



    return 0;
}