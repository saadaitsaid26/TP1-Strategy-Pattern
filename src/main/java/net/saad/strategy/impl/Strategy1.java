package net.saad.strategy.impl;

import net.saad.strategy.Strategy;

/**
 * Concrete strategy 1, discovered reflectively by {@link net.saad.strategy.App}.
 */
public class Strategy1 implements Strategy {

    @Override
    public void execute() {
        System.out.println("************* Strategy 1 *************");
    }
}
