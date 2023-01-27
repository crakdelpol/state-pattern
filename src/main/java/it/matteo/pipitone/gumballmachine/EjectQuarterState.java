package it.matteo.pipitone.gumballmachine;

public class EjectQuarterState extends State {

    public EjectQuarterState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    void insertQuarter() {
        gumballMachine.changeState(new HasQuarterState(gumballMachine));
    }

    @Override
    void ejectQuarter() {
        throw new RuntimeException("Cannot reject twice");
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
        throw new RuntimeException();
    }

    @Override
    String getState() {
        return "NO_QUARTER";
    }
}
