public class Rectangle implements GeometricFigure {
    private double width;
    private double height;
    private String backgroundColor;
    private String borderColor;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
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

