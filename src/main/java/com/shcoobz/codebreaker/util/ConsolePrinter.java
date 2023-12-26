package com.shcoobz.codebreaker.util;

/**
 * The `ConsolePrinter` class provides utility methods for printing messages and
 * interacting with the console.
 */
public class ConsolePrinter {

  /**
   * Prints the ASCII art representing the application name.
   */
  public static void appNameAscii(){
    print("     ____               _          ____                          _                  ");
    print("    / ___|   ___     __| |   ___  | __ )   _ __    ___    __ _  | | __   ___   _ __ ");
    print("   | |      / _ \\   / _` |  / _ \\ |  _ \\  | '__|  / _ \\  / _` | | |/ /  / _ \\ | '__|");
    print("   | |___  | (_) | | (_| | |  __/ | |_) | | |    |  __/ | (_| | |   <  |  __/ | |   ");
    print("    \\____|  \\___/   \\__,_|  \\___| |____/  |_|     \\___|  \\__,_| |_|\\_\\  \\___| |_|   ");
  }

  /**
   * Prints a welcome message.
   */
  public static void welcomeMessage() {
    print("\nWelcome to CodeBreaker!");
  }

  /**
   * Prints a message to choose the cipher (Caesar or Vigenere).
   */
  public static void chooseCipherMessage() {
    print("\nChoose cipher:");
    print("CC: Caesar Cipher!");
    print("VC: Vigenere Cipher!");
    print("X: I came here by mistake!");
    print("\nYou want to use: ");
  }

  /**
   * Prints an error message for an invalid cipher choice.
   */
  public static void invalidCipherChoice() {
    print("WRONG! Select CC, VC, or X.");
  }

  /**
   * Prints an exit message.
   */
  public static void exitMessage() {
    print("\nOver & out!");
  }

  /**
   * Displays the current cipher status, last action, and other information.
   *
   * @param lastUsedCipher     The last used cipher.
   * @param lastAction         The last action performed.
   * @param lastCipherModifier The last cipher modifier.
   * @param lastOriginalMessage The last original message.
   * @param lastResultMessage   The last result message.
   * @param currentCipher      The current cipher being used.
   */
  public static void displayCipherStatus(String lastUsedCipher, String lastAction, String lastCipherModifier, String lastOriginalMessage, String lastResultMessage, String currentCipher) {
    print("\n*****");
    print("Last Used Cipher: " + lastUsedCipher);
    print("Last Action: " + lastAction);
    print("Last Cipher Modifier: " + lastCipherModifier);
    print(" ");
    print("Last Original Message: " + lastOriginalMessage);
    print("Last Result Message: " + lastResultMessage);
    print("*****");
    print("Current Cipher: " + currentCipher);
    print("*****");
  }

  /**
   * Displays available cipher options (e.g., Encrypt, Decrypt, Change Cipher).
   */
  public static void displayCipherOptions() {
    print("It's dangerous to go alone, choose wisely:");
    print("1. Encrypt message");
    print("2. Decrypt message");
    print("3. Change Cipher");
    print("4. I don't even want to be here!");
    print("\nWhat will you do? THINK!: ");
  }

  /**
   * Displays a message indicating a cipher change.
   */
  public static void displayChangeCipherMessage() {
    print("\nChange Cipher!");
  }

  /**
   * Displays a message indicating an invalid option.
   */
  public static void displayInvalidOption() {
    print("Nope, try again.");
  }

  /**
   * Displays the original message, result message, and the action performed
   * (e.g., "Original Message: ...", "Encrypted Message: ...").
   *
   * @param originalMessage The original message.
   * @param resultMessage   The result message.
   * @param operation       The action performed (e.g., "Encrypted" or "Decrypted").
   */
  public static void displayResult(String originalMessage, String resultMessage, String operation) {
    print("\nOriginal Message: " + originalMessage);
    print(operation + " Message: " + resultMessage);
  }

  /**
   * Prompts the user for a keyword.
   */
  public static void promptForKeyword() {
    print("Keyword?: ");
  }

  /**
   * Prompts the user for a shift value.
   */
  public static void promptForShiftValue() {
    print("Shift value?: ");
  }

  private static void print(String message) {
    System.out.println(message);
  }
}
