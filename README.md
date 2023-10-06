# JavaFX-Wordle-Solver


![image](https://github.com/jason7599/JavaFX-Wordle-Solver/assets/95277635/cc543ef2-ea9d-41fa-87f8-e4bfa5bc4be0)


An interactive JavaFX app that helps you solve the game "Wordle".

# How to use
1. Enter your guesses using the keyboard.
2. Color each character.
3. Press the solve button to see the filtered list of candidate words.

# Limitations
- Cannot handle duplicate characters in a single guess such as C in CUBIC
  - In such cases, you must color only one instance of the character either green or yellow, and keep the rest uncolored.
- Some of the words in the list are not actually registered as real words in the official game.
- Half-assed UI
