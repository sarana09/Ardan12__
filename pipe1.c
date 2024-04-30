#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(){
/*Создаем массив для хранения файловых дескриптов для чтения и для записи*/
	int fd[2];
	pid_t result;
	size_t size;
	char string[] = "Hello, world!";
	char resstring[14];
/*Попытаемся создать pipe*/
	if(pipe(fd)<0){
/*Если создать pipe не удалось, печатаем об этом сообщение и прекращаем работу.*/
		printf("Can\'t create pipe\n");
		exit(-1);
		}
	result = fork();
	if (result<0){
		printf("Ошибка выолнения fork()\n");
		exit(-1);
}
	else if (result>0){
		if (close(fd[0])<0){
		printf("Ошибка при закрытии pipe на чтение\n ");
	exit(-1);
	}
/*Пробуем записать в pipe 14байт из нашего массива, т.е. всю строку "hello world!" вместе с признаком конца строки */	
		size = write(fd[1], string, 14);
	if(size !=14){
/*Если  записалось меньшее кол-во байт, сообщаем об ошибке*/
		 printf("Can\'t write all string\n");
		 exit(-1);
		}
		printf("Процесс - родитель записал информацию в pipe и заканчивает работу\n");
		if (close(fd[1]) < 0){
                printf("Can\'t close output stream\n");
                exit(-1);
        }
}
else {
		if (close(fd[1])<0){
                printf("Can\'t close output stream\n");
                exit(-1);
        }
 
	/*Пробуем прочитать из  pipe 14 байт в другой массив т.е всю записан-ю строку*/
		size = read(fd[0], resstring, 14);
//Проверка кол-ва байт, прочитанныхь изь pipe () c помощью read()
	if(size!=14) {
/*Если прочитать не смогли . сообщаем об ошибке*/
		printf("Can\'t read string\n");
		exit(-1);
		}
/*Печатаем прочитанную строку*/
		printf("%s\n", resstring);
		exit (-1);
//Закрытие pipe для чтения
	if(close(fd[0])<0){
		printf("Can\'t close input stream\n");
		 exit(-1);
	}
// Закрытие pipe для записи
	if (close(fd[1])<0){
	  	printf("Can\'t close output stream\n");
		exit(-1);
	
	}
}
	return 0;

	}

