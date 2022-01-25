package Utils;
import java.util.Iterator;


/**
 * Simple doubly linkedlist implementation, extending custom list interface.
 * Also implements Iterable interface. (commented out)
 * @param <E>
 */
public class CustomLinkedList<E> implements CustomListInterface<E>, Iterable<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;


    /**
     * Adds an object to the end of the linked list
     * @param e object to be added to the list
     */
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

//    /**
//     * Adds an object to the linked list at the specified index, splicing into place
//     * and effectively shifting all further objects
//     * @param index position to add object
//     * @param t object to be added
//     */
//    @Override
//    public void add(E e, int index) {
//        //Implement this method
//    }

    /**
     * gets the object found at provided index position
     * @param index location of the object to get
     * @return object found at index position
     */
    @Override
    public E get(int index) {
        //Implement this method
        Node<E> cursor = head;
        for(int i = 0; i < index; i++){ //this says everytime we iterator through we start at zero and if there is another node we move on to it
            // everytime time we advance we move the cursor
            cursor = cursor.next;
        }
        return cursor.obj;  //cursor.obj is the cursor payload stored in the node
    }

    /**
     * Clears the linked list by setting head and tail to null.
     *
     */
    @Override
    public void clear() {
        while(this.size>0)
            this.remove(0);
        this.head = null;
        this.tail = null;
    }

    /**
     * Searches linked list for an object using Object.equals() to compare
     * returns the index of the first matching object found. -1 if not found.
     * @param e the object to match
     * @return index of the first matching object found. -1 if not found
     */
    @Override
    public boolean contains(E e) {
        //Implement this method
        Node<E> cursor = head;
        for(int i = 0; i <this.size(); i++){
            if(cursor == null){
                return false;
            }
            if(cursor.obj.equals(e)){
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }


    /**
     * removes an object from linked list and splices the two resulting separate lists
     * together.
     * @param index the location of the object to be removed.
     */
    @Override
    public void remove(int index) {
        Node<E> cursor = head;
        Node<E> prev = null;
        Node<E> next = null;
        for (int i = 0; i < index; i++) {
            if (i != 0)
                prev = cursor;
            cursor = cursor.next;
            if (i <= index)
                next = cursor.next;
        }
        if (cursor == this.head)
            this.head = next;
        if (cursor == this.tail)
            this.tail = prev;

        prev.next = next;
        next.prev = prev;
        this.size--;
    }



    /**
     * returns the size of the linked list
     * @return size of linked list
     */
    @Override
    public int size() {
        //Implement this method
        return size;
    }

    /**
     * iterator implementation
     * @return returns an iterator object to traverse the linked list
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> cursor = head;

            /**
             * checks if the linked list has another node, testing if the cursor points to a node
             * or if it is null
             * @return true if the cursor points to a node, false if the cursor node reference is null
             */
            @Override
            public boolean hasNext() {
                if (cursor == null){
                    return false;
                }
                return true;
            }

            /**
             * returns the node the cursor points to, then advances the cursor to the next node
             * @return the object at the location of the cursor
             */
            @Override
            public E next() {
                E e = cursor.obj;
                cursor = cursor.next;
                return e;
            }
        };
    }


    /**
     * Private node class contains a reference to object of list type, a reference to the next node, and
     * to the previous node.
     * @param <E>
     */
    private class Node<E> {
        Node<E> next;
        Node<E>prev;
        E obj;

        /**
         * empty constructor creates an empty node
         */
        Node() {

        }

        /**
         * creates a node and stores an object by reference
         * @param e the stored object
         */
        Node(E e) {
            obj = e;
        }

        /**
         * creates a node which stores an object by reference and has a reference to another node
         * @param e object to be stored
         * @param next next node in list
         */
        Node(E e, Node<E> next) {
            this(e);
            this.next = next;
        }

        /**
         * creates a node which stores an object by reference and has refrences to two nodes,
         * previous and next in the list
         * @param e the object to be stored
         * @param next reference to next node in list
         * @param prev reference to previous node in list
         */
        Node(E e, Node<E> next, Node<E>prev) {
            this(e, next);
            this.prev = prev;
        }
    }


    /**
     * You can use this method to test the list, but it may be a good idea to add more tests
     * to make sure everything works properly. This test will print all the strings given in
     * the parameter list.
     * @param greeting - a string with a greeting message - first item added to list
     * @param goodbye - a string with a closing message - last item added to list
     * @param args - variable arguments, any number of strings which will be added to list
     */
    public void testMethod(String greeting, String goodbye, String... args) {
        System.out.println(greeting);
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        System.out.println(goodbye);
    }

    /**
     * Another method that can be used to test the list, give any number of ints in the parameter list
     * and it will return the sum of those integers.
     * @param nums - variable arguments - any number of integer values
     * @return - the sum of the integers given in the parameter list
     */
    public int testSum(Integer... nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }


}