package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.state.ApplicationState;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

public class VigenereCipherService {

  private VigenereCipher vigenereCipher;
  private final ApplicationState appState;
  private Scanner scanner;

  public VigenereCipherService(VigenereCipher vigenereCipher, Scanner scanner) {
    this.vigenereCipher = vigenereCipher;
    this.appState = new ApplicationState();
    this.scanner = scanner;
  }

  public void handleVigenereCipher(String message, int actionChoice) {
    System.out.print("Keyword?: ");
    String keyword = scanner.nextLine();

    String resultMessage;
    String action;

    if (actionChoice == 1) {
      resultMessage = vigenereCipher.encrypt(message, keyword);
      action = "Encrypted";
    } else {
      resultMessage = vigenereCipher.decrypt(message, keyword);
      action = "Decrypted";
    }

    appState.updateLastValues("Vigenere Cipher", action, "Keyword was " + keyword, message, resultMessage);
    ConsolePrinter.displayResult(message, resultMessage, action);
  }
}
