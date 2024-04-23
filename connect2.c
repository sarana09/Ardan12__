//Подключение библиотек управления файлами 
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
int  main() {
	int fd;
	size_t size;
//Инициализируем массив символов, чтобы туда записать информацию из файла
	char string[18];
//Открытие файла из чтения
	if((fd = open("file1.txt", O_RDONLY))<0) {
		printf(" ошибка при открытии файла на чтении\n");
		exit(-1);
	}
//Проверка количества прочитанных байт
	size = read(fd, string, 18);
	if (size != 18) {
		printf("Не удалось прочитать всю строку в файл\n");
		exit(-1);
//Запкрытие файла
	}
	  printf("%s\n", string);
	if (close (fd) < 0){
		printf("Не удалось закрыть файл\n");
		exit(-1);
	}
	return 0;
}

