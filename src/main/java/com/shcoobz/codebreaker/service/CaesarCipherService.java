package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.state.ApplicationState;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

public class CaesarCipherService {

  private CaesarCipher caesarCipher;
  private final ApplicationState appState;
  private Scanner scanner;

  public CaesarCipherService(CaesarCipher caesarCipher, Scanner scanner) {
    this.caesarCipher = caesarCipher;
    this.appState = new ApplicationState();
    this.scanner = scanner;
  }

  public void handleCaesarCipher(String message, int actionChoice) {
    System.out.print("Shift value?: ");
    int shift = scanner.nextInt();
    scanner.nextLine();  // consume the newline

    String resultMessage;
    String action;

    if (actionChoice == 1) {
      resultMessage = caesarCipher.encrypt(message, shift);
      action = "Encrypted";
    } else {
      resultMessage = caesarCipher.decrypt(message, shift);
      action = "Decrypted";
    }

    appState.updateLastValues("Caesar Cipher", action, "Shift by " + shift, message, resultMessage);
    ConsolePrinter.displayResult(message, resultMessage, action);
  }

}
