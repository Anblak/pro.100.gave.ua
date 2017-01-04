package StringReader.Function;

import Discrete.Math.Function.Class.DiscreteMathAdd;
import Discrete.Math.Function.Class.DiscreteMathAssociation;
import Discrete.Math.Function.Class.DiscreteMathDecussation;
import Discrete.Math.Function.Class.DiscreteMathDifference;
import Discrete.Math.Function.Interface.DiscreteMathFunction;

//  alt "@"  vid "/"  obed "+"  peretun "^" 
public class FunctionReader {
	public int a;
	public int b;

	public void FunctionReader(String reader) {

		int tempStringInt = 0;
		for (int i = 0; i < reader.length(); i++) {

			if (reader.charAt(i) != '/' && (reader.charAt(i) != '@') && reader.charAt(i) != '+'
					&& reader.charAt(i) != '^') {
				if (reader.charAt(i) == '1') {
					tempStringInt = 1;
				} else if (reader.charAt(i) == '2') {
					tempStringInt = 2;
				} else if (reader.charAt(i) == '3') {
					tempStringInt = 3;
				} else if (reader.charAt(i) == '4') {
					tempStringInt = 4;
				} else if (reader.charAt(i) == '5') {
					tempStringInt = 5;
				} else if (reader.charAt(i) == '6') {
					tempStringInt = 6;
				} else if (reader.charAt(i) == '7') {
					tempStringInt = 7;
				} else if (reader.charAt(i) == '8') {
					tempStringInt = 8;
				} else if (reader.charAt(i) == '9') {
					tempStringInt = 9;
				}
			} else {
				if (reader.charAt(i) == '/') {
					if (checkLength(i + 1, reader)) {

						b = tempStringInt(reader.charAt(i + 1))-1;

						break;
					}
				} else if (reader.charAt(i) == '@') {
					if (checkLength(i + 1, reader)) {

						b = tempStringInt(reader.charAt(i + 1))-1;
						break;
					}

				} else if (reader.charAt(i) == '+') {
					if (checkLength(i + 1, reader)) {
						b = (tempStringInt(reader.charAt(i +1)))-1;

						break;
					}

				} else if (reader.charAt(i) == '^') {

					if (checkLength(i + 1, reader)) {

						b = tempStringInt(reader.charAt(i + 1))-1;
						break;
					}

				}
			}
		}
		a = (tempStringInt)-1;

	}

	public DiscreteMathFunction objectFunction(String reader) {
		for (int i = 0; i < reader.length(); i++) {

			if (reader.charAt(i) != '/' && (reader.charAt(i) != '@') && reader.charAt(i) != '+'
					&& reader.charAt(i) != '^') {

			} else

			{
				if (reader.charAt(i) == '/') {
					if (checkLength(i + 1, reader)) {
						return new DiscreteMathDifference();
					}
				} else if (reader.charAt(i) == '@') {
					if (checkLength(i + 1, reader)) {
						return new DiscreteMathAdd();
					}

				} else if (reader.charAt(i) == '+') {
					if (checkLength(i + 1, reader)) {
						return new DiscreteMathAssociation();
					}

				} else if (reader.charAt(i) == '^') {

					if (checkLength(i + 1, reader)) {
						return new DiscreteMathDecussation();
					}

				}
			}
		}
		return null;
	}
	// private int checkLength(String reader) {
	// int tempInt = 0;
	// int tempIndex = 0;
	// for (int i = 0; i < reader.length(); i++) {
	//
	// boolean temp = true;
	// if (reader.charAt(i) == ')') {
	// temp = false;
	// }
	// if (reader.charAt(i) == '(' && temp) {
	// tempInt++;
	// }
	// }
	// for (int i = 0; i < reader.length(); i++) {
	//
	// boolean temp = true;
	// if (reader.charAt(i) == ')') {
	// temp = false;
	// }
	// if (reader.charAt(i) == '(' && temp) {
	// tempInt++;
	// tempIndex = i;
	// }
	// }
	// return tempIndex;
	// }

	// public void removeCharFromString(String s, int a, int b) {
	// String r = "";
	// for (int i = 0; i < s.length(); i++) {
	// if (i < a || i > b)
	// r += s.charAt(i);
	// }
	// s = r;
	// }

	private boolean checkLength(int i, String reader) {
		boolean tempCheck = false;
		if (i < reader.length()) {
			tempCheck = true;
		}
		return tempCheck;
	}

	private int tempStringInt(char tempChar) {
		int tempStringInt=0;
		if (tempChar != '/' && (tempChar != '@') && tempChar != '+' && tempChar != '^') {
			if (tempChar == '1') {
				tempStringInt = 1;
			} else if (tempChar == '2') {
				tempStringInt = 2;
			} else if (tempChar == '3') {
				tempStringInt = 3;
			} else if (tempChar == '4') {
				tempStringInt = 4;
			} else if (tempChar == '5') {
				tempStringInt = 5;
			} else if (tempChar == '6') {
				tempStringInt = 6;
			} else if (tempChar == '7') {
				tempStringInt = 7;
			} else if (tempChar == '8') {
				tempStringInt = 8;
			} else if (tempChar == '9') {
				tempStringInt = 9;
			}
		}
		return tempStringInt;
	}
}
