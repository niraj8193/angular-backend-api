package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;

	public Country() {
		super();
	}

	public Country(Integer cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cid", unique = true, nullable = false)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Column(name = "cname", nullable = false, length = 45)
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}

}
