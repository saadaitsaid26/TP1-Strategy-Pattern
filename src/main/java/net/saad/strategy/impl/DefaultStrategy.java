package net.saad.strategy.impl;

import net.saad.strategy.Strategy;

/**
 * Fallback strategy used until the client picks another one.
 */
public class DefaultStrategy implements Strategy {

    @Override
    public void execute() {
        System.out.println("************* Strategy By default *************");
    }
}
