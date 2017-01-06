package ua.game.pro.dto;

import java.util.ArrayList;
import java.util.List;


import ua.game.pro.entity.User;



public class DTOUtilMapper {
	public static List<UserDTO> usersToUsersDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {

			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setEmail(user.getEmail());

			userDTOs.add(userDTO);

		}

		return userDTOs;

	}

	
	
	
}
