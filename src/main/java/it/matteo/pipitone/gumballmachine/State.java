package it.matteo.pipitone.gumballmachine;

public abstract class State {

    protected GumballMachine gumballMachine;

    public State(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    abstract void insertQuarter();

    abstract void ejectQuarter();

    abstract void turnsCrank();

    abstract void dispense();

    abstract void refill(int countOfGumball);

    abstract String getState();
}
