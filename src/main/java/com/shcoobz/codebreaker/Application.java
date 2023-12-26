package com.shcoobz.codebreaker;

import com.shcoobz.codebreaker.cipher.CaesarCipher;
import com.shcoobz.codebreaker.cipher.VigenereCipher;
import com.shcoobz.codebreaker.initialization.StartupManager;
import com.shcoobz.codebreaker.service.CaesarCipherService;
import com.shcoobz.codebreaker.service.VigenereCipherService;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Application app = new Application();

    CaesarCipherService caesarCipherService = createCaesarCipherService(scanner);
    VigenereCipherService vigenereCipherService = createVigenereCipherService(scanner);

    StartupManager startupManager = new StartupManager(app, scanner, caesarCipherService, vigenereCipherService);
    startupManager.start();
  }

  private static CaesarCipherService createCaesarCipherService(Scanner scanner) {
    CaesarCipher caesarCipher = new CaesarCipher();
    return new CaesarCipherService(caesarCipher, scanner);
  }

  private static VigenereCipherService createVigenereCipherService(Scanner scanner) {
    VigenereCipher vigenereCipher = new VigenereCipher();
    return new VigenereCipherService(vigenereCipher, scanner);
  }
}


