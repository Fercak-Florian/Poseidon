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
	
	public Rating() {
	}
	
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
	
	@Column(name = "moodys_rating")
	private String moodysRating;
	
	@Column(name = "sand_rating")
	private String sandRating;
	
	@Column(name = "fitch_rating")
	private String fitchRating;
	
	@Column(name = "order_number")
	private int orderNumber;
}
