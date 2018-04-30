package com.softToken.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enet_categories")
public class CategoriesDo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5770618078734175016L;

	@Id
	@Column(name = "CATEGORYID")
	private int categoryId;

	@Column(name = "EN_CATEGORYNAME")
	private String categoryNameEN;

	@Column(name = "AR_CATEGORYNAME")
	private String categoryNameAR;

	@Column(name = "CATEGORIESSTATUS")
	private int categoryStatus;

    @Column(name = "ORDER_ID")
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryNameEN() {
		return categoryNameEN;
	}

	public void setCategoryNameEN(String categoryNameEN) {
		this.categoryNameEN = categoryNameEN;
	}

	public String getCategoryNameAR() {
		return categoryNameAR;
	}

	public void setCategoryNameAR(String categoryNameAR) {
		this.categoryNameAR = categoryNameAR;
	}

	public int getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}


	


}
