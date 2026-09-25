abstract class AbstractClass {
    AbstractClass() {
        System.out.println("This is the constructor of the abstract class");
    }

    abstract void aMethod();

    void normalMethod() {
        System.out.println("This is the normal method of the abstract class");
    }
}

class SubClass extends AbstractClass {
    void aMethod() {
        System.out.println("This is an abstract method");
    }

    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.aMethod();
        obj.normalMethod();
    }
}