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
@Table(name="genres_books")
public class GenresBooks {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_genres_books_gen")
	@SequenceGenerator(name = "seq_genres_books_gen", sequenceName = "seq_genres_books", allocationSize = 1)
	private Integer genresBooksId;
	
	@ManyToOne
	@JoinColumn(name = "genre_id", referencedColumnName = "genreId")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "bookId")
	private Book book;

	public Integer getGenresBooksId() {
		return genresBooksId;
	}

	public void setGenresBooksId(Integer genresBooksId) {
		this.genresBooksId = genresBooksId;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
