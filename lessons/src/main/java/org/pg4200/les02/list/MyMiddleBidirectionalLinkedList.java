package org.pg4200.les02.list;

public class MyMiddleBidirectionalLinkedList<T> implements MyList<T> {

  private class ListNodeBi {

    T value;
    ListNodeBi next;

    ListNodeBi previous;

    private ListNodeBi(T value) {
      this.value = value;
    }
  }

  private ListNodeBi head;

  private ListNodeBi middle;

  private ListNodeBi tail;

  private int size;

  @Override
  public void delete(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    if (size() == 0) {
      throw new Error("The list is already empty");
    }
    System.out.println("delete\\/");
    ListNodeBi nodeToDelete = walk(index);

    if (nodeToDelete == null) {
      throw new IndexOutOfBoundsException();
    }

    size--;

    if (size == 0) {
      head = middle = tail = null;
    }

    if (nodeToDelete.previous != null) {
      nodeToDelete.previous.next = nodeToDelete.next;
    }

    if (nodeToDelete.next != null) {
      nodeToDelete.next.previous = nodeToDelete.previous;
    }

    if (nodeToDelete == head) {
      head = nodeToDelete.next;
    }

    if (nodeToDelete == tail) {
      tail = nodeToDelete.previous;
    }

    nodeToDelete.previous = nodeToDelete.next = null;

    updateMiddleDelete();
    return;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

    ListNodeBi getNode = walk(index);
    return getNode.value;
  }

  @Override
  public void add(int index, T value) {
    if (index > size()) {
      throw new IndexOutOfBoundsException();
    }

    ListNodeBi newNode = new ListNodeBi(value);
    // head empty -> tail empty -> list empty
    if (head == null) {
      head = newNode;
      middle = head;
      tail = newNode;
      size++;
      return;
    }

    if (index == 0) {
      newNode.next = head;
      head.previous = newNode;
      head = newNode;
      size++;
      updateMiddleAdd(index);
      return;
    }

    if (index == size) {
      ListNodeBi oldTail = tail;
      oldTail.next = newNode;
      newNode.previous = oldTail;

      tail = newNode;
      size++;
      updateMiddleAdd(index);
      return;
    }

    ListNodeBi currentNode = walk(index);

    System.out.println("current node value is: " +  currentNode.value);

    ListNodeBi prevNode = currentNode.previous;

    prevNode.next = newNode;

    currentNode.previous = newNode;

    newNode.next = currentNode;
    newNode.previous = prevNode;
    size++;
    updateMiddleAdd(index);
    return;
  }

  @Override
  public int size() {
    return size;
  }

  private ListNodeBi walk(int index) {
    ListNodeBi curListNode = null;

    double percentage = Math.floor((double) index / (double) size * 100);

    System.out.println("list size is: " + size);

    String perc = "index "+ index + " is " + percentage + "% of the size of the list";
    System.out.println(perc);

    if (percentage >= 25 && percentage <= 75) {
      System.out.println("starting from middle");
      curListNode = middle;
      System.out.println("The middle value is: " + curListNode.value);

      if (percentage > 50) {
        System.out.println("is bigger");
        for (int i = (int) findMiddleOfList(); curListNode != null && i < index; i++) {
          curListNode = curListNode.next;
        System.out.println("next node is " + curListNode.value);

        }
        return curListNode;
      }

      if (percentage < 50) {
        System.out.println("is smaller");
        int middleI = (int) findMiddleOfList();
        for (int i = middleI ; curListNode != null && index < i; i--) {
          curListNode = curListNode.previous;
                  System.out.println("next node is " + curListNode.value);

        }
        return curListNode;
      }
    }

    if (percentage < 25) {
      System.out.println("starting from head");
      curListNode = head;
      for (int i = 0; curListNode != null && i < index ; i++) {
        curListNode = curListNode.next;
        System.out.println("next node is " + curListNode.value);

      }
      return curListNode;
    }

    if (percentage > 75) {
      System.out.println("starting from tail");

      curListNode = tail;
      for (int i = size; curListNode != null && i - 1 > index; i--) {
        curListNode = curListNode.previous;
        System.out.println("next node is " + curListNode.value);

      }
      return curListNode;
    }

    return curListNode;
  }

  public void printList() {
    ListNodeBi curr = head;

    for (int i = 0; i < size; i++) {
      System.out.println(curr.value.toString());
      curr = curr.next;
    }
  }

  public double findMiddleOfList() {
    double middleIndex = Math.floor((double) size / (double) 2);

    if (size % 2 == 0) {
      return middleIndex - 1;
    }

    return middleIndex;
  }

  public void updateMiddleAdd(int index) {

    System.out.println("size is: " + size);
    double middleInt = findMiddleOfList();

    System.out.println("\n");

System.out.println("middle is: " + middleInt);
    

    boolean insertedBehindMiddle = index < middleInt || index == middleInt;

    if(insertedBehindMiddle && size % 2 != 0){
        ListNodeBi oldMid = middle;
        middle = oldMid.previous;
    }else if(!insertedBehindMiddle && size % 2 != 0){
        middle = middle.next;
    }else{
        return;
    }


    
  }

  public T getMiddle(){
  return middle.value;
  }

  public void updateMiddleDelete() {
    if (size % 2 == 0) {
      ListNodeBi oldMid = middle;
      ListNodeBi newMid = middle.previous;
      newMid.next = oldMid;

      oldMid.previous = newMid;
    } else {
      return;
    }
  }
}
