package com.shcoobz.codebreaker.alphabetviewer.viewers;

import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.alphabetviewer.modifiers.ModifierType;

import java.util.Scanner;

/**
 * Provides functionality for viewing the shifted alphabet for the Vigenere cipher.
 * The Vigenere cipher shifts each letter in the alphabet using a keyword.
 */
public class VigenereCipherAlphabetViewer extends CipherAlphabetViewer {

  private final VigenereCipher vigenereCipher;

  /**
   * Constructor for the VigenereCipherAlphabetViewer that accepts a keyword.
   * Initializes the VigenereCipher with the given keyword.
   */
  public VigenereCipherAlphabetViewer(String keyword) {
    this.vigenereCipher = new VigenereCipher(keyword);
  }

  /**
   * Generates and returns the shifted alphabet based on a keyword and the specified case.
   *
   * @param keyword     The keyword to shift by.
   * @param isUppercase Flag indicating if the shifted alphabet should be uppercase or lowercase.
   * @return The shifted alphabet string.
   */
  @Override
  protected String getShiftedAlphabet(String keyword, boolean isUppercase) {
    if (keyword == null || keyword.trim().isEmpty()) {
      throw new IllegalArgumentException("Keyword cannot be null or empty.");
    }

    String original = isUppercase ? UPPERCASE_ALPHABET : LOWERCASE_ALPHABET;
    StringBuilder shifted = new StringBuilder();

    for (int i = 0; i < original.length(); i++) {
      char originalChar = original.charAt(i);
      char shiftedChar = vigenereCipher.encrypt(Character.toString(originalChar), keyword).charAt(0);
      shifted.append(shiftedChar);
    }

    return shifted.toString();
  }

  /**
   * Main method for the VigenereCipherAlphabetViewer. Interactively requests a keyword from the user
   * and displays the shifted alphabet based on the Vigenere cipher with the given keyword.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter keyword for Vigenere cipher: ");
    String keyword = scanner.nextLine().trim();

    while (keyword.isEmpty()) {
      System.out.println("Invalid keyword. Please provide a non-empty keyword.");
      System.out.print("Enter keyword for Vigenere cipher: ");
      keyword = scanner.nextLine().trim();
    }

    VigenereCipherAlphabetViewer viewer = new VigenereCipherAlphabetViewer(keyword);
    viewer.displayShiftedAlphabet(keyword, ModifierType.KEYWORD);
  }
}
