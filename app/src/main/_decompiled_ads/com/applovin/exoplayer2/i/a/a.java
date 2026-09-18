package com.applovin.exoplayer2.i.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.i.j;
import com.applovin.exoplayer2.i.k;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    private static final int[] OG = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] OH = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] OI = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] OJ = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] OK = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] OL = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] OM = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] ON = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final int OP;
    private final int OQ;
    private final int OR;
    private final long OS;
    private List<com.applovin.exoplayer2.i.a> OV;
    private List<com.applovin.exoplayer2.i.a> OW;
    private int OX;
    private int OY;
    private boolean OZ;
    private boolean Pa;
    private byte Pb;
    private byte Pc;
    private boolean Pe;
    private long Pf;
    private final y OO = new y();
    private final ArrayList<C0099a> OT = new ArrayList<>();
    private C0099a OU = new C0099a(0, 4);
    private int Pd = 0;

    private static boolean d(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static boolean e(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static boolean g(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean h(byte b2) {
        return (b2 & 224) == 0;
    }

    private static boolean h(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static int i(byte b2) {
        return (b2 >> 3) & 1;
    }

    private static boolean i(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean j(byte b2) {
        return (b2 & 240) == 16;
    }

    private static boolean j(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private static boolean k(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private static boolean l(byte b2) {
        return (b2 & 247) == 20;
    }

    @Override // com.applovin.exoplayer2.i.a.c, com.applovin.exoplayer2.c.d
    public void release() {
    }

    @Override // com.applovin.exoplayer2.i.a.c
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void D(j jVar) throws h {
        super.D(jVar);
    }

    @Override // com.applovin.exoplayer2.i.a.c, com.applovin.exoplayer2.i.g
    public /* bridge */ /* synthetic */ void bd(long j) {
        super.bd(j);
    }

    @Override // com.applovin.exoplayer2.i.a.c
    /* JADX INFO: renamed from: lV */
    public /* bridge */ /* synthetic */ j hc() throws h {
        return super.hc();
    }

    public a(String str, int i, long j) {
        this.OS = j > 0 ? j * 1000 : -9223372036854775807L;
        this.OP = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.OR = 0;
            this.OQ = 0;
        } else if (i == 2) {
            this.OR = 1;
            this.OQ = 0;
        } else if (i == 3) {
            this.OR = 0;
            this.OQ = 1;
        } else if (i == 4) {
            this.OR = 1;
            this.OQ = 1;
        } else {
            q.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.OR = 0;
            this.OQ = 0;
        }
        ek(0);
        mj();
        this.Pe = true;
        this.Pf = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.i.a.c, com.applovin.exoplayer2.c.d
    public void dI() {
        super.dI();
        this.OV = null;
        this.OW = null;
        ek(0);
        el(4);
        mj();
        this.OZ = false;
        this.Pa = false;
        this.Pb = (byte) 0;
        this.Pc = (byte) 0;
        this.Pd = 0;
        this.Pe = true;
        this.Pf = -9223372036854775807L;
    }

    @Override // com.applovin.exoplayer2.i.a.c, com.applovin.exoplayer2.c.d
    /* JADX INFO: renamed from: lW */
    public k hd() throws h {
        k kVarMA;
        k kVarHd = super.hd();
        if (kVarHd != null) {
            return kVarHd;
        }
        if (!mk() || (kVarMA = mA()) == null) {
            return null;
        }
        this.OV = Collections.emptyList();
        this.Pf = -9223372036854775807L;
        kVarMA.a(au(), mh(), Long.MAX_VALUE);
        return kVarMA;
    }

    @Override // com.applovin.exoplayer2.i.a.c
    protected boolean mg() {
        return this.OV != this.OW;
    }

    @Override // com.applovin.exoplayer2.i.a.c
    protected f mh() {
        this.OW = this.OV;
        return new d((List) com.applovin.exoplayer2.l.a.checkNotNull(this.OV));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    @Override // com.applovin.exoplayer2.i.a.c
    protected void b(j jVar) {
        boolean z;
        ByteBuffer byteBuffer = (ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(jVar.rH);
        this.OO.l(byteBuffer.array(), byteBuffer.limit());
        boolean z2 = false;
        while (true) {
            int iPj = this.OO.pj();
            int i = this.OP;
            if (iPj < i) {
                break;
            }
            byte bPo = i == 2 ? (byte) -4 : (byte) this.OO.po();
            int iPo = this.OO.po();
            int iPo2 = this.OO.po();
            if ((bPo & 2) == 0 && (bPo & 1) == this.OQ) {
                byte b2 = (byte) (iPo & WorkQueueKt.MASK);
                byte b3 = (byte) (iPo2 & WorkQueueKt.MASK);
                if (b2 != 0 || b3 != 0) {
                    boolean z3 = this.OZ;
                    if ((bPo & 4) == 4) {
                        boolean[] zArr = ON;
                        if (zArr[iPo] && zArr[iPo2]) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    this.OZ = z;
                    if (!a(z, b2, b3)) {
                        if (this.OZ) {
                            c(b2, b3);
                            if (this.Pe && a(b2)) {
                                if (h(b2)) {
                                    if (d(b2, b3)) {
                                        this.OU.a(e(b3));
                                    } else if (e(b2, b3)) {
                                        this.OU.mm();
                                        this.OU.a(f(b2, b3));
                                    } else if (g(b2, b3)) {
                                        b(b3);
                                    } else if (h(b2, b3)) {
                                        b(b2, b3);
                                    } else if (!i(b2, b3)) {
                                        if (j(b2, b3)) {
                                            c(b3);
                                        }
                                    } else {
                                        this.OU.Pl = b3 - 32;
                                    }
                                } else {
                                    this.OU.a(d(b2));
                                    if ((b3 & 224) != 0) {
                                        this.OU.a(d(b3));
                                    }
                                }
                                z2 = true;
                            }
                        } else if (z3) {
                            mj();
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (z2) {
            int i2 = this.OX;
            if (i2 == 1 || i2 == 3) {
                this.OV = mi();
                this.Pf = au();
            }
        }
    }

    private boolean a(byte b2) {
        if (h(b2)) {
            this.Pd = i(b2);
        }
        return this.Pd == this.OR;
    }

    private boolean a(boolean z, byte b2, byte b3) {
        if (z && j(b2)) {
            if (this.Pa && this.Pb == b2 && this.Pc == b3) {
                this.Pa = false;
                return true;
            }
            this.Pa = true;
            this.Pb = b2;
            this.Pc = b3;
        } else {
            this.Pa = false;
        }
        return false;
    }

    private void b(byte b2) {
        this.OU.a(' ');
        this.OU.m((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    private void b(byte b2, byte b3) {
        int i = OG[b2 & 7];
        if ((b3 & 32) != 0) {
            i++;
        }
        if (i != this.OU.Pj) {
            if (this.OX != 1 && !this.OU.isEmpty()) {
                C0099a c0099a = new C0099a(this.OX, this.OY);
                this.OU = c0099a;
                this.OT.add(c0099a);
            }
            this.OU.Pj = i;
        }
        boolean z = (b3 & 16) == 16;
        boolean z2 = (b3 & 1) == 1;
        int i2 = (b3 >> 1) & 7;
        this.OU.m(z ? 8 : i2, z2);
        if (z) {
            this.OU.Pk = OH[i2];
        }
    }

    private void c(byte b2) {
        if (b2 == 32) {
            ek(2);
            return;
        }
        if (b2 != 41) {
            switch (b2) {
                case 37:
                    ek(1);
                    el(2);
                    break;
                case 38:
                    ek(1);
                    el(3);
                    break;
                case 39:
                    ek(1);
                    el(4);
                    break;
                default:
                    int i = this.OX;
                    if (i != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.OV = Collections.emptyList();
                                    int i2 = this.OX;
                                    if (i2 == 1 || i2 == 3) {
                                        mj();
                                    }
                                    break;
                                case 45:
                                    if (i == 1 && !this.OU.isEmpty()) {
                                        this.OU.mn();
                                        break;
                                    }
                                    break;
                                case 46:
                                    mj();
                                    break;
                                case 47:
                                    this.OV = mi();
                                    mj();
                                    break;
                            }
                        } else {
                            this.OU.mm();
                            break;
                        }
                    }
                    break;
            }
            return;
        }
        ek(3);
    }

    private List<com.applovin.exoplayer2.i.a> mi() {
        int size = this.OT.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            com.applovin.exoplayer2.i.a aVarEm = this.OT.get(i).em(Integer.MIN_VALUE);
            arrayList.add(aVarEm);
            if (aVarEm != null) {
                iMin = Math.min(iMin, aVarEm.Oe);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            com.applovin.exoplayer2.i.a aVar = (com.applovin.exoplayer2.i.a) arrayList.get(i2);
            if (aVar != null) {
                if (aVar.Oe != iMin) {
                    aVar = (com.applovin.exoplayer2.i.a) com.applovin.exoplayer2.l.a.checkNotNull(this.OT.get(i2).em(iMin));
                }
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    private void ek(int i) {
        int i2 = this.OX;
        if (i2 == i) {
            return;
        }
        this.OX = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.OT.size(); i3++) {
                this.OT.get(i3).ek(i);
            }
            return;
        }
        mj();
        if (i2 == 3 || i == 1 || i == 0) {
            this.OV = Collections.emptyList();
        }
    }

    private void el(int i) {
        this.OY = i;
        this.OU.el(i);
    }

    private void mj() {
        this.OU.U(this.OX);
        this.OT.clear();
        this.OT.add(this.OU);
    }

    private void c(byte b2, byte b3) {
        if (k(b2)) {
            this.Pe = false;
            return;
        }
        if (l(b2)) {
            if (b3 != 32 && b3 != 47) {
                switch (b3) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b3) {
                            case 42:
                            case 43:
                                this.Pe = false;
                                break;
                        }
                }
            }
            this.Pe = true;
        }
    }

    private static char d(byte b2) {
        return (char) OJ[(b2 & 127) - 32];
    }

    private static char e(byte b2) {
        return (char) OK[b2 & 15];
    }

    private static char f(byte b2, byte b3) {
        if ((b2 & 1) == 0) {
            return f(b3);
        }
        return g(b3);
    }

    private static char f(byte b2) {
        return (char) OL[b2 & 31];
    }

    private static char g(byte b2) {
        return (char) OM[b2 & 31];
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.i.a.a$a, reason: collision with other inner class name */
    private static final class C0099a {
        private int OX;
        private int OY;
        private final List<C0100a> Pg = new ArrayList();
        private final List<SpannableString> Ph = new ArrayList();
        private final StringBuilder Pi = new StringBuilder();
        private int Pj;
        private int Pk;
        private int Pl;

        public C0099a(int i, int i2) {
            U(i);
            this.OY = i2;
        }

        public void U(int i) {
            this.OX = i;
            this.Pg.clear();
            this.Ph.clear();
            this.Pi.setLength(0);
            this.Pj = 15;
            this.Pk = 0;
            this.Pl = 0;
        }

        public boolean isEmpty() {
            return this.Pg.isEmpty() && this.Ph.isEmpty() && this.Pi.length() == 0;
        }

        public void ek(int i) {
            this.OX = i;
        }

        public void el(int i) {
            this.OY = i;
        }

        public void m(int i, boolean z) {
            this.Pg.add(new C0100a(i, z, this.Pi.length()));
        }

        public void mm() {
            int length = this.Pi.length();
            if (length > 0) {
                this.Pi.delete(length - 1, length);
                for (int size = this.Pg.size() - 1; size >= 0; size--) {
                    C0100a c0100a = this.Pg.get(size);
                    if (c0100a.start != length) {
                        return;
                    }
                    c0100a.start--;
                }
            }
        }

        public void a(char c) {
            if (this.Pi.length() < 32) {
                this.Pi.append(c);
            }
        }

        public void mn() {
            this.Ph.add(mo());
            this.Pi.setLength(0);
            this.Pg.clear();
            int iMin = Math.min(this.OY, this.Pj);
            while (this.Ph.size() >= iMin) {
                this.Ph.remove(0);
            }
        }

        public com.applovin.exoplayer2.i.a em(int i) {
            float f;
            int i2 = this.Pk + this.Pl;
            int i3 = 32 - i2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.Ph.size(); i4++) {
                spannableStringBuilder.append(ai.a(this.Ph.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(ai.a(mo(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                if (this.OX != 2 || (Math.abs(i5) >= 3 && length >= 0)) {
                    i = (this.OX != 2 || i5 <= 0) ? 0 : 2;
                } else {
                    i = 1;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.Pj;
            if (i6 > 7) {
                i6 = (i6 - 15) - 2;
            } else if (this.OX == 1) {
                i6 -= this.OY - 1;
            }
            return new com.applovin.exoplayer2.i.a.C0098a().m(spannableStringBuilder).a(Layout.Alignment.ALIGN_NORMAL).b(i6, 1).o(f).eg(i).lU();
        }

        private SpannableString mo() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.Pi);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            while (i < this.Pg.size()) {
                C0100a c0100a = this.Pg.get(i);
                boolean z2 = c0100a.Pn;
                int i7 = c0100a.Pm;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = a.OI[i7];
                    }
                    z = z3;
                }
                int i8 = c0100a.start;
                i++;
                if (i8 != (i < this.Pg.size() ? this.Pg.get(i).start : length)) {
                    if (i3 != -1 && !z2) {
                        a(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z2) {
                        i3 = i8;
                    }
                    if (i4 != -1 && !z) {
                        b(spannableStringBuilder, i4, i8);
                        i4 = -1;
                    } else if (i4 == -1 && z) {
                        i4 = i8;
                    }
                    if (i6 != i5) {
                        a(spannableStringBuilder, i2, i8, i5);
                        i5 = i6;
                        i2 = i8;
                    }
                }
            }
            if (i3 != -1 && i3 != length) {
                a(spannableStringBuilder, i3, length);
            }
            if (i4 != -1 && i4 != length) {
                b(spannableStringBuilder, i4, length);
            }
            if (i2 != length) {
                a(spannableStringBuilder, i2, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        /* JADX INFO: renamed from: com.applovin.exoplayer2.i.a.a$a$a, reason: collision with other inner class name */
        private static class C0100a {
            public final int Pm;
            public final boolean Pn;
            public int start;

            public C0100a(int i, boolean z, int i2) {
                this.Pm = i;
                this.Pn = z;
                this.start = i2;
            }
        }
    }

    private boolean mk() {
        return (this.OS == -9223372036854775807L || this.Pf == -9223372036854775807L || au() - this.Pf < this.OS) ? false : true;
    }
}
