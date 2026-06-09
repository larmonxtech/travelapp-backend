package com.xplorelatam.repository;

import com.xplorelatam.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends IGenericRepository<User, Integer> {
    //@Query("FROM User u WHERE u.username = ?);
    //Queries derivados
    User findOneByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = :password WHERE u.username = :username") //JQPL
    void changePassword(@Param("username") String username, @Param("password") String newPassword);
}
