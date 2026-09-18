package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.primitives.SignedBytes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7z, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C07617z {
    public static AtomicInteger A00;
    public static byte[] A01;
    public static String[] A02 = {"TEIgz1GSUxi0w6HxI", "WqDufwBE7AlvD41n6qdN4YbCXU2LtDad", "95AkSvnB6didgYS0", "q9Pm9O4XheyxpjJIaV85netzFUNpUTJ1", "laKi0sQOm1cRNFPmXQKezZzTFfBBOlTJ", "R9By8R7rHrFXxi8d0eZrOpOQKJFwFXXr", "DNKj97yZe49oXEmfRz7aINNiwqbkjDQZ", "HsAQREGxpVIGFVt11mTJ2r8ajNtMZb1h"};
    public static final Object A03;
    public static final String A04;
    public static final Map<String, Integer> A05;
    public static final Set<String> A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static AnonymousClass81 A01(String str, C7S c7s, Map<String, String> map) {
        AnonymousClass81 anonymousClass81 = null;
        try {
            anonymousClass81 = new AnonymousClass81(c7s.A08().A01(), c7s.A08().A02(), new C07487l(str, map, true).A02());
            A0C(anonymousClass81, c7s);
            return anonymousClass81;
        } catch (Exception unused) {
            return anonymousClass81;
        }
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JSONArray A04(C7S c7s, int i) {
        InterfaceC07587w interfaceC07587wA07;
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            try {
                try {
                    if (new File(c7s.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s)).exists()) {
                        fileInputStreamOpenFileInput = c7s.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null || i == 0) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            if (!jSONObject.has(A02(260, 7, 27))) {
                                jSONObject.put(A02(260, 7, 27), String.valueOf(0));
                            }
                            String string = jSONObject.getString(A02(343, 2, 126));
                            if (!A06.contains(string)) {
                                int i2 = jSONObject.getInt(A02(260, 7, 27));
                                Map<String, Integer> map = A05;
                                if (map.containsKey(string)) {
                                    jSONObject.put(A02(260, 7, 27), String.valueOf(map.get(string)));
                                } else {
                                    A0E(string, i2);
                                }
                                jSONArray.put(jSONObject);
                                if (i > 0) {
                                    i--;
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            e = e;
                            interfaceC07587wA07 = c7s.A07();
                            interfaceC07587wA07.A3Y(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (IOException | JSONException e2) {
                    c7s.A07().A3Y(e2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e = e3;
                            interfaceC07587wA07 = c7s.A07();
                            interfaceC07587wA07.A3Y(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        c7s.A07().A3Y(e4);
                        throw th;
                    }
                }
                if (0 != 0) {
                    inputStreamReader.close();
                }
                if (0 != 0) {
                    fileInputStreamOpenFileInput.close();
                }
                throw th;
            }
        }
        return jSONArray;
    }

    public static void A06() {
        A01 = new byte[]{7, 95, 83, 55, 1, 28, 3, 48, 28, 6, 29, 7, 22, 1, 73, 83, 63, 29, 18, 91, 8, 92, 24, 25, 16, 25, 8, 25, 92, 24, 25, 30, 9, 27, 92, 25, 10, 25, 18, 8, 15, 92, 26, 21, 16, 25, 82, 14, 44, 35, 106, 57, 109, 41, 40, 33, 40, 57, 40, 109, 43, 36, 33, 40, 108, 119, 118, 113, 102, 116, 108, 99, 97, 118, 117, 42, 25, 10, 1, 27, 44, 0, 26, 1, 27, 41, 45, 46, 26, 11, 6, 10, 1, 12, 10, 33, 10, 27, 24, 0, 29, 4, 31, 58, Base64.padSymbol, 40, 42, 111, 43, 42, 45, 58, 40, 111, 42, 57, 42, 33, 59, 60, 111, 41, 38, 35, 42, 97, 69, 9, 38, 35, 42, 111, 60, 38, 53, 42, 117, 111, 111, 87, 85, 76, 76, 89, 88, 28, 89, 74, 89, 82, 72, 79, 18, 40, 16, 18, 11, 11, 18, 21, 28, 91, 24, 20, 9, 9, 14, 11, 15, 30, 31, 91, 31, 30, 25, 14, 28, 91, 30, 13, 30, 21, 15, 91, 23, 18, 21, 30, 85, 98, 68, 79, 95, 88, 81, 22, 66, 89, 22, 67, 70, 82, 87, 66, 83, 22, 67, 88, 68, 83, 85, 89, 68, 82, 83, 82, 22, 82, 83, 84, 67, 81, 122, 89, 81, 115, SignedBytes.MAX_POWER_OF_TWO, 83, 88, 66, 24, 22, 87, 82, 82, 95, 88, 81, 22, 66, 89, 22, 121, 88, 81, 89, 95, 88, 81, 115, SignedBytes.MAX_POWER_OF_TWO, 83, 88, 66, 24, 58, 17, 0, 8, 21, 6, 19, 19, 2, 10, 23, 19, 88, 93, 72, 93, 127, 126, 68, 119, 116, 124, 124, 114, 117, 124, 43, 42, 45, 58, 40, 35, 32, 40, 60, 91, 84, 83, 84, 78, 85, 88, 89, 29, 88, 75, 88, 83, 73, 29, 78, 85, 82, 72, 81, 89, 29, 83, 82, 73, 29, 95, 88, 29, 72, 77, 89, 92, 73, 88, 89, 29, 73, 82, 29, 114, 83, 90, 82, 84, 83, 90, 120, 75, 88, 83, 73, 19, 107, 102, 126, 104, 126, 126, 100, 98, 99, 82, 100, 105, 72, 94, 72, 72, 82, 84, 85, 100, 79, 82, 86, 94, 105, 113, 115, 106, 106, 127, 126, 95, 108, 127, 116, 110, 105, 58, 39, 58, 49, 55, 32, 54, 59, 50, 39, 75, 77, 90, 76, 65, 72, 93, 103, 91, 87, 92, 93, 119, 106, 110, 102, 85, 88, 81, 68};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A0G(C7S c7s) {
        JSONArray jSONArray = new JSONArray();
        synchronized (A03) {
            int i = 0;
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            try {
                try {
                    if (new File(c7s.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s)).exists()) {
                        fileInputStreamOpenFileInput = c7s.openFileInput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s));
                        inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            String string = jSONObject.getString(A02(343, 2, 126));
                            if (!A06.contains(string)) {
                                Map<String, Integer> map = A05;
                                if (map.containsKey(string)) {
                                    Integer num = map.get(string);
                                    Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : 0);
                                    int iA02 = IR.A02(c7s);
                                    if (iA02 <= -1 || numValueOf.intValue() <= iA02 - 1) {
                                        jSONObject.put(A02(260, 7, 27), String.valueOf(numValueOf));
                                        jSONArray.put(jSONObject);
                                    } else {
                                        A0D(string);
                                        i++;
                                    }
                                } else {
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            sb.append(jSONArray.getJSONObject(i2).toString()).append('\n');
                        }
                        fileOutputStreamOpenFileOutput = c7s.openFileOutput(ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s), 0);
                        fileOutputStreamOpenFileOutput.write(sb.toString().getBytes());
                    }
                    A09(c7s, A00(c7s));
                    if (i > 0) {
                        c7s.A07().A9M(A02(271, 10, 103), C07597x.A2V, new C07607y(A02(138, 15, 64), A02(367, 16, 102) + i));
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            c7s.A07().A3Y(e);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    A06.clear();
                    A05.clear();
                    return true;
                } catch (IOException | JSONException e2) {
                    c7s.A07().A3Y(e2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            c7s.A07().A3Y(e3);
                            A06.clear();
                            A05.clear();
                            return false;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    A06.clear();
                    A05.clear();
                    return false;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        c7s.A07().A3Y(e4);
                        A06.clear();
                        A05.clear();
                        throw th;
                    }
                }
                if (0 != 0) {
                    inputStreamReader.close();
                }
                if (0 != 0) {
                    fileInputStreamOpenFileInput.close();
                }
                if (0 != 0) {
                    fileOutputStreamOpenFileOutput.close();
                }
                A06.clear();
                A05.clear();
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0227 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x022c A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0231 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0236 A[Catch: IOException -> 0x023f, all -> 0x0252, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x023b A[Catch: IOException -> 0x023f, all -> 0x0252, TRY_LEAVE, TryCatch #6 {IOException -> 0x023f, blocks: (B:115:0x0222, B:117:0x0227, B:119:0x022c, B:121:0x0231, B:123:0x0236, B:125:0x023b), top: B:139:0x0222, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0222 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x005d A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static boolean A0H(C7S c7s) {
        int iIntValue;
        synchronized (A03) {
            int i = 0;
            FileInputStream fileInputStreamOpenFileInput = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;
            FileOutputStream fileOutputStreamOpenFileOutput = null;
            FileInputStream fileInputStreamOpenFileInput2 = null;
            FileOutputStream fileOutputStreamOpenFileOutput2 = null;
            try {
                try {
                    String processSpecificName = ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s);
                    File file = new File(c7s.getFilesDir(), processSpecificName);
                    String str = processSpecificName + A02(255, 5, 25);
                    A0A(c7s, str);
                    if (file.exists()) {
                        fileOutputStreamOpenFileOutput2 = c7s.openFileOutput(str, 32768);
                        fileInputStreamOpenFileInput = c7s.openFileInput(processSpecificName);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(line);
                                            String string = jSONObject.getString(A02(343, 2, 126));
                                            if (!A06.contains(string)) {
                                                Map<String, Integer> map = A05;
                                                if (map.containsKey(string)) {
                                                    try {
                                                        Integer num = map.get(string);
                                                        if (num != null) {
                                                            try {
                                                                iIntValue = num.intValue();
                                                            } catch (IOException e) {
                                                                e = e;
                                                            } catch (JSONException e2) {
                                                                e = e2;
                                                                if (c7s.A04().A8o()) {
                                                                    Log.e(A04, A02(153, 36, 7), e);
                                                                }
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                if (bufferedReader != null) {
                                                                    try {
                                                                        bufferedReader.close();
                                                                    } catch (IOException e3) {
                                                                        c7s.A07().A3Y(e3);
                                                                        A06.clear();
                                                                        A05.clear();
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (inputStreamReader != null) {
                                                                    inputStreamReader.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput != null) {
                                                                    fileInputStreamOpenFileInput.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput != null) {
                                                                    fileOutputStreamOpenFileOutput.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput2 != null) {
                                                                    fileInputStreamOpenFileInput2.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput2 != null) {
                                                                    fileOutputStreamOpenFileOutput2.close();
                                                                }
                                                                A06.clear();
                                                                A05.clear();
                                                                throw th;
                                                            }
                                                        } else {
                                                            iIntValue = 0;
                                                        }
                                                        Integer numValueOf = Integer.valueOf(iIntValue);
                                                        int iA02 = IR.A02(c7s);
                                                        if (iA02 > -1) {
                                                            try {
                                                                if (numValueOf.intValue() > iA02 - 1) {
                                                                    try {
                                                                        try {
                                                                            A0D(string);
                                                                            i++;
                                                                        } catch (IOException e4) {
                                                                            e = e4;
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                            if (bufferedReader != null) {
                                                                                bufferedReader.close();
                                                                            }
                                                                            if (inputStreamReader != null) {
                                                                                inputStreamReader.close();
                                                                            }
                                                                            if (fileInputStreamOpenFileInput != null) {
                                                                                fileInputStreamOpenFileInput.close();
                                                                            }
                                                                            if (fileOutputStreamOpenFileOutput != null) {
                                                                                fileOutputStreamOpenFileOutput.close();
                                                                            }
                                                                            if (fileInputStreamOpenFileInput2 != null) {
                                                                                fileInputStreamOpenFileInput2.close();
                                                                            }
                                                                            if (fileOutputStreamOpenFileOutput2 != null) {
                                                                                fileOutputStreamOpenFileOutput2.close();
                                                                            }
                                                                            A06.clear();
                                                                            A05.clear();
                                                                            throw th;
                                                                        }
                                                                    } catch (JSONException e5) {
                                                                        e = e5;
                                                                        if (c7s.A04().A8o()) {
                                                                            Log.e(A04, A02(153, 36, 7), e);
                                                                        }
                                                                    }
                                                                }
                                                            } catch (IOException e6) {
                                                                e = e6;
                                                            } catch (JSONException e7) {
                                                                e = e7;
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                if (bufferedReader != null) {
                                                                    bufferedReader.close();
                                                                }
                                                                if (inputStreamReader != null) {
                                                                    inputStreamReader.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput != null) {
                                                                    fileInputStreamOpenFileInput.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput != null) {
                                                                    fileOutputStreamOpenFileOutput.close();
                                                                }
                                                                if (fileInputStreamOpenFileInput2 != null) {
                                                                    fileInputStreamOpenFileInput2.close();
                                                                }
                                                                if (fileOutputStreamOpenFileOutput2 != null) {
                                                                    fileOutputStreamOpenFileOutput2.close();
                                                                }
                                                                A06.clear();
                                                                A05.clear();
                                                                throw th;
                                                            }
                                                        }
                                                        jSONObject.put(A02(260, 7, 27), String.valueOf(numValueOf));
                                                        fileOutputStreamOpenFileOutput2.write((jSONObject.toString() + '\n').getBytes());
                                                    } catch (IOException e8) {
                                                        e = e8;
                                                    } catch (JSONException e9) {
                                                        e = e9;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                    }
                                                } else {
                                                    fileOutputStreamOpenFileOutput2.write((jSONObject.toString() + '\n').getBytes());
                                                }
                                            }
                                        } catch (JSONException e10) {
                                            e = e10;
                                        }
                                    } catch (IOException e11) {
                                        e = e11;
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                    c7s.A07().A3Y(e);
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e12) {
                                            c7s.A07().A3Y(e12);
                                        }
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (fileInputStreamOpenFileInput != null) {
                                        fileInputStreamOpenFileInput.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput != null) {
                                        fileOutputStreamOpenFileOutput.close();
                                    }
                                    if (fileInputStreamOpenFileInput2 != null) {
                                        fileInputStreamOpenFileInput2.close();
                                    }
                                    if (fileOutputStreamOpenFileOutput2 != null) {
                                        fileOutputStreamOpenFileOutput2.close();
                                    }
                                    A06.clear();
                                    A05.clear();
                                    return false;
                                }
                                fileInputStreamOpenFileInput2 = c7s.openFileInput(str);
                                fileOutputStreamOpenFileOutput = c7s.openFileOutput(processSpecificName, 0);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = fileInputStreamOpenFileInput2.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    }
                                    fileOutputStreamOpenFileOutput.write(bArr, 0, i2);
                                }
                                fileInputStreamOpenFileInput2.close();
                                fileOutputStreamOpenFileOutput2.close();
                                A0A(c7s, str);
                            } catch (IOException e13) {
                                e = e13;
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (IOException e14) {
                            e = e14;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                    A09(c7s, A00(c7s));
                    if (i > 0) {
                        c7s.A07().A9M(A02(271, 10, 103), C07597x.A2V, new C07607y(A02(138, 15, 64), A02(367, 16, 102) + i));
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e15) {
                            c7s.A07().A3Y(e15);
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                    if (fileInputStreamOpenFileInput2 != null) {
                        fileInputStreamOpenFileInput2.close();
                    }
                    if (fileOutputStreamOpenFileOutput2 != null) {
                        fileOutputStreamOpenFileOutput2.close();
                    }
                    A06.clear();
                    A05.clear();
                    return true;
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (IOException e16) {
                e = e16;
            }
        }
    }

    static {
        A06();
        A04 = C07617z.class.getName();
        A03 = new Object();
        A06 = Collections.synchronizedSet(new HashSet());
        A05 = Collections.synchronizedMap(new HashMap());
        A00 = new AtomicInteger();
    }

    public static int A00(Context context) {
        return context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0).getInt(A02(75, 10, 19), 0) - A06.size();
    }

    public static JSONArray A03(C7S c7s) {
        return A04(c7s, -1);
    }

    public static JSONObject A05(AnonymousClass81 anonymousClass81) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A02(343, 2, 126), UUID.randomUUID().toString());
        jSONObject.put(A02(TTAdConstant.LANDING_PAGE_TYPE_CODE, 4, 93), anonymousClass81.A03());
        jSONObject.put(A02(TTAdConstant.AD_ID_IS_NULL_CODE, 4, WorkQueueKt.MASK), LM.A02(anonymousClass81.A01()));
        jSONObject.put(A02(355, 12, 71), LM.A02(anonymousClass81.A00()));
        jSONObject.put(A02(345, 10, 113), anonymousClass81.A02());
        jSONObject.put(A02(267, 4, 64), anonymousClass81.A04() != null ? new JSONObject(anonymousClass81.A04()) : new JSONObject());
        jSONObject.put(A02(260, 7, 27), String.valueOf(0));
        return jSONObject;
    }

    public static void A07(Context context) {
        synchronized (A03) {
            File debugFile = new File(context.getFilesDir(), ProcessUtils.getProcessSpecificName(A02(281, 9, 51), context));
            if (debugFile.exists()) {
                debugFile.delete();
            }
            A09(context, 0);
            A06.clear();
            A05.clear();
        }
    }

    public static void A08(Context context) {
        A09(context, context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0).getInt(A02(75, 10, 19), 0) + 1);
    }

    public static void A09(Context context, int i) {
        int i2 = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(ProcessUtils.getProcessSpecificName(A02(65, 10, 79), context), 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (i >= 0) {
            i2 = i;
        }
        editorEdit.putInt(A02(75, 10, 19), i2).apply();
    }

    public static void A0A(C7S c7s, String str) {
        File file = new File(c7s.getFilesDir(), str);
        if (file.exists() && !file.delete()) {
            c7s.A07().A3Y(new RuntimeException(A02(47, 18, 49)));
        }
    }

    public static void A0B(Y9 y9, String str) {
        Map<String, Integer> map = A05;
        Integer num = map.get(str);
        if (num == null) {
            if (y9.A04().A8o()) {
                Log.e(A04, A02(189, 66, 74));
            }
            num = 0;
        } else {
            map.remove(str);
        }
        map.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public static void A0C(AnonymousClass81 anonymousClass81, C7S c7s) {
        if (anonymousClass81 != null && c7s != null) {
            synchronized (A03) {
                try {
                    String processSpecificName = ProcessUtils.getProcessSpecificName(A02(281, 9, 51), c7s);
                    File file = new File(c7s.getFilesDir(), processSpecificName);
                    if (file.exists()) {
                        int iA07 = IR.A07(c7s);
                        long length = file.length();
                        if (iA07 > 0 && length > iA07) {
                            boolean zDelete = file.delete();
                            A09(c7s, 0);
                            A06.clear();
                            A05.clear();
                            if (zDelete) {
                                Map<String, String> mapA4j = c7s.A03().A4j();
                                mapA4j.put(A02(383, 7, 62), A02(271, 10, 103));
                                mapA4j.put(A02(390, 12, 68), String.valueOf(2401));
                                A01(A02(102, 36, 51) + length + A02(1, 15, 15) + A00.getAndIncrement(), c7s, mapA4j);
                                return;
                            }
                            Log.e(A02(85, 17, 19), A02(16, 31, 0));
                        }
                    }
                    JSONObject jSONObjectA05 = A05(anonymousClass81);
                    FileOutputStream outputStream = c7s.openFileOutput(processSpecificName, 32768);
                    outputStream.write((jSONObjectA05.toString() + A02(0, 1, 113)).getBytes());
                    outputStream.close();
                    A08(c7s);
                } catch (Exception e) {
                    c7s.A07().A3Y(e);
                }
            }
        }
    }

    public static void A0D(String str) {
        A05.remove(str);
        A06.add(str);
    }

    public static void A0E(String str, int i) {
        if (!A06.contains(str)) {
            Map<String, Integer> map = A05;
            boolean zContainsKey = map.containsKey(str);
            if (A02[7].charAt(23) == 'F') {
                throw new RuntimeException();
            }
            A02[6] = "rEqe91lv7lznGuMpeMm8YlOivWfc8wjs";
            if (zContainsKey) {
                map.remove(str);
            }
            map.put(str, Integer.valueOf(i));
            return;
        }
        throw new RuntimeException(A02(290, 53, 65));
    }

    public static boolean A0F(C7S c7s) {
        if (IR.A0O(c7s)) {
            return A0H(c7s);
        }
        boolean zA0G = A0G(c7s);
        String[] strArr = A02;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "3ABJ1YchwKShiC4YrWnTlA0erUDCQvCN";
        strArr2[1] = "wuaZskSkctYpKQ1vHIoiu3NDqUJM9HRQ";
        return zA0G;
    }

    public static boolean A0I(String str) {
        return A06.contains(str) || A05.containsKey(str);
    }
}
