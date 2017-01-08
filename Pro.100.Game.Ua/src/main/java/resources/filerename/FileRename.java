package resources.filerename;

import resources.exceptions.ProjectExceptions;

/*
import java.io.File;

public class Main{
    public static void main(String [] args){
        java.io.File file = new java.io.File("D:\\test.txt"); // создаем объект на файл test.txt
        if(file.exists()){ // если файл существует, то переименовываем его
            file.renameTo(new java.io.File("D:\\main.java"));
        }
        else{
            System.out.println("File not found!");
        }
    }
}
*/
/**
 * 
 * @author prometej
 *
 */
public class FileRename {

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
	public boolean renameFile(String oldName, String grup, String profesor, String user, String refFile)
			throws ProjectExceptions {
		String newName = newName(grup, profesor, user);
		java.io.File file = new java.io.File(refFile + oldName);
		if (file.exists()) { // если файл существует, то переименовываем его
			file.renameTo(new java.io.File(refFile + newName + oldName));
			return true;
		} else {
			new ProjectExceptions("File not found!");
			return false;
		}

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
	public String newName(String grup, String profesor, String user) {

		return (grup + "." + profesor + "." + user);
	}

}
