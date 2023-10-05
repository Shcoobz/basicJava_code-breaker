package com.shcoobz.codebreaker.cipher;

/**
 * Implementation of the Vigenere Cipher encryption and decryption.
 */
public class VigenereCipher {

  private final CaesarCipher caesarCipher;

  /**
   * Constructor to initialize VigenereCipher with a CaesarCipher.
   * @param caesarCipher Instance of CaesarCipher to be used.
   */
  public VigenereCipher(CaesarCipher caesarCipher) {
    this.caesarCipher = caesarCipher;
  }

  /**
   * Default constructor creating a new CaesarCipher instance internally.
   */
  public VigenereCipher() {
    this.caesarCipher = new CaesarCipher();
  }

  /**
   * Constructor with a keyword.
   * Currently just delegates to the default constructor.
   * @param keyword The keyword for the Vigenere cipher.
   */
  public VigenereCipher(String keyword) {
    this();
  }

  /**
   * Process text by encrypting or decrypting it using Vigenere Cipher logic.
   * @param text The input text.
   * @param keyword The keyword for Vigenere Cipher.
   * @param isEncryption Flag to indicate if it's encryption or decryption.
   * @return Processed (encrypted/decrypted) text.
   */
  private String processText(String text, String keyword, boolean isEncryption) {
    StringBuilder processedText = new StringBuilder();
    int keywordIndex = 0;

    for (int i = 0; i < text.length(); i++) {
      char charToBeShifted = text.charAt(i);

      if (Character.isLetter(charToBeShifted)) {
        char keywordChar = keyword.charAt(keywordIndex % keyword.length());
        int shift = Character.isUpperCase(keywordChar) ? keywordChar - 'A' : keywordChar - 'a';

        if (isEncryption) {
          processedText.append(caesarCipher.encrypt(Character.toString(charToBeShifted), shift));
        } else {
          processedText.append(caesarCipher.decrypt(Character.toString(charToBeShifted), shift));
        }

        keywordIndex++;
      } else {
        processedText.append(charToBeShifted);
      }
    }

    return processedText.toString();
  }

  /**
   * Encrypt the given text using the Vigenere Cipher.
   * @param text The text to be encrypted.
   * @param keyword The keyword for encryption.
   * @return Encrypted text.
   */
  public String encrypt(String text, String keyword) {
    return processText(text, keyword, true);
  }

  /**
   * Decrypt the given text using the Vigenere Cipher.
   * @param text The text to be decrypted.
   * @param keyword The keyword for decryption.
   * @return Decrypted text.
   */
  public String decrypt(String text, String keyword) {
    return processText(text, keyword, false);
  }
}
