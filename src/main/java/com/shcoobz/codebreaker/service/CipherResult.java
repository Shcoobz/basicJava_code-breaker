package com.shcoobz.codebreaker.service;

/**
 * The `CipherResult` class represents the result of a cipher operation,
 * including the result message, modifier, and action.
 */
public class CipherResult {
  private final String resultMessage;
  private final String modifier;
  private final String action;

  /**
   * Initializes a new instance of the `CipherResult` class with the provided
   * result message, modifier, and action.
   *
   * @param resultMessage The result message of the cipher operation.
   * @param modifier      The modifier used in the cipher operation.
   * @param action        The action performed (e.g., "Encrypted" or "Decrypted").
   */
  public CipherResult(String resultMessage, String modifier, String action) {
    this.resultMessage = resultMessage;
    this.modifier = modifier;
    this.action = action;
  }

  /**
   * Gets the result message of the cipher operation.
   *
   * @return The result message.
   */
  public String getResultMessage() {
    return resultMessage;
  }

  /**
   * Gets the modifier used in the cipher operation.
   *
   * @return The modifier.
   */
  public String getModifier() {
    return modifier;
  }

  /**
   * Gets the action performed in the cipher operation (e.g., "Encrypted" or "Decrypted").
   *
   * @return The action.
   */
  public String getAction() {
    return action;
  }
}
