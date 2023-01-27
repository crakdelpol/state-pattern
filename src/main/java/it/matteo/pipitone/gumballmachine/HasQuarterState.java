package it.matteo.pipitone.gumballmachine;

public class HasQuarterState extends State {

    public HasQuarterState(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override
    public void insertQuarter() {
        throw new HasJustQuarterException();
    }

    @Override
    public void ejectQuarter() {
        super.gumballMachine.changeState(new EjectQuarterState(gumballMachine));
    }

    @Override
    public void turnsCrank() {

        if(!gumballMachine.hasAvailableGunBalls()){
            super.gumballMachine.changeState(new OutOfGumballState(gumballMachine));
            throw new NoGumballPresentException();
        }
        gumballMachine.removeGumball();
        super.gumballMachine.changeState(new TurnCrankState(gumballMachine));
    }

    @Override
    public void dispense() {
        throw new RuntimeException();
    }

    @Override
    void refill(int countOfGumball) {
        throw new RuntimeException();
    }

    @Override
    String getState() {
        return "HAS_QUARTER";
    }
}
