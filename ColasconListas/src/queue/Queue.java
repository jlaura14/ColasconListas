package queue;

import java.lang.reflect.Array;
import java.util.Iterator;

import node.node;
public class Queue <T extends Comparable<T>> implements Iterable<T>, iQueue<T> {
	
	private T[] data = null;
	private Class<T> type = null;
	private int front = -1;//el siguiente en salir
	private int back = 0;//donde se va a insertar, guardar
	private int count = 0;
	public int tope=10;
	public int top =-1;

private node<T> start = null, end = null;
	public Queue(){
		start = new node<T>();
		start.setIndex(-1); //
		end = new node<T>();
		end.setIndex(-1);
	}
	public Queue(T value){
		this();
		end.setBack(new node<T>(value));
		start.setNext(end.getBack());
		start.getNext().setIndex(0); // 
	}

	@Override
	public void enQueue(T value) throws QueueFullException {
		
		if(isFull()) throw new QueueFullException("Cola llena");//si la cola esta llena aparecera el aviso de cola llena 
		
		node<T> tmp = end.getBack();//creamos un temporal de end.getback
		end.setBack(new node<T>(value));//end.setback sera igual al valor que nosotros le mandemos
		
		if(tmp == null){//si temporal es igual a null
			start.setNext(end.getBack());//start en su setnext sera igual a end.getback
			end.getBack().setIndex(0);
		}else{
			end.getBack().setBack(tmp);//si no end.getback.setback sera igual al temporañ
			tmp.setNext(end.getBack());//y temporal en su setnext sera igual a end.getback
		}
		front++;//front aumenta
		count++;//contador aumenta
	}		

	@Override
	public T deQueue() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("No hay nada en la cola");// si cola esta vacia marcara error
		T tmp= start.getNext().getValue();//creamos un temporal de start con el valor de start en su next
		start=start.getNext();//start dara un salto para asi borrar el primer valor
		count--;//contador disminuye
		front--;//front disminuye
		return tmp;		//returnamos el valor de tmp que en este caso era el valor que acabamos de eliminar
	}

	
	@Override
	public boolean isEmpty() {
		
		return count == 0;//sera vacio si contador es igual a 0
	}

	@Override
	public boolean isFull() {
	
		return (count == tope);//la cola estara llena si el contador es igual a tope
	}

	@Override
	public T front() throws QueueEmptyException {
		if(isEmpty()) throw new QueueEmptyException("cola vacia");//si esta vacia marcara error
		T tmp = start.getNext().getValue();//creamos un temporal del valor de start en su next
		
		return tmp;//returnamos el valor de tmp
	}

	@Override
	public node<T> Search(T value)
	{
		
		return Search(value,start);  //recibimos un valor y returnamos el mismo valor y start
	}

	public node<T> Search(T value, node<T> lista) //recibimos el valor y start
	{
		if (lista.getNext()==null)return null;			//si lista.getnext es igual a nulo returnamos nulo
		if(lista.getNext().getValue().equals(value))return lista.getNext(); //si el valor de lista.getnext es igual al
		//valor recibido returnamos lista.getnext
		return Search(value, lista.getNext()); //si no se cumplen regresamos al metodo pero ahora lista avanza getnext
	}

	@Override
	public void clear() {
		
		front = -1;//reiniciamos los valores de front
		count=0;//reiniciamos los valores de count
	}

	@Override
	public boolean frontOf(T value, int priority) throws QueueFullException {
		
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			int _count = front;
			@Override
			public boolean hasNext() {
				
				return (_count >= 0);
			}

			@Override
			public T next() {
				start=start.getNext();
				_count--;
				return start.getValue();
			}
		};
	}

	@Override
	public int size() {
		
		return count;//imprimimos la cantidad de count para saber el tamaño de la cola
	}

}
