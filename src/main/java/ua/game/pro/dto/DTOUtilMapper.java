package ua.game.pro.dto;

import java.util.ArrayList;
import java.util.List;

import ua.game.pro.entity.*;
import ua.game.pro.entity.Professor;


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
	
	public static List<ProfessorDTO> profesorToProfesorDTO(List<Professor> professors){
		List<ProfessorDTO> profesorDTOs=new ArrayList<ProfessorDTO>();
		
		for (Professor professor : professors) {
			
			ProfessorDTO profesorDTO=new ProfessorDTO();
			profesorDTO.setName(professor.getName());
			profesorDTO.setId(professor.getId());
			profesorDTO.setGroupOfUsers(professor.getGroupOfUsers());
			profesorDTOs.add(profesorDTO);
			
		}
		return profesorDTOs;
	}

	

	
	
}
