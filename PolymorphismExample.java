// Абстрактный класс рецепта
abstract class Recipe {
protected String name; // Название рецепта

// Конструктор с параметром для названия рецепта
Recipe(String name) {
this.name = name;
}

// Абстрактный метод для вычисления количества ингредиентов
abstract void calculateIngredients(int numberOfPeople);
}

// Подкласс для супа
class Borscht extends Recipe {
// Конструктор для супа
Borscht() {
super("Борщ"); // Вызов конструктора суперкласса
}

// Реализация метода calculateIngredients для супа
@Override
void calculateIngredients(int numberOfPeople) {
// Вычисление количества ингредиентов для супа Борщ
// (для примера предположим фиксированные значения)
double potatoes = 0.2 * numberOfPeople; // 200 грамм картофеля на человека
double cabbage = 0.1 * numberOfPeople; // 100 грамм капусты на человека
double beets = 0.15 * numberOfPeople; // 150 грамм свеклы на человека

// Вывод количества ингредиентов для супа Борщ
System.out.println("Ингредиенты для супа " + name + " на " + numberOfPeople + " человек:");
System.out.println("Картофель: " + potatoes + " кг");
System.out.println("Капуста: " + cabbage + " кг");
System.out.println("Свекла: " + beets + " кг");
}
}

// Подкласс для салата
class CaesarSalad extends Recipe {
// Конструктор для салата
CaesarSalad() {
super("Цезарь"); // Вызов конструктора суперкласса
}

// Реализация метода calculateIngredients для салата
@Override
void calculateIngredients(int numberOfPeople) {
// Вычисление количества ингредиентов для салата Цезарь
// (для примера предположим фиксированные значения)
double lettuce = 0.1 * numberOfPeople; // 100 грамм салата на человека
double chicken = 0.15 * numberOfPeople; // 150 грамм курицы на человека
double croutons = 0.05 * numberOfPeople; // 50 грамм гренок на человека

// Вывод количества ингредиентов для салата Цезарь
System.out.println("Ингредиенты для салата " + name + " на " + numberOfPeople + " человек:");
System.out.println("Салат: " + lettuce + " кг");
System.out.println("Курица: " + chicken + " кг");
System.out.println("Гренки: " + croutons + " кг");
}
}

// Главный класс для тестирования
public class Main {
public static void main(String[] args) {
int numberOfPeople = 20; // Количество человек

// Создание объектов для супа и салата
Recipe borscht = new Borscht();
Recipe caesarSalad = new CaesarSalad();

// Вычисление и вывод необходимого количества ингредиентов
borscht.calculateIngredients(numberOfPeople);
caesarSalad.calculateIngredients(numberOfPeople);
}
} 
