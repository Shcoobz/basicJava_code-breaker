package com.shcoobz.codebreaker.cipher;

/**
 * Test class for the VigenereCipher.
 */
public class VigenereCipherTest {

  /**
   * Utility method to run a test on VigenereCipher.
   * @param description Description of the test.
   * @param inputText Text to be encrypted or decrypted.
   * @param keyword Keyword for the Vigenere cipher.
   * @param expectedOutcome Expected outcome after encryption/decryption.
   * @param isEncryptionTest Flag to indicate if it's an encryption or decryption test.
   */
  private static void runTest(String description, String inputText, String keyword, String expectedOutcome, boolean isEncryptionTest) {
    System.out.println(description);

    VigenereCipher cipher = new VigenereCipher(new CaesarCipher()); // Assuming CaesarCipher has a default constructor

    String actualOutcome;

    if (isEncryptionTest) {
      actualOutcome = cipher.encrypt(inputText, keyword);
    } else {
      actualOutcome = cipher.decrypt(inputText, keyword);
    }

    if (actualOutcome.equals(expectedOutcome)) {
      System.out.println("SUCCESS: Expected " + (isEncryptionTest ? "encryption" : "decryption") + " to be " + expectedOutcome + ", got " + actualOutcome);
    } else {
      System.out.println("FAIL: Expected " + (isEncryptionTest ? "encryption" : "decryption") + " to be " + expectedOutcome + ", but got " + actualOutcome);
    }
  }

  /**
   * Main method to execute the tests.
   * @param args Command-line arguments.
   */
  public static void main(String[] args) {
    runTest("\n>>> Test Encryption 1 - Success <<<", "Encryption Test", "Keyword", "Oranmgwssl Psjw", true);
    runTest("\n>>> Test Encryption 2 - Fail <<<", "Encryption Test", "Keyword", "No", true);
    runTest("\n>>> Test Decryption 3 - Success<<<", "Decryption Test", "Keyword", "Taevkyqykp Xqbq", false);
    runTest("\n>>> Test Decryption 4 - Fail <<<", "Decryption Test", "Keyword", "No", false);
  }
}
