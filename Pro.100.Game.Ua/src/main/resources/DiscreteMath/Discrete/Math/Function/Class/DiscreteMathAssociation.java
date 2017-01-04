package Discrete.Math.Function.Class;

import java.util.HashSet;

import Discrete.Math.Function.Interface.DiscreteMathFunction;

//обєднання
public class DiscreteMathAssociation implements DiscreteMathFunction {

	@Override
	public HashSet<Integer> function(HashSet<Integer> A, HashSet<Integer> B) {
		HashSet<Integer> space = new HashSet<Integer>();
		space.addAll(A);
		space.addAll(B);
		return space;

	}

}
