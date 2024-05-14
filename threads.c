#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
int a = 0; //инициализация глобальной статической переменной, доступной из  каждого tread'a
//Функция, выполняющаяся в рамках второго треада 
void *mythread(void *dummy){
	pthread_t mythid; //Идентификатор треад а для каждого имеет свое значение
	mythid = pthread_self();
	a = a+1;
	printf("Thread %ld, Результат вычисления a = %d\n", mythid, a); //Печать идентификатора текущего треада и  значения глобальной переменной 
	return NULL;
}
int main () {
	pthread_t thid, mythid;	
	int result;
	result = pthread_create(&thid,(pthread_attr_t *)NULL, mythread, NULL); //Создания нового треад при помощи вызова функции mythread()
	if (result !=0) {
		printf("Ошибка при создании нового thread\'a, возвращенное значение =%d\n", result);
		exit (-1);
	}
	printf("Thread создан, thid = %ld\n", thid);
	mythid = pthread_self(); //Сохраняем в переменной mythid идентификатор главного треада
	a = a+1;
	printf("tread %ld, Результат вычисления a =%d\n", mythid, a);
	pthread_join(thid, (void **)NULL);//ожидание завершения порожденного thread'a
	return 0; 
}
