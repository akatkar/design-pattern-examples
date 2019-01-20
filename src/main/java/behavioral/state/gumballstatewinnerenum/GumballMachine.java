package behavioral.state.gumballstatewinnerenum;

public class GumballMachine {

    State state = MachineState.SOLD_OUT;

    int count = 0;

    public GumballMachine(int numberGumballs) {

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = MachineState.NO_QUARTER;
        }
    }

    public void insertQuarter() {
        state.insertQuarter(this);
    }

    public void ejectQuarter() {
        state.ejectQuarter(this);
    }

    public void turnCrank() {
        state.turnCrank(this);
        state.dispense(this);
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count = count;
        state = MachineState.NO_QUARTER;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: ").append(count).append(" gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is ").append(state).append("\n");
        return result.toString();
    }
}
