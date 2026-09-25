abstract class Shape {
    abstract void RectangleArea(double length, double breadth);
    abstract void SquareArea(double side);
    abstract void CircleArea(double radius);
    public static void main(String[] args) {
        Area obj = new Area();
        obj.RectangleArea(5, 10);
        obj.SquareArea(4);
        obj.CircleArea(7);
    }
}

class Area extends Shape {
    void RectangleArea(double length, double width) {
        System.out.println("Rectangle Area: " + (length * width));
    }

    void SquareArea(double side) {
        System.out.println("Square Area: " + (side * side));
    }

    void CircleArea(double radius) {
        System.out.println("Circle Area: " + (3.14159 * radius * radius));
    }
}
