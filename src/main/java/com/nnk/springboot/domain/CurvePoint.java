package com.nnk.springboot.domain;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
/*import javax.validation.constraints.NotBlank;*/
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "curve_point")
public class CurvePoint {
	
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
	
	public CurvePoint() {
	}
	
	public CurvePoint(int curveId, double term,  double value) {
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@DecimalMin(value = "1", inclusive = true)
    @Digits(integer=3, fraction=0)
	@NotNull(message = "curveId is mandatory")
	@Column(name = "curve_id")
	private int curveId;
	
	@Column(name = "as_of_date")
	private Timestamp asOfDate;
	
	@DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer=3, fraction=2)
	@NotNull(message = "Term is mandatory")
	@Column(name = "term")
	private double term;
	
	@DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer=3, fraction=2)
	@NotNull(message = "Value is mandatory")
	@Column(name = "value")
	private double value;
	
	@Column(name = "creation_date")
	private Timestamp creationDate;
}
