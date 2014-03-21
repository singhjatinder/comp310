package edu.wit.comp310.lab1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.wit.comp310.TreeDemo.Node;
import edu.wit.comp310.TreeDemo.Visitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import edu.wit.comp310.TreeDemo.Node;
import edu.wit.comp310.TreeDemo.Visitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Roll your own Singly-linked list.
 * 
 * This means that we implement ourselves.
 * 
 * The List interface is described here:
 * 
 * @see http://docs.oracle.com/javase/7/docs/api/java/util/List.html
 *
 */
public class MyLinkedList<ValueType> implements List<ValueType> {
	Node<ValueType> first;
	Node<ValueType> last;
	int size = 0;
	public static class Node<T> {
		T data;
		Node<T> next;
	}
	@Override
	public boolean add(ValueType arg0) {
		if (this.isEmpty()) {
			Node<ValueType> newNode = new Node<ValueType>();
			newNode.data = arg0;
			first = newNode;
			last = newNode;
		}
		return false;
	}

	@Override
	public void add(int index, ValueType arg1) {
		int i=0;
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("WTF?!?");
		}
		Node<ValueType> newNode = new Node<ValueType>();
		newNode.data=arg1;
		Node<ValueType> current=first;
		while(i<index)
			current=current.next;
		newNode.next=current.next;
		current.next=newNode;
	}

	@Override
	public boolean addAll(Collection<? extends ValueType> arg0) {
		int i=0;
		for(ValueType e: arg0){
			if(i==0){
				add(e);
				i++;
			}
			else{
				Node<ValueType> newNode = new Node<ValueType>();
				Node<ValueType> current=first;
				newNode.data = e;
				while(current.next!=null)
					current=current.next;
				newNode.next=current.next;
				current.next=newNode;
			}
		}
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends ValueType> arg1) {
		int i=0;
		for(ValueType e: arg1){
			while(i<arg0){
				add(e);
				i++;
			}
				Node<ValueType> newNode = new Node<ValueType>();
				Node<ValueType> current=first;
				newNode.data = e;
				while(current.next!=null)
					current=current.next;
				newNode.next=current.next;
				current.next=newNode;
		}
		return false;
	}

	@Override
	public void clear() {
		first=null;
	}

	@Override
	public boolean contains(Object arg0) {
		Node<ValueType> current;
		for (current = first;current != null;current = current.next){
			if(current.data==arg0)
				return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		Node<ValueType> current;
		int i = 0;
		for(Object e: arg0){
			for (current = first;current != null;current = current.next){
				if(e==current.data)
					i++;
			}
		}
		if(i==arg0.size())
			return true;
		else
			return false;
	}

	@Override
	public ValueType get(int arg0){
		Node<ValueType> current = first;
		int i=0;
		while(i!=arg0){
			current=current.next;
		}
		return current.data;
	}

	@Override
	public int indexOf(Object arg0) {
		Node<ValueType> current;
		int i=0;
		for (current = first;current != null;current = current.next){
			if(current.data==arg0){
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<ValueType> iterator() {
		return new Iterator<ValueType>() {
			Node<ValueType> current = first;
			@Override
			public boolean hasNext() {
				// is there an element after current?
				if(current.next != null)
					return true;
				else
					return false;
			}
			@Override
			public ValueType next() {
				// Advance current to next
				// return current's data
				if(hasNext()){
					current=current.next;
					return current.data;
				}
				else{
					throw new IndexOutOfBoundsException("There's nothing left!!");
				}
			}
			@Override
			public void remove() {
				// Don't bother, please
			}
		};
	}

	@Override
	public int lastIndexOf(Object arg0) {
		Node<ValueType> current;
		int i=0;
		int index = -1;
		for (current = first;current != null;current = current.next){
			if(current.data==arg0)
				index=i;
			i++;
		}
		return index;
	}

	@Override
	public ListIterator<ValueType> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<ValueType> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		Node<ValueType> current;
		for (current = first;current != null;current = current.next){
			if(current.next==arg0){
				current.next=current.next.next;
				return true;
			}
		}
		return false;
	}

	@Override
	public ValueType remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ValueType set(int arg0, ValueType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<ValueType> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
