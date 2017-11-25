package app;

import node.node;
import queue.Queue;

public class App {

	public static <T> void main(String[] args) {
		Queue<String> names = new Queue<>();
		try {
			names.enQueue("Luis");
			names.enQueue("Ana");
			names.enQueue("Ricardo");
			names.enQueue("Yarely");
			names.enQueue("Milton");
			names.enQueue("Abraham");
			names.enQueue("Andres");
			//names.enQueue("Roberto");
			System.out.println("--------deQueue---------");
			System.out.println(names.deQueue());
			System.out.println(names.deQueue());
			System.out.println("--------Front---------");
			System.out.println(names.front());
			System.out.println(names.front());
			System.out.println("--------Size---------");
			System.out.println(names.size());
			System.out.println("---------Search--------");
			node<T> name = (node<T>) names.Search("Abraham");
			if(name!=null){
				System.out.println(name.getValue());
			}else{
				System.out.println("Nombre no encontrado");
			}
			System.out.println("--------Imprimir-----"
					+ "----");
			for (String string :names) {
				System.out.println(string);
			}	
			names.clear();
			System.out.println("----IMPRIMIR despues de CLEAR-----");
			for (String string :names) {
				System.out.println(string);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
