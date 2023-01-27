package it.matteo.pipitone.gumballmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class GumballMachineTest {
    GumballMachine gumballMachine;

    @BeforeEach
    void setUp() {
        gumballMachine  = new GumballMachine();
    }

    @Test
    void startMachineWithoutQuarter() {
        assertTrue(gumballMachine.getState().equalsIgnoreCase("NO_QUARTER"));
    }

    @Test
    void verifyInsertQuarter() {
        gumballMachine.insertQuarter();
        assertEquals("HAS_QUARTER", gumballMachine.getState());
    }

    @Test
    void verifyEjectQuarter() {
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        assertTrue(gumballMachine.getState().equalsIgnoreCase("NO_QUARTER"));
    }

    @Test
    void ejectQuarterWithNoQuarterInside() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            gumballMachine.ejectQuarter();
        });
    }

    @Test
    void tryToTurnCranks() {
        gumballMachine.insertQuarter();
        gumballMachine.turnsCrank();
        assertEquals("GUMBALL_SOLD", gumballMachine.getState());
    }

    @Test
    void tryToTurnCranksWithoutQuarter() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            gumballMachine.turnsCrank();
        });
    }

    @Test
    void tryToTurnCrankWithoutGumballsInsideMachine() {
        RuntimeException thrown = Assertions.assertThrows(NoGumballPresentException.class, () -> {
            for (int i = 0; i < 11; i++) {
                gumballMachine.insertQuarter();
                gumballMachine.turnsCrank();
                gumballMachine.dispense();
            }
        });
        assertEquals("OUT_OF_GUMBALLS", gumballMachine.getState());

    }

    @Test
    void tryToGetDispenseHappyPath() {
        gumballMachine.insertQuarter();
        gumballMachine.turnsCrank();
        gumballMachine.dispense();
        assertEquals(gumballMachine.getState(), "NO_QUARTER");
    }
    @Test
    void tryToDispenseWithoutQuarter() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            gumballMachine.dispense();
        });

    }
    @Test
    void tryToDispenseWithoutTurnsCrank() {
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            gumballMachine.insertQuarter();
            gumballMachine.dispense();
        });
    }

    @Test
    void tryToRefill(){
        RuntimeException thrown = Assertions.assertThrows(NoGumballPresentException.class, () -> {
            for (int i = 0; i < 11; i++) {
                gumballMachine.insertQuarter();
                gumballMachine.turnsCrank();
                gumballMachine.dispense();
            }
        });
        assertEquals("OUT_OF_GUMBALLS", gumballMachine.getState());
        gumballMachine.refill(10);
        assertEquals("NO_QUARTER", gumballMachine.getState());
    }

    @Test
    void refillWithNoQuarter() {
        gumballMachine.refill(10);
        assertEquals("NO_QUARTER", gumballMachine.getState());

    }
}