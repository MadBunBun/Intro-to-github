abstract class Parent {
    abstract void message();
    public static void main(String[] args) {
        Parent obj1 = new Message1();
        Parent obj2 = new Message2();

        obj1.message();
        obj2.message();
    }
}

class Message1 extends Parent {
    void message() {
        System.out.println("This is the first subclass");
    }
}

class Message2 extends Parent {
    void message() {
        System.out.println("This is the second subclass");
    }
}


