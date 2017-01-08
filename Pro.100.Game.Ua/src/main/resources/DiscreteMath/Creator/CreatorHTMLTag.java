package Creator;

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
		return div;
	}

	/**
	 * 
	 * @param input
	 * @param style
	 * @return div ������� String ��� html ��������� �������� div input ��
	 *         �������� ������� div style �� ��������� div clas �� ����
	 *         �������� ��
	 */
	public String div(String input, String style, String clas) {
		String div = "";
		div = "<div class='"+clas+"' style='" + style + "'>" + input + "</div>";
		return div;
	}

	/**
	 * 
	 * @param input
	 * @param style
	 * @return div ������� String ��� html ��������� �������� div input ��
	 *         �������� ������� div style �� ��������� div clas �� ����
	 *         �������� �� id �� id �������� div
	 */
	public String div(String input, String style, String clas, String id) {
		String div = "";
		div = "<div id='"+id+"' class='"+clas+"' style='" + style + "'>" + input + "</div>";
		return div;
	}
	/**
	 * 
	 * @param styleUl - ��������� ul 
	 * @param clasUl - ���� ul
	 * @param idUl - id ul
	 * @param numberLi  - ������� li
	 * @param inputLi ���������� li
	 * @return  - string  c����� <ul><li>....</li>....</ul>
	 */
	 
	public String listUl(String styleUl,String clasUl,String idUl,int numberLi,String[] inputLi){
		String ul="<ul id='"+idUl+"' class='"+clasUl+"' style='" + styleUl + "'>";
		for(int i=0;i<numberLi;i++){
			ul+="<li>"+inputLi[i]+"</li>";
		}
		ul+=" </ul> ";
		return ul;
		
	}
}
