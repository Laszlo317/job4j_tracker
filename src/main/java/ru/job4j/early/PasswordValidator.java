package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException();
        }
        char[] pass = password.toCharArray();

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException();
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
        throw new IllegalArgumentException();
    }

    private static boolean digitCheck(char[] pass) {
        for (char c : pass) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean symbolCheck(char[] pass) {
        for (char c : pass) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private static void combinationCheck(String pass) {
        String[] combs = {"qwerty", "12345", "admin", "user"};
        for (String comb : combs) {
            for (int j = 0; j < pass.length() - comb.length() + 1; j++) {
                String compareStr = pass.substring(j, j + comb.length());
                if (compareStr.equalsIgnoreCase(comb)) {
                    throw new IllegalArgumentException();
                }
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