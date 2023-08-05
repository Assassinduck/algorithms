package org.pg4200.les02.list;

public class MyBidirectionalLinkedList<T> implements MyList<T> {



    private class ListNodeBi{
        T value;
        ListNodeBi next;
        ListNodeBi previous;

        private ListNodeBi(T value){
            this.value = value;
        }

        }


        private ListNodeBi head;

        private ListNodeBi tail;


        private int size;

        @Override
        public void delete(int index) {

            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException();
            }

            if(size() == 0){
                throw new Error("The list is already empty");
            }

            ListNodeBi nodeToDelete = walk(index);

            if(nodeToDelete == null){
                throw new IndexOutOfBoundsException();
            }

            size--;

            if(size == 0){
                head = tail = null;
            }

            if(nodeToDelete.previous != null){
                nodeToDelete.previous.next = nodeToDelete.next;
            }

            if(nodeToDelete.next != null){
                nodeToDelete.next.previous = nodeToDelete.previous;
            }

            if(nodeToDelete == head){
                head = nodeToDelete.next;   
            }


            if(nodeToDelete == tail){
                tail = nodeToDelete.previous;
            }

            nodeToDelete.previous = nodeToDelete.next = null;
            return;
            

        }

        @Override
        public T get(int index) {
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException();
            }

            ListNodeBi getNode = walk(index);
            return getNode.value;
        }

        @Override
        public void add(int index, T value) {

            if(index > size()){
                throw new IndexOutOfBoundsException();
            }

            ListNodeBi newNode = new ListNodeBi(value);
            // head empty -> tail empty -> list empty
            if(head == null){
                head = newNode;
                tail = newNode;
                size++;
                return;
            }

            if(index == 0){
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
                size++;
                return;
            }

            if(index == size){

                ListNodeBi oldTail = tail;
                oldTail.next = newNode;
                newNode.previous = oldTail;

                tail = newNode;

                size++;
                return;
            }

            ListNodeBi currentNode = walk(index);

            System.out.println("value is "+currentNode.value);

            ListNodeBi prevNode = currentNode.previous;

            prevNode.next = newNode;

            currentNode.previous = newNode;

            newNode.next = currentNode;
            newNode.previous = prevNode;

            size++;
            return;
        }

        @Override
        public int size() {
            return size;
        }


        private ListNodeBi walk( int index){
        ListNodeBi curListNode = null;

            if((size() / 2) <= index){
                System.out.println("start at tail");
                curListNode = tail;
                for (int i = size; curListNode != null && i-1 > index ; i--) {
                    curListNode = curListNode.previous;
                }
                return curListNode;
            }else{
                System.out.println("start at head");
                curListNode = head;
                for (int i = 0; curListNode != null && i < index ; i++) {
                    curListNode = curListNode.next;
                }
                return curListNode;
            }
        }

        public void printList(){
            ListNodeBi curr = head;
        
            for (int i = 0; i < size; i++) {
                System.out.println(curr.value.toString());
                curr = curr.next;
            }

            

            

        }







    
}
