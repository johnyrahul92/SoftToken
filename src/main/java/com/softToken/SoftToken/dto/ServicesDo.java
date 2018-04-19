package com.softToken.SoftToken.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enet_services")
public class ServicesDo {

	@Id
	@Column(name = "SERVICEID")
	private int serviceId;

	@Column(name = "COMPANYID")
	private int companyId;

    @Column(name = "SERVICETYPENAME")
    private String serviceTypename;

	@Column(name = "EN_SERVICETYPENAME")
	private String serviceTypenameEN;

	@Column(name = "AR_SERVICETYPENAME")
	private String serviceTypenameAR;

	@Column(name = "SERVICESTATUS")
	private int serviceStatus;

    @Column(name = "PRODUCTLISTFLAG")
    private int prdouctListFlag;

    //
    @Column(name = "UNIQUEFIELD")
    private String uniqueField;

    @Column(name = "EN_UNIQUEFIELD")
    private String uniqueFieldEN;

    @Column(name = "AR_UNIQUEFIELD")
    private String uniqueFieldAR;

    @Column(name = "MIN_UNIQUEFIELD")
    private int uniqueFieldMin;

    @Column(name = "MAX_UNIQUEFIELD")
    private int uniqueFieldMax;

    @Column(name = "AMOUNTREADONLY")
    private int amountReadyOnly;

    @Column(name = "TYPE_PATTERN")
    private String typePattern;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "OLB_NOTXN_LIMIT")
    private int olbNoTxnLimit;

    @Column(name = "ENET_NOTXN_LIMIT")
    private int enetNoTxnLimit;

    public int getOlbNoTxnLimit() {
        return olbNoTxnLimit;
    }

    public void setOlbNoTxnLimit(int olbNoTxnLimit) {
        this.olbNoTxnLimit = olbNoTxnLimit;
    }

    public int getEnetNoTxnLimit() {
        return enetNoTxnLimit;
    }

    public void setEnetNoTxnLimit(int enetNoTxnLimit) {
        this.enetNoTxnLimit = enetNoTxnLimit;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTypePattern() {
        return typePattern;
    }

    public void setTypePattern(String typePattern) {
        this.typePattern = typePattern;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getServiceTypename() {
        return serviceTypename;
    }

    public void setServiceTypename(String serviceTypename) {
        this.serviceTypename = serviceTypename;
    }

    public String getServiceTypenameEN() {
        return serviceTypenameEN;
    }

    public void setServiceTypenameEN(String serviceTypenameEN) {
        this.serviceTypenameEN = serviceTypenameEN;
    }

    public String getServiceTypenameAR() {
        return serviceTypenameAR;
    }

    public void setServiceTypenameAR(String serviceTypenameAR) {
        this.serviceTypenameAR = serviceTypenameAR;
    }

    public int getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(int serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public int getPrdouctListFlag() {
        return prdouctListFlag;
    }

    public void setPrdouctListFlag(int prdouctListFlag) {
        this.prdouctListFlag = prdouctListFlag;
    }

    public String getUniqueField() {
        return uniqueField;
    }

    public void setUniqueField(String uniqueField) {
        this.uniqueField = uniqueField;
    }

    public String getUniqueFieldEN() {
        return uniqueFieldEN;
    }

    public void setUniqueFieldEN(String uniqueFieldEN) {
        this.uniqueFieldEN = uniqueFieldEN;
    }

    public String getUniqueFieldAR() {
        return uniqueFieldAR;
    }

    public void setUniqueFieldAR(String uniqueFieldAR) {
        this.uniqueFieldAR = uniqueFieldAR;
    }

    public int getUniqueFieldMin() {
        return uniqueFieldMin;
    }

    public void setUniqueFieldMin(int uniqueFieldMin) {
        this.uniqueFieldMin = uniqueFieldMin;
    }

    public int getUniqueFieldMax() {
        return uniqueFieldMax;
    }

    public void setUniqueFieldMax(int uniqueFieldMax) {
        this.uniqueFieldMax = uniqueFieldMax;
    }

    public int getAmountReadyOnly() {
        return amountReadyOnly;
    }

    public void setAmountReadyOnly(int amountReadyOnly) {
        this.amountReadyOnly = amountReadyOnly;
    }
}
