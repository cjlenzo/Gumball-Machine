package edu.iu.habahram.GumballMachine.model;

public class SoldState implements IState{
    IGumballMachine gumballMachine;

    public SoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        boolean succeeded = false;
        String message = "Please wait, we're already giving you a gumball";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult ejectQuarter() {
        boolean succeeded = false;
        String message = "Sorry, you already turned the crank";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult turnCrank() {

        boolean succeeded = false;
        String message = "Turning twice doesn't get you another gumball!";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        } else {
            gumballMachine.changeTheStateTo(GumballMachineState.OUT_OF_GUMBALLS);
        }

        boolean succeeded = true;
        String message = "Here is your gumball!";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public String getTheName() {
        return GumballMachineState.GUMBALL_SOLD.name();
    }

}
