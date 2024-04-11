package edu.iu.habahram.GumballMachine.model;

public class HasQuarterState implements IState{
    IGumballMachine gumballMachine;

    public HasQuarterState(IGumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        boolean succeeded = false;
        String message = "You can't insert another quarter";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult ejectQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);

        boolean succeeded = true;
        String message = "Quarter returned";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult turnCrank() {
        gumballMachine.changeTheStateTo(GumballMachineState.GUMBALL_SOLD);

        boolean succeeded = true;
        String message = "You turned the crank";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public TransitionResult dispense() {
        boolean succeeded = false;
        String message = "No gumball dispensed";
        String stateAfter = gumballMachine.getTheStateName();
        Integer countAfter = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, stateAfter, countAfter);
    }

    @Override
    public String getTheName() {
        return GumballMachineState.HAS_QUARTER.name();
    }
}