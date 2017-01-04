package TestDiscrete;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import Discrete.Math.Function.Class.*;

public class TestDiscrete {

	private DiscreteMathAdd discreteMathAdd = new DiscreteMathAdd();
	private DiscreteMathAssociation discreteMathAssociation = new DiscreteMathAssociation();
	private DiscreteMathDecussation discreteMathDecussation = new DiscreteMathDecussation();
	private DiscreteMathDifference discreteMathDifference = new DiscreteMathDifference();

	@Test
	public void testDiscreteMathAdd() {
		Set<Integer> set = new HashSet<Integer>();

		set.add(1);
		set.addAll(createHashSet(5, 7, 9));

		assertEquals(discreteMathAdd.function(createHashSet(1, 3, 5), createHashSet(3, 7, 9)), (HashSet<Integer>) set);
	}

	@Test
	public void testDiscreteMathAssociation() {
		Set<Integer> set = createHashSet(1, 3, 5);

		set.addAll(createHashSet(3, 7, 9));

		assertEquals(discreteMathAssociation.function(createHashSet(1, 3, 5), createHashSet(3, 7, 9)),
				(HashSet<Integer>) set);
	}

	@Test
	public void testDiscreteMathDecussation() {
		Set<Integer> set = new HashSet<Integer>();

		set.add(3);

		assertEquals(discreteMathDecussation.function(createHashSet(1, 3, 5), createHashSet(3, 7, 9)),
				(HashSet<Integer>) set);
	}

	@Test
	public void testDiscreteMathDifference() {
		Set<Integer> set = new HashSet<Integer>();

		set.add(1);
		set.add(5);

		assertEquals(discreteMathDifference.function(createHashSet(1, 3, 5), createHashSet(3, 7, 9)),
				(HashSet<Integer>) set);

	}

	private HashSet<Integer> createHashSet(int value1, int value2, int value3) {
		Set<Integer> set = new HashSet<>();

		set.add(value1);
		set.add(value2);
		set.add(value3);

		return (HashSet<Integer>) set;
	}

}
