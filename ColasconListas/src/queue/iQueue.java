package queue;

import node.node;

public interface iQueue<T> {
	public void enQueue(T value) throws QueueFullException;
	public T deQueue() throws QueueEmptyException;
	public boolean isEmpty();
	public boolean isFull();
	public T front() throws QueueEmptyException;
	public node<T> Search(T value) throws QueueEmptyException;
	public void clear();
	public boolean frontOf(T value, int priority) throws QueueFullException;
	public int size();
}
