package com.vishaluplanch.org.pojo;

import com.vishaluplanch.org.vo.ApplicantDetail;
import com.vishaluplanch.org.vo.CollateralDetail;

import java.math.BigDecimal;

public class LoanDetailPojo {

    private Long loanId;
    private String bankName;
    private String branch;
    private String micrCode;
    private String branchAddress;
    private Long loanAccountNum;
    private BigDecimal requestedLoanAmount;
    private BigDecimal approvedLoanAmount;
    private String loanApprovalDate;

    private ApplicantDetail applicantDetail;
    private CollateralDetail collateralDetail;

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public void setLoanAccountNum(Long loanAccountNum) {
        this.loanAccountNum = loanAccountNum;
    }

    public void setRequestedLoanAmount(BigDecimal requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }

    public void setApprovedLoanAmount(BigDecimal approvedLoanAmount) {
        this.approvedLoanAmount = approvedLoanAmount;
    }

    public void setLoanApprovalDate(String loanApprovalDate) {
        this.loanApprovalDate = loanApprovalDate;
    }

    public void setApplicantDetail(ApplicantDetail applicantDetail) {
        this.applicantDetail = applicantDetail;
    }

    public void setCollateralDetail(CollateralDetail collateralDetail) {
        this.collateralDetail = collateralDetail;
    }

    public Long getLoanId() {
        return loanId;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranch() {
        return branch;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public Long getLoanAccountNum() {
        return loanAccountNum;
    }

    public BigDecimal getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public BigDecimal getApprovedLoanAmount() {
        return approvedLoanAmount;
    }

    public String getLoanApprovalDate() {
        return loanApprovalDate;
    }

    public ApplicantDetail getApplicantDetail() {
        return applicantDetail;
    }

    public CollateralDetail getCollateralDetail() {
        return collateralDetail;
    }
}
