package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Category {
	
	@Id
	private int cid;
	private String cname ,catDesc;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}		

}
