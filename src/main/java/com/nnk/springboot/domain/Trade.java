package com.nnk.springboot.domain;

import javax.persistence.*;
/*import javax.validation.constraints.NotBlank;*/

import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "trade")
public class Trade {
	
    // TODO: Map columns in data table TRADE with corresponding java fields
	public Trade(String account, String type) {
		this.account = account;
		this.type = type;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int tradeId;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "buy_quantity")
	private double buyQuantity;
	
	@Column(name = "sell_quantity")
	private double sellQuantity;
	
	@Column(name = "buy_price")
	private double buyPrice;
	
	@Column(name = "sell_price")
	private double sellPrice;
	
	@Column(name = "trade_date")
	private Timestamp tradeDate;
	
	@Column(name = "security")
	private String security;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "trader")
	private String trader;
	
	@Column(name = "benchmark")
	private String benchmark;
	
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
