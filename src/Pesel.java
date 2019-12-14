class Pesel {
    static String checkPesel(String pesel) {
        if (!isLengthCorrect(pesel)) return "Pesel length is incorrect";
        if (!isCharactersCorrect(pesel)) return "Pesel characters are incorrect";
        if (!isCheckDigitCorrect(pesel)) return "Pesel check digit is incorrect";
        return pesel;
    }

    private static boolean isLengthCorrect(String pesel) {
        return pesel.length() == 11;
    }

    private static boolean isCharactersCorrect(String pesel) {
        int testNumber;
        try {
            for (int i = 0; i < pesel.length(); i++) {
                testNumber = Integer.parseInt(pesel.substring(i, i + 1));
            }
        } catch (NumberFormatException exc) {
            return false;
        }
        return true;
    }

    private static boolean isCheckDigitCorrect(String pesel) {
        int checkDigit = 0;
        int lastDigit = Integer.parseInt(pesel.substring(10, 11));
        int[] validators = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        for (int i = 0; i < validators.length; i++) {
            checkDigit += (Integer.parseInt(pesel.substring(i, i + 1)) * validators[i]);
        }
        checkDigit %= 10;
        if(checkDigit != 0) checkDigit = 10 - checkDigit;
        return checkDigit == lastDigit;
    }
}