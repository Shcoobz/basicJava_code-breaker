package com.shcoobz.codebreaker.state;

/**
 * The `ApplicationState` class maintains the state of the cipher application,
 * including information about the last used cipher, action, modifier, original message,
 * and result message.
 */
public class ApplicationState {
  private String lastUsedCipher = "N/A";
  private String lastAction = "N/A";
  private String lastCipherModifier = "N/A";
  private String lastOriginalMessage = "N/A";
  private String lastResultMessage = "N/A";

  /**
   * Updates the last used cipher, action, modifier, original message, and result message.
   *
   * @param cipher          The last used cipher.
   * @param action          The last action performed.
   * @param modifier        The last cipher modifier.
   * @param originalMessage The last original message.
   * @param resultMessage   The last result message.
   */
  public void updateLastValues(String cipher, String action, String modifier, String originalMessage, String resultMessage) {
    this.lastUsedCipher = cipher;
    this.lastAction = action;
    this.lastCipherModifier = modifier;
    this.lastOriginalMessage = originalMessage;
    this.lastResultMessage = resultMessage;
  }

  /**
   * Gets the last used cipher.
   *
   * @return The last used cipher.
   */
  public String getLastUsedCipher() {
    return lastUsedCipher;
  }

  /**
   * Gets the last action performed.
   *
   * @return The last action.
   */
  public String getLastAction() {
    return lastAction;
  }

  /**
   * Gets the last cipher modifier.
   *
   * @return The last cipher modifier.
   */
  public String getLastCipherModifier() {
    return lastCipherModifier;
  }

  /**
   * Gets the last original message.
   *
   * @return The last original message.
   */
  public String getLastOriginalMessage() {
    return lastOriginalMessage;
  }

  /**
   * Gets the last result message.
   *
   * @return The last result message.
   */
  public String getLastResultMessage() {
    return lastResultMessage;
  }
}
