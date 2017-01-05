package BaseActions;

import java.util.HashSet;
import java.util.Set;

import DiscreteMath.Exceptions.DiscreteMathException;
import StringReader.FunctionString.FunctionString;

public class BaseActions {
	
	public HashSet<Integer> baseOperationOnSpace(String formul, String space) throws DiscreteMathException {
		
		FunctionString functionString = new FunctionString();
		HashSet<Integer> set;
		
		
		try{
			set = functionString.stringFunction(formul, space);
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
