package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState{
    IGumballMachine gumballMachine;

    public SoldOutState(IGumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        boolean succeeded = false;
        String message = "You can't insert a quarter, the machine is sold out";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult ejectQuarter() {
        boolean succeeded = false;
        String message = "You can't eject, because there are no gumballs!";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult turnCrank() {
        boolean succeeded = false;
        String message = "You can't turn the crank, because there are no gumballs!";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult dispense() {
        boolean succeeded = false;
        String message = "No gumball dispensed, because we are out of gumballs!";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }
}
