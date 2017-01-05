package StringReader.Space;

import java.util.HashSet;

public class SpaceReader {
	public SpaceReader() {

	}

	public HashSet<Integer> addInSpace(String reader) {
		HashSet<Integer> space = new HashSet<>();
		String tempStringInt = "";
		for (int i = 0; i < reader.length(); i++) {
			if (reader.charAt(i) != ',' && reader.charAt(i) != '.') {
				// if (reader.charAt(i) == '1') {
				// tempStringInt += "1";
				// } else if (reader.charAt(i) == '2') {
				// tempStringInt += "2";
				// } else if (reader.charAt(i) == '3') {
				// tempStringInt += "3";
				// } else if (reader.charAt(i) == '4') {
				// tempStringInt += "4";
				// } else if (reader.charAt(i) == '5') {
				// tempStringInt += "5";
				// } else if (reader.charAt(i) == '6') {
				// tempStringInt += "6";
				// } else if (reader.charAt(i) == '7') {
				// tempStringInt += "7";
				// } else if (reader.charAt(i) == '8') {
				// tempStringInt += "8";
				// } else if (reader.charAt(i) == '9') {
				// tempStringInt += "9";
				// } else if (reader.charAt(i) == '0') {
				// tempStringInt += "0";
				// }

				tempStringInt += reader.charAt(i);
			} else {
				stringoToInt(tempStringInt, space);
				tempStringInt = "";
			}
		}
		return space;

	}

	public HashSet<Integer> stringoToInt(String stringInt, HashSet<Integer> space) {

		int tempInt = 0;
		for (int i = 0; i < stringInt.length(); i++) {
			if (stringInt.length() == 3) {

				if (i == 0) {

					if (stringInt.charAt(i) == '1') {
						tempInt += 100;
						// System.out.println("100");
					} else if (stringInt.charAt(i) == '2') {
						tempInt += 200;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 300;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 400;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 500;
						// System.out.println("500");
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 600;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 700;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 800;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 900;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				} else if (i == 1) {
					if (stringInt.charAt(i) == '1') {
						tempInt += 10;
					} else if (stringInt.charAt(i) == '2') {
						// System.out.println("20");
						tempInt += 20;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 30;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 40;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 50;
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 60;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 70;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 80;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 90;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				} else if (i == 2) {
					if (stringInt.charAt(i) == '1') {
						tempInt += 1;
					} else if (stringInt.charAt(i) == '2') {
						tempInt += 2;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 3;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 4;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 5;
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 6;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 7;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 8;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 9;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				}
			} else if (stringInt.length() == 2) {

				if (i == 0) {
					if (stringInt.charAt(i) == '1') {
						tempInt += 10;
					} else if (stringInt.charAt(i) == '2') {
						// System.out.println("20");
						tempInt += 20;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 30;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 40;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 50;
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 60;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 70;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 80;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 90;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				} else if (i == 1) {
					if (stringInt.charAt(i) == '1') {
						tempInt += 1;
					} else if (stringInt.charAt(i) == '2') {
						tempInt += 2;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 3;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 4;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 5;
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 6;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 7;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 8;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 9;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				}

			} else if (stringInt.length() == 1) {
				if (i == 0) {
					if (stringInt.charAt(i) == '1') {
						tempInt += 1;
					} else if (stringInt.charAt(i) == '2') {
						tempInt += 2;
					} else if (stringInt.charAt(i) == '3') {
						tempInt += 3;
					} else if (stringInt.charAt(i) == '4') {
						tempInt += 4;
					} else if (stringInt.charAt(i) == '5') {
						tempInt += 5;
					} else if (stringInt.charAt(i) == '6') {
						tempInt += 6;
					} else if (stringInt.charAt(i) == '7') {
						tempInt += 7;
					} else if (stringInt.charAt(i) == '8') {
						tempInt += 8;
					} else if (stringInt.charAt(i) == '9') {
						tempInt += 9;
					} else if (stringInt.charAt(i) == '0') {
						tempInt += 0;
					}
				}
			}
		}

		space.add(tempInt);
		return space;
	}
}
