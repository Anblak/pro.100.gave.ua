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
	 * @return div ������� String ��� html ��������� �������� div input ��
	 *         �������� ������� div style �� ��������� div
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
	 * @return div ������� String ��� html ��������� �������� div input ��
	 *         �������� ������� div style �� ��������� div clas �� ����
	 *         �������� ��
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
	 * @return div ������� String ��� html ��������� �������� div input ��
	 *         �������� ������� div style �� ��������� div clas �� ����
	 *         �������� �� id �� id �������� div
	 */
	public String div(String input, String style, String clas, String id) {
		String div = "";
		div = "<div id='" + id + "' class='" + clas + "' style='" + style + "'>" + input + "</div>";
		return div;
	}

	/**
	 * 
	 * @param styleUl
	 *            - ��������� ul
	 * @param clasUl
	 *            - ���� ul
	 * @param idUl
	 *            - id ul
	 * @param numberLi
	 *            - ������� li
	 * @param inputLi
	 *            ���������� li
	 * @return - string c�����
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
	 *            - ���������� li
	 * @return - HTML element
	 *         <li>input</li>
	 */
	public String li(String input) {
		String li = "<li >"+input+"</li>";
		return li;
	}

	/**
	 * 
	 * @param input
	 *            - ��������� ul
	 * @param clas
	 *            - ���� ul
	 * @param style
	 *            - ��������� ul
	 * @param id
	 *            - id ul
	 * @return - HTML element
	 *         <ul>
	 * 		input
	 *         </ul>
	 */
	public String ul(String input, String clas, String style, String id) {
		String ul = "<<ul id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</ul>";

		return ul;

	}

	/**
	 * 
	 * @param input
	 *            - ���������� p
	 * @param clas
	 *            - ���� �
	 * @param style
	 *            - ��������� �
	 * @param id
	 *            - id p
	 * @return - HTML element
	 *         <p>
	 * 		input
	 *         </p>
	 */
	public String p(String input, String clas, String style, String id) {
		String p = "<p id='" + id + "' class='" + clas + "' style='" + style + "'>>" + input + "</p>";
		return p;
	}

}