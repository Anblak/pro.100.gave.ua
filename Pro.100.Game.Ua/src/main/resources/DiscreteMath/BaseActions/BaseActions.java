package BaseActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DiscreteMath.Exceptions.DiscreteMathException;
import StringReader.FunctionString.FunctionString;

public class BaseActions {
	public ArrayList<HashSet<Integer>> list;
	public List<HashSet<Integer>> space;
	
	public HashSet<Integer> baseOperationOnSpace(String formul, String space) throws DiscreteMathException {
		
		FunctionString functionString = new FunctionString();
		HashSet<Integer> set;
		
		
		try{
			set = functionString.stringFunction(formul, space);
			this.space=functionString.space;
			this.list=(ArrayList<HashSet<Integer>>) functionString.indexSpace;
		}
		catch(IndexOutOfBoundsException e){
			throw new DiscreteMathException("Space number does not exist!!!");

		}
		catch(NullPointerException e){
			throw new DiscreteMathException("Wrong syntax!!!");
		}
		
		return set;
		
	}

}
