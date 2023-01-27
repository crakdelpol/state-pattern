package it.matteo.pipitone.gumballmachine;

public class OutOfGumballState extends State {
    public OutOfGumballState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        throw new RuntimeException();
    }

    @Override
    void ejectQuarter() {
        throw new RuntimeException();
    }

    @Override
    void turnsCrank() {
        throw new RuntimeException();
    }

    @Override
    void dispense() {
        throw new RuntimeException();
    }

    @Override
    void refill(int countOfGumball) {
        gumballMachine.changeState(new NoQuarterState(gumballMachine));
    }

    @Override
    String getState() {
        return "OUT_OF_GUMBALLS";
    }
}
