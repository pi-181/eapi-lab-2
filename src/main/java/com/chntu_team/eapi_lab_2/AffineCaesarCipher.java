package com.chntu_team.eapi_lab_2;

import org.jetbrains.annotations.NotNull;

public class AffineCaesarCipher {

    @NotNull
    public String encrypt(@NotNull String alphabet, @NotNull String input, int a, int b) {
        final int n = alphabet.length();

        String text = input.toLowerCase();
        StringBuilder encryptedT = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int pos = alphabet.indexOf(c);

            // Skip non alphabet symbol, if it not found.
            if (pos == -1) {
                encryptedT.append(c);
                continue;
            }

            int newPos = (pos * a + b) % n;
            char newC = alphabet.charAt(newPos);
            encryptedT.append(newC);
        }

        return encryptedT.toString();
    }

    @NotNull
    public String decrypt(@NotNull String alphabet, @NotNull String input, int a, int b) {
        final int n = alphabet.length();

        int kInverse = this.calcInverse(a, n);
        String text = input.toLowerCase();
        StringBuilder decryptedT = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int pos = alphabet.indexOf(c);

            // Skip non alphabet symbol, if it not found.
            if (pos == -1) {
                decryptedT.append(c);
                continue;
            }

            int newPos = (kInverse * (pos + n - b)) % n;
            char newC = alphabet.charAt(newPos);
            decryptedT.append(newC);
        }

        return decryptedT.toString();
    }

    private int calcInverse(int a, int n) {
        for (int i = 1; i < n; i++)
            if ((a * i) % n == 1)
                return i;

        return 1;
    }

}
