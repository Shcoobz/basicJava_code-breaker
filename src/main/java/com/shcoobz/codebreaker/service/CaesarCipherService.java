package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

/**
 * The `CaesarCipherService` class provides services related to the Caesar cipher,
 * including encryption and decryption of messages.
 */
public class CaesarCipherService {
  private CaesarCipher caesarCipher;
  private Scanner scanner;

  /**
   * Initializes a new instance of the `CaesarCipherService` class with the provided
   * dependencies.
   *
   * @param caesarCipher The CaesarCipher instance used for encryption and decryption.
   * @param scanner      The scanner for user input.
   */
  public CaesarCipherService(CaesarCipher caesarCipher, Scanner scanner) {
    this.caesarCipher = caesarCipher;
    this.scanner = scanner;
  }

  /**
   * Handles encryption or decryption of a message using the Caesar cipher.
   *
   * @param message      The message to be encrypted or decrypted.
   * @param actionChoice An integer representing the action choice (1 for encryption, 2 for decryption).
   * @return A `CipherResult` object containing the result message, modifier, and action.
   */
  public CipherResult handleCaesarCipher(String message, int actionChoice) {
    ConsolePrinter.promptForShiftValue();
    int shift = scanner.nextInt();
    scanner.nextLine();  // consume the newline

    String resultMessage = (actionChoice == 1)
        ? caesarCipher.encrypt(message, shift)
        : caesarCipher.decrypt(message, shift);

    String action = (actionChoice == 1) ? "Encrypted" : "Decrypted";
    String modifier = "Shift by: " + shift;

    return new CipherResult(resultMessage, modifier, action);
  }
}
