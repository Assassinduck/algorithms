package org.pg4200.ex01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MyArrayListIntegerTest {

    private MyArrayListInteger list;

    @BeforeEach
    public void initTest(){
        list = new MyArrayListInteger();
    }

    @Test
    public void testEmpty(){
        assertEquals(0, list.size());
    }

    @Test
    public void testAddOneElement(){
        int n = list.size();
        list.add(1);

        assertEquals(n+1, list.size());
    }

    @Test
    public void testAddAndRetrieveElement(){
        int value = 983;

        list.add(value);

        int res = list.get(0);

        assertEquals(res, value);
    }

    @Test
    public void testAdd5Elements(){
          assertEquals(0, list.size());
        int a = 1;
        int b = 2;
        int c = 3;

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(a);
        list.add(a);

        assertEquals(a, list.get(0));
        assertEquals(b, list.get(1));
        assertEquals(c, list.get(2));
        assertEquals(a, list.get(3));
        assertEquals(a, list.get(4));
    }

    @Test
    public void testOutOfIndex(){

        assertNull(list.get(-5));
        assertNull(list.get(42));
    }

    
}
