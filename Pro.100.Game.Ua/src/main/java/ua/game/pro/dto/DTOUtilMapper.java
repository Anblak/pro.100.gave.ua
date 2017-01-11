package ua.game.pro.dto;

import java.util.ArrayList;
import java.util.List;

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
//	public static List<GroupDTO> groupToGroupDTO(List<Group> groups) {
//
//		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();
//
//		for (Group group : groups) {
//
//			GroupDTO groupDTO = new GroupDTO();
//			
//			groupDTO.setId(group.getId());
//			groupDTO.setName(group.getName());
//			groupDTO.setUuid(group.getUuid());
//			
//			groupDTOs.add(groupDTO);
//
//		}
//
//		return groupDTOs;
//
//	}
	
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
	

	
	
}
