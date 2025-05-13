package com.hiringglobal.mobile.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hiringglobal.mobile.model.User;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);

	@Query(nativeQuery = true, value = "Select * from user")
	List<User> getAllUser();
	
    @Modifying
    @Query("Update User u set u.password=:password WHERE u.id = (:id) ")
    int changePassword(@Param("id") Integer id,@Param("password") String password);

    @Query(value= "Update User u Set u.locked=(:locked)")
    void updateLock(@Param("locked") boolean locked);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.locked = :isLocked WHERE u.id = :idUser")
    void lockUser(int idUser, boolean isLocked);

}
