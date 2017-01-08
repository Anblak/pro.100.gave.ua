package ua.game.pro.validator;

import org.springframework.stereotype.Component;

import ua.game.pro.entity.GroupOfUsers;

@Component("GroupOfUsersValidator")
public class GroupOfUsersValidator implements Validator {

	@Override
	public void validate(Object object) throws Exception {
		
		GroupOfUsers groupOfUsers= (GroupOfUsers)object;
		if(groupOfUsers.getName().isEmpty()){
			throw new GroupOfUsersValidationException(GroupOfUsersValidationMessages.EMPTY_NAME_FIELD);
		}
		
	}

}
