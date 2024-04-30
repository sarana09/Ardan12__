#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(){
/*Создаем массив для хранения файловых дескриптов для чтения и для записи*/
	int fd1[2], fd2[2];
	pid_t result;
	size_t size;
	char string1[] = "Hello, child!", string2[] = "Hello, parent!";
	char resstring1[13], resstring2[14];
/*Попытаемся создать pipe*/
	if(pipe(fd1) < 0){
/*Если создать pipe не удалось, печатаем об этом сообщение и прекращаем работу.*/
		printf("Can't create pipe\n");
		exit(-1);
	}
	result = fork();
	if(pipe(fd2) < 0){
                printf("Can't create pipe\n");
                exit(-1);
        }
        result = fork();
	if (result<0){
		printf("Ошибка выолнения fork()\n");
		exit(-1);
        }
	else if (result>0){
		if (close(fd1[0])<0){
			printf("Ошибка при закрытии pipe на чтение\n ");
	 		exit(-1);
		}
		if (close(fd2[1])<0){
                	printf("Ошибка при закрытии pipe на запись\n ");
       			 exit(-1);
		}
		/*Пробуем записать в pipe 14байт из нашего массива, т.е. всю строку "hello world!" вместе с признаком конца строки */	
		size = write(fd1[1], string1, 13);
		if(size !=13){
/*Если  записалось меньшее кол-во байт, сообщаем об ошибке*/
			 printf("Can't write all string\n");
		 	 exit(-1);
		}
		printf("Процесс - родитель записал информацию в pipe\n");
		size = read(fd2[0], resstring2, 14);
		//Проверка кол-ва байт, прочитанныхь изь pipe () c помощью read()
        	if(size!=14) {
/*Если прочитать не смогли . сообщаем об ошибке*/
                	printf("Can't read string\n");
                	exit(-1);
                }
		printf("Информация от родительского процесса:");
	for (int i=0; i<14; i++) printf("%c", resstring2[i]);
	printf ("\n");	
	if (close(fd1[1]) < 0){
                	printf("Can't close output stream\n");
                	exit(-1);
        	}
		if (close(fd2[0]) < 0){
        	        printf("Can't close output stream\n");
                	exit(-1);
	}
}
else {          
	//закрытие pipe  для записи
	if (close(fd1[1])<0){
                printf("Can't close output stream\n");
                exit(-1);
        }
        if (close(fd2[0])<0){
                printf("Can't close output stream\n");
                exit(-1);
        }

	/*Пробуем прочитать из  pipe 14 байт в другой массив т.е всю записан-ю строку*/
	size = read(fd1[0], resstring1, 13);
	if(size!=13) {
	/*Если прочитать не смогли . сообщаем об ошибке*/
		printf("Can't read string\n");
		exit(-1);
		}
       	printf("%s\n", resstring1);
	for (int i=0; i<13; i++) printf ("%c", resstring1[i]);
	printf("\n");
	 size = write(fd2[1], string2, 14);
        if(size !=14){
/*Если  записалось меньшее кол-во байт, сообщаем об ошибке*/
                 printf("Can't write all string\n");
                 exit(-1);
                }
	printf("Процесс - ребенок записал информацию в pipe\n");
//Закрытие pipe для чтения
	if(close(fd1[0])<0){
		printf("Can't close input stream\n");
		 exit(-1);
		}
// Закрытие pipe для записи
	if (close(fd2[1])<0){
	  	printf("Can't close output stream\n");
		exit(-1);
	}
	}
	return 0;
}



