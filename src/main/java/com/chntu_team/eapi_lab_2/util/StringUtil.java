package com.chntu_team.eapi_lab_2.util;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class StringUtil {
    @NotNull
    public static String indexOrder(@NotNull String input) {
        final List<Character> chars = new ArrayList<>(Arrays.asList(toCharacterArray(input)));
        final List<Character> orderedChars = new ArrayList<>(chars);
        System.out.println(orderedChars);
        orderedChars.sort(Character::compare);

        StringBuilder indexed = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            final Character character = chars.get(i);
            final int i1 = orderedChars.indexOf(character);
            indexed.append(i1 + 1);
            orderedChars.set(i1, null);
        }

        return indexed.toString();
    }

    @NotNull
    public static Character[] toCharacterArray(@NotNull String input) {
        final Character[] characters = new Character[input.length()];
        final char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++)
            characters[i] = chars[i];
        return characters;
    }

    @NotNull
    @SneakyThrows
    public static String readFromFile(File file) {
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public static void saveToFile(@NotNull String text, @NotNull File file) {
        Files.write(file.toPath(), text.getBytes(StandardCharsets.UTF_8));
    }
}
