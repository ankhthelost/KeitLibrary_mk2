package jp.co.keit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.keit.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
