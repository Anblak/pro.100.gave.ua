package TestBaseActions;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import BaseActions.BaseActions;
import resources.exceptions.ProjectExceptions;

public class TestBaseActions {

	private BaseActions baseActions = new BaseActions();

	@Test
	public void testBaseAction() throws ProjectExceptions {
		Set<Integer> set = new HashSet<Integer>();

		//set.add(7);

		assertEquals(baseActions.baseOperationOnSpace("((((1^2)^3)+3)/3)", "(7,8,9)(7,2,3)(7,5,6)"),
				(HashSet<Integer>) set);

	}

}