package jp.co.keit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.keit.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE mailAddress = :mailAddress AND password = ORA_HASH(:password) AND deleteFlg = 0")
	User findByMailAddressAndPassword(String mailAddress, String password);
}
