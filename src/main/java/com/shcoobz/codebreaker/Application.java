package com.shcoobz.codebreaker;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.initialization.StartupManager;
import com.shcoobz.codebreaker.service.CaesarCipherService;
import com.shcoobz.codebreaker.service.VigenereCipherService;

import java.util.Scanner;

/**
 * The `Application` class serves as the entry point for the CodeBreaker cipher
 * tool.
 * It initializes the necessary components, including ciphers and user
 * interfaces,
 * and starts the application.
 */
public class Application {

  /**
   * The main method that starts the CodeBreaker application.
   *
   * @param args The command-line arguments (not used).
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Application app = new Application();

    CaesarCipherService caesarCipherService = createCaesarCipherService(scanner);
    VigenereCipherService vigenereCipherService = createVigenereCipherService(scanner);

    StartupManager startupManager = new StartupManager(app, scanner, caesarCipherService, vigenereCipherService);
    startupManager.start();
  }

  /**
   * Creates a `CaesarCipherService` instance with the provided `Scanner`.
   *
   * @param scanner The `Scanner` for user input.
   * @return A `CaesarCipherService` instance.
   */
  private static CaesarCipherService createCaesarCipherService(Scanner scanner) {
    CaesarCipher caesarCipher = new CaesarCipher();
    return new CaesarCipherService(caesarCipher, scanner);
  }

  /**
   * Creates a `VigenereCipherService` instance with the provided `Scanner`.
   *
   * @param scanner The `Scanner` for user input.
   * @return A `VigenereCipherService` instance.
   */
  private static VigenereCipherService createVigenereCipherService(Scanner scanner) {
    VigenereCipher vigenereCipher = new VigenereCipher();
    return new VigenereCipherService(vigenereCipher, scanner);
  }
}
