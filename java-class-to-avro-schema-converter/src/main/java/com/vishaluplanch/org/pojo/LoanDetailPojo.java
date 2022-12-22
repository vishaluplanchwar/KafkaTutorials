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

}
