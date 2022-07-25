package com.example.hw_5.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class PhoneUtil {

    private final static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    public static String reformatRuTelephone(String phone) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(phone, Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name());
        boolean validNumber = phoneNumberUtil.isValidNumberForRegion(phoneNumber, "RU");
        if(!validNumber) {
            throw new IllegalArgumentException("number is not russian");
        }
        return phoneNumberUtil.format(phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
    }
}
