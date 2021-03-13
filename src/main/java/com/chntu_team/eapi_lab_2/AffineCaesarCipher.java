package com.chntu_team.eapi_lab_2;

import org.jetbrains.annotations.NotNull;

public class AffineCaesarCipher {

    @NotNull
    public String encrypt(@NotNull String alphabet, @NotNull String input, int b, int t) {
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

            int newPos = (pos * t + b) % n;
            char newC = alphabet.charAt(newPos);
            encryptedT.append(newC);
        }

        return encryptedT.toString();
    }

    @NotNull
    public String decrypt(@NotNull String alphabet, @NotNull String input, int b, int t) {
        final int n = alphabet.length();

        int kInverse = this.calcInverse(t, n);
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
            System.out.println(newC + " - " + newPos);
            decryptedT.append(newC);
        }

        return decryptedT.toString();
    }

    private int calcInverse(int t, int n) {
        for (int i = 1; i < n; i++)
            if ((t * i) % n == 1)
                return i;

        return 1;
    }

}