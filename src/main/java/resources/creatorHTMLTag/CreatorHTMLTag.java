package resources.creatorHTMLTag;

import java.util.Map.Entry;
import java.util.TreeMap;

import resources.file.File;

/**
 * 
 * @author prometej
 *
 */
public class CreatorHTMLTag {


	public String div(String input, String style) {
		String div = "";
		div = "<div style='" + style + "'>" + input + "</div>";
		File fileRename = new File();

		return div;

	}


	public String div(String input, String style, String clas) {
		String div = "";
		div = "<div class='" + clas + "' style='" + style + "'>" + input + "</div>";
		return div;
	}


	public String div(String input, String style, String clas, String id) {
		String div = "";
		div = "<div id='" + id + "' class='" + clas + "' style='" + style + "'>" + input + "</div>";
		return div;
	}


	public String listUWithLi(String styleUl, String clasUl, String idUl, int numberLi, String[] inputLi) {
		String ul = "<ul id='" + idUl + "' class='" + clasUl + "' style='" + styleUl + "'>";
		for (int i = 0; i < numberLi; i++) {
			ul += "<li>" + inputLi[i] + "</li>";
		}
		ul += " </ul> ";
		return ul;

	}

	public String li(String input) {
		String li = "<li >" + input + "</li>";
		return li;
	}

	public String li(String input, String clas) {
		String li = "<li " + "class='" + clas + "' >" + input + "</li>";
		return li;
	}


	public String ul(String input, String clas, String style, String id) {
		String ul = "<<ul id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</ul>";

		return ul;

	}


	public String p(String input, String clas, String style, String id) {
		String p = "<p id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</p>";
		return p;
	}


	public String p(String input, String clas, String style) {
		String p = "<p  class='" + clas + "' style='" + style + "'>" + input + "</p>";
		return p;
	}


	public String button(String input, String clas, String name, String value, String type, String formmethod,
			String formaction) {
		return " <button class='" + clas + "' name='" + name + "' value='" + value + "' type='" + type
				+ "' formmethod='" + formmethod + "' formaction='" + formaction + "' >" + input + "</button>";
	}

	public String button(String input, String clas, String name, String id, String type) {
		return " <button class='" + clas + "'id='" + id + "' name='" + name + "'type='" + type + "'>" + input
				+ "</button>";
	}

	public String button(String input, String clas, String type) {

		return " <button class='" + clas + "' type='" + type + "' >" + input + "</button>";
	}


	public String input(String name, String placeholder, String clas, String id, String type) {

		return "<input name='" + name + "' placeholder='" + placeholder + "' class='" + clas + "' id='" + id
				+ "' type='" + type + "' >";
	}

	public String a(String href, String download, String name, String title, String type, String input) {
		return "<a href='" + href + "' download='" + download + "' name='" + name + "' title='" + title + "' type='"
				+ type + "' >" + input + "</a>";

	}

	public String a(String href, String download, String name, String input) {
		return "<a href='" + href + "' download='" + download + "' name='" + name + "'>" + input + "</a>";

	}


	public String form(String input, String action, String method) {

		return " <form action='" + action + "' method='" + method + "' >" + input + "</form>";
	}

	public String select(TreeMap<Integer, String> map, String nameSelect) {
		String body = "<select name = '" + nameSelect + "'>";
		for (Entry<Integer, String> entry : map.entrySet()) {
			body += "<option value = '" + entry.getKey() + "'>" + entry.getValue() + "</option>";
		}
		body += "</select>";
		return body;
	}

	public String selectAll(TreeMap<Integer, String> map, String nameSelect, String size) {
		String body = "<select multiple='multiple' size='" + size + "' name = '" + nameSelect + "'>";
		for (Entry<Integer, String> entry : map.entrySet()) {
			body += "<option value = '" + entry.getKey() + "'>" + entry.getValue() + "</option>";
		}
		body += "</select>";
		return body;
	}
}
