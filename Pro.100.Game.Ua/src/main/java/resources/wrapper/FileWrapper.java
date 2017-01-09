package resources.wrapper;

import org.springframework.web.multipart.MultipartFile;

public class FileWrapper {

	private MultipartFile multipartFile;
	private String profesor;
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public FileWrapper() {
		super();
	}
	public FileWrapper(MultipartFile multipartFile, String profesor) {
		super();
		this.multipartFile = multipartFile;
		this.profesor = profesor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multipartFile == null) ? 0 : multipartFile.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileWrapper other = (FileWrapper) obj;
		if (multipartFile == null) {
			if (other.multipartFile != null)
				return false;
		} else if (!multipartFile.equals(other.multipartFile))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FileWrapper [multipartFile=" + multipartFile + ", profesor=" + profesor + "]";
	}
	
	
	
	
}
