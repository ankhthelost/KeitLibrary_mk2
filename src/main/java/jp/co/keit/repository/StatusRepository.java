package jp.co.keit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.keit.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
