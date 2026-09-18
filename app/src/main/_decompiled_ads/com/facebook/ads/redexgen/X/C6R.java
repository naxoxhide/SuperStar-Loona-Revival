package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6R {
    public static byte[] A02;
    public static String[] A03 = {"xEW9LSpkxtcMkiVkCjWXuTu5CJHPJiyq", "tTP", "A", "dhAFlm3SiPB0s9864OvgcmZEVzRtwwmX", "mnE9bSEHBlleLkXo6La2W5bpkmZqSUyN", "0jwmHWkFqK", "xBcWrb6s57BN1yke0uYkFqIHC7aAgPEb", "dL0KwaEpZdlIbw3ka3MpOkzONR5qkJY2"};
    public static final String A04;
    public static volatile C6R A05;
    public final Y9 A00;
    public final Map<String, C6O> A01 = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private Bitmap A02(C7S c7s, C6O c6o, String str) throws Throwable {
        Bitmap bitmapA01;
        String str2 = c6o.A07;
        int i = c6o.A03;
        int i2 = c6o.A04;
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOException e = null;
        String strA08 = A08(223, 9, 70);
        boolean zStartsWith = str2.startsWith(strA08);
        String strA09 = A08(239, 22, 123);
        if (zStartsWith || str2.startsWith(strA09)) {
            String strSubstring = str2.startsWith(strA08) ? str2.substring(strA08.length()) : str2.substring(strA09.length());
            InputStream inputStreamOpen = null;
            try {
                try {
                    inputStreamOpen = this.A00.getAssets().open(strSubstring);
                    if (A0C(i, i2)) {
                        try {
                            bitmapA01 = C6V.A01(inputStreamOpen, i, i2);
                        } catch (IOException e2) {
                            e = e2;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            A0B(e);
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStreamOpen != null) {
                                A0A(inputStreamOpen);
                            }
                            throw th;
                        }
                    } else {
                        bitmapA01 = BitmapFactory.decodeStream(inputStreamOpen);
                    }
                    if (inputStreamOpen != null) {
                        A0A(inputStreamOpen);
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            boolean zA0C = A0C(i, i2);
            if (A03[2].length() == 5) {
                throw new RuntimeException();
            }
            A03[3] = "EtuvklQgZLPMp8CYh3QQVMKsyyqrprqR";
            if (zA0C) {
                try {
                    bitmapA01 = A05(str2, i, i2);
                } catch (IOException e6) {
                    e = e6;
                    A0B(e);
                    bitmapA01 = A03(str2);
                }
            } else {
                bitmapA01 = A03(str2);
            }
        }
        String string = e != null ? e.toString() : null;
        if (bitmapA01 == null) {
            C6T.A03(c7s, c6o, str, C6T.A03, string, null, null);
            return null;
        }
        long jA00 = A00(str2, bitmapA01);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA00 > 0) {
            C6T.A03(c7s, c6o, str, C6T.A02, string, Long.valueOf(jA00), Long.valueOf(jCurrentTimeMillis2));
            return bitmapA01;
        }
        C6T.A03(c7s, c6o, str, C6T.A01, string, null, null);
        if (IP.A0u(c7s)) {
            return null;
        }
        return bitmapA01;
    }

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{97, 102, 34, 124, 98, 107, 68, 103, 98, 38, 105, 115, 114, 118, 115, 114, 38, 98, 99, 117, 114, 111, 104, 103, 114, 111, 105, 104, 38, 46, 96, 111, 106, 99, 59, 26, 49, 44, 53, 57, 40, 120, 43, 49, 34, Base64.padSymbol, 120, Base64.padSymbol, 32, 59, Base64.padSymbol, Base64.padSymbol, 60, 43, 120, 53, 57, 32, 120, 43, 49, 34, Base64.padSymbol, 120, 62, 55, 42, 120, 43, 44, 55, 42, 57, 63, Base64.padSymbol, 98, 120, 103, 69, 71, 76, 65, 4, 65, 86, 86, 75, 86, 10, 4, 102, 77, 80, 73, 69, 84, 4, 77, 87, 4, 74, 81, 72, 72, 10, 57, 30, 22, 19, 26, 27, 95, 11, 16, 95, 28, 16, 15, 6, 95, 19, 16, 28, 30, 19, 95, 22, 18, 30, 24, 26, 95, 22, 17, 11, 16, 95, 28, 30, 28, 23, 26, 95, 87, 10, 13, 19, 66, 53, 14, 1, 2, 12, 5, SignedBytes.MAX_POWER_OF_TWO, 20, 15, SignedBytes.MAX_POWER_OF_TWO, 23, 18, 9, 20, 5, SignedBytes.MAX_POWER_OF_TWO, 2, 9, 20, 13, 1, 16, SignedBytes.MAX_POWER_OF_TWO, 20, 15, SignedBytes.MAX_POWER_OF_TWO, 6, 9, 12, 5, SignedBytes.MAX_POWER_OF_TWO, 72, 21, 18, 12, 93, 80, 107, 100, 103, 105, 96, 37, 113, 106, 37, 114, 119, 108, 113, 96, 37, 103, 108, 113, 104, 100, 117, 37, 113, 106, 37, 106, 112, 113, 117, 112, 113, 37, 118, 113, 119, 96, 100, 104, 126, 108, 108, 122, 107, 37, 48, 48, 48, 63, 48, 53, 60, 99, 118, 118, 68, 75, 78, 71, 24, 13, 13, 13, 67, 76, 70, 80, 77, 75, 70, 125, 67, 81, 81, 71, 86, 13, 27, 31, 19, 21, 23, 0, 3, 13, 8, 77, 86, 83, 86, 87, 79, 86};
    }

    static {
        A09();
        A04 = C6R.class.getSimpleName();
    }

    public C6R(Y9 y9) {
        this.A00 = y9;
    }

    private int A00(String str, Bitmap bitmap) {
        String strA08 = A08(0, 2, 17);
        if (bitmap == null) {
            A0B(null);
            return 0;
        }
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        try {
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    int size = byteArrayOutputStream.size();
                    if (size >= IP.A0F(this.A00)) {
                        A0B(new Throwable(A08(35, 42, 1) + size));
                        A0A(byteArrayOutputStream);
                        A0A(null);
                        return 0;
                    }
                    FileOutputStream fOut = new FileOutputStream(file);
                    byteArrayOutputStream.writeTo(fOut);
                    fOut.flush();
                    A0A(byteArrayOutputStream);
                    A0A(fOut);
                    return size;
                } catch (FileNotFoundException e) {
                    Log.e(A04, A08(6, 29, 95) + file.getPath() + strA08, e);
                    A0B(e);
                    A0A(null);
                    A0A(null);
                    return 0;
                } catch (IOException e2) {
                    A0B(e2);
                    Log.e(A04, A08(148, 36, 57) + str + strA08, e2);
                    A0A(null);
                    A0A(null);
                    return 0;
                }
            } catch (OutOfMemoryError e3) {
                A0B(e3);
                Log.e(A04, A08(184, 39, 92), e3);
                A0A(null);
                A0A(null);
                if (A03[2].length() == 5) {
                    throw new RuntimeException();
                }
                A03[5] = "QxsbBUkJdqjFKv7NMRisOUwCFhjpKYpW";
                return 0;
            }
        } catch (Throwable th) {
            A0A(null);
            A0A(null);
            throw th;
        }
    }

    private final Bitmap A01(C7S c7s, C6O c6o, int i, int i2, String str) {
        if (C6T.A06(c7s) && A08(266, 4, 53).equals(str)) {
            Map<String, C6O> map = this.A01;
            if (A03[4].charAt(4) != 'b') {
                throw new RuntimeException();
            }
            A03[1] = "FHlvPh";
            map.put(c6o.A07, c6o);
        }
        String str2 = c6o.A07;
        C6S c6s = new C6S(c6o.A05, c6o.A06, A08(261, 5, 43), str, str2);
        File fileA07 = A07(this.A00);
        StringBuilder sbAppend = new StringBuilder().append(str2.hashCode());
        String url = A08(2, 4, 85);
        File file = new File(fileA07, sbAppend.append(url).toString());
        if (!file.exists()) {
            C6T.A04(c7s, c6s, false);
            String url2 = A08(232, 7, 0);
            if (str2.startsWith(url2)) {
                String url3 = A08(239, 22, 123);
                if (!str2.startsWith(url3)) {
                    return A04(str2, i2, i);
                }
            }
            return A02(c7s, c6o, str);
        }
        C6T.A04(c7s, c6s, true);
        try {
            if (A0C(i2, i)) {
                return C6V.A02(file.getCanonicalPath(), i2, i, this.A00);
            }
            String url4 = file.getCanonicalPath();
            return BitmapFactory.decodeFile(url4);
        } catch (IOException e) {
            A0B(e);
            return null;
        }
    }

    private Bitmap A03(String str) {
        byte[] bytes;
        InterfaceC1208Qg interfaceC1208QgADo = C1227Qz.A00(this.A00).ADo(str, new C1223Qv());
        if (interfaceC1208QgADo != null && (bytes = interfaceC1208QgADo.A63()) != null) {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        return null;
    }

    private Bitmap A04(String str, int i, int i2) {
        Bitmap bitmapA02;
        try {
            boolean zA0C = A0C(i, i2);
            String strA08 = A08(232, 7, 0);
            if (!zA0C) {
                bitmapA02 = BitmapFactory.decodeStream(new FileInputStream(str.substring(strA08.length())), null, null);
            } else {
                bitmapA02 = C6V.A02(str.substring(strA08.length()), i, i2, this.A00);
            }
            int iA00 = A00(str, bitmapA02);
            if (IP.A0u(this.A00) && iA00 <= 0) {
                return null;
            }
            return bitmapA02;
        } catch (IOException e) {
            Log.e(A04, A08(105, 43, 38) + str + A08(0, 2, 17), e);
        }
    }

    private Bitmap A05(String str, int i, int i2) throws IOException {
        URL urlObj = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        Bitmap bitmapA01 = C6V.A01(inputStream, i, i2);
        A0A(inputStream);
        return bitmapA01;
    }

    public static C6R A06(Y9 y9) {
        if (A05 == null) {
            synchronized (C6R.class) {
                if (A05 == null) {
                    A05 = new C6R(y9);
                }
            }
        }
        return A05;
    }

    public static File A07(C7S c7s) {
        return c7s.getCacheDir();
    }

    public static void A0A(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    private void A0B(Throwable th) {
        String strA08 = A08(261, 5, 43);
        if (th != null) {
            this.A00.A07().A9M(strA08, C07597x.A1e, new C07607y(th));
        } else {
            this.A00.A07().A9M(strA08, C07597x.A1e, new C07607y(A08(77, 28, 125)));
        }
    }

    private boolean A0C(int i, int i2) {
        return i > 0 && i2 > 0 && IP.A1B(this.A00);
    }

    public final Bitmap A0D(C6O c6o) {
        return A01(this.A00, c6o, c6o.A04, c6o.A03, c6o.A01);
    }

    public final Bitmap A0E(C7S c7s, String str, int i, int i2, String str2) {
        C6O c6o = this.A01.get(str);
        return (!C6T.A06(c7s) || c6o == null) ? A01(c7s, new C6O(str, i, i2, A08(270, 7, 97), A08(270, 7, 97)), i2, i, str2) : A01(c7s, c6o, i2, i, str2);
    }

    public final File A0F(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public final String A0G(String str) {
        File file = new File(A07(this.A00), str.hashCode() + A08(2, 4, 85));
        return file.exists() ? file.getPath() : str;
    }
}
