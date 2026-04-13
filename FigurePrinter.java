public class FigurePrinter {
    public static void printFigureInfo(GeometricFigure figure) {
        System.out.println("Периметр: " + figure.calculatePerimeter());
        System.out.println("Площадь: " + figure.calculateArea());
        System.out.println("Цвет заливки: " + figure.getBackgroundColor());
        System.out.println("Цвет границы: " + figure.getBorderColor());
        System.out.println("------------------------");
    }
}

