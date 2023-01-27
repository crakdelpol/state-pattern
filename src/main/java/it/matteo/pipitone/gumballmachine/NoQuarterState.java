package it.matteo.pipitone.gumballmachine;

public class NoQuarterState extends State {
    public NoQuarterState(
          GumballMachine gumballMachine
    ) {
        super(gumballMachine);
    }

    @Override
    public void insertQuarter() {
        gumballMachine.changeState(new HasQuarterState(gumballMachine));
    }

    @Override
    public void ejectQuarter() {
        throw new RuntimeException();
    }

    @Override
    public void turnsCrank() {
        throw new RuntimeException();
    }

    @Override
    public void dispense() {
        throw new RuntimeException();
    }

    @Override
    void refill(int countOfGumball) {
        gumballMachine.addGumballs(countOfGumball);
    }

    @Override
    public String getState() {
        return "NO_QUARTER";
    }
}
