package com.shcoobz.codebreaker.initialization;

import com.shcoobz.codebreaker.Application;
import com.shcoobz.codebreaker.service.CipherResult;
import com.shcoobz.codebreaker.state.ApplicationState;
import com.shcoobz.codebreaker.service.CaesarCipherService;
import com.shcoobz.codebreaker.service.VigenereCipherService;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The `StartupManager` class is responsible for managing the initialization
 * and user interactions of the cipher application. It presents a menu
 * to the user for choosing between Caesar and Vigenere ciphers, performs
 * encryption or decryption actions on messages, and provides an option to exit
 * the application.
 */
public class StartupManager {
  private final Application app;
  private final Scanner scanner;
  private final ApplicationState appState;
  private final CaesarCipherService caesarCipherService;
  private final VigenereCipherService vigenereCipherService;
  private boolean shouldExit = false;
  private static final String CAESAR_CIPHER = "CC";
  private static final String VIGENERE_CIPHER = "VC";
  private static final String EXIT_CIPHER_SELECTION = "X";
  private static final int ENCRYPT = 1;
  private static final int DECRYPT = 2;
  private static final int CHANGE_CIPHER = 3;
  private static final int EXIT_CIPHER = 4;

  /**
   * Initializes a new instance of the `StartupManager` class with the provided
   * dependencies.
   *
   * @param app                  The application instance.
   * @param scanner              The scanner for user input.
   * @param caesarCipherService  The Caesar cipher service.
   * @param vigenereCipherService The Vigenere cipher service.
   */
  public StartupManager(Application app, Scanner scanner, CaesarCipherService caesarCipherService, VigenereCipherService vigenereCipherService) {
    this.app = app;
    this.scanner = scanner;
    this.appState = new ApplicationState();
    this.caesarCipherService = caesarCipherService;
    this.vigenereCipherService = vigenereCipherService;
  }

  /**
   * Starts the cipher application by displaying the application name
   * and a welcome message, then enters the main interaction loop.
   */
  public void start() {
    ConsolePrinter.appNameAscii();
    ConsolePrinter.welcomeMessage();
    mainInteractionLoop();
  }

  /**
   * Enters the main interaction loop, where user cipher choices are handled
   * until the `shouldExit` flag is set to true.
   */
  private void mainInteractionLoop() {
    while (!shouldExit) {
      handleUserCipherChoice();
    }
  }

  /**
   * Handles the user's choice of cipher (Caesar or Vigenere) and enters
   * the cipher-specific interaction loop to perform actions on messages.
   *
   * @param cipherChoice The chosen cipher ("CC" for Caesar Cipher, "VC" for
   *                     Vigenere Cipher).
   */
  private void handleUserCipherChoice() {
    String cipherChoice = getCipherChoiceFromUser();

    if (cipherChoice.equals(EXIT_CIPHER_SELECTION)) {
      ConsolePrinter.exitMessage();
      shouldExit = true;
    } else {
      handleCipherChoice(cipherChoice);
    }
  }

  /**
   * Prompts the user to input their cipher choice and returns it as a string.
   *
   * @return The user's cipher choice as a string.
   */
  private String getCipherChoiceFromUser() {
    ConsolePrinter.chooseCipherMessage();
    String choice = scanner.nextLine().toUpperCase();

    if (!isValidCipherChoice(choice)) {
      ConsolePrinter.invalidCipherChoice();
    }
    return choice;
  }

  /**
   * Checks if the provided cipher choice is valid (Caesar, Vigenere, or Exit).
   *
   * @param choice The user's cipher choice.
   * @return True if the choice is valid; otherwise, false.
   */
  private boolean isValidCipherChoice(String choice) {
    return choice.equals(CAESAR_CIPHER) || choice.equals(VIGENERE_CIPHER) || choice.equals(EXIT_CIPHER_SELECTION);
  }

