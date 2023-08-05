package org.pg4200.ex04;

public class FibMain {

    public static void main(String[] args) {
        FibonacciImplMemoized fib = new FibonacciImplMemoized();
        int n = 100;
        System.out.println(fib.compute(n, new int[n]));
    }
}
