package com.shcoobz.codebreaker.alphabetviewer.viewers;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.alphabetviewer.modifiers.ModifierType;

import java.util.Scanner;

/**
 * Provides functionality for viewing the shifted alphabet for the Caesar cipher.
 * The Caesar cipher shifts each letter in the alphabet by a specified number.
 */
public class CaesarCipherAlphabetViewer extends CipherAlphabetViewer {
  private final CaesarCipher caesarCipher = new CaesarCipher();

  @Override
  protected String getShiftedAlphabet(final String shiftValue, final boolean isUppercase) {
    int shift = Integer.parseInt(shiftValue);  // Safe to parse since we've already validated
    return generateShiftedAlphabet(shift, isUppercase);
  }

  /**
   * Generates and returns the shifted alphabet for the provided shift and case.
   *
   * @param shift       the number of positions to shift the alphabet
   * @param isUppercase if true, use the uppercase alphabet; otherwise, use the lowercase alphabet
   * @return the shifted alphabet string
   */
  private String generateShiftedAlphabet(final int shift, final boolean isUppercase) {
    char[] original = isUppercase ? UPPERCASE_ALPHABET.toCharArray() : LOWERCASE_ALPHABET.toCharArray();
    StringBuilder shifted = new StringBuilder();

    for (char character : original) {
      shifted.append(caesarCipher.shiftCharacter(character, shift, getStartChar(isUppercase), getEndChar(isUppercase)));
    }

    return shifted.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean validInput = false;
    String shiftValue = null;

    while (!validInput) {
      System.out.print("Enter shift value: ");
      shiftValue = scanner.nextLine();

      if (isInteger(shiftValue)) {
        validInput = true;
      } else {
        System.out.println("Invalid input. Please enter a number for the shift value.");
      }
    }

    CaesarCipherAlphabetViewer viewer = new CaesarCipherAlphabetViewer();
    viewer.displayShiftedAlphabet(shiftValue, ModifierType.SHIFT);
  }

  /**
   * Checks if a string can be parsed as an integer.
   *
   * @param value the string to check
   * @return true if the string can be parsed as an integer, false otherwise
   */
  private static boolean isInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
