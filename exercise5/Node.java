package exercise5;

import java.util.ArrayList;
import java.util.List;

public class Node extends Thread {
	private List<Integer> lista;

	public Node(List<Integer> lista) {
		this.lista = lista;
	}

	private void add(List<Integer> l, int from, int to) {
		int auxC = from;

		while (auxC < to) {
			l.add(lista.get(auxC));
			auxC++;
		}
	}

	private void merge(List<Integer> la, List<Integer> lb) {
		lista.clear();
		Integer auxA, auxB;

		while (la.size() > 0 && lb.size() > 0){
			auxA = la.get(0);
			auxB = lb.get(0);
			if (auxA.compareTo(auxB) < 0){
				lista.add(auxA);
				la.remove(0);
			} else {
				lista.add(auxB);
				lb.remove(0);
			}
		}
		
		lista.addAll(la);
		lista.addAll(lb);
	}

	@Override
	public void run() {

		if (lista.size() != 1) {
			int mid, end;
			end = lista.size();
			mid = end / 2;

			List<Integer> leftList = new ArrayList<Integer>();
			List<Integer> rightList = new ArrayList<Integer>();

			add(leftList, 0, mid);
			add(rightList, mid, end);

			Node leftNode = new Node(leftList);
			Node rightNode = new Node(rightList);

			leftNode.start();
			try {
				leftNode.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			rightNode.start();
			try {
				rightNode.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			merge(leftList, rightList);
		}
	}
}
