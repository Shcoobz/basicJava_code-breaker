package com.shcoobz.codebreaker.initialization;

import com.shcoobz.codebreaker.Application;
import com.shcoobz.codebreaker.state.ApplicationState;
import com.shcoobz.codebreaker.service.CaesarCipherService;
import com.shcoobz.codebreaker.service.VigenereCipherService;
import com.shcoobz.codebreaker.util.ConsolePrinter;

import java.util.Scanner;

public class StartupManager {
  private final Application app;
  private final Scanner scanner;
  private final ApplicationState appState;
  private final CaesarCipherService caesarCipherService;
  private final VigenereCipherService vigenereCipherService;

  private boolean shouldExit = false;

  public StartupManager(Application app, Scanner scanner, CaesarCipherService caesarCipherService, VigenereCipherService vigenereCipherService) {
    this.app = app;
    this.scanner = scanner;
    this.appState = new ApplicationState();
    this.caesarCipherService = caesarCipherService;
    this.vigenereCipherService = vigenereCipherService;
  }

  public void start() {
    ConsolePrinter.welcomeMessage();

    while (!shouldExit) {
      ConsolePrinter.chooseCipherMessage();
      String cipherChoice = scanner.nextLine().toUpperCase();

      if (!cipherChoice.equals("CC") && !cipherChoice.equals("VC") && !cipherChoice.equals("X")) {
        ConsolePrinter.invalidCipherChoice();
        continue;
      }

      if (cipherChoice.equals("X")) {
        ConsolePrinter.exitMessage();
        shouldExit = true;
        return;
      }

      handleCipherChoice(cipherChoice);
    }
  }

  private void handleCipherChoice(String cipherChoice) {

    while (!shouldExit) {
      String currentCipher = cipherChoice.equals("CC") ? "Caesar Cipher" : "Vigenere Cipher";
      ConsolePrinter.displayCipherStatus(appState.getLastUsedCipher(), appState.getLastAction(), appState.getLastCipherModifier(), appState.getLastOriginalMessage(), appState.getLastResultMessage(), currentCipher);
      ConsolePrinter.displayCipherOptions();

      int actionChoice = scanner.nextInt();
      scanner.nextLine();  // consume the newline

      if (actionChoice == 1 || actionChoice == 2) {
        System.out.print("\nMessage: "); // Keep this if you need inline input prompt
        String message = scanner.nextLine();

        if (cipherChoice.equals("CC")) {
          caesarCipherService.handleCaesarCipher(message, actionChoice);
        } else if (cipherChoice.equals("VC")) {
          vigenereCipherService.handleVigenereCipher(message, actionChoice);
        }
      } else if (actionChoice == 3) {
        ConsolePrinter.displayChangeCipherMessage();
        break;
      } else if (actionChoice == 4) {
        ConsolePrinter.exitMessage();
        shouldExit = true;
        return;
      } else {
        ConsolePrinter.displayInvalidOption();
      }
    }
  }
}
