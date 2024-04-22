package edu.iu.habahram.GumballMachine.model;

public class GumballMachine implements IGumballMachine {
    final String SOLD_OUT = GumballMachineState.OUT_OF_GUMBALLS.name();
    final String NO_QUARTER = GumballMachineState.NO_QUARTER.name();
    final String HAS_QUARTER = GumballMachineState.HAS_QUARTER.name();
    final String SOLD = GumballMachineState.GUMBALL_SOLD.name();
    private String id;
    String state = SOLD_OUT;
    int count = 0;

    public GumballMachine(String id, String state, int count) {
        this.id = id;
        this.state = state;
        this.count = count;
    }

    @Override
    public TransitionResult insertQuarter() {
        boolean succeeded = false;
        String message = "";
        if (state.equalsIgnoreCase(HAS_QUARTER)) {
            message = "You can't insert another quarter";
        }
        else if (state.equalsIgnoreCase(SOLD_OUT)) {
            message = "You can't insert a quarter, the machine is sold out";
        }
        else if (state.equalsIgnoreCase(SOLD)) {
            message = "Please wait, we're already giving you a gumball";
        }
        else if (state.equalsIgnoreCase(NO_QUARTER)) {
            state = HAS_QUARTER;
            message = "You inserted a quarter";
            succeeded = true;
        }
        return new TransitionResult(succeeded, message, state, count);
    }

    @Override
    public TransitionResult ejectQuarter() {
        boolean succeeded = false;
        String message = "";
        if (state.equalsIgnoreCase(HAS_QUARTER)) {
            state = NO_QUARTER;
            message = "Quarter returned";
            succeeded = true;
        }
        else if (state.equalsIgnoreCase(NO_QUARTER)) {
            message = "You haven't inserted a quarter";
        }
        else if (state.equalsIgnoreCase(SOLD_OUT)) {
            message = "You can't eject, you haven't inserted a quarter yet";
        }
        else if (state.equalsIgnoreCase(SOLD)) {
            message = "Sorry, you already turned the crank";
        }
        return new TransitionResult(succeeded, message, state, count);
    }

    @Override
    public TransitionResult turnCrank() {
        boolean succeeded = false;
        String message = "";
        if (state.equalsIgnoreCase(NO_QUARTER)) {
            message = "You turned but there's no quarter";
        }
        else if (state.equalsIgnoreCase(SOLD_OUT)) {
            message = "You try to turn the crank, but we are sold out!";
        }
        else if (state.equalsIgnoreCase(SOLD)) {
            message = "We are already giving you a gumball, please wait!";
        }
        else if (state.equalsIgnoreCase(HAS_QUARTER)) {
            releaseBall();
            if (state.equalsIgnoreCase(SOLD_OUT)) {
                message = "Oops, out of gumballs, please take your quarter back!";
                succeeded = true;
            }
            else if (state.equalsIgnoreCase(SOLD)){
                state = NO_QUARTER;
                message = "You turn the crank and get a gumball!";
                succeeded = true;
            }
        }
        return new TransitionResult(succeeded, message, state, count);
    }

    @Override
    public TransitionResult refill(int count) {
        boolean succeeded = false;
        String message = "";
        if (state.equalsIgnoreCase(SOLD_OUT)) {
            this.count = count;
            state = NO_QUARTER;
            message = "Machine refilled with " + count + " gumballs!";
            succeeded = true;
        }
        else if (state.equalsIgnoreCase(NO_QUARTER)) {
            message = "You can only refill when the machine is sold out!";
        }
        else if (state.equalsIgnoreCase(SOLD)) {
            message = "You can only refill when the machine is sold out!";
        }
        else if (state.equalsIgnoreCase(HAS_QUARTER)) {
            message = "You can only refill when the machine is sold out!";
        }
        return new TransitionResult(succeeded, message, state, this.count);
    }

    @Override
    public void changeTheStateTo(GumballMachineState name) {
        state = name.name();
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public String getTheStateName() {
        return null;
    }

    @Override
    public void releaseBall() {
        if (count >= 1) {
            count = count - 1;
            state = SOLD;
        }
        else {
            state = SOLD_OUT;
        }
    }
}