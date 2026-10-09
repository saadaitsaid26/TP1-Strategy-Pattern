# Strategy Pattern — Java Demo

A small interactive Java demo of the **Strategy** design pattern (GoF behavioral):
a context object delegates its work to a `Strategy` implementation that can be
swapped at runtime — here, discovered **by reflection** from user input and
**cached** so each strategy is only ever instantiated once.

## How it works

| Pattern role        | Class                          | Description                                    |
|---------------------|--------------------------------|------------------------------------------------|
| Strategy (contract) | `net.saad.strategy.Strategy`   | Interface every swappable algorithm implements |
| Concrete strategies | `impl.Strategy1`, `impl.Strategy2`, `impl.DefaultStrategy` | Actual behaviors |
| Context             | `net.saad.strategy.Context`    | Holds the current strategy, delegates to it    |
| Client              | `net.saad.strategy.App`        | Selects strategies by number at runtime        |

Type a number at the prompt: the client turns it into a class name
(`net.saad.strategy.impl.Strategy<n>`), loads the class by reflection, and
caches the instance. Choosing the same number again reuses the cached strategy
(no second `"Creating new strategy ..."` message).

## Project layout

```
src/main/java/net/saad/strategy/
├── App.java          # client: reflective lookup + instance cache
├── Strategy.java     # the strategy contract
├── Context.java      # context object
└── impl/
    ├── DefaultStrategy.java
    ├── Strategy1.java
    └── Strategy2.java
```

## Requirements

- Java 21+
- Maven 3.9+

## Build & run

```bash
mvn clean compile
java -cp target/classes net.saad.strategy.App
```

The program loops until interrupted (`Ctrl+C`); the strategy starts as
`DefaultStrategy` and switches to whichever numbered strategy you type.

## Extending

Add `Strategy3.java` (etc.) to `impl/` implementing `Strategy` — the client
will pick it up automatically through the reflective lookup.
