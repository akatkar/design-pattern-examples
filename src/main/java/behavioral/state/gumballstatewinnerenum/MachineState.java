package behavioral.state.gumballstatewinnerenum;

import java.util.Random;

public enum MachineState implements State {

    NO_QUARTER {
        @Override
        public void insertQuarter(GumballMachine machine) {
            System.out.println("You inserted a quarter");
            machine.setState(HAS_QUARTER);
        }

        @Override
        public void ejectQuarter(GumballMachine machine) {
            System.out.println("You haven't inserted a quarter");
        }

        @Override
        public void turnCrank(GumballMachine machine) {
            System.out.println("You turned, but there's no quarter");
        }

        @Override
        public void dispense(GumballMachine machine) {
            System.out.println("You need to pay first");
        }
    },
    HAS_QUARTER {
        Random randomWinner = new Random(System.currentTimeMillis());

        @Override
        public void insertQuarter(GumballMachine machine) {
            System.out.println("You can't insert another quarter");
        }

        @Override
        public void ejectQuarter(GumballMachine machine) {
            System.out.println("Quarter returned");
            machine.setState(NO_QUARTER);
        }

        @Override
        public void turnCrank(GumballMachine machine) {
            System.out.println("You turned...");
            int winner = randomWinner.nextInt(10);
            if ((winner == 0) && (machine.getCount() > 1)) {
                machine.setState(WINNER);
            } else {
                machine.setState(SOLD);
            }
        }

        @Override
        public void dispense(GumballMachine machine) {
            System.out.println("No gumball dispensed");
        }
    },
    SOLD_OUT {
        @Override
        public void insertQuarter(GumballMachine machine) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        }

        @Override
        public void ejectQuarter(GumballMachine machine) {
            System.out.println("You can't eject, you haven't inserted a quarter yet");
        }

        @Override
        public void turnCrank(GumballMachine machine) {
            System.out.println("You turned, but there are no gumballs");
        }

        @Override
        public void dispense(GumballMachine machine) {
            System.out.println("No gumball dispensed");
        }
    },
    SOLD {
        @Override
        public void insertQuarter(GumballMachine machine) {
            System.out.println("Please wait, we're already giving you a gumball");
        }

        @Override
        public void ejectQuarter(GumballMachine machine) {
            System.out.println("Sorry, you already turned the crank");
        }

        @Override
        public void turnCrank(GumballMachine machine) {
            System.out.println("Turning twice doesn't get you another gumball!");
        }

        @Override
        public void dispense(GumballMachine machine) {
            machine.releaseBall();
            if (machine.getCount() > 0) {
                machine.setState(NO_QUARTER);
            } else {
                System.out.println("Oops, out of gumballs!");
                machine.setState(SOLD_OUT);
            }
        }
    },
    WINNER {
        @Override
        public void insertQuarter(GumballMachine machine) {
            System.out.println("Please wait, we're already giving you a Gumball");
        }

        @Override
        public void ejectQuarter(GumballMachine machine) {
            System.out.println("Please wait, we're already giving you a Gumball");
        }

        @Override
        public void turnCrank(GumballMachine machine) {
            System.out.println("Turning again doesn't get you another gumball!");
        }

        @Override
        public void dispense(GumballMachine machine) {
            System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
            machine.releaseBall();
            if (machine.getCount() == 0) {
                machine.setState(SOLD_OUT);
            } else {
                machine.releaseBall();
                if (machine.getCount() > 0) {
                    machine.setState(NO_QUARTER);
                } else {
                    System.out.println("Oops, out of gumballs!");
                    machine.setState(SOLD_OUT);
                }
            }
        }
    };
}
