package jp.co.keit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="authors_books")
public class AuthorsBooks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_authors_books_gen")
	@SequenceGenerator(name = "seq_authors_books_gen", sequenceName = "seq_authors_books", allocationSize = 1)
	private Integer authorsBooksId;
	
	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "authorId")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "bookId")
	private Book book;

	public Integer getAuthorsBooksId() {
		return authorsBooksId;
	}

	public void setAuthorsBooksId(Integer authorsBooksId) {
		this.authorsBooksId = authorsBooksId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
