/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 *
 * @author e.bentijani
 */
public class TestQuestionValidation {

    public static String ifInputStringEmptyDO(String nameInput, String input) {
        if (input.trim().isEmpty()) {
            return "* Champ " + nameInput + " obligatoire.";
        } else {
            return "";
        }
    }

    public static String validateStringOfNumber(String nameInput, String ch) {
        if (ch.trim().isEmpty()) {
            return ifInputStringEmptyDO(nameInput, ch);
        }
        if (!ch.matches("[0-9]+") || Integer.valueOf(ch) <= 0) {
            return nameInput + " invalide.";
        } else {
            return "";
        }
    }

    public static String validateStringOfFloat(String nameInput, String ch) {
        if (ch.trim().isEmpty()) {
            return ifInputStringEmptyDO(nameInput, ch);
        }
        if (!ch.matches("[0-9.]+")) {
            return nameInput + " invalide.";
        } else {
            Float d;
            try {
                d = Float.parseFloat(ch);
            } catch (NumberFormatException e) {
                return nameInput + " invalide.";

            }
            if (d > 0) {
                return "";
            } else {
                return nameInput + " invalide.";
            }

        }
    }

}
