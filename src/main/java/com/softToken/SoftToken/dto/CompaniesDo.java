package com.softToken.SoftToken.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enet_companies")
public class CompaniesDo  implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -5706762149887756793L;

	@Id
	@Column(name = "COMPANYID")
	private int companyId;

	@Column(name = "EN_COMPANYNAME")
	private String companyNameEN;

	@Column(name = "AR_COMPANYNAME")
	private String companyNameAR;

	@Column(name = "CATEGORYID")
	private int categoryId;

	@Column(name = "COMPANYSTATUS")
    private int companyStatus;

    @Column(name = "ORDER_ID")
    private int orderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



	/*private CategoriesDo categoriesDo;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORYID", nullable=false)
	public CategoriesDo getCategoriesDo() {
		return categoriesDo;
	}

	public void setCategoriesDo(CategoriesDo categoriesDo) {
		this.categoriesDo = categoriesDo;
	}*/

	public String getCompanyNameEN() {
		return companyNameEN;
	}

	public void setCompanyNameEN(String companyNameEN) {
		this.companyNameEN = companyNameEN;
	}

	public String getCompanyNameAR() {
		return companyNameAR;
	}

	public void setCompanyNameAR(String companyNameAR) {
		this.companyNameAR = companyNameAR;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(int companyStatus) {
		this.companyStatus = companyStatus;
	}




}
