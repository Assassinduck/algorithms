package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils {

    @Override
    public int min(int[] array) throws IllegalArgumentException { 
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }

        int min = array[0];

        for(int i = 0; i < array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
    return min;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }

            int max = array[0];

        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
    return max;

    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array is null or empty");
        }

        int numberOfitems = array.length;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double mean = sum / numberOfitems;

        return mean;
    
    }
    
}

