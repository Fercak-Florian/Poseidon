package com.nnk.springboot.domain;

import javax.persistence.*;
/*import javax.validation.constraints.NotBlank;*/
/*import javax.validation.constraints.NotNull;*/

import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rating")
public class Rating {
	
    // TODO: Map columns in data table RATING with corresponding java fields
	public Rating(String moodysRating, String sandRating, String fitchRating, int orderNumber) {
		this.moodysRating = moodysRating;
		this.sandRating = sandRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "moodysRating")
	private String moodysRating;
	
	@Column(name = "sandRating")
	private String sandRating;
	
	@Column(name = "fitchRating")
	private String fitchRating;
	
	@Column(name = "orderNumber")
	private int orderNumber;
}
