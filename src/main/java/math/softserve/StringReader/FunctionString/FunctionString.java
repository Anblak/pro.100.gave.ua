package math.softserve.StringReader.FunctionString;

import math.softserve.StringReader.CalculatorOneFormula.CalculatorOneFormula;
import math.softserve.StringReader.Function.FunctionReader;
import math.softserve.StringReader.String.StringReaderSpace;

import java.util.HashSet;
import java.util.List;


public class FunctionString {

    public List<HashSet<Integer>> indexSpace;
    public List<HashSet<Integer>> space;

    public HashSet<Integer> stringFunction(String formul, String space) {

        CalculatorOneFormula oneFormula = new CalculatorOneFormula();

        StringReaderSpace readerSpace = new StringReaderSpace();
        List<HashSet<Integer>> indexSpace = readerSpace.redaderSpace(space);
        this.space = readerSpace.redaderSpace(space);
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


    }

    // (1+2)
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
