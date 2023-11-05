/**
 * This file is mostly credited to Michael T. Goodrich, Roberto Tamassia, 
 * Michael H.Goldwasser as part of their book:
 *   Data Structures and Algorithms in Java, Sixth Edition, John Wiley & 
 *   Sons, 2014.
 * 
 * Their program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * A copy of the GNU General Public License is at
 *   <http://www.gnu.org/licenses/>.
 *
 * Modifications by R. Heise
 * Oct 27, 2023 at 4:02:18 p.m.
 * Modifications include variable and method names, extra documentation, and
 * small run-time efficiencies.
 *
 *
 * Methods available:
 *
 * Default constructor 
 *    Starts an empty CircularlyLinkedList
 * size() --> int
 *    Returns the number of nodes in the list
 * isEmpty() --> boolean
 *    Determines whether the list is empty
 * getFirstElement() --> E
 *    Returns the first element in the list (does NOT remove it)
 * getLastElement() --> E
 *    Returns the last element in the list (does NOT remove it)
 * rotateCCW() 
 *    Rotates the list counterclockwise
 * addAsFirst(E) 
 *    Adds a new node into the "beginning" of the list.  This node contains
 *    the given element.
 * addAsLast(E)
 *    Adds a new node into the "end" of the list.  This node contains
 *    the given element
 * removeFirst() --> E
 *    Takes out the "beginning" node of the list and returns its value.  If
 *    the list is empty, returns null
 * toString() --> String
 *    Gives a string representation of the list - a clockwise traversal
 *
 */

 /** 
  * Circular singly linked list.
  * @param <E> - the data type of the information to be stored in a node
  */
public class CircularlyLinkedList<E> {
  //---------------- nested Node class ---------------------------------------
  /**
   * Singly linked node, which stores a reference to its element and
   * to the subsequent node in the list.
   */
  private static class Node<E> {

    // Data ===================================================================
    private final E element;
    private Node<E> next;

    // Constructors ===========================================================
    /**
     * Creates a node with the given element and next node.
     *
     * @param theElement -  the element to be stored
     * @param theNextNode -  reference to a node that should follow the 
     *                       new node
     */
    public Node(E theElement, Node<E> theNextNode) {
      element = theElement;
      next = theNextNode;
    }//constructor

    // Accessor methods ======================================================
    /**
     * Returns the element stored at the node.
     * @return the element stored at the node
     */
    public E getElement() { 
        return element; 
    }//getElement

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return - the following node
     */
    public Node<E> getNext() { 
        return next; 
    }//getNext

    // Modifier methods ======================================================
    /**
     * Sets the node's next reference to point to Node afterNode.
     * @param afterNode - this node that should follow current one
     */
    public void setNext(Node<E> afterNode) { 
        next = afterNode; 
    }//setNext
  }//end of nested Node class

  //---------------------------------------------------------------------------
  //---------------------------------------------------------------------------
  //---------------------------------------------------------------------------
  //---------------- Start of CircularlyLinkedList class ----------------------
 
  // Data =====================================================================
  private Node<E> entry; // cursor to access the list, at the last node
                         // idea of "tail", not "head"
  private int size;

  // Constructor ==============================================================
  /**
   * Makes an initially empty list. 
   */
  public CircularlyLinkedList() { 
      entry = null;
      size = 0;
  }//constructor

  // Accessor methods =========================================================
  /**
   * Returns the number of elements in the linked list.
   * @return - number of elements in the list
   */
  public int size() { 
      return size; 
  }//size

  /**
   * Tests whether the linked list is empty.
   * @return - true if the list is empty; false otherwise
   */
  public boolean isEmpty() { 
      return size == 0; 
  }//isEmpty

  /**
   * Returns (but does not remove) the first element of the list.
   * @return - element at the "head" of the list, so one forward of "entry",
   *           or null if the list is empty
   */
  public E getFirstElement() { 
    if (size == 0){//empty
        return null;
    }
    return entry.getNext().getElement();  // the "head" is *after* the entry
  }//getFirstElement

  /**
   * Returns (but does not remove) the last element of the list.
   * @return - element at the "back" of the list (at entry)
   *           or null if the list is empty
   */
  public E getLastElement() { 
    if (size == 0){//empty
        return null;
    }
    return entry.getElement();
  }//getLastElement

  // Update methods ===========================================================
  /**
   * Rotate the first element to the back of the list.  If you consider the 
   * entry fixed, then this has the affect of turning the list in a 
   * counterclockwise direction.
   */
  public void rotateCCW() {
    if (entry != null){        // if empty, do nothing
      entry = entry.getNext(); // the old "head" becomes the new "tail"
    }
  }//rotateCCW

  /**
   * Adds an element to the front of the list.
   * @param newElement - the new element to add
   */
  public void addAsFirst(E newElement) { 
    if (size == 0){//empty
      entry = new Node<>(newElement, null);
      entry.setNext(entry); // link to itself circularly
    } 
    else{//list already has at least one node in it
      Node<E> newest = new Node<>(newElement, entry.getNext()); //link to "head"
      entry.setNext(newest); //becomes new "head"
    }
    size++;
  }//addAsFirst

  /**
   * Adds an element to the end of the list.
   * @param newElement - the new element to add
   */
  public void addAsLast(E newElement) {
    addAsFirst(newElement); //insert new element at front of list
    entry = entry.getNext(); //and then just change entry so the new
                             //item becomes the "tail"
  }//addAsLast

  /**
   * Removes the first node and returns that element.
   * @return - the removed element, or null if the list was empty
   */
  public E removeFirst() {
    if (size == 0){ // nothing to remove
        return null;
    }
    
    Node<E> head = entry.getNext();
    if (head == entry){//only one node in list 
        entry = null;
    }
    else{//multiple items in the list
        entry.setNext(head.getNext());  // removes "head" from the list
    }
    size--;
    return head.getElement();
  }//removeFirst
  
    public boolean exchange(String playerName1, String playerName2) {
        Node<E> prev1 = entry;
        Node<E> player1 = entry.getNext();
        Node<E> prev2 = entry; 
        Node<E> player2 = entry.getNext();
        boolean foundPlayer1 = false; 
        boolean foundPlayer2 = false; 
        if (size == 0) {
            System.out.println("No players to swap");
            return false;
        }
        //search for first player in list
        while (player1 != entry){
            if(player1 .getElement().equals(playerName1)){
                foundPlayer1 = true; 
                break; 
            }//if
            prev1 = player1; 
            player1 = player1.getNext();
        }//while
        
        while(player2 != entry){
            if(player2.getElement().equals(playerName2)){
                foundPlayer2 = true;
                break;
            }//if
            prev2 = player2; 
            player2 = player2.getNext();
        }//while
        
        
        if(foundPlayer1 = true && foundPlayer2 == true){
            
        }
       return true;
    }
     
     
      
      

  

  /**
   * Produces a string representation of the contents of the list.
   */
  @Override
  public String toString() {
    if (entry == null) 
        return "()";
    
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = entry; //use walk as the cursor to move through the list
    
    do{
      walk = walk.getNext();
      sb.append(walk.getElement());
      if (walk != entry){//add comma only if more left
        sb.append(", ");
      }
    } while (walk != entry);
    
    sb.append(")");
    return sb.toString();
  }//toString
}//class CircularlyLinkedList
  
