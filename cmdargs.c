#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
int main(int argc, char *argv[], char *envp[]) {	
	int i;
 	printf("Кол-во аргументов: %d\n\n", argc);
	for (int i=0; i<argc; i++){
		printf("аргумент %d: %s\n", i, argv[i]);
  	}
	printf("\n");
	i=0;
	while (envp[i]!=NULL){
		printf ("%s\n", envp[i]);
		i++;
	}
return 0;
}
