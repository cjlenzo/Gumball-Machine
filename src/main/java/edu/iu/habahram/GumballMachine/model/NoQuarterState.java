package edu.iu.habahram.GumballMachine.model;

public class NoQuarterState implements IState{
    IGumballMachine gumballMachine;

    public NoQuarterState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);

        boolean succeeded = true;
        String message = "You inserted a quarter";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult ejectQuarter() {
        boolean succeeded = false;
        String message = "You haven't inserted a quarter";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult turnCrank() {
        boolean succeeded = false;
        String message = "You turned, but there's no quarter";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult dispense() {
        boolean succeeded = false;
        String message = "You need to pay first";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public String getTheName() {
        return GumballMachineState.NO_QUARTER.name();
    }
}