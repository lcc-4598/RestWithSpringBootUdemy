package br.com.erudio.validation;

public class MathValidator {

    public Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;
        String number = strNumber.replace(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNotZero (String strNumber) {
        if (isNumeric(strNumber)) {
            return convertToDouble(strNumber) != 0D;
        }
        return false;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
