package org.pg4200.ex04;

public class FibonacciImplMemoizedTest extends FibonacciMemoTestTemplate {

    @Override
    protected FibonacciImplMemoized getInstance() {
        return new FibonacciImplMemoized();
    }
}
