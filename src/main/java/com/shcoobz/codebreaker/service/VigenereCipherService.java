package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

/**
 * The `VigenereCipherService` class provides services related to the Vigenere cipher,
 * including encryption and decryption of messages.
 */
public class VigenereCipherService {
  private VigenereCipher vigenereCipher;
  private Scanner scanner;

  /**
   * Initializes a new instance of the `VigenereCipherService` class with the provided
   * dependencies.
   *
   * @param vigenereCipher The VigenereCipher instance used for encryption and decryption.
   * @param scanner        The scanner for user input.
   */
  public VigenereCipherService(VigenereCipher vigenereCipher, Scanner scanner) {
    this.vigenereCipher = vigenereCipher;
    this.scanner = scanner;
  }

  /**
   * Handles encryption or decryption of a message using the Vigenere cipher.
   *
   * @param message      The message to be encrypted or decrypted.
   * @param actionChoice An integer representing the action choice (1 for encryption, 2 for decryption).
   * @return A `CipherResult` object containing the result message, modifier, and action.
   */
  public CipherResult handleVigenereCipher(String message, int actionChoice) {
    ConsolePrinter.promptForKeyword();
    String keyword = scanner.nextLine();

    String resultMessage = (actionChoice == 1)
        ? vigenereCipher.encrypt(message, keyword)
        : vigenereCipher.decrypt(message, keyword);

    String action = (actionChoice == 1) ? "Encrypted" : "Decrypted";
    String modifier = "Keyword: " + keyword;

    return new CipherResult(resultMessage, modifier, action);
  }
}
