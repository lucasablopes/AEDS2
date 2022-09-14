#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int main(){
    int n;
    double write, read;

    FILE * answ = fopen("answ.txt", "wb");
    
    scanf("%d", &n);

    for(int i=0; i<n; i++){
        scanf("%lf", &write);
        fwrite(&write, sizeof(double), 1, answ);
    }

    fclose(answ);

    FILE * answ2 = fopen("answ.txt", "r");

    for(int i=1; i<=n; i++){
        fseek(answ2,-i*(sizeof(double)),SEEK_END);
        fread(&read, sizeof(double), 1, answ2);
        printf("%g\n", read);
    }
    
    fclose(answ2);

    return 0;
}