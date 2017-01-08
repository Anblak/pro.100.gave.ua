package Creator;

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
		return div;
	}

	/**
	 * 
	 * @param input
	 * @param style
	 * @return div створює String для html створення елемента div input це
	 *         внутрішня частина div style це стилізація div clas це клас
	 *         елемента дів
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
	 * @return div створює String для html створення елемента div input це
	 *         внутрішня частина div style це стилізація div clas це клас
	 *         елемента дів id це id елемента div
	 */
	public String div(String input, String style, String clas, String id) {
		String div = "";
		div = "<div id='"+id+"' class='"+clas+"' style='" + style + "'>" + input + "</div>";
		return div;
	}
	/**
	 * 
	 * @param styleUl - стилізація ul 
	 * @param clasUl - клас ul
	 * @param idUl - id ul
	 * @param numberLi  - кількість li
	 * @param inputLi наповнення li
	 * @return  - string  cписок <ul><li>....</li>....</ul>
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
