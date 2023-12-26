package com.shcoobz.codebreaker.initialization;

import com.shcoobz.codebreaker.Application;
import com.shcoobz.codebreaker.service.CipherResult;
import com.shcoobz.codebreaker.state.ApplicationState;
import com.shcoobz.codebreaker.service.CaesarCipherService;
import com.shcoobz.codebreaker.service.VigenereCipherService;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

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

  public StartupManager(Application app, Scanner scanner, CaesarCipherService caesarCipherService, VigenereCipherService vigenereCipherService) {
    this.app = app;
    this.scanner = scanner;
    this.appState = new ApplicationState();
    this.caesarCipherService = caesarCipherService;
    this.vigenereCipherService = vigenereCipherService;
  }

  public void start() {
    ConsolePrinter.appNameAscii();
    ConsolePrinter.welcomeMessage();
    mainInteractionLoop();
  }

  private void mainInteractionLoop() {
    while (!shouldExit) {
      handleUserCipherChoice();
    }
  }

  private void handleUserCipherChoice() {
    String cipherChoice = getCipherChoiceFromUser();
    if (cipherChoice.equals(EXIT_CIPHER_SELECTION)) {
      ConsolePrinter.exitMessage();
      shouldExit = true;
    } else {
      handleCipherChoice(cipherChoice);
    }
  }

  private String getCipherChoiceFromUser() {
    ConsolePrinter.chooseCipherMessage();
    String choice = scanner.nextLine().toUpperCase();
    if (!isValidCipherChoice(choice)) {
      ConsolePrinter.invalidCipherChoice();
    }
    return choice;
  }

  private boolean isValidCipherChoice(String choice) {
    return choice.equals(CAESAR_CIPHER) || choice.equals(VIGENERE_CIPHER) || choice.equals(EXIT_CIPHER_SELECTION);
  }

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


  private CipherResult getCipherResult(String cipherChoice, String message, int actionChoice) {
    if (cipherChoice.equals(CAESAR_CIPHER)) {
      return caesarCipherService.handleCaesarCipher(message, actionChoice);
    } else if (cipherChoice.equals(VIGENERE_CIPHER)) {
      return vigenereCipherService.handleVigenereCipher(message, actionChoice);
    }
    return null;
  }

  private void displayCipherOptions(String currentCipher) {
    ConsolePrinter.displayCipherStatus(appState.getLastUsedCipher(), appState.getLastAction(), appState.getLastCipherModifier(), appState.getLastOriginalMessage(), appState.getLastResultMessage(), currentCipher);
    ConsolePrinter.displayCipherOptions();
  }




  private void handleExit() {
    ConsolePrinter.exitMessage();
    shouldExit = true;
  }
}
