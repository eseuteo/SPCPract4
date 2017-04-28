package exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DriverMerge {
	private static int SIZE_ARRAY = 256;
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random(3);
		List<Integer> list = new ArrayList<Integer>();
		int value;
		for (int i=0; i<SIZE_ARRAY; i++){
			value = r.nextInt(SIZE_ARRAY*10);
			System.out.println(value);
			list.add(value);
		}
		Node n = new Node(list);
		n.start();
		n.join();
		System.out.println(list.toString());
	}
}
