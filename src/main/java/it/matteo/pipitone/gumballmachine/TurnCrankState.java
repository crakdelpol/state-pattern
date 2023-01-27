package it.matteo.pipitone.gumballmachine;

public class TurnCrankState extends State {
    public TurnCrankState(GumballMachine gumballMachine) {
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
        gumballMachine.changeState(new DispenseState(gumballMachine));
    }

    @Override
    void refill(int countOfGumball) {
        throw new RuntimeException();
    }

    @Override
    String getState() {
        return "GUMBALL_SOLD";
    }
}
