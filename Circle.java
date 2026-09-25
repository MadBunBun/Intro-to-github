public class Circle {
    double radius;
    final double PI = Math.PI;

    public Circle() {
        this.radius = 1.0;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void calculateCircumference() {
        System.out.println("Circumference: " + (2 * PI * radius));
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle();
        circle2.setRadius(5.0);

        circle1.calculateCircumference();
        circle2.calculateCircumference();
    }
}
