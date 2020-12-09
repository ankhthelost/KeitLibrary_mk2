package jp.co.keit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_publisher_gen")
	@SequenceGenerator(name = "seq_publisher_gen", sequenceName = "seq_publisher", allocationSize = 1)
	private Integer publisherId;
	
	@Column
	private String publisherName;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	
}
