package BaseActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import StringReader.FunctionString.FunctionString;
import resources.exceptions.ProjectExceptions;

public class BaseActions {
	public ArrayList<HashSet<Integer>> list;
	public List<HashSet<Integer>> space;
	
	public HashSet<Integer> baseOperationOnSpace(String formul, String space) throws ProjectExceptions {
		
		FunctionString functionString = new FunctionString();
		HashSet<Integer> set;
		
		
		try{
			set = functionString.stringFunction(formul, space);
			this.space=functionString.space;
			this.list=(ArrayList<HashSet<Integer>>) functionString.indexSpace;
		}
		catch(IndexOutOfBoundsException e){
			throw new ProjectExceptions("Space number does not exist!!!");

		}
		catch(NullPointerException e){
			throw new ProjectExceptions("Wrong syntax!!!");
		}
		
		return set;
		
	}

}
