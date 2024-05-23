package com.vishaluplanch.kafka.util;

import com.vishaluplanch.kafka.avro.schema.AccountDetail;

import java.util.Random;

public class BankUtils {

    private static Random r = new Random();

    public static int generateBankAccountNumber() {
        return r.ints(1000, 1000000).findFirst().getAsInt();
    }

    public static String generateBranchCode() {
        return "ABC000" + r.ints(100, 1000).findFirst().getAsInt();
    }

    public static String generateMicrCode() {
        return "MICR000" + r.ints(100, 1000).findFirst().getAsInt();
    }

    public static AccountDetail generateAbcBankAccount(Long customerUniqueIdentification, int index) {
        return AccountDetail.newBuilder().setAccountNumber(generateBankAccountNumber())
                .setCustomerUniqueIdentification(customerUniqueIdentification)
                .setAccountHolderName("ABC CUSTOMER-" + index)
                .setAddress("Sector-11, Navi Mumbai")
                .setBranchCode(generateBranchCode())
                .setMicrCode(generateMicrCode())
                .setCurrentBalance(150.00).build();
    }

    public static AccountDetail generateXyzBankAccount(Long customerUniqueIdentification, int index) {
        return AccountDetail.newBuilder().setAccountNumber(generateBankAccountNumber())
                .setCustomerUniqueIdentification(customerUniqueIdentification)
                .setAccountHolderName("XYZ CUSTOMER-" + index)
                .setAddress("Sector-5, Navi Mumbai")
                .setBranchCode(generateBranchCode())
                .setMicrCode(generateMicrCode())
                .setCurrentBalance(300.00).build();
    }
}
