/*
@author Roi Porat-Shliom with starter code from Mr. Menchukov
@version 9/30/2025
@purpose create the linkedlist class containing methods to add, show, clear, remove, and reverse a linked list/its values
*/ 

/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance variables go here (think about what you need to keep track of!)
  private ListNode head = null;
  private int length;
  //constructors go here 
  public LinkedList(){
    head = null;
    length = 1;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode current = head;
    //if the list is empty
      if(head == null){
       head = new ListNode(line, head);
       length++;
       return head;
      }
      if (line.toLowerCase().compareTo(head.getValue().toLowerCase())<0){
        head = new ListNode(line, head);
        length++;
        return head;
      }
    while(current.getNext()!= null){
      //insert somewhere
      if (current.getNext().getValue().toLowerCase().compareTo(line.toLowerCase())>0){
        ListNode newNode = new ListNode(line, current.getNext());
        current.setNext(newNode);
        length ++;
        return newNode;
      }
      //at the end
      if (current.getValue().toLowerCase().compareTo(line.toLowerCase())<0){
          if(current.getNext().getValue().toLowerCase().compareTo(line.toLowerCase())>0){
            ListNode newNode = new ListNode(line, current.getNext());
            current.setNext(newNode);
          }
      }
      current = current.getNext();
    }
    current.setNext(new ListNode(line, null));
    length++;
    return current.getNext();
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    ListNode current = head;
    while(current.getNext()!= null){
      if(current.getValue().equals(line)){

      }
      current = current.getNext();
    }
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    ListNode current = head;
    String values = "";
    while (current != null){
      values += current.getValue() + " ";
      current = current.getNext();
    }
    return values;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    length = 1;
    head = null;
  }


  //precondition: the linked list has been initialized
  //postconditions: the linked list is reversed
  public void reverse(){
    ListNode prev = null;
    ListNode current = head;

    while (current != null){
      ListNode next=current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;

    }
    head = prev;
  }

  //precondition: the linked list has been initialized
  //postconditions: groups of n nodes in the linked list are reversed
  public void nReverse(int n){
    ListNode prev = null;
    ListNode current = head;
    ListNode next = null;
    ListNode temp = new ListNode(null, head);
    ListNode newH = head;
    ListNode newE = temp;

    while (newH != null){
      current = newH;
      int groupCount;

      for (groupCount = 0; groupCount <n && current != null; groupCount++){
        current = current.getNext();
      }

      if(groupCount<n){
        break;
      }

      prev = null;
      current = newH;

      for (int i = 0; i<n; i++){
        next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
    }

    newE.setNext(prev);
    newH.setNext(current);
    newE = newH;
    newH = current;
    }
    head = temp.getNext();
  }
  }

