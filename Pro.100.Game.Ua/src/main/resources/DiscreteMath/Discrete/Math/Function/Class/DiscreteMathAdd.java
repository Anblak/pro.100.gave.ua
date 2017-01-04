package Discrete.Math.Function.Class;

import java.util.HashSet;
import java.util.Iterator;

import Discrete.Math.Function.Interface.DiscreteMathFunction;

//Альтернативне додавання
public class DiscreteMathAdd implements DiscreteMathFunction {

	@Override
	public HashSet<Integer> function(HashSet<Integer> A, HashSet<Integer> B) {
		HashSet<Integer> space = new HashSet<Integer>();
		Iterator iteratorA = A.iterator();

		while (iteratorA.hasNext()) {
			Integer integerA = (Integer) iteratorA.next();
			Iterator iteratorB = B.iterator();
			boolean checkTemp = true;
			while (iteratorB.hasNext()) {

				if (!(integerA.equals(iteratorB.next())) && checkTemp) {

				} else {
					checkTemp = false;
				}
			}
			if (checkTemp) {
				space.add(integerA);
			}
		}
		temp(A, B, space);
		return space;

	}
	private void temp(HashSet<Integer> A,HashSet<Integer> B,HashSet<Integer> space){
		Iterator iteratorB = B.iterator();

		while (iteratorB.hasNext()) {
			Integer integerB = (Integer) iteratorB.next();
			Iterator iteratorA = A.iterator();
			boolean checkTemp = true;
			while (iteratorA.hasNext()) {

				if (!(integerB.equals(iteratorA.next())) && checkTemp) {

				} else {
					checkTemp = false;
				}
			}
			if (checkTemp) {
				space.add(integerB);
			}
		}
	}
}
