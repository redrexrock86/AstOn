public interface GeometricFigure {
    double calculatePerimeter();
    double calculateArea();

    default String getBackgroundColor() {
        return "не задан";
    }

    default String getBorderColor() {
        return "не задан";
    }

    void setBackgroundColor(String color);
    void setBorderColor(String color);
}
