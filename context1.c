//Подключение библиотек 
#include <sys/types.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
//Главная функция программы
int main(int argc, char *argv[], char *envp[]) {
	int result1;
	//Обьявление переменных
        pid_t procid, parentid; //идентификаторы процессов
        pid_t result; // результат системного вызова fork()
        int a = 0; // Переменная для проверки работы процесса - родителят и процесса - ребенка
        result = fork();
	if (result < 0){
		printf ("Ошибка при выполнении fork()\n");
		exit(-1);
	}
	else if (result == 0){
        	a=a+1;
		procid = getpid(); //Получение идентификатора текущего процесса 
		parentid = getppid(); //Получениеи идентификатора родительского процесса
		printf("Ид. процесса: %d, идю родителя: %d, значение переменной а: %d\n", procid, parentid, a);
        	result1 = execle("/bin/cat", "/bin/cat", "otchet_16_04_2024.txt", 0, envp);
	        // printf() выполняется только в случаяе ошибки вызова execle()
        	printf("ошибка при выполнении системного вызова execle()\n");
       		 exit(-1);

	}
	else {	
		a= a+555; 
		procid = getpid(); //Получение идентификатора текущего процесса 
        	parentid = getppid(); //Получениеи идентификатора родительского процесса
        	printf("Ид. процесса: %d, идю родителя: %d, значение переменной а: %d\n", procid, parentid, a);

	}
	return 0; //Никогда не выполняется
}

