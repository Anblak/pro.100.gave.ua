package StringReader.FunctionString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import StringReader.CalculatorOneFormula.CalculatorOneFormula;
import StringReader.Function.FunctionReader;
import StringReader.String.StringReaderSpace;

public class FunctionString {

	public List<HashSet<Integer>> indexSpace;
	public List<HashSet<Integer>> space;

	public HashSet<Integer> stringFunction(String formul, String space) {

		CalculatorOneFormula oneFormula = new CalculatorOneFormula();

		StringReaderSpace readerSpace = new StringReaderSpace();
		int tempInt;
		List<HashSet<Integer>> indexSpace = readerSpace.redaderSpace(space);
		this.space=readerSpace.redaderSpace(space);
		HashSet<Integer> tempSet = null;
		while (formul.length() > 1) {
			// tempSet.clear();
			FunctionReader functionReader = new FunctionReader();
			functionReader.FunctionReader(formul);

			tempSet = (oneFormula.Index(getFromString(formul, indexBracketsStart(formul), indexBracketsEnd(formul)),
					indexSpace, functionReader.a, functionReader.b));

			int indexSize = indexSpace.size();

			indexSpace.add(indexSize, tempSet);
			formul = removeCharFromString(formul, indexBracketsStart(formul), indexBracketsEnd(formul),
					indexSpace.size() - 1);
		}
		
		this.indexSpace = indexSpace;
		return tempSet;

	}

	// шукає внутрішню відкриваючу дужку
	private int indexBracketsStart(String formul) {

		int tempIndex = 0;

		boolean temp = true;
		for (int i = 0; i < formul.length(); i++) {

			if (formul.charAt(i) == ')') {
				temp = false;
				break;
			}
			if (formul.charAt(i) == '(' && temp) {

				tempIndex = i;

			}
		}
		return tempIndex;
	}

	// шукає закриваючу дужку
	private int indexBracketsEnd(String formul) {

		int tempIndex = 0;

		boolean temp = true;
		for (int i = 0; i < formul.length(); i++) {

			if (formul.charAt(i) == ')') {
				tempIndex = i;
				break;
			}

		}
		return tempIndex;
	}

	// видаляє одну дію з дужками і записує на їхнє місце символ який вказує на
	// колекцію
	private String removeCharFromString(String formul, int start, int end, int newFormul) {
		String temp = "";
		for (int i = 0; i < formul.length(); i++) {
			if (i < start || i > end) {

				temp += formul.charAt(i);

			} else if (start == i) {
				temp += (newFormul + 1);
			}

		}
		return temp;
		// delete
		// System.out.println(formul);

	}

	// повертає одну дію приклад (1+2)
	private String getFromString(String formul, int start, int end) {
		String temp = "";
		for (int i = 0; i < formul.length(); i++) {
			if (start < i && i < end) {

				temp += formul.charAt(i);
			}

		}
		return temp;
	}
}
