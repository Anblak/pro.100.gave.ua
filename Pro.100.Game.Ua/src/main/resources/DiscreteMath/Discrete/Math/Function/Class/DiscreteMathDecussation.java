package Discrete.Math.Function.Class;

import java.util.HashSet;
import java.util.Iterator;

import Discrete.Math.Function.Interface.DiscreteMathFunction;

//перетин
public class DiscreteMathDecussation implements DiscreteMathFunction {

	@Override
	public HashSet<Integer> function(HashSet<Integer> A, HashSet<Integer> B) {
		HashSet<Integer> space = new HashSet<Integer>();
		Iterator iteratorA = A.iterator();

		while (iteratorA.hasNext()) {
			Integer integerA = (Integer) iteratorA.next();
			Iterator iteratorB = B.iterator();
			
			while (iteratorB.hasNext()) {

				if (integerA.equals(iteratorB.next())) {
					space.add(integerA);
					
				}
			}
		}

		return space;
	}

}