  /**
   * Handles the user's action choice (Encrypt, Decrypt, Change Cipher, or Exit)
   * for a selected cipher, taking input message, performing the action, and
   * displaying the result.
   *
   * @param cipherChoice The chosen cipher ("CC" for Caesar Cipher, "VC" for
   *                     Vigenere Cipher).
   * @param actionChoice The action choice (1 for Encrypt, 2 for Decrypt,
   *                     3 for Change Cipher, 4 for Exit).
   */
  private void handleCipherChoice(String cipherChoice) {
    while (!shouldExit) {
      displayCipherOptions(cipherChoice);
      int actionChoice = getUserActionChoice();

      if (actionChoice == CHANGE_CIPHER) {
        ConsolePrinter.displayChangeCipherMessage();
        return;
      } else if (actionChoice == EXIT_CIPHER) {
        handleExit();
        return;
      } else if (actionChoice == ENCRYPT || actionChoice == DECRYPT) {
        processCipherAction(cipherChoice, actionChoice);
      } else {
        ConsolePrinter.displayInvalidOption();
      }
    }
  }

  /**
   * Retrieves the user's action choice (Encrypt, Decrypt, Change Cipher, or Exit)
   * and returns it as an integer.
   *
   * @return The user's action choice as an integer.
   */
  private int getUserActionChoice() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      scanner.nextLine();  // consume the invalid input
      return -1;  // Indicate invalid choice
    } finally {
      scanner.nextLine();  // always consume the newline
    }
  }

  /**
   * Processes the user's chosen cipher action (Encrypt or Decrypt) for the
   * selected cipher, taking input message, performing the action, and
   * displaying the result.
   *
   * @param cipherChoice The chosen cipher ("CC" for Caesar Cipher, "VC" for
   *                     Vigenere Cipher).
   * @param actionChoice The action choice (1 for Encrypt, 2 for Decrypt).
   */
  private void processCipherAction(String cipherChoice, int actionChoice) {
    System.out.print("\nMessage: ");
    String message = scanner.nextLine();
    CipherResult cipherResult = getCipherResult(cipherChoice, message, actionChoice);

    if (cipherResult != null) {
      appState.updateLastValues(
          cipherChoice.equals(CAESAR_CIPHER) ? "Caesar Cipher" : "Vigenere Cipher",
          cipherResult.getAction(),
          cipherResult.getModifier(),
          message,
          cipherResult.getResultMessage()
      );
      ConsolePrinter.displayResult(message, cipherResult.getResultMessage(), cipherResult.getAction());
    } else {
      ConsolePrinter.displayInvalidOption();
    }
  }

  /**
   * Retrieves the cipher result for the selected cipher, action, and input message.
   *
   * @param cipherChoice  The chosen cipher ("CC" for Caesar Cipher, "VC" for
   *                      Vigenere Cipher).
   * @param message       The input message.
   * @param actionChoice  The action choice (1 for Encrypt, 2 for Decrypt).
   * @return The cipher result containing the action, modifier, and result message.
   */
  private CipherResult getCipherResult(String cipherChoice, String message, int actionChoice) {
    if (cipherChoice.equals(CAESAR_CIPHER)) {
      return caesarCipherService.handleCaesarCipher(message, actionChoice);
    } else if (cipherChoice.equals(VIGENERE_CIPHER)) {
      return vigenereCipherService.handleVigenereCipher(message, actionChoice);
    }
    return null;
  }

  /**
   * Displays the available options for the selected cipher.
   *
   * @param currentCipher The currently selected cipher ("Caesar Cipher" or
   *                      "Vigenere Cipher").
   */
  private void displayCipherOptions(String currentCipher) {
    ConsolePrinter.displayCipherStatus(appState.getLastUsedCipher(), appState.getLastAction(), appState.getLastCipherModifier(), appState.getLastOriginalMessage(), appState.getLastResultMessage(), currentCipher);
    ConsolePrinter.displayCipherOptions();
  }

  /**
   * Handles the application exit by displaying an exit message and setting the
   * `shouldExit` flag to true.
   */
  private void handleExit() {
    ConsolePrinter.exitMessage();
    shouldExit = true;
  }
}
