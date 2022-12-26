package com.nnk.springboot.domain;

import org.springframework.beans.factory.annotation.Required;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "bid")
public class Bid {
	
    // TODO: Map columns in data table BIDLIST with corresponding java fields
	
	public Bid() {
	}
	
	public Bid(String account, String type, double bidQuantity) {
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name = "account")
	private String account;
	
	@NotBlank(message = "Type is mandatory")
	@Column(name = "type")
	private String type;
	
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
	@Column(name = "bid_quantity")
	private double bidQuantity;
	
	@Column(name = "ask_quantity")
	private double askQuantity;
	
	@Column(name = "bid")
	private double bid;
	
	@Column(name = "ask")
	private double ask;
	
	@Column(name = "benchmark")
	private String benchmark;
	
	@Column(name = "bid_list_date")
	private Timestamp bidListDate;
	
	@Column(name = "commentary")
	private String commentary;
	
	@Column(name = "security")
	private String security;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "trader")
	private String trader;
	
	@Column(name = "book")
	private String book;
	
	@Column(name = "creation_name")
	private String creationName;
	
	@Column(name = "creation_date")
	private Timestamp creationDate;
	
	@Column(name = "revision_name")
	private String revisionName;
	
	@Column(name = "revision_date")
	private Timestamp revisionDate;
	
	@Column(name = "deal_name")
	private String dealName;
	
	@Column(name = "deal_type")
	private String dealType;
	
	@Column(name = "source_list_id")
	private String sourceListId;
	
	@Column(name = "side")
	private String side;
}
