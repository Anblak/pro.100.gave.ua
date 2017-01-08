package resources.parset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 
 * @author prometej
 *
 */
public class Parset {
	/**
	 * 
	 * @param set
	 *            - HashSet<Integer>
	 * @return String � �������� HashSet<Integer>
	 */
	public String HashSetIntegerToString(HashSet<Integer> set) {
		Iterator iterator = set.iterator();
		String string = "(";

		while (iterator.hasNext()) {
			Integer tempInt = (Integer) iterator.next();
			string += parsetChar(tempInt);
			if (iterator.hasNext()) {

				string += ",";
			}
		}
		string += ")";
		return string;
	}

	/**
	 * 
	 * @param list
	 *            - ArrayList<HashSet<Integer>>
	 * @return - String � �������� ArrayList<HashSet<Integer>>
	 */
	public String ArrayListHashSetIntegerToString(ArrayList<HashSet<Integer>> list) {
		String tempStringList = "";
		for (int i = 0; i < list.size(); i++) {
			tempStringList += "  space� [" + (parsetChar(i + 1) + "]:{" + HashSetIntegerToString(list.get(i)) + "} ");
		}
		return tempStringList;
	}

	/**
	 * 
	 * @param list
	 *            - ArrayList<HashSet<Integer>>
	 * @param index
	 *            - �� ����� �������� ���������� � String
	 * @return - String � �������� ArrayList<HashSet<Integer>>
	 */
	public String ArrayListHashSetIntegerToStringStart(ArrayList<HashSet<Integer>> list, int index) {
		String tempStringList = "";
		for (int i = 0; i < index; i++) {
			tempStringList += "  space� [" + (parsetChar(i + 1) + "]:{" + HashSetIntegerToString(list.get(i)) + "} ");
		}
		return tempStringList;
	}

	/**
	 * 
	 * @param list
	 *            - ArrayList<HashSet<Integer>>
	 * @param index
	 *            - � ����� �������� ���������� � String
	 * @return - String � �������� ArrayList<HashSet<Integer>>
	 */
	public String ArrayListHashSetIntegerToStringEnd(ArrayList<HashSet<Integer>> list, int index) {
		String tempStringList = "";
		for (int i = (index), j = 1; i < list.size(); i++, j++) {
			tempStringList += "  rezaltAction� ["
					+ (parsetChar(j) + "]:{" + HashSetIntegerToString(list.get(i)) + "} ");
		}
		return tempStringList;
	}

	// 990
	private String parsetChar(int tempInt) {
		String tempStringInt = "";
		if (tempInt <= 999 && tempInt >= 100) {

			tempStringInt += numbers((tempInt - (tempInt % 100)) / 100);
			tempInt = (tempInt % 100);

			tempStringInt += numbers((tempInt - (tempInt % 10)) / 10);
			tempInt = (tempInt % 10);

			tempStringInt += numbers(tempInt);

		} else if (tempInt <= 99 && tempInt >= 10) {

			tempStringInt += numbers((tempInt - (tempInt % 10)) / 10);

			tempInt = (tempInt % 10);

			tempStringInt += numbers(tempInt);

		} else if (tempInt <= 9) {

			tempStringInt += numbers(tempInt);
		}

		return tempStringInt;
	}

	private String numbers(int tempInt) {
		String tempStringInt = "";
		if (tempInt == 1) {
			tempStringInt += "1";
		} else if (tempInt == 2) {
			tempStringInt += "2";
		} else if (tempInt == 3) {
			tempStringInt += "3";
		} else if (tempInt == 4) {
			tempStringInt += "4";
		} else if (tempInt == 5) {
			tempStringInt += "5";
		} else if (tempInt == 6) {
			tempStringInt += "6";
		} else if (tempInt == 7) {
			tempStringInt += "7";
		} else if (tempInt == 8) {
			tempStringInt += "8";
		} else if (tempInt == 9) {
			tempStringInt += "9";
		} else if (tempInt == 0) {
			tempStringInt += "0";
		}
		return tempStringInt;
	}

}
