> Чудес не бывает:
// Абстрактный класс Recipe
abstract class Recipe {
    private double quantity; // Количество (граммы, литры и т.д.)
    private String name; // Название рецепта

    // Конструктор по умолчанию
    Recipe() {
        quantity = 0.0;
        name = "none";
    }

    // Параметризированный конструктор
    Recipe(double qty, String n) {
        quantity = qty;
        name = n;
    }

    // Конструктор с одинаковыми значениями переменных экземпляра
    Recipe(double qty) {
        quantity = qty;
        name = "none";
    }

    // Конструктор для создания одного объекта на основе другого
    Recipe(Recipe ob) {
        quantity = ob.quantity;
        name = ob.name;
    }

    // Методы доступа к переменным quantity и name
    double getQuantity() {
        return quantity;
    }

    String getName() {
        return name;
    }

    void setQuantity(double qty) {
        quantity = qty;
    }

    void setName(String n) {
        name = n;
    }

    // Абстрактный метод для вычисления необходимых ингредиентов
    abstract void calculateIngredients(int people);
}

// Подкласс Salad, представляющий салат
class Salad extends Recipe {
    private String type; // Тип салата

    // Конструктор по умолчанию
    Salad() {
        super();
        type = "none";
    }

    // Конструктор класса Salad
    Salad(String t, double qty) {
        super(qty, "Салат");
        type = t;
    }

    // Конструктор с одним аргументом для создания салата
    Salad(double qty) {
        super(qty);
        type = "обычный";
    }

    // Конструктор для создания одного объекта на основе другого
    Salad(Salad ob) {
        super(ob);
        type = ob.type;
    }

    // Реализация метода calculateIngredients для салата
    @Override
    void calculateIngredients(int people) {
        double lettucePerPerson = 50.5; // 50.5 грамм салата на человека
        double tomatoPerPerson = 30.3;  // 30.3 грамм помидоров на человека
        double cucumberPerPerson = 20.2; // 20.2 грамм огурцов на человека

        double totalLettuce = people * lettucePerPerson;
        double totalTomato = people * tomatoPerPerson;
        double totalCucumber = people * cucumberPerPerson;

        System.out.println("Для приготовления " + type + " салата на " + people + " человек нужно:");
        System.out.println(totalLettuce + " грамм салата");
        System.out.println(totalTomato + " грамм помидоров");
        System.out.println(totalCucumber + " грамм огурцов");
    }
}

// Подкласс Soup, представляющий суп
class Soup extends Recipe {
    private String soupType; // Тип супа

    // Конструктор по умолчанию
    Soup() {
        super();
        soupType = "none";
    }

    // Конструктор класса Soup
    Soup(String s, double qty) {
        super(qty, "Суп");
        soupType = s;
    }

    // Конструктор с одним аргументом для создания супа
    Soup(double qty) {
        super(qty);
        soupType = "обычный";
    }

    // Конструктор для создания одного объекта на основе другого
    Soup(Soup ob) {
        super(ob);
        soupType = ob.soupType;
    }

    // Реализация метода calculateIngredients для супа
    @Override
    void calculateIngredients(int people) {
        double potatoPerPerson = 100.0;  // 100 грамм картофеля на человека
        double carrotPerPerson = 50.5;   // 50.5 грамм моркови на человека
        double meatPerPerson = 150.75;   // 150.75 грамм мяса на человека

        double totalPotato = people * potatoPerPerson;
        double totalCarrot = people * carrotPerPerson;
        double totalMeat = people * meatPerPerson;

        System.out.println("Для приготовления супа '" + soupType + "' на " + people + " человек нужно:");
        System.out.println(totalPotato + " грамм картофеля");
        System.out.println(totalCarrot + " грамм моркови");
        System.out.println(totalMeat + " грамм мяса");
    }
}

// Главный класс для тестирования полиморфизма
public class PolymorphismExample {
    public static void main(String[] args) {
        int numberOfGirls = 15; // Количество девочек

> Чудес не бывает:
int numberOfBoys = 10; // Количество мальчиков

        // Создание объектов салата и супа
        Recipe salad = new Salad("Цезарь", 1.5);
        Recipe soup = new Soup("Борщ", 2.0);

        // Вычисление и вывод необходимого количества ингредиентов для салата и супа для девочек и мальчиков
        salad.calculateIngredients(numberOfGirls);
        soup.calculateIngredients(numberOfBoys);
    }
}

