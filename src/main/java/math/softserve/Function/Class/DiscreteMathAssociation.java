package math.softserve.Function.Class;

import math.softserve.Function.Interface.DiscreteMathFunction;

import java.util.HashSet;



public class DiscreteMathAssociation implements DiscreteMathFunction {

	@Override
	public HashSet<Integer> function(HashSet<Integer> A, HashSet<Integer> B) {
		HashSet<Integer> space = new HashSet<>();
		space.addAll(A);
		space.addAll(B);
		return space;

	}

}
