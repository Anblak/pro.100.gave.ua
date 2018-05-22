package math.softserve.StringReader.CalculatorOneFormula;



import math.softserve.Function.Interface.DiscreteMathFunction;
import math.softserve.StringReader.Function.FunctionReader;

import java.util.HashSet;
import java.util.List;

public class CalculatorOneFormula {
    public HashSet<Integer> Index(String formul, List<HashSet<Integer>> IndexSpace, int indexSpaceA, int indexSpaceB) {

        FunctionReader functionReader = new FunctionReader();

        DiscreteMathFunction function = functionReader.objectFunction(formul);

        return function.function(IndexSpace.get(indexSpaceA), IndexSpace.get(indexSpaceB));

    }
}
