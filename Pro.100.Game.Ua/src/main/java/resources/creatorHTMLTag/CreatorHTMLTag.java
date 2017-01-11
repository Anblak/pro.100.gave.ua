package resources.creatorHTMLTag;

import resources.file.File;

/**
 * 
 * @author prometej
 *
 */
public class CreatorHTMLTag {
	/**
	 * 
	 * @param input
	 * @param style
	 * @return div створює String для html створення елемента div input це
	 *         внутрішня частина div style це стилізація div
	 */

	public String div(String input, String style) {
		String div = "";
		div = "<div style='" + style + "'>" + input + "</div>";
		File fileRename = new File();

		return div;

	}

	/**
	 * 
	 * @param input
	 * @param style
	 * @param clas
	 * @return div створює String для html створення елемента div input це
	 *         внутрішня частина div style це стилізація div clas це клас
	 *         елемента дів
	 */
	public String div(String input, String style, String clas) {
		String div = "";
		div = "<div class='" + clas + "' style='" + style + "'>" + input + "</div>";
		return div;
	}

	/**
	 * 
	 * @param input
	 * @param style
	 * @param id
	 * @param clas
	 * @return div створює String для html створення елемента div input це
	 *         внутрішня частина div style це стилізація div clas це клас
	 *         елемента дів id це id елемента div
	 */
	public String div(String input, String style, String clas, String id) {
		String div = "";
		div = "<div id='" + id + "' class='" + clas + "' style='" + style + "'>" + input + "</div>";
		return div;
	}

	/**
	 * 
	 * @param styleUl
	 *            - стилізація ul
	 * @param clasUl
	 *            - клас ul
	 * @param idUl
	 *            - id ul
	 * @param numberLi
	 *            - кількість li
	 * @param inputLi
	 *            наповнення li
	 * @return - string cписок
	 *         <ul>
	 *         <li>....</li>....
	 *         </ul>
	 */

	public String listUWithLi(String styleUl, String clasUl, String idUl, int numberLi, String[] inputLi) {
		String ul = "<ul id='" + idUl + "' class='" + clasUl + "' style='" + styleUl + "'>";
		for (int i = 0; i < numberLi; i++) {
			ul += "<li>" + inputLi[i] + "</li>";
		}
		ul += " </ul> ";
		return ul;

	}

	/**
	 * 
	 * @param input
	 *            - наповнення li
	 * @return - HTML element
	 *         <li>input</li>
	 */
	public String li(String input) {
		String li = "<li >" + input + "</li>";
		return li;
	}

	/**
	 * 
	 * @param input
	 *            - наповення ul
	 * @param clas
	 *            - клас ul
	 * @param style
	 *            - стилізація ul
	 * @param id
	 *            - id ul
	 * @return - HTML element
	 *         <ul>
	 *         input
	 *         </ul>
	 */
	public String ul(String input, String clas, String style, String id) {
		String ul = "<<ul id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</ul>";

		return ul;

	}

	/**
	 * 
	 * @param input
	 *            - наповнення p
	 * @param clas
	 *            - клас р
	 * @param style
	 *            - стилізація р
	 * @param id
	 *            - id p
	 * @return - HTML element
	 *         <p>
	 *         input
	 *         </p>
	 */
	public String p(String input, String clas, String style, String id) {
		String p = "<p id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</p>";
		return p;
	}

	/**
	 * 
	 * @param input
	 *            - наповнення p
	 * @param clas
	 *            - клас р
	 * @param style
	 *            - стилізація р
	 * 
	 * @return - HTML element
	 *         <p>
	 *         input
	 *         </p>
	 */
	public String p(String input, String clas, String style) {
		String p = "<p  class='" + clas + "' style='" + style + "'>" + input + "</p>";
		return p;
	}

	/**
	 * 
	 * @param input
	 * @param clas
	 * @param name
	 * @param value
	 * @param type
	 * @param formmethod
	 * @param formaction
	 * @return button
	 */
	public String button(String input, String clas, String name, String value, String type, String formmethod,
			String formaction) {
		return " <button class='" + clas + "' name='" + name + "' value='" + value + "' type='" + type
				+ "' formmethod='" + formmethod + "' formaction='" + formaction + "' >" + input + "</button>";
	}

	/**
	 * 
	 * @param input
	 * @param clas
	 * @param type
	 * @return
	 */

	public String button(String input, String clas, String type) {

		return " <button class='" + clas + "' type='" + type + "' >" + input + "</button>";
	}

	/**
	 * 
	 * @param name
	 * @param placeholder
	 * @param clas
	 * @param id
	 * @param type
	 * @return
	 */

	public String input(String name, String placeholder, String clas, String id, String type) {

		return "<input name='" + name + "' placeholder='" + placeholder + "' class='" + clas + "' id='" + id
				+ "' type='" + type + "' >";
	}

	/**
	 * 
	 * @param href
	 * @param download
	 * @param name
	 * @param title
	 * @param type
	 * @param input
	 * @return
	 */
	public String a(String href, String download, String name, String title, String type, String input) {
		return "<a href='" + href + "' download='" + download + "' name='" + name + "' title='" + title + "' type='"
				+ type + "' >" + input + "</a>";

	}

	/**
	 * 
	 * @param href
	 * @param download
	 * @param name
	 * @param input
	 * @return
	 */
	public String a(String href, String download, String name, String input) {
		return "<a href='" + href + "' download='" + download + "' name='" + name + "'>" + input + "</a>";

	}

	/**
	 * 
	 * @param input
	 * @param action
	 * @param method
	 * @return
	 */
	public String form(String input, String action, String method) {

		return " <form action='" + action + "' method='" + method + "' >" + input + "</form>";
	}
}
