package com.shcoobz.codebreaker.service;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

public class CaesarCipherService {
  private CaesarCipher caesarCipher;
  private Scanner scanner;

  public CaesarCipherService(CaesarCipher caesarCipher, Scanner scanner) {
    this.caesarCipher = caesarCipher;
    this.scanner = scanner;
  }

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
