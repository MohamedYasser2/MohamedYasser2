package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;

public class Stack implements IStack {

	class Node{
		Object element;
		Node next;
		
		public void setObj(Object e)
		{
			element=e;
		}
		public void setNext(Node n)
		{
			next=n;
		}
		public Object getObj()
		{
			return element;
		}
		public Node getNext()
		{
			return next;
		}
	}
	Node head=new Node();
	int size=0;
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
			Object temp=head.getObj();
			head=head.getNext();
			size--;
			return temp;
	}
	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		return head.getObj();
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		Node current=new Node();
		if(size==0)
		{
			head=current;
			head.setObj(element);
			head.setNext(null);
			size++;
		}
		else{
			current.setNext(head);
			current.setObj(element);
			head=current;
			size++;
		}
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size==0)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	

}
