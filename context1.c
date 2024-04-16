//Подключение библиотек 
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
//Главная функция программы
int main(int argc, char *argv[], char *envp[]) {
	int result;
	//Запуск программы cat с аргументам щтчет-16-04-2024.ече
	result = execle("/bin/cat", "/bin/cat", "otchet_16_04_2024.txt", 0, envp);
	// printf() выполняется только в случаяе ошибки вызова execle()
	printf("ошибка при выполнении системного вызова execle()\n");
	exit(-1);
	return 0; //Никогда не выполняется
}

