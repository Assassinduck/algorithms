package org.pg4200.ex04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class FibonacciMemoTestTemplate {

    protected abstract FibonacciImplMemoized getInstance();


    @Test
    public void testInvalid(){
        assertThrows(IllegalArgumentException.class,() ->
                getInstance().compute(-1, null));
    }

    @Test
    public void testCompute00(){
        assertEquals(0, getInstance().compute(0, new int[0]));
    }

    @Test
    public void testCompute01(){
        assertEquals(1, getInstance().compute(1, new int[1]));
    }

    @Test
    public void testCompute02(){
        assertEquals(1, getInstance().compute(2, new int[2]));
    }

    @Test
    public void testCompute03(){
        assertEquals(2, getInstance().compute(3, new int[2]));
    }

    @Test
    public void testCompute04(){
        assertEquals(3, getInstance().compute(4, new int[4]));
    }

    @Test
    public void testCompute05(){
        assertEquals(5, getInstance().compute(5, new int[5]));
    }

    @Test
    public void testCompute06(){
        assertEquals(8, getInstance().compute(6, new int[6]));
    }

    @Test
    public void testCompute07(){
        assertEquals(13, getInstance().compute(7, new int[7]));
    }

    @Test
    public void testCompute08(){
        assertEquals(21, getInstance().compute(8, new int[8]));
    }

    @Test
    public void testCompute09(){
        assertEquals(34, getInstance().compute(9,new int[9]));
    }


    @Test
    public void testComputeHighValueNoException(){
        //just check it is not throwing any exception
        getInstance().compute(100, new int[100]);
    }

}
