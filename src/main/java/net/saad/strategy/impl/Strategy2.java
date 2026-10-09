package net.saad.strategy.impl;

import net.saad.strategy.Strategy;

/**
 * Concrete strategy 2, discovered reflectively by {@link net.saad.strategy.App}.
 */
public class Strategy2 implements Strategy {

    @Override
    public void execute() {
        System.out.println("************* Strategy 2 *************");
    }
}
