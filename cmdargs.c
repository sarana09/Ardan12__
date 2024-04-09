#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
int main(int argc, char *argv[], char *envp[])
 {	
	int i;
 	printf("Кол-во аргументов: %d\n\n", argc);
	if (argc<1){
		printf("Ошибка\n");
		exit(-1); 
	} 
		else if (argc==1){
			while (envp[i]!=NULL){
				printf ("%s\n", envp[i]);
				i++;
	}
}
return 0;
}
