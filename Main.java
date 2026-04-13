public class Main {
    public static void main(String[] args) {
        // Создаём фигуры
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);

        // Устанавливаем цвета
        circle.setBackgroundColor("красный");
        circle.setBorderColor("синий");

        rectangle.setBackgroundColor("зелёный");
        rectangle.setBorderColor("жёлтый");

        triangle.setBackgroundColor("оранжевый");
        triangle.setBorderColor("фиолетовый");

        // Выводим информацию
        System.out.println("Круг:");
        FigurePrinter.printFigureInfo(circle);

        System.out.println("Прямоугольник:");
        FigurePrinter.printFigureInfo(rectangle);

        System.out.println("Треугольник:");
        FigurePrinter.printFigureInfo(triangle);
    }
}

