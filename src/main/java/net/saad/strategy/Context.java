package net.saad.strategy;

import net.saad.strategy.impl.DefaultStrategy;

/**
 * The Strategy-pattern context. Holds the current strategy and delegates work
 * to it; the implementation can be swapped at any time by the client.
 */
public class Context {

    private Strategy strategy = new DefaultStrategy();

    public void performOperation() {
        System.out.println("**************************");
        strategy.execute();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
