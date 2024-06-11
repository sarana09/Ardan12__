import java.util.ArrayList;
import java.util.List;

// Интерфейс, представляющий блюдо
interface Dish {
// Метод для приготовления блюда
void cook();

// Метод для получения списка ингредиентов
List<Ingredient> getIngredients();
}

// Класс, представляющий суп Борщ
class Borscht implements Dish {
private int servings; // Количество порций

// Конструктор для приготовления Борща на неопределенное количество человек
public Borscht(int servings) {
this.servings = servings;

// Добавление ингредиентов в список
List<Ingredient> ingredients = new ArrayList<>();
ingredients.add(new Ingredient("Свекла", servings / 2));
ingredients.add(new Ingredient("Картофель", servings));
ingredients.add(new Ingredient("Капуста", servings / 2));
ingredients.add(new Ingredient("Морковь", servings / 2));
ingredients.add(new Ingredient("Лук", servings / 2));
ingredients.add(new Ingredient("Томатная паста", servings / 4));
ingredients.add(new Ingredient("Говядина", servings / 2));
ingredients.add(new Ingredient("Вода", servings * 2));
this.ingredients = ingredients;
}

// Метод для приготовления Борща
@Override
public void cook() {
System.out.println("Приготовление Борща на " + servings + " человек");
// TODO: Здесь должен быть код приготовления Борща
}

// Метод для получения списка ингредиентов
@Override
public List<Ingredient> getIngredients() {
return this.ingredients;
}
}

// Класс, представляющий салат Цезарь
class CaesarSalad implements Dish {
private int servings; // Количество порций

// Конструктор для приготовления салата Цезарь на неопределенное количество человек
public CaesarSalad(int servings) {
this.servings = servings;

// Добавление ингредиентов в список
List<Ingredient> ingredients = new ArrayList<>();
ingredients.add(new Ingredient("Салат ромэн", servings));
ingredients.add(new Ingredient("Куриная грудка (гриль)", servings / 2));
ingredients.add(new Ingredient("Пармезан (тертый)", servings / 4));
ingredients.add(new Ingredient("Сухарики", servings / 2));
ingredients.add(new Ingredient("Оливковое масло", servings / 8));
ingredients.add(new Ingredient("Лимонный сок", servings / 8));
ingredients.add(new Ingredient("Вустерширский соус", servings / 16));
ingredients.add(new Ingredient("Соль", servings / 16));
ingredients.add(new Ingredient("Перец", servings / 16));
this.ingredients = ingredients;
}

// Метод для приготовления салата Цезарь
@Override
public void cook() {
System.out.println("Приготовление салата Цезарь на " + servings + " человек");
// TODO: Здесь должен быть код приготовления салата Цезарь
}

// Метод для получения списка ингредиентов
@Override
public List<Ingredient> getIngredients() {
return this.ingredients;
}
}

// Класс, представляющий ингредиент
class Ingredient {
private String name; // Название ингредиента
private int quantity; // Количество ингредиента

// Конструктор для ингредиента
public Ingredient(String name, int quantity) {
this.name = name;
this.quantity = quantity;
}

// Геттер для названия ингредиента
public String getName() {
return this.name;
}

// Геттер для количества ингредиента
public int getQuantity() {
return this.quantity;
}
}

// Основной класс
public class Main {
public static void main(String[] args) {
// Создание объекта Борщ на 4 человека
Dish borscht = new Borscht(4);

// Создание объекта Салат Цезарь на 6 человек
Dish caesarSalad = new CaesarSalad(6);

// Вывод списка ингредиентов для Борща
System.out.println("Ингредиенты для Борща:");
for (Ingredient ingredient : borscht.getIngredients()) {
System.out.println(ingredient.getName() + ": " + ingredient.getQuantity());
}

// Вывод списка ингредиентов для Салата Цезарь
System.out.println("Ингредиенты для Салата Цезарь:");
for (Ingredient ingredient : caesarSalad.getIngredients()) {
System.out.println(ingredient.getName() + ": " + ingredient.getQuantity());
}
}
} 
