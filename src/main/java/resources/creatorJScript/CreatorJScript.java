package resources.creatorJScript;

/**
 * 
 * @author prometej
 *
 */
public class CreatorJScript {
	/**
	 * 
	 * @param input
	 *            - input String JScript
	 * @return
	 * 
	 */
	public String JS(String input) {
		return "<script>" + input + "</script>";
	}

	/**
	 * 
	 * @param command:
	 *            document."command"
	 * @return doucment.command
	 */
	public String Document(String command) {
		return "document." + command;
	}

	/**
	 * 
	 * @param id
	 *            - id element
	 * @param command
	 *            - getElementById('" + id + "').command
	 * @return
	 */
	public String ByGetElement(String id, String command) {
		return "getElementById('" + id + "')." + command;
	}

	/**
	 * 
	 * @param input
	 *            - innerHTML = input
	 * @return "innerHTML=" + input
	 */
	public String innerHTML(String input) {
		return "innerHTML=" + "'"+input+"'";
	}


	public String innerHTMLadd(String input) {
		return "innerHTML+=" + "'"+input+"'";
	}
}
