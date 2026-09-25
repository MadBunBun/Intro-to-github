
public class Triangle {
    int a, b, c;

    public Triangle() {
        this.a = 3;
        this.b = 4;
        this.c = 5;
    } 

    public void calculate() {
        int perimeter = a + b + c;
        double s = perimeter / 2.0;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.calculate();
    }
}
