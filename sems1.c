#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>
#include <stdlib.h>
int main(){
	int semid;// идентификатор айписи для массива симафора
	char pathname[] = "forftok.ipc";//Файл, используемыйдля генерации шзс - ключа
	key_t key;// айписи ключ
	struct sembuf mybuf;//Cтруктура для задания операции над семафорам
 	//Генерация ключа айписи
	if((key = ftok(pathname, 0)) < 0){
		printf("Не удалось сгенерировать ipc-ключ\n");
		exit(-1);
	}
	//Получение доступа к м ассиву семафоров по айписи ключу
	if ((semid = semget(key, 1, 0666 | IPC_CREAT)) <0){
		printf("Не удалось получить доступ к масству семафоров\n");
		exit(-1);
	}
	mybuf.sem_op = -1;
	mybuf.sem_flg = 0;
	mybuf.sem_num = 0;
	//Выполняем операции
	if(semop(semid, &mybuf, 1) <0) {
		printf("Не удалось выполнить операцию над семафором 0\n");
		exit(-1);
	}
	printf("Условие уствновлено\n");
	return 0;
}
