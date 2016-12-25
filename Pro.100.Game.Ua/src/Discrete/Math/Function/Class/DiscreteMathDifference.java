package Discrete.Math.Function.Class;

import java.util.HashSet;

import Discrete.Math.Function.Interface.DiscreteMathFunction;

//р≥зниц€
public class DiscreteMathDifference implements DiscreteMathFunction {

	@Override
	public HashSet<Integer> funclion(HashSet<Integer> A, HashSet<Integer> B) {
		HashSet<Integer> space = new HashSet<Integer>();
		Iterator iteratorA = A.iterator();

		while (iteratorA.hasNext()) {
			Integer integerA = iteratorA.next();
			Iterator iteratorB = B.iterator();
			boolean checkTemp = true;
			while (iteratorB.hasNext()) {

				if (integerA.equals(iteratorB.next())) {
					checkTemp = false;
				} else {
					checkTemp = true;
				}
			}
		}
		return space;
	}

}
