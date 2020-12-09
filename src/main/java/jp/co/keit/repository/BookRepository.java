package jp.co.keit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.keit.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByBookNameLike(String name);
	
	Book findByBookName(String name);
}
