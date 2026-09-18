package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: compiled from: SameBase64Tool.java */
/* JADX INFO: loaded from: classes4.dex */
public class u {
    private static final String a = "u";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Character, Character> f2228b;
    private static Map<Character, Character> c;
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        HashMap map = new HashMap();
        c = map;
        map.put('v', 'A');
        c.put('S', 'B');
        c.put('o', 'C');
        c.put('a', 'D');
        c.put('j', 'E');
        c.put('c', 'F');
        c.put('7', 'G');
        c.put('d', 'H');
        c.put('R', 'I');
        c.put('z', 'J');
        c.put('p', 'K');
        c.put('W', 'L');
        c.put('i', 'M');
        c.put('f', 'N');
        c.put('G', 'O');
        c.put('y', 'P');
        c.put('N', 'Q');
        c.put('x', 'R');
        c.put('Z', 'S');
        c.put('n', 'T');
        c.put('V', 'U');
        c.put('5', 'V');
        c.put('k', 'W');
        c.put('+', 'X');
        c.put('D', 'Y');
        c.put('H', 'Z');
        c.put('L', 'a');
        c.put('Y', 'b');
        c.put('h', 'c');
        c.put('J', 'd');
        c.put('4', 'e');
        c.put('6', 'f');
        c.put('l', 'g');
        c.put('t', 'h');
        c.put('0', 'i');
        c.put('U', 'j');
        c.put('3', 'k');
        c.put('Q', 'l');
        c.put('r', 'm');
        c.put('g', 'n');
        c.put('E', 'o');
        c.put('u', 'p');
        c.put('q', 'q');
        c.put('8', 'r');
        c.put('s', 's');
        c.put('w', 't');
        c.put('/', 'u');
        c.put('X', 'v');
        c.put('M', 'w');
        c.put('e', 'x');
        c.put('B', 'y');
        c.put('A', 'z');
        c.put('T', '0');
        c.put('2', '1');
        c.put('F', '2');
        c.put('b', '3');
        c.put('9', '4');
        c.put('P', '5');
        c.put('1', '6');
        c.put('O', '7');
        c.put('I', '8');
        c.put('K', '9');
        c.put('m', '+');
        c.put('C', '/');
        HashMap map2 = new HashMap();
        f2228b = map2;
        map2.put('A', 'v');
        f2228b.put('B', 'S');
        f2228b.put('C', 'o');
        f2228b.put('D', 'a');
        f2228b.put('E', 'j');
        f2228b.put('F', 'c');
        f2228b.put('G', '7');
        f2228b.put('H', 'd');
        f2228b.put('I', 'R');
        f2228b.put('J', 'z');
        f2228b.put('K', 'p');
        f2228b.put('L', 'W');
        f2228b.put('M', 'i');
        f2228b.put('N', 'f');
        f2228b.put('O', 'G');
        f2228b.put('P', 'y');
        f2228b.put('Q', 'N');
        f2228b.put('R', 'x');
        f2228b.put('S', 'Z');
        f2228b.put('T', 'n');
        f2228b.put('U', 'V');
        f2228b.put('V', '5');
        f2228b.put('W', 'k');
        f2228b.put('X', '+');
        f2228b.put('Y', 'D');
        f2228b.put('Z', 'H');
        f2228b.put('a', 'L');
        f2228b.put('b', 'Y');
        f2228b.put('c', 'h');
        f2228b.put('d', 'J');
        f2228b.put('e', '4');
        f2228b.put('f', '6');
        f2228b.put('g', 'l');
        f2228b.put('h', 't');
        f2228b.put('i', '0');
        f2228b.put('j', 'U');
        f2228b.put('k', '3');
        f2228b.put('l', 'Q');
        f2228b.put('m', 'r');
        f2228b.put('n', 'g');
        f2228b.put('o', 'E');
        f2228b.put('p', 'u');
        f2228b.put('q', 'q');
        f2228b.put('r', '8');
        f2228b.put('s', 's');
        f2228b.put('t', 'w');
        f2228b.put('u', '/');
        f2228b.put('v', 'X');
        f2228b.put('w', 'M');
        f2228b.put('x', 'e');
        f2228b.put('y', 'B');
        f2228b.put('z', 'A');
        f2228b.put('0', 'T');
        f2228b.put('1', '2');
        f2228b.put('2', 'F');
        f2228b.put('3', 'b');
        f2228b.put('4', '9');
        f2228b.put('5', 'P');
        f2228b.put('6', '1');
        f2228b.put('7', 'O');
        f2228b.put('8', 'I');
        f2228b.put('9', 'K');
        f2228b.put('+', 'm');
        f2228b.put('/', 'C');
    }

    private u() {
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : ab.b(str);
    }

    public static String b(String str) {
        return ab.a(str);
    }
}
