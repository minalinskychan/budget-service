package com.gin.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    public static void main(String[] args) {

    }

    public static final String REGEX_ALPHABET = "^[a-zA-Z]*$";
    public static final String REGEX_NUMERIC = "^[0-9]*$";
    public static final String REGEX_ALPHANUMERIC = "^[a-zA-Z0-9_]*$";
    public static final String REGEX_ALPHANUMERIC_SPACE = "^[a-zA-Z0-9_ ]*$";
    public static final String REGEX_ALPHANUMERIC_SPACE_SPECIAL_CHAR = "^[a-zA-Z0-9_ .!@#$%^&*()_+-=]*$";
    private static final String REGEX_REPEAT_DIGIT = "^([0-9])\\1*$";
    private static final String REGEX_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static boolean isPhoneNumberFormatValid(String phoneNumber) {
        return !isInvalidLength(phoneNumber, 4, 15) && isNumeric(phoneNumber);
    }

    public static boolean isValidSmsDestination(String phoneNumber) {
        return isNumeric(phoneNumber);
    }

    public static boolean isValidSmsMessageLength(String message, Integer maxLength) {
        return message.length() <= maxLength;
    }

    public static boolean isInvalidLength(String value, int minLength, int maxLength) {
        return value.length() < minLength || value.length() > maxLength;
    }

    public static boolean isInvalidLength(String value, int fixedLength) {
        return value.length() != fixedLength;
    }

    public static boolean isLengthGreaterThan(String value, int maxLength) {
        return value.length() > maxLength;
    }

    public static boolean isInvalidNumeric(String value) {
        return !isNumeric(value.trim());
    }

    public static boolean isInvalidSelected(String value) {
        return value == null || value.trim().equals("-1") || value.trim().equals("-1.0") || value.trim().equals("");
    }

    public static boolean isEmptyString(String value) {
        return value == null || value.trim().isEmpty();
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmptyList(List list) {
        return list == null || list.size() == 0;
    }

    private static boolean isInvalidFormat(String value, String expression) {
        if (value.length() == 0) {
            return true;
        }

        Pattern pattern;
        pattern = Pattern.compile(expression, 2);
        Matcher matcher = pattern.matcher(value);
        return !matcher.matches();
    }

    public static boolean isEmailAddressValid(String email) {
        String[] mailAddress = email.split(";");

        for (String address : mailAddress) {
            if (isInvalidFormat(address, REGEX_EMAIL)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRepeatDigit(String value) {
        return !isInvalidFormat(value, REGEX_REPEAT_DIGIT);
    }

    public static boolean isInvalidAmount(Object oValue, double minAmount, double maxAmount) {
        double value;
        try {
            value = (Double) oValue;
        } catch (Exception e) {
            return true;
        }
        if (value == 0) {
            return true;
        }
        return value < minAmount || value > maxAmount;
    }

    private static boolean isNumeric(String number) {
        boolean isValid = false;

//        String expression = "^[-+]?[0-9]*\\.?[0-9]+$";
        String expression = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(number);

        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

//    public static boolean isInvalidDate(String date) {
//        try {
//            Constants.d2.parse(date);
//            return false;
//        } catch (ParseException e) {
//            return true;
//        }
//    }

    public static boolean isInvalidRangeNumeric(int number, int min, int max) {
        return number < min || number > max;
    }

    //    public static boolean isDateAfter(String date1, String date2) {
//        try {
//            Date d1, d2;
//            if (date1.equals(Constants.NOW)) {
//                d1 = new Date();
//            } else {
//                d1 = Constants.d2.parse(date1);
//            }
//
//            if (date2.equals(Constants.NOW)) {
//                d2 = new Date();
//            } else {
//                d2 = Constants.d2.parse(date2);
//            }
//
//            return d1.after(d2);
//        } catch (ParseException e) {
//            return false;
//        }
//    }

    /**
     * Is date1 after now+days
     *
     * @param date1 date
     * @param days  days
     * @return return checker value
     */
    public static boolean isDateAfterDays(String date1, int days) {
//        try {
//            Date d1 = Constants.d2.parse(date1);
//            Date d2 = new Date();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(d2);
//            cal.add(Calendar.DATE, days);
//            if (d1.after(cal.getTime())) {
//                return true;
//            }
//            return false;
//        } catch (ParseException e) {
        return false;
//        }
    }

    /**
     * Is date1+minutes after now
     *
     * @param date1   date
     * @param minutes minutes
     * @return bolean value
     */
    public static boolean isDateAfterMinutes(Date date1, int minutes) {
        Date d2 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.MINUTE, minutes);
        System.out.println("Date Grace Period : "+Constants.sdf1.format(cal.getTime()));
        return d2.after(cal.getTime());
    }
    
    /**
     * Is date1+seconds after now
     *
     * @param date1   date
     * @param seconds seconds
     * @return bolean value
     */
    public static boolean isDateAfterSeconds(Date date1, int seconds) {
        Date d2 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        cal.add(Calendar.SECOND, seconds);
        return d2.after(cal.getTime());
    }

    /**
     * is range of date1 to date2 is more than days
     *
     * @param date1 start date
     * @param date2 end date
     * @param days  days
     * @return boolean value
     */
    public static boolean isDateRangeInvalid(String date1, String date2, int days) {
//        try {
//            Date d1 = Constants.d2.parse(date1);
//            Date d2 = Constants.d2.parse(date2);
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(d1);
//            cal.add(Calendar.DATE, days);
//            return d2.after(cal.getTime());
//        } catch (ParseException e) {
        return false;
//        }
    }

    public static boolean isRepeatDigit(String value, int minCounter) {
        int number = 0, currNumber, counter = 0;

        if (value.length() < minCounter)
            return false;
        for (int i = 0; i < value.length(); i++) {
            currNumber = value.charAt(i);
            if (i == 0) {
                number = currNumber;
            } else {
                if (number == currNumber) {
                    counter++;
                    if (counter >= minCounter - 1) {
                        return true;
                    }
                } else {
                    number = currNumber;
                    counter = 0;
                }
            }
        }
        return false;
    }

    public static boolean isIncrementDigit(String value, int minCounter) {
        int first, second = 0, counter = 0;
        boolean increment = false;
        boolean undefinedType = true;

        if (value.length() <= minCounter)
            return false;

        for (int i = 0; i < value.length(); i++) {
            if (i >= 1 && undefinedType) {
                second = value.charAt(i);
                first = value.charAt(i - 1);
                if (second - 1 == first) {
                    increment = true;
                    counter++;
                    undefinedType = false;
                } else if (second + 1 == first) {
                    increment = false;
                    counter++;
                    undefinedType = false;
                }
            } else if (i > 1) {
                if (increment) {
                    second += 1;
                    int val = value.charAt(i);
                    if (second != val) {
                        undefinedType = true;
                        counter = 0;
                    } else {
                        counter++;
                        if (counter >= minCounter - 1) {
                            return true;
                        }
                    }
                } else {
                    second -= 1;
                    int val = value.charAt(i);
                    if (second != val) {
                        undefinedType = true;
                        counter = 0;
                    } else {
                        counter++;
                        if (counter >= minCounter - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isIncrementDigit(String value) {
        int first, second = 0;
        boolean increment = false;

        if (value.length() <= 1)
            return false;

        for (int i = 0; i < value.length(); i++) {
            if (i == 1) {
                second = value.charAt(i);
                first = value.charAt(i - 1);
                if (second - 1 == first) {
                    increment = true;
                } else if (second + 1 == first) {
                    increment = false;
                } else {
                    return false;
                }
            } else if (i > 1) {
                if (increment) {
                    second += 1;
                    int val = value.charAt(i);
                    if (second != val) {
                        return false;
                    }
                } else {
                    second -= 1;
                    int val = value.charAt(i);
                    if (second != val) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isStringEqual(String... strings) {
        String temp = strings[0];

        for (String string : strings) {
            if (!temp.toUpperCase().equals(string.toUpperCase())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check paid notif type
     *
     * @param validate validator
     * @param data validator
     * @return checker result
     */
    public static boolean notifPaidValidation(String validate, String... data) {
        if (validate == null || validate.isEmpty()) {
            return false;
        }

        String[] list = validate.toUpperCase().split(";");

        for (String datum : data) {
            if (Arrays.asList(list).contains(datum.toUpperCase())) {
                return true;
            }
        }

        return false;
    }
}
