package com.facebook.ads.redexgen.X;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XL implements AW {
    public static boolean A0p;
    public static boolean A0q;
    public static byte[] A0r;
    public static String[] A0s = {"hUCCDXcY4t01difYD4QJmSlSRe7RVS9F", "yHOnf8lHgEM0FI0EKX1KbB3TaozNa", "kXByBOPR65DToxooqsu0gGt9HKAYl4Vo", "NIkyagP1AzDGImvyfrRhWneTEqqmK", "aXPRHAu0VDe5efXXlwPVbrYy41", "xYrm6yKJij65q9D2CisZETvgfz", "Fi2DTXQipqprJDEroL63LN5SWS4FAMqA", "8o6UBOAn3xAy4ZEKn0SjK2UR42QgxF0P"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public AudioTrack A0M;
    public AudioTrack A0N;
    public C07929f A0O;
    public C07929f A0P;
    public AB A0Q;
    public AU A0R;
    public ByteBuffer A0S;
    public ByteBuffer A0T;
    public ByteBuffer A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public AJ[] A0d;
    public ByteBuffer[] A0e;
    public final ConditionVariable A0f;
    public final AC A0g;
    public final C0814Ac A0h;
    public final XO A0i;
    public final InterfaceC0817Af A0j;
    public final XF A0k;
    public final ArrayDeque<C0819Ah> A0l;
    public final boolean A0m;
    public final AJ[] A0n;
    public final AJ[] A0o;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private AudioTrack A0F(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    public static String A0I(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0r, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0O() {
        A0r = new byte[]{33, 45, 106, 98, 121, 45, 82, 102, 119, 122, 124, 71, 97, 114, 112, 120, 47, 2, 24, 8, 4, 5, 31, 2, 5, 30, 2, 31, 18, 75, 15, 14, 31, 14, 8, 31, 14, 15, 75, 48, 14, 19, 27, 14, 8, 31, 14, 15, 75, 33, 57, 38, 43, 38, 46, 78, 121, 111, 121, 104, 104, 117, 114, 123, 60, 111, 104, 125, 112, 112, 121, 120, 60, 125, 105, 120, 117, 115, 60, 104, 110, 125, 127, 119, 46, 21, 30, 3, 11, 30, 24, 15, 30, 31, 91, 26, 14, 31, 18, 20, 91, 30, 21, 24, 20, 31, 18, 21, 28, 65, 91, 58, 1, 28, 26, 31, 31, 0, 29, 27, 10, 11, 79, 12, 7, 14, 1, 1, 10, 3, 79, 12, 0, 26, 1, 27, 85, 79, 24, 121, 112, 108, 107, 122, 109, 41, 58, 40, 58};
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0147  */
    /* JADX WARN: Code duplicated, block: B:78:0x014b A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d3, code lost:
    
        if (r6 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d6, code lost:
    
        r4 = r9.A08;
        r3 = com.facebook.ads.redexgen.X.XL.A0s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01e9, code lost:
    
        if (r3[2].charAt(5) == r3[7].charAt(5)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f0, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f1, code lost:
    
        r3 = com.facebook.ads.redexgen.X.XL.A0s;
        r3[4] = "14nowEFL6Yk6bTHhGEAerIHyFS";
        r3[5] = "whsLbLpoTkO7JKoY0ylMAK08jN";
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fe, code lost:
    
        if (r4 == 5) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0201, code lost:
    
        if (r4 != 6) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0203, code lost:
    
        r9.A02 = 20480;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x020a, code lost:
    
        if (r4 != 7) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x020c, code lost:
    
        r9.A02 = 49152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0213, code lost:
    
        r9.A02 = 294912;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0192, code lost:
    
        if (r6 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0194, code lost:
    
        r3 = android.media.AudioTrack.getMinBufferSize(r12, r5, r9.A08);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x019b, code lost:
    
        if (r3 == (-2)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019d, code lost:
    
        com.facebook.ads.redexgen.X.HI.A04(r4);
        r9.A02 = com.facebook.ads.redexgen.X.C0996Hx.A06(r3 * 4, ((int) A07(250000)) * r9.A09, (int) java.lang.Math.max(r3, A07(750000) * ((long) r9.A09)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01c5, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.X.AW
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A4M(int r10, int r11, int r12, int r13, int[] r14, int r15, int r16) throws com.facebook.ads.redexgen.X.AS {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XL.A4M(int, int, int, int, int[], int, int):void");
    }

    static {
        A0O();
        A0p = false;
        A0q = false;
    }

    public XL(AC ac, InterfaceC0817Af interfaceC0817Af, boolean z) {
        this.A0g = ac;
        this.A0j = (InterfaceC0817Af) HI.A01(interfaceC0817Af);
        this.A0m = z;
        this.A0f = new ConditionVariable(true);
        this.A0h = new C0814Ac(new XM(this, null));
        XO xo = new XO();
        this.A0i = xo;
        XF xf = new XF();
        this.A0k = xf;
        ArrayList<AudioProcessor> toIntPcmAudioProcessors = new ArrayList<>();
        Collections.addAll(toIntPcmAudioProcessors, new XI(), xo, xf);
        Collections.addAll(toIntPcmAudioProcessors, interfaceC0817Af.A5z());
        this.A0o = (AJ[]) toIntPcmAudioProcessors.toArray(new AJ[toIntPcmAudioProcessors.size()]);
        this.A0n = new AJ[]{new XK()};
        this.A00 = 1.0f;
        this.A0D = 0;
        this.A0Q = AB.A04;
        this.A01 = 0;
        this.A0P = C07929f.A04;
        this.A04 = -1;
        this.A0d = new AJ[0];
        this.A0e = new ByteBuffer[0];
        this.A0l = new ArrayDeque<>();
    }

    public XL(AC ac, AJ[] ajArr) {
        this(ac, ajArr, false);
    }

    public XL(AC ac, AJ[] ajArr, boolean z) {
        this(ac, new XN(ajArr), z);
    }

    public static int A00(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return C0821Aj.A00(byteBuffer);
        }
        if (i == 5) {
            return A8.A00();
        }
        if (i == 6) {
            int iA03 = A8.A03(byteBuffer);
            String[] strArr = A0s;
            if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[4] = "kQJQgIYBfsXVI0BXiDfXFh8Y0v";
            strArr2[5] = "xmKGBElaJ1P1UFLQWjzE2KvoVx";
            return iA03;
        }
        if (i == 14) {
            int iA02 = A8.A02(byteBuffer);
            if (iA02 == -1) {
                return 0;
            }
            int syncframeOffset = A8.A04(byteBuffer, iA02);
            return syncframeOffset * 16;
        }
        throw new IllegalStateException(A0I(84, 27, 113) + i);
    }

    public static int A01(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int A02(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.A0S == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.A0S = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.A0S.putInt(1431633921);
        }
        if (this.A03 == 0) {
            this.A0S.putInt(4, i);
            this.A0S.putLong(8, 1000 * j);
            this.A0S.position(0);
            this.A03 = i;
        }
        int iRemaining = this.A0S.remaining();
        String[] strArr = A0s;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "ZxHEhXNaRaOeicOuVS0y7eKtBmJV15x7";
        strArr2[0] = "lpmrRXkhPpBf5A8LovnLhyOg75mNhzFm";
        if (iRemaining > 0) {
            int avSyncHeaderBytesRemaining = audioTrack.write(this.A0S, iRemaining, 1);
            if (avSyncHeaderBytesRemaining < 0) {
                this.A03 = 0;
                return avSyncHeaderBytesRemaining;
            }
            if (avSyncHeaderBytesRemaining < iRemaining) {
                return 0;
            }
        }
        int iA01 = A01(audioTrack, byteBuffer, i);
        if (iA01 < 0) {
            this.A03 = 0;
            String[] strArr3 = A0s;
            String str = strArr3[6];
            String str2 = strArr3[0];
            int iCharAt = str.charAt(5);
            int avSyncHeaderBytesRemaining2 = str2.charAt(5);
            if (iCharAt != avSyncHeaderBytesRemaining2) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0s;
            strArr4[6] = "98oBXXwj84JUUigMvdtlS6TYqH9EDAiG";
            strArr4[0] = "VyAxkX5UR8Pe4wLdxiezRSIVcQQDizsa";
            return iA01;
        }
        int avSyncHeaderBytesRemaining3 = this.A03;
        this.A03 = avSyncHeaderBytesRemaining3 - iA01;
        return iA01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A0X ? this.A0J / ((long) this.A0B) : this.A0I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A0X ? this.A0L / ((long) this.A09) : this.A0K;
    }

    private long A05(long j) {
        return A08(this.A0j.A7s()) + j;
    }

    private long A06(long j) {
        C0819Ah c0819Ah = null;
        while (!this.A0l.isEmpty()) {
            C0819Ah checkpoint = this.A0l.getFirst();
            if (j < checkpoint.A01) {
                break;
            }
            C0819Ah c0819AhRemove = this.A0l.remove();
            String[] strArr = A0s;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[1] = "EqLX22Mle1kVg1sX5ZT6YkRLc5f35";
            strArr2[3] = "gdY2b1urbXezKivfsFNrjnMWNzK4t";
            c0819Ah = c0819AhRemove;
        }
        if (c0819Ah != null) {
            this.A0P = c0819Ah.A02;
            this.A0G = c0819Ah.A01;
            this.A0F = c0819Ah.A00 - this.A0H;
        }
        if (this.A0P.A01 == 1.0f) {
            return (this.A0F + j) - this.A0G;
        }
        if (this.A0l.isEmpty()) {
            return this.A0F + this.A0j.A7H(j - this.A0G);
        }
        return this.A0F + C0996Hx.A0C(j - this.A0G, this.A0P.A01);
    }

    private long A07(long j) {
        return (((long) this.A0A) * j) / 1000000;
    }

    private long A08(long j) {
        return (1000000 * j) / ((long) this.A0A);
    }

    private long A09(long j) {
        return (1000000 * j) / ((long) this.A06);
    }

    private AudioTrack A0D() {
        AudioAttributes audioAttributesA00;
        if (this.A0b) {
            audioAttributesA00 = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            audioAttributesA00 = this.A0Q.A00();
        }
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.A07).setEncoding(this.A08).setSampleRate(this.A0A).build();
        int audioSessionId = this.A01;
        if (audioSessionId == 0) {
            audioSessionId = 0;
        }
        return new AudioTrack(audioAttributesA00, audioFormatBuild, this.A02, 1, audioSessionId);
    }

    private AudioTrack A0E() throws AT {
        AudioTrack audioTrack;
        if (C0996Hx.A02 >= 21) {
            audioTrack = A0D();
        } else {
            int iA03 = C0996Hx.A03(this.A0Q.A03);
            int streamType = this.A01;
            if (streamType == 0) {
                audioTrack = new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1);
            } else {
                audioTrack = new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1, this.A01);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new AT(state, this.A0A, this.A07, this.A02);
    }

    private void A0J() {
        int i = 0;
        while (true) {
            AJ[] ajArr = this.A0d;
            int i2 = ajArr.length;
            if (i < i2) {
                AJ aj = ajArr[i];
                aj.flush();
                this.A0e[i] = aj.A7O();
                i++;
            } else {
                return;
            }
        }
    }

    private void A0K() throws AT {
        C07929f c07929fA3X;
        this.A0f.block();
        AudioTrack audioTrackA0E = A0E();
        this.A0M = audioTrackA0E;
        int audioSessionId = audioTrackA0E.getAudioSessionId();
        if (A0p && C0996Hx.A02 < 21) {
            AudioTrack audioTrack = this.A0N;
            if (audioTrack != null) {
                int audioSessionId2 = audioTrack.getAudioSessionId();
                if (audioSessionId != audioSessionId2) {
                    A0L();
                }
            }
            if (this.A0N == null) {
                this.A0N = A0F(audioSessionId);
            }
        }
        int audioSessionId3 = this.A01;
        if (audioSessionId3 != audioSessionId) {
            this.A01 = audioSessionId;
            AU au = this.A0R;
            if (au != null) {
                au.AAd(audioSessionId);
            }
        }
        if (this.A0V) {
            c07929fA3X = this.A0j.A3X(this.A0P);
        } else {
            c07929fA3X = C07929f.A04;
        }
        this.A0P = c07929fA3X;
        A0N();
        C0814Ac c0814Ac = this.A0h;
        AudioTrack audioTrack2 = this.A0M;
        int i = this.A08;
        int i2 = this.A09;
        int audioSessionId4 = this.A02;
        c0814Ac.A0G(audioTrack2, i, i2, audioSessionId4);
        A0M();
    }

    private void A0L() {
        if (this.A0N == null) {
            return;
        }
        AudioTrack audioTrack = this.A0N;
        this.A0N = null;
        new C0816Ae(this, audioTrack).start();
    }

    private void A0M() {
        if (!A0U()) {
            return;
        }
        if (C0996Hx.A02 >= 21) {
            A0Q(this.A0M, this.A00);
            return;
        }
        AudioTrack audioTrack = this.A0M;
        String[] strArr = A0s;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[2] = "RUPACOvpiKp7bcWaTWyqVFSR7GtEantX";
        strArr2[7] = "RzQzoOWLdvYkkdkBCtRhC7yU7hWBsadG";
        A0R(audioTrack, this.A00);
    }

    private void A0N() {
        ArrayList arrayList = new ArrayList();
        for (AJ aj : A0V()) {
            if (aj.A8l()) {
                arrayList.add(aj);
            } else {
                aj.flush();
            }
        }
        int count = arrayList.size();
        this.A0d = (AJ[]) arrayList.toArray(new AJ[count]);
        this.A0e = new ByteBuffer[count];
        A0J();
    }

    private void A0P(long j) throws AV {
        ByteBuffer input;
        int length = this.A0d.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                int count = i - 1;
                input = this.A0e[count];
            } else {
                input = this.A0T;
                if (input == null) {
                    input = AJ.A00;
                }
            }
            if (i == length) {
                A0S(input, j);
            } else {
                AJ aj = this.A0d[i];
                aj.AE7(input);
                ByteBuffer byteBufferA7O = aj.A7O();
                this.A0e[i] = byteBufferA7O;
                if (byteBufferA7O.hasRemaining()) {
                    i++;
                }
            }
            boolean zHasRemaining = input.hasRemaining();
            String[] strArr = A0s;
            String str = strArr[4];
            String str2 = strArr[5];
            int index = str.length();
            int count2 = str2.length();
            if (index != count2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "GvJ2yOfBgit1iG3ukbpo3ztMvZtxyKui";
            strArr2[7] = "YNNwMOgGE9szKpvyLkHk1WmQlE5xjnt7";
            if (zHasRemaining) {
                return;
            } else {
                i--;
            }
        }
    }

    public static void A0Q(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    public static void A0R(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c2  */
    private void A0S(ByteBuffer byteBuffer, long j) throws AV {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        ByteBuffer byteBuffer2 = this.A0U;
        String[] strArr = A0s;
        if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[1] = "Y8Mrx0I9TdYWTjTrSbpDFDKjoXuQO";
        strArr2[3] = "wRs1O0frPXGaUer72uaPv4p6RCTih";
        if (byteBuffer2 != null) {
            HI.A03(byteBuffer2 == byteBuffer);
        } else {
            this.A0U = byteBuffer;
            if (C0996Hx.A02 < 21) {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = this.A0c;
                if (bArr != null) {
                    int bytesRemaining = bArr.length;
                    if (bytesRemaining < iRemaining) {
                        this.A0c = new byte[iRemaining];
                    }
                } else {
                    this.A0c = new byte[iRemaining];
                }
                int bytesToWrite = byteBuffer.position();
                byteBuffer.get(this.A0c, 0, iRemaining);
                byteBuffer.position(bytesToWrite);
                this.A0C = 0;
            }
        }
        int iRemaining2 = byteBuffer.remaining();
        int iA01 = 0;
        if (C0996Hx.A02 < 21) {
            int iA0B = this.A0h.A0B(this.A0L);
            if (iA0B > 0) {
                iA01 = this.A0M.write(this.A0c, this.A0C, Math.min(iRemaining2, iA0B));
                if (iA01 > 0) {
                    this.A0C += iA01;
                    byteBuffer.position(byteBuffer.position() + iA01);
                }
            }
        } else if (!this.A0b) {
            iA01 = A01(this.A0M, byteBuffer, iRemaining2);
        } else {
            HI.A04(j != -9223372036854775807L);
            iA01 = A02(this.A0M, byteBuffer, iRemaining2, j);
        }
        this.A0E = SystemClock.elapsedRealtime();
        if (iA01 >= 0) {
            boolean z = this.A0X;
            if (z) {
                this.A0L += (long) iA01;
            }
            if (iA01 == iRemaining2) {
                if (!z) {
                    this.A0K += (long) this.A05;
                }
                this.A0U = null;
                return;
            }
            return;
        }
        throw new AV(iA01);
    }

    private boolean A0T() throws AV {
        boolean z = false;
        if (this.A04 == -1) {
            boolean audioProcessorNeedsEndOfStream = this.A0Z;
            this.A04 = audioProcessorNeedsEndOfStream ? 0 : this.A0d.length;
            z = true;
        }
        while (true) {
            int i = this.A04;
            AJ[] ajArr = this.A0d;
            if (i < ajArr.length) {
                AJ aj = ajArr[i];
                if (z) {
                    aj.AE6();
                }
                A0P(-9223372036854775807L);
                boolean audioProcessorNeedsEndOfStream2 = aj.A8q();
                if (!audioProcessorNeedsEndOfStream2) {
                    return false;
                }
                z = true;
                this.A04++;
            } else {
                ByteBuffer byteBuffer = this.A0U;
                if (byteBuffer != null) {
                    A0S(byteBuffer, -9223372036854775807L);
                    if (this.A0U != null) {
                        return false;
                    }
                }
                this.A04 = -1;
                return true;
            }
        }
    }

    private boolean A0U() {
        return this.A0M != null;
    }

    private AJ[] A0V() {
        if (this.A0a) {
            return this.A0n;
        }
        return this.A0o;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void A54() {
        if (this.A0b) {
            this.A0b = false;
            this.A01 = 0;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void A5R(int i) {
        HI.A04(C0996Hx.A02 >= 21);
        if (this.A0b) {
            int i2 = this.A01;
            String[] strArr = A0s;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "PS7IBOM7NZDOoVGPPjdQOv1dv3IkizxK";
            strArr2[7] = "jjqtzOvKeeqNL4elNx3MZRV4owozeHXU";
            if (i2 == i) {
                return;
            }
        }
        this.A0b = true;
        this.A01 = i;
        reset();
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final long A6Y(boolean z) {
        if (!A0U() || this.A0D == 0) {
            return Long.MIN_VALUE;
        }
        long jA0C = this.A0h.A0C(z);
        long positionUs = A04();
        return this.A0H + A05(A06(Math.min(jA0C, A08(positionUs))));
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final C07929f A7Z() {
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final boolean A8H(ByteBuffer byteBuffer, long j) throws AT, AV {
        ByteBuffer byteBuffer2 = this.A0T;
        HI.A03(byteBuffer2 == null || byteBuffer == byteBuffer2);
        boolean zA0U = A0U();
        String[] strArr = A0s;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "RcCB0XsFwDDOAw3euoH2B524NJP5PtQP";
        strArr2[0] = "S6sRDXDIUBrBns4w0IFsbKHJgfJaiswv";
        if (!zA0U) {
            A0K();
            if (this.A0Y) {
                ADs();
            }
        }
        if (!this.A0h.A0L(A04())) {
            return false;
        }
        ByteBuffer byteBuffer3 = this.A0T;
        String strA0I = A0I(6, 10, 25);
        if (byteBuffer3 == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.A0X && this.A05 == 0) {
                int iA00 = A00(this.A08, byteBuffer);
                this.A05 = iA00;
                if (iA00 == 0) {
                    return true;
                }
            }
            if (this.A0O != null) {
                if (!A0T()) {
                    return false;
                }
                C07929f c07929f = this.A0O;
                this.A0O = null;
                this.A0l.add(new C0819Ah(this.A0j.A3X(c07929f), Math.max(0L, j), A08(A04()), null));
                A0N();
            }
            if (this.A0D == 0) {
                this.A0H = Math.max(0L, j);
                this.A0D = 1;
            } else {
                long expectedPresentationTimeUs = this.A0H + A09(A03());
                if (this.A0D == 1 && Math.abs(expectedPresentationTimeUs - j) > 200000) {
                    Log.e(strA0I, A0I(16, 33, 97) + expectedPresentationTimeUs + A0I(0, 6, 7) + j + A0I(138, 1, 79));
                    this.A0D = 2;
                }
                if (this.A0D == 2) {
                    this.A0H += j - expectedPresentationTimeUs;
                    this.A0D = 1;
                    AU au = this.A0R;
                    if (au != null) {
                        au.ACT();
                    }
                }
            }
            if (this.A0X) {
                this.A0J += (long) byteBuffer.remaining();
            } else {
                this.A0I += (long) this.A05;
            }
            this.A0T = byteBuffer;
        }
        if (!this.A0Z) {
            A0S(this.A0T, j);
        } else {
            A0P(j);
        }
        if (!this.A0T.hasRemaining()) {
            this.A0T = null;
            return true;
        }
        if (this.A0h.A0K(A04())) {
            Log.w(strA0I, A0I(55, 29, 22));
            reset();
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void A8K() {
        if (this.A0D == 1) {
            this.A0D = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final boolean A8P() {
        if (A0U()) {
            boolean zA0J = this.A0h.A0J(A04());
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[4] = "9qaAbWK7Rz0EURQ8gVPoKZJ79p";
            strArr2[5] = "PQsLZF4zdgMsSCMdKk30KO6aPE";
            if (zA0J) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final boolean A8p(int i) {
        if (C0996Hx.A0c(i)) {
            return i != 4 || C0996Hx.A02 >= 21;
        }
        AC ac = this.A0g;
        return ac != null && ac.A04(i);
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final boolean A8q() {
        return !A0U() || (this.A0W && !A8P());
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void ADs() {
        this.A0Y = true;
        if (A0U()) {
            this.A0h.A0E();
            this.A0M.play();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void ADt() throws AV {
        if (!this.A0W && A0U() && A0T()) {
            this.A0h.A0F(A04());
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[1] = "3Beu4rQqJml6K6p71ugtSnl6z4kve";
            strArr2[3] = "vTiWK9GhFZyDb3TQGI4eNztci47gx";
            this.A0M.stop();
            this.A03 = 0;
            this.A0W = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void AEO() {
        reset();
        A0L();
        for (AJ aj : this.A0o) {
            aj.reset();
        }
        for (AJ aj2 : this.A0n) {
            aj2.reset();
        }
        this.A01 = 0;
        this.A0Y = false;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void AF8(AB ab) {
        if (this.A0Q.equals(ab)) {
            return;
        }
        this.A0Q = ab;
        if (this.A0b) {
            return;
        }
        reset();
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void AFJ(AU au) {
        this.A0R = au;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final C07929f AFP(C07929f c07929f) {
        if (A0U() && !this.A0V) {
            C07929f c07929f2 = C07929f.A04;
            this.A0P = c07929f2;
            return c07929f2;
        }
        C07929f c07929f3 = this.A0O;
        String[] strArr = A0s;
        if (strArr[6].charAt(5) != strArr[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[1] = "qknQOXr2sfI1wZbS1fFTxKCHwtwOF";
        strArr2[3] = "6hx8Cx11JAWA8IEiphxLzKnZtiWJj";
        if (c07929f3 == null) {
            if (!this.A0l.isEmpty()) {
                c07929f3 = this.A0l.getLast().A02;
            } else {
                c07929f3 = this.A0P;
            }
        }
        boolean zEquals = c07929f.equals(c07929f3);
        String[] strArr3 = A0s;
        if (strArr3[6].charAt(5) != strArr3[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0s;
        strArr4[4] = "rapNwYGl5aH6wSWwsREtxqAYY9";
        strArr4[5] = "Swk5nrnVyktI66zCHmEiilSuas";
        if (!zEquals) {
            if (A0U()) {
                this.A0O = c07929f;
            } else {
                C07929f lastSetPlaybackParameters = this.A0j.A3X(c07929f);
                this.A0P = lastSetPlaybackParameters;
            }
        }
        C07929f lastSetPlaybackParameters2 = this.A0P;
        return lastSetPlaybackParameters2;
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void pause() {
        this.A0Y = false;
        if (A0U() && this.A0h.A0I()) {
            AudioTrack audioTrack = this.A0M;
            String[] strArr = A0s;
            if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "3LzsBOqgGe30i16a9NIVlDJcub4Z4Vvr";
            strArr2[7] = "hMaFPO8QBdBmzyeIOXtEGbbLXROtxATQ";
            audioTrack.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void reset() {
        if (A0U()) {
            this.A0J = 0L;
            this.A0I = 0L;
            this.A0L = 0L;
            this.A0K = 0L;
            this.A05 = 0;
            C07929f c07929f = this.A0O;
            if (c07929f != null) {
                this.A0P = c07929f;
                String[] strArr = A0s;
                if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0s;
                strArr2[1] = "rnKZk3c8Taby0V4iUj7wGFJub43iz";
                strArr2[3] = "VEk4k7rPnS3kvq1QwagsAStWXQ6pG";
                this.A0O = null;
            } else if (!this.A0l.isEmpty()) {
                this.A0P = this.A0l.getLast().A02;
            }
            this.A0l.clear();
            this.A0F = 0L;
            this.A0G = 0L;
            this.A0T = null;
            this.A0U = null;
            A0J();
            this.A0W = false;
            this.A04 = -1;
            this.A0S = null;
            this.A03 = 0;
            this.A0D = 0;
            if (this.A0h.A0H()) {
                this.A0M.pause();
            }
            AudioTrack audioTrack = this.A0M;
            this.A0M = null;
            this.A0h.A0D();
            this.A0f.close();
            new C0815Ad(this, audioTrack).start();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AW
    public final void setVolume(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            A0M();
        }
    }
}
