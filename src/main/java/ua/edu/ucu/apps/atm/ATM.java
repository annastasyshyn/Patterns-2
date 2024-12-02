package ua.edu.ucu.apps.atm;

public class ATM {
    private Banknote firstTray;
    public ATM() {
        firstTray = new Banknote100(new Banknote50(new Banknote5(null)));
    }

    public void process(int amount) {
        firstTray.process(amount);
    }
}