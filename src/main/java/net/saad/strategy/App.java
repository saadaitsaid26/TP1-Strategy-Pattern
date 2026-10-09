package net.saad.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Client entry point for the Strategy pattern demo.
 * <p>
 * Strategies are discovered at runtime: an unknown input (e.g. "1") is turned
 * into a class name ({@code net.saad.strategy.impl.Strategy<n>}) and loaded via
 * reflection. Each strategy is instantiated at most once and cached, so the
 * same selection reuses the existing instance.
 */
public class App {

    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        Map<String, Strategy> strategyMap = new HashMap<>();
        Strategy strategy;

        while (true) {
            System.out.println("Type your strategy's number  :");
            String str = scanner.nextLine();

            strategy = strategyMap.get(str);
            if (strategy == null) {
                System.out.println("Creating new strategy ...");
                strategy = (Strategy) Class.forName("net.saad.strategy.impl.Strategy" + str).getConstructor().newInstance();
                strategyMap.put(str, strategy);
            }

            context.setStrategy(strategy);
            context.performOperation();
        }
    }
}
