package com.shcoobz.codebreaker.service;

public class CipherResult {
  private final String resultMessage;
  private final String modifier;
  private final String action;

  public CipherResult(String resultMessage, String modifier, String action) {
    this.resultMessage = resultMessage;
    this.modifier = modifier;
    this.action = action;
  }

  public String getResultMessage() {
    return resultMessage;
  }

  public String getModifier() {
    return modifier;
  }

  public String getAction() {
    return action;
  }
}
