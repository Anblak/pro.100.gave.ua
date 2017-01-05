package TestStringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import Discrete.Math.Function.Class.DiscreteMathAssociation;
import StringReader.CalculatorOneFormula.CalculatorOneFormula;
import StringReader.Function.FunctionReader;
import StringReader.FunctionString.FunctionString;
import StringReader.Space.SpaceReader;
import StringReader.String.StringReaderSpace;

public class TestStringReader {

	private SpaceReader spaceReader = new SpaceReader();
	private StringReaderSpace stringReaderSpace = new StringReaderSpace();
	private FunctionReader functionReader = new FunctionReader();
	private CalculatorOneFormula calculatorOneFormula = new CalculatorOneFormula();
	private FunctionString functionString = new FunctionString();

	@Test
	public void testSpaceReader() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		assertEquals(spaceReader.addInSpace("1,2,3."), set);
	}

	@Test
	public void testStringReaderSpace() {
		List<HashSet<Integer>> list = new ArrayList<>();

		list.add(createHashSet(1, 2, 3));
		list.add(createHashSet(4, 5, 6));
		list.add(createHashSet(7, 8, 9));

		assertEquals(stringReaderSpace.redaderSpace("(1, 2, 3)(4, 5, 6)(7, 8, 9)"), list);

	}

	@Test
	public void testFunctionReader() {
		functionReader.FunctionReader("2+4");

		assertTrue(functionReader.a == 1 && functionReader.b == 3);
		assertEquals(functionReader.objectFunction("2+4").getClass(), new DiscreteMathAssociation().getClass());
	}

	@Test
	public void testIndex() {
		List<HashSet<Integer>> list = new ArrayList<>();

		list.add(createHashSet(1, 2, 3));
		list.add(createHashSet(4, 5, 6));
		list.add(createHashSet(7, 8, 9));

		Set<Integer> set = createHashSet(1, 2, 3);
		set.addAll(createHashSet(7, 8, 9));

		assertEquals(calculatorOneFormula.Index("1+3", list, 0, 2), (HashSet<Integer>) set);
	}

	@Test
	public void testStringFunction() {
		Set<Integer> set = new HashSet<Integer>();

		set.addAll(createHashSet(5, 6, 7));
		set.add(8);

		assertEquals(functionString.stringFunction("(((1^2)^4)+3)", "(7,8,9)(7,8,3)(7,5,6)(7,8,10)"),
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
