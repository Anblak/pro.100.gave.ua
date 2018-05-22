package ua.game.pro.dto;

import java.util.ArrayList;
import java.util.List;

import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.MusicFile;
import ua.game.pro.entity.Profesor;
import ua.game.pro.entity.User;



public class DTOUtilMapper {
	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());
			userDTO.setPhone(user.getPhone());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}
	public static List<GroupOfUsersDTO> groupToGroupDTO(List<GroupOfUsers> groupsOfUsers) {

		List<GroupOfUsersDTO> groupOfUsersDTOs = new ArrayList<>();

		for (GroupOfUsers groupOfUsers : groupsOfUsers) {

			GroupOfUsersDTO groupOfUsersDTO = new GroupOfUsersDTO();
			
			groupOfUsersDTO.setId(groupOfUsers.getId());
			groupOfUsersDTO.setName(groupOfUsers.getName());
			groupOfUsersDTO.setUuid(groupOfUsers.getUuid());
			
			groupOfUsersDTOs.add(groupOfUsersDTO);

		}

		return groupOfUsersDTOs;

	}
	
	public static List<ProfesorDTO> profesorToProfesorDTO(List<Profesor>profesors){		
		List<ProfesorDTO> profesorDTOs=new ArrayList<ProfesorDTO>();
		
		for (Profesor profesor : profesors) {
			
			ProfesorDTO profesorDTO=new ProfesorDTO();
			profesorDTO.setName(profesor.getName());
			profesorDTO.setId(profesor.getId());
			profesorDTO.setGroupOfUsers(profesor.getGroupOfUsers());
			profesorDTOs.add(profesorDTO);
			
		}
		return profesorDTOs;
	}
	
	public static List<FileUserDTO> fileUsertoFileUsersDTO(List<FileUser> fileUsers){
		
		List<FileUserDTO> fileUserDTOs=new ArrayList<>();
		
		for(FileUser fileUser : fileUsers){
			
			FileUserDTO fileUserDTO=new FileUserDTO();
			
			fileUserDTO.setId(fileUser.getId());
			fileUserDTO.setName(fileUser.getName());
			fileUserDTO.setPath(fileUser.getPath());
			fileUserDTO.setProfesor(fileUser.getProfesor());
			fileUserDTO.setUser(fileUser.getUser());
			
			fileUserDTOs.add(fileUserDTO);
		}
		return fileUserDTOs;
	}
	
	public static List<MusicFileDTO> musicFileToMusicFileDTO(List<MusicFile>musicFiles){
		
		List<MusicFileDTO>musicFileDTOs=new ArrayList<>();
		
		for(MusicFile musicFile : musicFiles){
			
			MusicFileDTO musicFileDTO = new MusicFileDTO();
			
			musicFileDTO.setId(musicFile.getId());
			musicFileDTO.setName(musicFile.getName());
			musicFileDTO.setPathMusic(musicFile.getPath());
			
			musicFileDTOs.add(musicFileDTO);
			
		}
		
		return musicFileDTOs;
	}
	

	
	
}
