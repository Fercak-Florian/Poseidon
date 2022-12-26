package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
/*import javax.validation.constraints.NotNull;*/
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message = "Moodys Rating is mandatory")
	@Column(name = "moodys_rating")
	private String moodysRating;
	
	@NotBlank(message = "Sand Rating is mandatory")
	@Column(name = "sand_rating")
	private String sandRating;
	
	@NotBlank(message = "Fitch Rating is mandatory")
	@Column(name = "fitch_rating")
	private String fitchRating;
	
	@DecimalMin(value = "1", inclusive = true)
	@Column(name = "order_number")
	private int orderNumber;
}
