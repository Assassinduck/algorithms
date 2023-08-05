package org.pg4200.ex04;

public class FibonacciImplMemoized  {
    public int compute(int n, int[] memo) throws IllegalArgumentException {

        if(n < 0 && memo == null ){
            throw new IllegalArgumentException();
        }

        if(n == 0 || n == 1){
            return n;
        }

        if(memo[n-1] != n){
            memo[n-1] = compute(n-1, memo) +  compute(n-2, memo);
        }else{
            return memo[n-1];
        }
        return memo[n-1];
    }
}
