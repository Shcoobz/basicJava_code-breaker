package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

public class VigenereCipherService {
  private VigenereCipher vigenereCipher;
  private Scanner scanner;

  public VigenereCipherService(VigenereCipher vigenereCipher, Scanner scanner) {
    this.vigenereCipher = vigenereCipher;
    this.scanner = scanner;
  }

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
