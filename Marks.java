abstract class Marks {
    abstract double getPercentage();
    public static void main(String[] args) {
        A studentA = new A(80, 90, 85);
        B studentB = new B(75, 85, 95, 100);

        System.out.println("Student A Percentage: " + studentA.getPercentage() + "%");
        System.out.println("Student B Percentage: " + studentB.getPercentage() + "%");
    }
}

class A extends Marks {
    int s1, s2, s3;

    A(int s1, int s2, int s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    double getPercentage() {
        return (s1 + s2 + s3) / 3.0;
    }
}

class B extends Marks {
    int s1, s2, s3, s4;

    B(int s1, int s2, int s3, int s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    double getPercentage() {
        return (s1 + s2 + s3 + s4) / 4.0;
    }
}