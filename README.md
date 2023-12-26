# CodeBreaker Cipher Tool

![CodeBreaker Logo](src/main/resources/img/CodeBreaker.png)

CodeBreaker is a simple Java application that allows you to perform encryption and decryption using various ciphers, including the Caesar Cipher and Vigenere Cipher. This tool is designed to help you learn and experiment with different ciphers and their applications in cryptography.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Future To-Dos](#future-to-dos)
- [License](#license)

## Features

- **Caesar Cipher**: Encrypt or decrypt messages using the Caesar Cipher with a user-defined shift value.
- **Vigenere Cipher**: Encrypt or decrypt messages using the Vigenere Cipher with a user-defined keyword.
- **Interactive Console**: An interactive command-line interface makes it easy to use different ciphers and perform actions on messages.
- **Application State**: Keeps track of the last used cipher, action, modifier, original message, and result message.

## Getting Started

To get started with CodeBreaker, follow these steps:

1. Clone this repository to your local machine.
2. Ensure you have Java and a Java Development Kit (JDK) installed.
3. Build the project using a Java build tool like Maven or compile the source code manually.

## Usage

To use CodeBreaker, run the `Application` class, and the interactive console will guide you through the process of selecting a cipher, performing actions on messages, and more. Follow the on-screen prompts to interact with the tool.

## Future To-Dos
While CodeBreaker currently supports the Caesar Cipher and Vigenere Cipher, there are exciting possibilities for expanding its capabilities. Here are some future to-dos for the project:

- Implement More Ciphers: Expand the range of supported ciphers, such as the Atbash Cipher, Substitution Cipher, and Transposition Cipher.
- Enhance User Experience: Improve the user interface and provide more detailed feedback during cipher operations.
- Add Cryptanalysis Tools: Integrate tools for breaking simple ciphers and analyzing the security of encrypted messages.
- Support File Input/Output: Allow users to encrypt or decrypt messages from files, not just the console input.

Contributions and suggestions for these enhancements are welcome! Feel free to open issues or submit pull requests to help us improve CodeBreaker.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
