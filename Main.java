import java.lang.Math;

// Абстрактный класс для геометрических фигур
abstract class Polygon {
protected int numSides; // Количество сторон фигуры

// Конструктор с параметром для установки количества сторон
Polygon(int numSides) {
this.numSides = numSides;
}

// Абстрактный метод для вычисления площади фигуры
abstract double calculateArea();
}

// Подкласс для восьмиугольника
class Octagon extends Polygon {
// Конструктор для восьмиугольника
Octagon() {
super(8); // Вызов конструктора суперкласса с указанием количества сторон
}

// Реализация метода calculateArea для восьмиугольника
@Override
double calculateArea() {
double sideLength = 5.0; // Длина стороны восьмиугольника
return 2 * Math.pow(sideLength, 2) * (1 + Math.sqrt(2)); // Формула площади восьмиугольника
}
}

// Подкласс для девятиугольника
class Nonagon extends Polygon {
// Конструктор для девятиугольника
Nonagon() {
super(9); // Вызов конструктора суперкласса с указанием количества сторон
}

// Реализация метода calculateArea для девятиугольника
@Override
double calculateArea() {
double sideLength = 6.0; // Длина стороны девятиугольника
return 9 * Math.pow(sideLength, 2) / (4 * Math.tan(Math.PI / 9)); // Формула площади девятиугольника
}
}

// Подкласс для десятиугольника
class Decagon extends Polygon {
// Конструктор для десятиугольника
Decagon() {
super(10); // Вызов конструктора суперкласса с указанием количества сторон
}

// Реализация метода calculateArea для десятиугольника
@Override
double calculateArea() {
double sideLength = 7.0; // Длина стороны десятиугольника
return 5 * Math.pow(sideLength, 2) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) / 4; // Формула площади десятиугольника
}
}

// Главный класс для тестирования
public class Main {
public static void main(String[] args) {
// Создание объектов восьмиугольника, девятиугольника и десятиугольника
Polygon octagon = new Octagon();
Polygon nonagon = new Nonagon();
Polygon decagon = new Decagon();

// Вычисление и вывод площади каждой фигуры
System.out.println("Площадь восьмиугольника: " + octagon.calculateArea());
System.out.println("Площадь девятиугольника: " + nonagon.calculateArea());
System.out.println("Площадь десятиугольника: " + decagon.calculateArea());
}
}
