public class LinkedList
{
  Node head;
   public LinkedList()
  {
    head=null;
  }
  public int getLength()
  {
    Node current = head;
    int count = 0;
    while(current != null)
    {
      current = current.getNext();
      count++;
    }
    return count;
  }
  public void addToFront(Student toAdd)
  {
    Node current = new Node(toAdd, head);
    head = current;
  }
  public void addToEnd(Student toAdd)
  {
    if(head == null)
    {
      head = new Node(toAdd, null);
    }
    else
    {
      Node last = new Node(toAdd, head);
      Node current = head;
    while(current.getNext() != null)
    {
      current = current.getNext();
    }
    current.setnext(last);
    last.setnext(null);
    }
  }
  public Student removeFromFront()
  {
    Node newHead = head;
    if(head == null)
    {
      return null;
    }
    
    else
    {
      head = head.getNext();
    }
    return newHead.getdata();
   
  }
  public Student removeFromEnd()
  {
    Node current = head;
    Node tail = null;
    if(current == null)
    {
      return null;
    }
    if(current.next == null)
    {
      head = null;
      return current.getdata();
    }
      while(current.getNext() != null)
      {
        tail = current;
        current = current.getNext();
      }
      tail.next = null;
      return current.getdata();
    }
  public boolean removeTarget(Student toRemove)
  {
    Node current = head;
    Node tail = null;
    if(current == null)
    {
      return false;
    }
    while(current.getdata()!=null & current.getdata() != toRemove)
    {
      tail = current;
      current = current.next;
      if(tail.getdata()!=toRemove)
      {
        return false;
      }
    }
    if(current!=null && current.getdata() == toRemove)
    {
      head = current.next;
      return true;
    }
    while(current.getdata()!=null && current.getdata() != toRemove)
    {
      tail = current;
      current = current.next;
    }
    tail.next = current.next;
    return true;
  }
  
  public String toString()
  {
    Node current = head;
    String list = "head->";
    while(current != null)
    {
      list+=current.getdata().toString();
      current = current.getNext();
      list += "->";
    }
    list += "null";
    return list;
  }
  private class Node
  {
    private Student data;
    private Node next;
    Node(Student dataPassed, Node nextPassed)
    {
     data = dataPassed;
     next = nextPassed;
    }
    public void setdata(Student dataPassed)
    {
     data = dataPassed;
    }
    public Student getdata()
    {
      return data;
    }
    public Node getNext()
    {
     return next;
    }
    public void setnext(Node passed)
    {
     next = passed;
    }
    public String toString()
    {
      return data.toString();
    }
  }
}