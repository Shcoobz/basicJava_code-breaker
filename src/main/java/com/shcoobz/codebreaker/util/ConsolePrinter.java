package com.shcoobz.codebreaker.util;

public class ConsolePrinter {

  public static void appNameAscii(){
    print("     ____               _          ____                          _                  ");
    print("    / ___|   ___     __| |   ___  | __ )   _ __    ___    __ _  | | __   ___   _ __ ");
    print("   | |      / _ \\   / _` |  / _ \\ |  _ \\  | '__|  / _ \\  / _` | | |/ /  / _ \\ | '__|");
    print("   | |___  | (_) | | (_| | |  __/ | |_) | | |    |  __/ | (_| | |   <  |  __/ | |   ");
    print("    \\____|  \\___/   \\__,_|  \\___| |____/  |_|     \\___|  \\__,_| |_|\\_\\  \\___| |_|   ");
  }

  public static void welcomeMessage() {
    print("\nWelcome to CodeBreaker!");
  }

  public static void chooseCipherMessage() {
    print("\nChoose cipher:");
    print("CC: Caesar Cipher!");
    print("VC: Vigenere Cipher!");
    print("X: I came here by mistake!");
    print("\nYou want to use: ");
  }

  public static void invalidCipherChoice() {
    print("WRONG! Select CC, VC, or X.");
  }

  public static void exitMessage() {
    print("\nOver & out!");
  }

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

  public static void displayCipherOptions() {
    print("It's dangerous to go alone, choose wisely:");
    print("1. Encrypt message");
    print("2. Decrypt message");
    print("3. Change Cipher");
    print("4. I don't even want to be here!");
    print("\nWhat will you do? THINK!: ");
  }

  public static void displayChangeCipherMessage() {
    print("\nChange Cipher!");
  }

  public static void displayInvalidOption() {
    print("Nope, try again.");
  }

  public static void displayResult(String originalMessage, String resultMessage, String operation) {
    print("\nOriginal Message: " + originalMessage);
    print(operation + " Message: " + resultMessage);
  }

  public static void promptForKeyword() {
    print("Keyword?: ");
  }

  public static void promptForShiftValue() {
    print("Shift value?: ");
  }

  private static void print(String message) {
    System.out.println(message);
  }
}
