package com.string.examples;

public class StringUtil {
    public static void removeChars( StringBuilder str, String remove ) {
        boolean[] flags = new boolean[128]; // assumes ASCII
        int src, dst = 0;

        // Set flags for characters to be removed
        for (char c: remove.toCharArray()) {
            flags[c] = true;
        }

        // Now loop through all the characters,
        // copying only if they aren't flagged
        for ( src = 0; src < str.length(); ++src ) {
            char c = str.charAt(src);
            if ( !flags[ c ] ) {
                str.setCharAt( dst++, c );
            }
        }

        str.setLength(dst);
        return;
    }

}
