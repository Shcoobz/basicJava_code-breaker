package com.shcoobz.codebreaker.state;

public class ApplicationState {
  private String lastUsedCipher = "N/A";
  private String lastAction = "N/A";
  private String lastCipherModifier = "N/A";
  private String lastOriginalMessage = "N/A";
  private String lastResultMessage = "N/A";

  public void updateLastValues(String cipher, String action, String modifier, String originalMessage, String resultMessage) {
    this.lastUsedCipher = cipher;
    this.lastAction = action;
    this.lastCipherModifier = modifier;
    this.lastOriginalMessage = originalMessage;
    this.lastResultMessage = resultMessage;
  }

  public String getLastUsedCipher() {
    return lastUsedCipher;
  }

  public String getLastAction() {
    return lastAction;
  }

  public String getLastCipherModifier() {
    return lastCipherModifier;
  }

  public String getLastOriginalMessage() {
    return lastOriginalMessage;
  }

  public String getLastResultMessage() {
    return lastResultMessage;
  }
}
