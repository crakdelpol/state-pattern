package it.matteo.pipitone.gumballmachine;

public class GumballMachine {

    boolean hasQuarter;
    private int gumballsCount;
    private State _state;

    public GumballMachine() {
        this.hasQuarter = false;
        gumballsCount = 10;
        this._state = new NoQuarterState(this);

    }

    public void changeState(State state){
        this._state = state;
    }

    public void insertQuarter() {
        this._state.insertQuarter();
    }

    public void ejectQuarter() {
        this._state.ejectQuarter();
    }

    public void turnsCrank() {
        this._state.turnsCrank();
    }

    public String getState() {
        return _state.getState();
    }

    public void dispense() {
        this._state.dispense();
    }

    public boolean hasAvailableGunBalls() {
        return gumballsCount > 0;
    }

    public void removeGumball() {
        gumballsCount--;
    }

    public void refill(int countOfGumball) {
        addGumballs(countOfGumball);
        this._state.refill(countOfGumball);
    }

    public void addGumballs(int countOfGumball) {
        gumballsCount += countOfGumball;
    }
}
