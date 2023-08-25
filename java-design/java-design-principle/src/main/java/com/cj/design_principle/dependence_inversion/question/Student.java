package com.cj.design_principle.dependence_inversion.question;

public class Student {
    public void payForScanCode(ScanCodePay scanCodePay) {
        scanCodePay.payOff();
    }
    public void payForSchoolCard(SchoolCardPay schoolCardPay) {
        schoolCardPay.payOff();
    }
}
