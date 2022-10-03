package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException();
        }
        char[] pass = password.toCharArray();

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password must be no less than 8 symbols and no longer than 32!");
        }

        caseValidate(pass);
        digitCheck(pass);
        symbolCheck(pass);
        combinationCheck(password);
        return password;
    }

    private static boolean caseValidate(char[] pass) {
        for (int i = 1; i < pass.length; i++) {
            if (Character.isLetter(pass[i])
                    && isOppositeOfFirst(pass[0], pass[i])) {
                return true;
            }
        }
        throw new IllegalArgumentException("Password must contain both lower and upper case symbols");
    }

    private static boolean digitCheck(char[] pass) {
        for (char c : pass) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Password must contain at least one digit!");
    }

    private static boolean symbolCheck(char[] pass) {
        for (char c : pass) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        throw new IllegalArgumentException("Password must contain at least one special symbol");
    }

    private static void combinationCheck(String pass) {
        String[] combs = {"qwerty", "12345", "password", "admin", "user"};
        String comparisonPass = pass.toUpperCase();
        for (String comb : combs) {
                if (comparisonPass.contains(comb.toUpperCase())) {
                    throw new IllegalArgumentException("Password includes " + comb + " sequence");
                }
        }
    }

    private static boolean isOppositeOfFirst(char chFirst, char charToCheck) {
        if (Character.isLowerCase(chFirst) && Character.isUpperCase(charToCheck)) {
            return true;
        } else {
            return Character.isUpperCase(chFirst) && Character.isLowerCase(charToCheck);
        }
    }

}