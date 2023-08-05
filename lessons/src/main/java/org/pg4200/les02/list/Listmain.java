package org.pg4200.les02.list;

public class Listmain {

    

public static void main(String[] args) {
    MyMiddleBidirectionalLinkedList<Integer> myBiList = new MyMiddleBidirectionalLinkedList<Integer>();

    myBiList.add(0, 0);
    myBiList.add(1, 1);
    myBiList.add(2, 2);
    myBiList.add(3, 99);
    myBiList.add(3, 888888);
    myBiList.add(3,3777777);
        myBiList.add(2,444);
                myBiList.add(2,445);            
                myBiList.add(2,446);







    System.out.println("dwhdaw "+myBiList.get(0));  
        System.out.println("\n");
  
    System.out.println("dwhdaw "+myBiList.get(1));
        System.out.println("\n");

    System.out.println("dwhdaw "+myBiList.get(2));
    System.out.println("\n");
    System.out.println("dwhdaw "+myBiList.get(3));
        System.out.println("\n");

        System.out.println("dwhdaw "+myBiList.get(4));
                System.out.println("\n");

                System.out.println("dwhdaw "+myBiList.get(5));




    
























        System.out.println("\n");


        myBiList.printList();


    System.out.println("\n");
    

    

 
    System.out.println("middle index:  " + myBiList.findMiddleOfList());
    System.out.println("size of list at end: " + myBiList.size());
    System.out.println(" middle value at the end is: "+myBiList.getMiddle());
    





}

}
