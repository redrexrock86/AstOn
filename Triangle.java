public class Triangle implements GeometricFigure {
    private double sideA;
    private double sideB;
    private double sideC;
    private String backgroundColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2; // полупериметр
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)); // формула Герона
    }

    @Override
    public void setBackgroundColor(String color) {
        this.backgroundColor = color;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
