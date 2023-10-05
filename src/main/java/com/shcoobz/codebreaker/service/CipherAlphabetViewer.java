package com.shcoobz.codebreaker.service;

/**
 * An abstract viewer to display cipher alphabets.
 */
public abstract class CipherAlphabetViewer {
  public static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  private static final String HEADER_FORMAT = "%-20s %-20s%n";
  private static final String ALPHABET_MAPPING_FORMAT = " %-20s %-20s%n";
  private final char[] originalUppercase = UPPERCASE_ALPHABET.toCharArray();
  private final char[] originalLowercase = LOWERCASE_ALPHABET.toCharArray();

  /**
   * Gets the shifted alphabet based on a keyword.
   *
   * @param keyword     The keyword to shift by.
   * @param isUppercase Flag indicating if it's uppercase or not.
   * @return The shifted alphabet string.
   */
  protected abstract String getShiftedAlphabet(String keyword, boolean isUppercase);

  /**
   * Retrieves the starting character based on the case.
   *
   * @param isUppercase Flag indicating if the starting character should be uppercase or lowercase.
   * @return The starting character.
   */
  protected char getStartChar(boolean isUppercase) {
    return isUppercase ? 'A' : 'a';
  }

  /**
   * Retrieves the ending character based on the case.
   *
   * @param isUppercase Flag indicating if the ending character should be uppercase or lowercase.
   * @return The ending character.
   */
  protected char getEndChar(boolean isUppercase) {
    return isUppercase ? 'Z' : 'z';
  }

  /**
   * Prints the header for the alphabet display.
   */
  private void printHeaders() {
    System.out.printf(HEADER_FORMAT, "Uppercase", "Lowercase");
    System.out.printf(HEADER_FORMAT, "---------", "---------");
  }

  /**
   * Displays the shifted alphabet to the console.
   *
   * @param keyword      The keyword used for shifting.
   * @param modifierType The type of the modifier.
   */
  public void displayShiftedAlphabet(String keyword, ModifierType modifierType) {
    char[] shiftedUppercase = getShiftedAlphabet(keyword, true).toCharArray();
    char[] shiftedLowercase = getShiftedAlphabet(keyword, false).toCharArray();

    System.out.println("\nCipher " + modifierType.name() + ": " + keyword + "\n");

    printHeaders();

    for (int i = 0; i < originalUppercase.length; i++) {
      System.out.printf(ALPHABET_MAPPING_FORMAT,
          originalUppercase[i] + " -> " + shiftedUppercase[i],
          originalLowercase[i] + " -> " + shiftedLowercase[i]);
    }
  }
}
