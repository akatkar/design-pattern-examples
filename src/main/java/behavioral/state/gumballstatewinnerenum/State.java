package behavioral.state.gumballstatewinnerenum;

public interface State {

    public void insertQuarter(GumballMachine machine);

    public void ejectQuarter(GumballMachine machine);

    public void turnCrank(GumballMachine machine);

    public void dispense(GumballMachine machine);
}
