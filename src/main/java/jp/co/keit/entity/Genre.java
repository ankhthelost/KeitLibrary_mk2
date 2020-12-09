package jp.co.keit.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_genre_gen")
	@SequenceGenerator(name = "seq_genre_gen", sequenceName = "seq_genre", allocationSize = 1)
	private Integer genreId;
	
	@Column
	private String genreName;
	
	@OneToMany(mappedBy = "genre")
	private List<GenresBooks> GenresbooksList;
	
	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<GenresBooks> getGenresbooksList() {
		return GenresbooksList;
	}

	public void setGenresbooksList(List<GenresBooks> genresbooksList) {
		GenresbooksList = genresbooksList;
	}
	
	
}
