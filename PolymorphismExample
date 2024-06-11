// Абстрактный класс Recipe
abstract class Recipe {
// Абстрактный метод для вычисления общего количества ингредиентов
abstract int getTotalIngredients();
}

// Подкласс SaladRecipe, представляющий рецепт салата
class SaladRecipe extends Recipe {
private int vegetables;
private int dressings;

// Конструктор для инициализации количества ингредиентов
public SaladRecipe(int vegetables, int dressings) {
this.vegetables = vegetables;
this.dressings = dressings;
}

// Реализация метода getTotalIngredients для салата
@Override
int getTotalIngredients() {
return vegetables + dressings;
}
}

// Подкласс SoupRecipe, представляющий рецепт супа
class SoupRecipe extends Recipe {
private int vegetables;
private int spices;
private int water;

// Конструктор для инициализации количества ингредиентов
public SoupRecipe(int vegetables, int spices, int water) {
this.vegetables = vegetables;
this.spices = spices;
this.water = water;
}

// Реализация метода getTotalIngredients для супа
@Override
int getTotalIngredients() {
return vegetables + spices + water;
}
}

// Подкласс DessertRecipe, представляющий рецепт десерта
class DessertRecipe extends Recipe {
private int flour;
private int sugar;
private int eggs;

// Конструктор для инициализации количества ингредиентов
public DessertRecipe(int flour, int sugar, int eggs) {
this.flour = flour;
this.sugar = sugar;
this.eggs = eggs;
}

// Реализация метода getTotalIngredients для десерта
@Override
int getTotalIngredients() {
return flour + sugar + eggs;
}
}

// Главный класс для тестирования полиморфизма
public class PolymorphismExample {
public static void main(String[] args) {
// Создание массива рецептов
Recipe[] recipes = new Recipe[3];

// Инициализация массива различными рецептами
recipes[0] = new SaladRecipe(5, 2);
recipes[1] = new SoupRecipe(4, 3, 1);
recipes[2] = new DessertRecipe(2, 3, 4);

// Проход по массиву и вычисление общего количества ингредиентов для каждого рецепта
for (Recipe recipe : recipes) {
System.out.println("Общее количество ингредиентов: " + recipe.getTotalIngredients());
}
}
}
