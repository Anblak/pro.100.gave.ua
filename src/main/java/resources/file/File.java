package resources.file;

import resources.exceptions.ProjectExceptions;
import resources.parset.Parset;

/**
 * 
 * @author prometej
 *
 */
public class File {

	/**
	 * 
	 * @param oldName
	 *            - name file
	 * @param grup
	 *            - id.grup
	 * @param profesor
	 *            - id.profesor
	 * @param user
	 *            - id.user
	 * @param refFile
	 *            - ref file
	 * @return true of false
	 * @throws ProjectExceptions
	 */
	public boolean renameFile(String oldName, int grup, int profesor, int user, String refFile)
			throws ProjectExceptions {
		String newName = newFolder(grup, profesor, user);
		java.io.File file = new java.io.File(refFile + oldName);
		if (file.exists()) {
			file.renameTo(new java.io.File(refFile + newName + oldName));
			return true;
		} else {
			new ProjectExceptions("File not found!");
			return false;
		}

	}

	/**
	 * 
	 * @param ref
	 * @param id
	 * @param oldName
	 * @return
	 * @throws ProjectExceptions
	 */
	public String renameFile(String ref, int id, String oldName) throws ProjectExceptions {
		String newName = "" + id + teg(oldName);
		java.io.File file = new java.io.File(ref + oldName);
		if (file.exists()) {
			file.renameTo(new java.io.File(newName));
			return ref + newName;
		} else {
			new ProjectExceptions("File not found!");
			return null;

		}

	}

	public String teg(String fullNameFile) {
		String tag = "";

		int numberPoint = 0;
		int numberTegPoint = 0;

		for (int i = 0; i < fullNameFile.length(); i++) {
			if (fullNameFile.charAt(i) == '.') {
				numberPoint++;
				numberTegPoint = i;
			}
		}

		for (int i = numberTegPoint; i < fullNameFile.length(); i++) {

			tag += fullNameFile.charAt(i);

		}
		return tag;
	}

	/**
	 * 
	 * @param grup
	 *            - id.grup
	 * @param profesor
	 *            - id.profesor
	 * @param user
	 *            - id.user
	 * @return string : {[id.grup].[id.rpfesor].[id.user]}
	 */
	public String newFolder(int grup, int profesor, int user) {
		Parset parset = new Parset();

		return (parset.parsetChar(grup) + "/" + parset.parsetChar(profesor) + "/" + parset.parsetChar(user) + "/");
	}


	public String Name(String grup, String profesor, String user, String oldName) {

		return (grup + "." + profesor + "." + user + "." + oldName);
	}

}
