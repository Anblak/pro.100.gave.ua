package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.game.pro.entity.GroupOfUsers;

@Repository
public interface GroupOfUsersDao extends JpaRepository<GroupOfUsers, Integer> {

    @Query("select u from GroupOfUsers u where u.uuid =:uuid")
    GroupOfUsers findByUUID(@Param("uuid") String uuid);

}
