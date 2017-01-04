package StringReader.CalculatorOneFormula;

import java.util.List;
import java.util.HashSet;
import StringReader.*;
import StringReader.Function.FunctionReader;
import StringReader.String.StringReaderSpace;
import Discrete.*;
import Discrete.Math.Function.Interface.DiscreteMathFunction;

public class CalculatorOneFormula {
	public HashSet<Integer> Index(String formul, List<HashSet<Integer>> IndexSpace, int indexSpaceA, int indexSpaceB) {

		FunctionReader functionReader = new FunctionReader();

		DiscreteMathFunction function = functionReader.objectFunction(formul);

		return function.function(IndexSpace.get(indexSpaceA), IndexSpace.get(indexSpaceB));

	}
}
