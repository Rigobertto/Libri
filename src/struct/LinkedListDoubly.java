package struct;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDoubly<T> implements List<T>{
	//classe interna
	class Node {
		int id;
		T data;
		Node next;
		Node previous;
		
		public Node(T data) {
			this.id = nextId;
			nextId++;
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
	
	public Node head;
	public Node tail;
	public int size;
	public int nextId;
	
	public LinkedListDoubly() {
		head = null;
		tail = null;
		nextId = 1;
		size = 0;
	}
	
	public void show() {
		Node n = head;
		
		if(n == null) {
			System.out.println("Lista Vazia");
		} else {
			while(n != null) {
				System.out.println(n.id + " - " + n.data);
				n = n.next;
			}
			
			System.out.println("size: " + size);
		}
	}
	
	public void showReverse() {
		Node n = tail;
		
		if(n == null) {
			System.out.println("Lista Vazia");
		} else {
			while(n != null) {
				System.out.println(n.id + " - " + n.data);
				n = n.previous;
			}
			
			System.out.println("size: " + size);
		}
	}
	
	public boolean add(T t) {
		if(t == null) {
			return false;
		} else {
			Node novo = new Node(t);
			
			if(head == null) {
				head = novo;
				tail = novo;
			} else {
				novo.previous = tail;
				tail.next = novo;
				tail = novo;
			}
			
			size++;
			
			return true;
		}
	}

	public void add(int id, T t) {
		Node n = searchNode(id);
		
		if(n == null) {
			System.out.println("Id inválido");
		} else {
			Node novo = new Node(t);
			
			if(n.next == null) {
				tail = novo;
			}
			
			novo.next = n.next;
			novo.previous = n;
			n.next = novo;
			
			Node aux = novo.next;
			
			if(aux != null) { //previne null pointer exception
				aux.previous = novo;
			}
			
			size++;
		}
	}

	public T peekFirst() {
		if(head == null) {
			System.out.println("Lista Vazia");
			return null;
		} else {
			return head.data;
		}
	}

	public T peekLast() {
		if(tail == null) {
			System.out.println("Lista Vazia");
			return null;
		} else {
			return tail.data;
		}
	}

	public T removeFirst() {
		Node n = head;
		
		if(head == null) {
			System.out.println("Lista vazia");
			return null;
		} else {
			if(head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.previous = null;
			}
			
			n.next = null;
			size--;
			
			return n.data;
		} 
	}

	public T removeLast() {
		Node n = tail;
		
		if(tail == null) {
			System.out.println("Lista vazia");
			return null;
		} else {
			if(head == tail) {
				head = null;
				tail = null;
			} else {
				Node before = tail.previous;
				tail.previous = null;
				tail = before;
				tail.next = null;
			}
			
			size--;
			
			return n.data;
		} 
	}

	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public T remove(int id) {
		if(head == null) {
			System.out.println("Lista vazia");
			return null;
		} else {
			Node removed = searchNode(id);
			
			if(removed == null) {
				System.out.println("Id não existe");
				return null;
			} else {
				if(head.id == id) {
					removed = head;
					
					if(head == tail) { //remove o único
						head = null;
						tail = null;
					} else { //remover o primeiro
						head = head.next;
						head.previous = null;
						removed.next = null;
					}
				} else if(removed == tail) { //remove o último
					tail = tail.previous;
					tail.next = null;
					removed.previous = null;
				} else { //remove do meio
					Node after = removed.next;
					Node before = removed.previous;
					
					after.previous = removed.previous;
					before.next = removed.next;
					
					removed.next = null;
					removed.previous = null;
				}
				
				size--;
				
				return removed.data;
			}
		}
	}

	private Node searchNode(int id) {
		Node n = head;
		
		while(n != null) {
			if(n.id == id) {
				return n;
			}
			
			n = n.next;
		}
		return null;
	}
	
	public T get(int id) {
		Node n = searchNode(id);
		
		if(n == null) {
			return null;
		} else {
			return n.data;
		}
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
