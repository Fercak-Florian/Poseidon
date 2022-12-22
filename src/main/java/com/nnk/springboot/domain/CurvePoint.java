package com.nnk.springboot.domain;

/*import org.hibernate.validator.constraints.Length;*/

import lombok.Data;

import javax.persistence.*;
/*import javax.validation.constraints.NotBlank;*/
/*import javax.validation.constraints.NotNull;*/
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "curve_point")
public class CurvePoint {
	
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
	public CurvePoint(int curveId, double term,  double value) {
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "curve_id")
	private int curveId;
	
	@Column(name = "as_of_date")
	private Timestamp asOfDate;
	
	@Column(name = "term")
	private double term;
	
	@Column(name = "value")
	private double value;
	
	@Column(name = "creation_date")
	private Timestamp creationDate;
}
