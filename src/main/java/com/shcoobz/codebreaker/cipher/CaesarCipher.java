package com.shcoobz.codebreaker.cipher;

/**
 * Implements the Caesar Cipher encryption and decryption mechanism.
 * The Caesar Cipher is a type of substitution cipher where each letter in the plain text
 * is shifted a certain number of places down or up the alphabet.
 */
public class CaesarCipher {

  /**
   * Shifts a given character by a specified number of positions.
   *
   * @param charToBeShifted         The character to be shifted.
   * @param numberOfPositionToShift The number of positions to shift the character.
   * @param lowerBoundary           The lower boundary of the character set.
   * @param upperBoundary           The upper boundary of the character set.
   * @return The shifted character.
   */
  public char shiftCharacter(char charToBeShifted, int numberOfPositionToShift, char lowerBoundary, char upperBoundary) {
    int shifted = charToBeShifted + numberOfPositionToShift;

    if (shifted < lowerBoundary) {
      shifted = upperBoundary - (lowerBoundary - shifted) + 1;
    } else if (shifted > upperBoundary) {
      shifted = lowerBoundary + (shifted - upperBoundary) - 1;
    }

    return (char) shifted;
  }

  /**
   * Encrypts a plain text using the Caesar Cipher.
   *
   * @param plainText The plain text to be encrypted.
   * @param shift     The number of positions to shift each character.
   * @return The encrypted text.
   */
  public String encrypt(String plainText, int shift) {
    StringBuilder encryptedText = new StringBuilder();
    for (char charToBeShifted : plainText.toCharArray()) {
      if (Character.isUpperCase(charToBeShifted)) {
        encryptedText.append(shiftCharacter(charToBeShifted, shift, 'A', 'Z'));
      } else if (Character.isLowerCase(charToBeShifted)) {
        encryptedText.append(shiftCharacter(charToBeShifted, shift, 'a', 'z'));
      } else {
        encryptedText.append(charToBeShifted);
      }
    }
    return encryptedText.toString();
  }

  /**
   * Decrypts a cipher text using the Caesar Cipher.
   *
   * @param cipherText The cipher text to be decrypted.
   * @param shift      The number of positions to reverse shift each character.
   * @return The decrypted text.
   */
  public String decrypt(String cipherText, int shift) {
    return encrypt(cipherText, -shift);
  }
}
