package com.vishaluplanch.org.vo;

import java.math.BigDecimal;

public class CollateralDetail {
    private Long collateralId;
    private String collateralType;
    private String collateralDesc;
    private BigDecimal collateralValue;

    public Long getCollateralId() {
        return collateralId;
    }

    public void setCollateralId(Long collateralId) {
        this.collateralId = collateralId;
    }

    public String getCollateralType() {
        return collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public String getCollateralDesc() {
        return collateralDesc;
    }

    public void setCollateralDesc(String collateralDesc) {
        this.collateralDesc = collateralDesc;
    }

    public BigDecimal getCollateralValue() {
        return collateralValue;
    }

    public void setCollateralValue(BigDecimal collateralValue) {
        this.collateralValue = collateralValue;
    }
}
