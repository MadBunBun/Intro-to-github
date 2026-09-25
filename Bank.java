abstract class Bank {
    abstract int getBalance();
    public static void main(String[] args) {
        Bank a = new BankA();
        Bank b = new BankB();
        Bank c = new BankC();

        System.out.println("Bank A Balance: $" + a.getBalance());
        System.out.println("Bank B Balance: $" + b.getBalance());
        System.out.println("Bank C Balance: $" + c.getBalance());
    }
}

class BankA extends Bank {
    int getBalance() { return 100; }
}

class BankB extends Bank {
    int getBalance() { return 150; }
}

class BankC extends Bank {
    int getBalance() { return 200; }
}
