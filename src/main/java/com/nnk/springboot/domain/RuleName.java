package com.nnk.springboot.domain;

import javax.persistence.*;
/*import javax.validation.constraints.NotBlank;*/

import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rule_name")
public class RuleName {
	
    // TODO: Map columns in data table RULENAME with corresponding java fields
	
	public RuleName() {
	}
	
	public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "json")
	private String json;
	
	@Column(name = "template")
	private String template;
	
	@Column(name = "sql_str")
	private String sqlStr;
	
	@Column(name = "sql_part")
	private String sqlPart;
}
