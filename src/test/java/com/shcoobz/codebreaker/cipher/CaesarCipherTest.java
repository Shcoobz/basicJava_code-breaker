package com.shcoobz.codebreaker.cipher;

import com.shcoobz.codebreaker.cipher.CaesarCipher;

/**
 * Test class for the CaesarCipher.
 */
public class CaesarCipherTest {

  /**
   * Helper method to run individual CaesarCipher tests.
   *
   * @param description     Test description.
   * @param inputText       The input text for the test.
   * @param shift           The shift value for the test.
   * @param expectedOutcome The expected outcome of the test.
   * @param isEncryptTest   Flag indicating if the test is for encryption or decryption.
   */
  private static void runTest(String description, String inputText, int shift, String expectedOutcome, boolean isEncryptTest) {
    System.out.println(description);

    CaesarCipher cipher = new CaesarCipher();

    try {
      String actualOutcome;
      if (isEncryptTest) {
        actualOutcome = cipher.encrypt(inputText, shift);
      } else {
        actualOutcome = cipher.decrypt(inputText, shift);
      }

      if (actualOutcome.equals(expectedOutcome)) {
        System.out.println("SUCCESS: Expected text to be " + expectedOutcome + ", got " + actualOutcome);
      } else {
        System.out.println("FAIL: Expected text to be " + expectedOutcome + ", but got " + actualOutcome);
      }
    } catch (Exception e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    runTest("\n>>> Test Encrypt 'hello' with shift 3 - Success <<<", "hello", 3, "khoor", true);
    runTest("\n>>> Test Encrypt 'hello' with shift 3 - Failure <<<", "hello", 3, "wrong", true);
    runTest("\n>>> Test Decrypt 'khoor' with shift 3 - Success <<<", "khoor", 3, "hello", false);
    runTest("\n>>> Test Decrypt 'khoor' with shift 3 - Failure <<<", "khoor", 3, "wrong", false);
  }
}
