package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.game.pro.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByName(String name);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.name =:name")
	boolean userExistsByName(@Param("name") String name);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email =:email")
	boolean userExistsByEmail(@Param("email") String email);
	
	@Query("select u from User u where u.uuid =:uuid")
	User findByUUID(@Param("uuid") String uuid);
	
	@Query("select distinct u from User u left join fetch u.profesors where u.id =:id")
	User fetchUserWithProfesor(@Param("id") int id);
}
