package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V0 implements InterfaceC0951Gc {
    public static byte[] A0L;
    public static String[] A0M = {"BZiYu5nwNf87X3b9kN", "UgTeeMN2jxyMd9Kylf", "PJ", "CPqLt3pCFfCSwfi", "XN4Dvc1", "tWEaaCCiJhgiXtacO5se5vgeqa", "S002dfR", "J7ycXdK5d"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public InterfaceC0951Gc A07;
    public H6 A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC0951Gc A0D;
    public final InterfaceC0951Gc A0E;
    public final InterfaceC0951Gc A0F;
    public final H2 A0G;
    public final H4 A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0L = new byte[]{-92, -93, 120, -106, -104, -99, -102, -103, 119, -82, -87, -102, -88, -121, -102, -106, -103};
    }

    static {
        A06();
    }

    public V0(H2 h2, InterfaceC0951Gc interfaceC0951Gc, InterfaceC0951Gc interfaceC0951Gc2, InterfaceC0949Ga interfaceC0949Ga, int i, H4 h4) {
        this.A0G = h2;
        this.A0D = interfaceC0951Gc2;
        this.A0I = (i & 1) != 0;
        this.A0K = (i & 2) != 0;
        this.A0J = (i & 4) != 0;
        this.A0F = interfaceC0951Gc;
        if (interfaceC0949Ga != null) {
            this.A0E = new V3(interfaceC0951Gc, interfaceC0949Ga);
        } else {
            this.A0E = null;
        }
        this.A0H = h4;
    }

    private int A00(C0955Gg c0955Gg) {
        if (this.A0K) {
            boolean z = this.A0C;
            String[] strArr = A0M;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[3] = "r97zDVaaptRGknr";
            strArr2[6] = "AimjfMN";
            if (z) {
                if (A0M[7].length() != 14) {
                    A0M[7] = "lgdHkpCnxjAeRqVRog4eGXXV3TVVS";
                    return 0;
                }
                A0M[4] = "GvTYan8nqvP";
                return 0;
            }
        }
        if (this.A0J && c0955Gg.A02 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(H2 h2, String str, Uri uri) {
        HC contentMetadata = h2.A6R(str);
        Uri uriA01 = HD.A01(contentMetadata);
        return uriA01 == null ? uri : uriA01;
    }

    private void A03() throws IOException {
        InterfaceC0951Gc interfaceC0951Gc = this.A07;
        if (interfaceC0951Gc == null) {
            return;
        }
        try {
            interfaceC0951Gc.close();
            this.A07 = null;
            this.A0A = false;
            H6 h6 = this.A08;
            if (A0M[5].length() != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A0M;
            strArr[3] = "f78PdfdQFRIsoy9";
            strArr[6] = "Xl8bArW";
            if (h6 != null) {
                this.A0G.AES(h6);
                this.A08 = null;
            }
        } catch (Throwable th) {
            this.A07 = null;
            this.A0A = false;
            H6 h7 = this.A08;
            if (h7 != null) {
                this.A0G.AES(h7);
                this.A08 = null;
            }
            throw th;
        }
    }

    private void A04() {
        if (this.A0H != null && this.A04 > 0) {
            this.A0G.A6A();
            throw new NullPointerException(A02(0, 17, 18));
        }
    }

    private void A05() throws IOException {
        this.A01 = 0L;
        if (A0C()) {
            this.A0G.AFD(this.A09, this.A03);
        }
    }

    private void A07(IOException iOException) {
        if (A0A() || (iOException instanceof H0)) {
            this.A0C = true;
        }
    }

    private void A08(boolean z) throws IOException {
        H6 h6AFk;
        long jMin;
        C0955Gg c0955Gg;
        InterfaceC0951Gc nextDataSource;
        long j;
        if (this.A0B) {
            h6AFk = null;
        } else if (this.A0I) {
            try {
                h6AFk = this.A0G.AFk(this.A09, this.A03);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            h6AFk = this.A0G.AFl(this.A09, this.A03);
        }
        if (h6AFk == null) {
            nextDataSource = this.A0F;
            c0955Gg = new C0955Gg(this.A06, this.A03, this.A01, this.A09, this.A00);
        } else if (h6AFk.A05) {
            Uri uriFromFile = Uri.fromFile(h6AFk.A03);
            long filePosition = this.A03 - h6AFk.A02;
            long length = h6AFk.A01 - filePosition;
            long j2 = this.A01;
            if (j2 != -1) {
                length = Math.min(length, j2);
            }
            c0955Gg = new C0955Gg(uriFromFile, this.A03, filePosition, length, this.A09, this.A00);
            nextDataSource = this.A0D;
        } else {
            if (h6AFk.A02()) {
                jMin = this.A01;
            } else {
                jMin = h6AFk.A01;
                long length2 = this.A01;
                if (length2 != -1) {
                    jMin = Math.min(jMin, length2);
                }
            }
            c0955Gg = new C0955Gg(this.A06, this.A03, jMin, this.A09, this.A00);
            if (this.A0E != null) {
                nextDataSource = this.A0E;
            } else {
                nextDataSource = this.A0F;
                this.A0G.AES(h6AFk);
                h6AFk = null;
            }
        }
        if (!this.A0B && nextDataSource == this.A0F) {
            j = this.A03 + 102400;
        } else {
            j = Long.MAX_VALUE;
        }
        this.A02 = j;
        if (z) {
            HI.A04(A09());
            if (nextDataSource == this.A0F) {
                return;
            }
            try {
                A03();
            } catch (Throwable th) {
                if (h6AFk.A01()) {
                    this.A0G.AES(h6AFk);
                }
                throw th;
            }
        }
        if (h6AFk != null && h6AFk.A01()) {
            this.A08 = h6AFk;
        }
        this.A07 = nextDataSource;
        this.A0A = c0955Gg.A02 == -1;
        long jADb = nextDataSource.ADb(c0955Gg);
        HE he = new HE();
        if (this.A0A) {
            if (A0M[2].length() != 2) {
                throw new RuntimeException();
            }
            A0M[7] = "GQ8HbidAJ3";
            if (jADb != -1) {
                this.A01 = jADb;
                HD.A05(he, this.A03 + jADb);
            }
        }
        if (A0B()) {
            Uri uriA85 = this.A07.A85();
            this.A05 = uriA85;
            if (true ^ this.A06.equals(uriA85)) {
                Uri uri = this.A05;
                if (A0M[5].length() != 26) {
                    HD.A06(he, uri);
                } else {
                    A0M[4] = "mDcPGOd9V6d2O";
                    HD.A06(he, uri);
                }
            } else {
                HD.A04(he);
            }
        }
        if (A0C()) {
            this.A0G.A3W(this.A09, he);
        }
    }

    private boolean A09() {
        return this.A07 == this.A0F;
    }

    private boolean A0A() {
        return this.A07 == this.A0D;
    }

    private boolean A0B() {
        return !A0A();
    }

    private boolean A0C() {
        return this.A07 == this.A0E;
    }

    public static boolean A0D(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof C0952Gd) && ((C0952Gd) cause).A00 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final Uri A85() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final long ADb(C0955Gg c0955Gg) throws IOException {
        try {
            this.A09 = H8.A02(c0955Gg);
            Uri uri = c0955Gg.A04;
            this.A06 = uri;
            this.A05 = A01(this.A0G, this.A09, uri);
            this.A00 = c0955Gg.A00;
            this.A03 = c0955Gg.A03;
            this.A0B = A00(c0955Gg) != -1;
            if (c0955Gg.A02 != -1 || this.A0B) {
                this.A01 = c0955Gg.A02;
            } else {
                long jA6Q = this.A0G.A6Q(this.A09);
                this.A01 = jA6Q;
                if (jA6Q != -1) {
                    long j = jA6Q - c0955Gg.A03;
                    this.A01 = j;
                    if (j <= 0) {
                        throw new C0952Gd(0);
                    }
                }
            }
            A08(false);
            return this.A01;
        } catch (IOException e) {
            A07(e);
            throw e;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A04();
        try {
            A03();
        } catch (IOException e) {
            A07(e);
            throw e;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0951Gc
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            if (this.A03 >= this.A02) {
                A08(true);
            }
            int i3 = this.A07.read(bArr, i, i2);
            if (i3 != -1) {
                if (A0A()) {
                    this.A04 += (long) i3;
                }
                this.A03 += (long) i3;
                long j = this.A01;
                if (j != -1) {
                    this.A01 = j - ((long) i3);
                }
            } else if (this.A0A) {
                A05();
            } else {
                long j2 = this.A01;
                if (j2 <= 0) {
                    if (j2 == -1) {
                    }
                }
                A03();
                A08(false);
                return read(bArr, i, i2);
            }
            return i3;
        } catch (IOException e) {
            if (this.A0A && A0D(e)) {
                A05();
                return -1;
            }
            A07(e);
            throw e;
        }
    }
}
