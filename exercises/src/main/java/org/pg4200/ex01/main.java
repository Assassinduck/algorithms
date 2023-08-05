package org.pg4200.ex01;

public class main {
    public static void main(String[] args) {

        ArrayUtilsImp arrutil = new ArrayUtilsImp();

        int[] arr = {12,54,213,67,8,9};

        int lowest = arrutil.min(arr);
        int highest = arrutil.max(arr);
        System.out.println(lowest);
        System.out.println(highest);
        System.out.println(arrutil.mean(arr));
    }
}
