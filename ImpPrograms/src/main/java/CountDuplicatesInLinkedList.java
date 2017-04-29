package main.java;
import java.util.*;
public class CountDuplicatesInLinkedList {

	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);

		Set<Integer> uniqueSet = new HashSet<Integer>(list);
		for(Integer temp : uniqueSet){
			System.out.println(temp + " Counted for : " + Collections.frequency(list,temp) + " times");
		}
	}
}
