package math.softserve.StringReader.String;

import math.softserve.StringReader.Space.SpaceReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



public class StringReaderSpace {
	public List<HashSet<Integer>> redaderSpace(String string) {
		List<HashSet<Integer>> setSpace = new ArrayList<>();
		String stringTempSpace = "";
		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) != '(' && string.charAt(i) != ')') {

				stringTempSpace += string.charAt(i);
			}
			if ((string.charAt(i)) == ')') {
				stringTempSpace += '.';
				SpaceReader space = new SpaceReader();
				setSpace.add(space.addInSpace(stringTempSpace));
				stringTempSpace = "";
			}
		}
		return setSpace;
	}
}
