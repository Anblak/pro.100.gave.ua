package resources.parset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import ua.game.pro.dto.ProfessorDTO;
import ua.game.pro.entity.User;

/**
 *
 * @author prometej
 *
 */
public class Parset {

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

	public String ArrayListHashSetIntegerToString(ArrayList<HashSet<Integer>> list) {
		String tempStringList = "";
		for (int i = 0; i < list.size(); i++) {
			tempStringList += " <p> space� [" + (parsetChar(i + 1) + "]:{" + HashSetIntegerToString(list.get(i)) + "} </p>");
		}
		return tempStringList;
	}


	public String ArrayListHashSetIntegerToStringStart(ArrayList<HashSet<Integer>> list, int index) {
		String tempStringList = "";
		for (int i = 0; i < index; i++) {
			tempStringList += " <p> space� [" + (parsetChar(i + 1) + "]:{" + HashSetIntegerToString(list.get(i)) + "} </p> ");
		}
		return tempStringList;
	}


	public String ArrayListHashSetIntegerToStringEnd(ArrayList<HashSet<Integer>> list, int index) {
		String tempStringList = "";
		for (int i = (index), j = 1; i < list.size(); i++, j++) {
			tempStringList += "<p>  rezaltAction� ["
					+ (parsetChar(j) + "]:{" + HashSetIntegerToString(list.get(i)) + "} </p> ");
		}
		return tempStringList;
	}

	public String parsetChar(int tempInt) {
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
	public HashMap<Integer, String> ArrayListToMap(List<ProfessorDTO> list){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (ProfessorDTO profesorDTO : list) {
			map.put(profesorDTO.getId(), profesorDTO.getName());
		}
		
		return map;
	}
	public HashMap<Integer, String> ArrayListToMap(List<ProfessorDTO> list, User user){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (ProfessorDTO profesorDTO : list) {
			if(profesorDTO.getGroupOfUsers().getId()==user.getGroupOfUsers().getId()){
				
			map.put(profesorDTO.getId(), profesorDTO.getName());
			}
		}
		
		return map;
	}

}
