package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class d4 extends b4 {
    public static final c4 p = new c4();
    public final Reader c;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public boolean o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k7 f2742b = new k7();
    public final char[] d = new char[1024];
    public int e = 0;
    public int f = 0;
    public int g = 1;
    public int h = 1;
    public final ArrayList i = new ArrayList();

    public d4(Reader reader) {
        y();
        this.o = false;
        this.c = reader;
    }

    @Override // com.tapjoy.internal.b4
    public final void a() throws IOException {
        a(3);
    }

    @Override // com.tapjoy.internal.b4
    public final void b() throws IOException {
        a(4);
    }

    @Override // com.tapjoy.internal.b4
    public final boolean c() throws IOException {
        q();
        int i = this.j;
        return (i == 4 || i == 2) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.l = null;
        this.j = 0;
        this.i.clear();
        this.i.add(e4.h);
        this.c.close();
    }

    @Override // com.tapjoy.internal.b4
    public final boolean g() throws IOException {
        q();
        if (this.j != 8) {
            throw new IllegalStateException("Expected a boolean but was ".concat(f4.a(this.j)));
        }
        boolean z = this.l == "true";
        t();
        return z;
    }

    @Override // com.tapjoy.internal.b4
    public final double h() throws IOException {
        q();
        int i = this.j;
        if (i != 6 && i != 7) {
            throw new IllegalStateException("Expected a double but was ".concat(f4.a(this.j)));
        }
        double d = Double.parseDouble(this.l);
        t();
        return d;
    }

    @Override // com.tapjoy.internal.b4
    public final int i() throws IOException {
        int i;
        q();
        int i2 = this.j;
        if (i2 != 6 && i2 != 7) {
            throw new IllegalStateException("Expected an int but was ".concat(f4.a(this.j)));
        }
        try {
            i = Integer.parseInt(this.l);
        } catch (NumberFormatException unused) {
            double d = Double.parseDouble(this.l);
            int i3 = (int) d;
            if (i3 != d) {
                throw new NumberFormatException(this.l);
            }
            i = i3;
        }
        t();
        return i;
    }

    @Override // com.tapjoy.internal.b4
    public final String l() throws IOException {
        q();
        if (this.j != 5) {
            throw new IllegalStateException("Expected a name but was ".concat(f4.a(q())));
        }
        String str = this.k;
        t();
        return str;
    }

    @Override // com.tapjoy.internal.b4
    public final String m() throws IOException {
        q();
        int i = this.j;
        if (i != 6 && i != 7) {
            throw new IllegalStateException("Expected a string but was ".concat(f4.a(q())));
        }
        String str = this.l;
        t();
        return str;
    }

    @Override // com.tapjoy.internal.b4
    public final int q() throws IOException {
        int i = this.j;
        if (i != 0) {
            return i;
        }
        ArrayList arrayList = this.i;
        switch (((e4) arrayList.get(arrayList.size() - 1)).ordinal()) {
            case 0:
                return a(true);
            case 1:
                return a(false);
            case 2:
                return b(true);
            case 3:
                int iW = w();
                if (iW == 58) {
                    e4 e4Var = e4.e;
                    ArrayList arrayList2 = this.i;
                    arrayList2.set(arrayList2.size() - 1, e4Var);
                    return x();
                }
                if (iW != 61) {
                    b("Expected ':'");
                    throw null;
                }
                u();
                throw null;
            case 4:
                return b(false);
            case 5:
                e4 e4Var2 = e4.g;
                ArrayList arrayList3 = this.i;
                arrayList3.set(arrayList3.size() - 1, e4Var2);
                int iX = x();
                int i2 = this.j;
                if (i2 == 1 || i2 == 3) {
                    return iX;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was ".concat(f4.a(this.j)));
            case 6:
                try {
                    x();
                    b("Expected EOF");
                    throw null;
                } catch (EOFException unused) {
                    this.j = 10;
                    return 10;
                }
            case 7:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    @Override // com.tapjoy.internal.b4
    public final void r() throws IOException {
        q();
        int i = this.j;
        if (i == 2 || i == 4) {
            throw new IllegalStateException("Expected a value but was ".concat(f4.a(this.j)));
        }
        this.o = true;
        int i2 = 0;
        do {
            try {
                int iT = t();
                if (iT == 1 || iT == 3) {
                    i2++;
                } else if (iT == 2 || iT == 4) {
                    i2--;
                }
            } finally {
                this.o = false;
            }
        } while (i2 != 0);
    }

    public final int t() throws IOException {
        q();
        int i = this.j;
        this.j = 0;
        this.l = null;
        this.k = null;
        return i;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(d4.class.getSimpleName()).append(" near ");
        StringBuilder sb = new StringBuilder();
        int iMin = Math.min(this.e, 20);
        sb.append(this.d, this.e - iMin, iMin);
        sb.append(this.d, this.e, Math.min(this.f - this.e, 20));
        return sbAppend.append((Object) sb).toString();
    }

    public final void u() throws n4 {
        b("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final long v() throws IOException {
        long j;
        q();
        int i = this.j;
        if (i != 6 && i != 7) {
            throw new IllegalStateException("Expected a long but was ".concat(f4.a(this.j)));
        }
        try {
            j = Long.parseLong(this.l);
        } catch (NumberFormatException unused) {
            double d = Double.parseDouble(this.l);
            long j2 = (long) d;
            if (j2 != d) {
                throw new NumberFormatException(this.l);
            }
            j = j2;
        }
        t();
        return j;
    }

    public final int w() throws n4, EOFException {
        while (true) {
            if (this.e >= this.f && !b(1)) {
                throw new EOFException("End of input");
            }
            char[] cArr = this.d;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            char c = cArr[i];
            if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                if (c == '#') {
                    u();
                    throw null;
                }
                if (c != '/') {
                    return c;
                }
                if (i2 == this.f && !b(1)) {
                    return c;
                }
                u();
                throw null;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013e  */
    /* JADX WARN: Code duplicated, block: B:122:0x018d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0197  */
    /* JADX WARN: Code duplicated, block: B:126:0x019e  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01be A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:142:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:155:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:158:0x01f1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:159:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:161:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:81:0x0106  */
    /* JADX WARN: Code duplicated, block: B:83:0x010c  */
    /* JADX WARN: Code duplicated, block: B:99:0x013b  */
    public final int x() throws n4, EOFException {
        int i;
        String string;
        int i2;
        int i3;
        char[] cArr;
        int i4;
        char c;
        int i5;
        int i6;
        char c2;
        int i7;
        char c3;
        char[] cArr2;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char[] cArr3;
        char c9;
        char c10;
        char c11;
        char c12;
        char[] cArr4;
        char c13;
        char c14;
        char c15;
        char c16;
        int iW = w();
        if (iW == 34) {
            this.l = a((char) iW);
            this.j = 6;
            return 6;
        }
        if (iW == 39) {
            u();
            throw null;
        }
        if (iW == 91) {
            this.i.add(e4.a);
            this.j = 1;
            return 1;
        }
        if (iW == 123) {
            this.i.add(e4.c);
            this.j = 3;
            return 3;
        }
        this.e--;
        this.m = -1;
        int i8 = 0;
        this.n = 0;
        StringBuilder sb = null;
        do {
            int i9 = 0;
            while (true) {
                int i10 = this.e + i9;
                i = 9;
                if (i10 < this.f) {
                    char c17 = this.d[i10];
                    if (c17 != '\t' && c17 != '\n' && c17 != '\f' && c17 != '\r' && c17 != ' ') {
                        if (c17 != '#') {
                            if (c17 != ',') {
                                if (c17 != '/' && c17 != '=') {
                                    if (c17 != '{' && c17 != '}' && c17 != ':') {
                                        if (c17 != ';') {
                                            switch (c17) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i9++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        u();
                        throw null;
                    }
                    i8 = i9;
                } else if (i9 >= this.d.length) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(this.d, this.e, i9);
                    this.n += i9;
                    this.e += i9;
                } else if (!b(i9 + 1)) {
                    this.d[this.f] = 0;
                    i8 = i9;
                }
                if (sb == null) {
                    this.m = this.e;
                    string = null;
                } else if (this.o) {
                    string = "skipped!";
                } else {
                    sb.append(this.d, this.e, i8);
                    string = sb.toString();
                }
                i2 = this.n + i8;
                this.n = i2;
                this.e += i8;
                this.l = string;
                if (i2 != 0) {
                    b("Expected literal value");
                    throw null;
                }
                i3 = this.m;
                if (i3 != -1) {
                    i = 6;
                } else if (i2 == 4 || !(('n' == (c13 = (cArr4 = this.d)[i3]) || 'N' == c13) && (('u' == (c14 = cArr4[i3 + 1]) || 'U' == c14) && (('l' == (c15 = cArr4[i3 + 2]) || 'L' == c15) && ('l' == (c16 = cArr4[i3 + 3]) || 'L' == c16))))) {
                    if (i2 != 4 && (('t' == (c9 = (cArr3 = this.d)[i3]) || 'T' == c9) && (('r' == (c10 = cArr3[i3 + 1]) || 'R' == c10) && (('u' == (c11 = cArr3[i3 + 2]) || 'U' == c11) && ('e' == (c12 = cArr3[i3 + 3]) || 'E' == c12))))) {
                        this.l = "true";
                    } else if (i2 == 5 || !(('f' == (c4 = (cArr2 = this.d)[i3]) || 'F' == c4) && (('a' == (c5 = cArr2[i3 + 1]) || 'A' == c5) && (('l' == (c6 = cArr2[i3 + 2]) || 'L' == c6) && (('s' == (c7 = cArr2[i3 + 3]) || 'S' == c7) && ('e' == (c8 = cArr2[i3 + 4]) || 'E' == c8)))))) {
                        this.l = this.f2742b.a(this.d, i3, i2);
                        cArr = this.d;
                        i4 = this.m;
                        int i11 = this.n;
                        c = cArr[i4];
                        if (c == '-') {
                            int i12 = i4 + 1;
                            i5 = i12;
                            c = cArr[i12];
                        } else {
                            i5 = i4;
                        }
                        if (c == '0') {
                            i6 = i5 + 1;
                            c2 = cArr[i6];
                        } else if (c >= '1' || c > '9') {
                            i = 6;
                        } else {
                            i6 = i5 + 1;
                            c2 = cArr[i6];
                            while (c2 >= '0' && c2 <= '9') {
                                i6++;
                                c2 = cArr[i6];
                            }
                        }
                        if (c2 == '.') {
                            i6++;
                            c2 = cArr[i6];
                            while (c2 >= '0' && c2 <= '9') {
                                i6++;
                                c2 = cArr[i6];
                            }
                        }
                        if (c2 != 'e' || c2 == 'E') {
                            i7 = i6 + 1;
                            c3 = cArr[i7];
                            if (c3 != '+' || c3 == '-') {
                                i7++;
                                c3 = cArr[i7];
                            }
                            if (c3 >= '0' || c3 > '9') {
                                i = 6;
                            } else {
                                i6 = i7 + 1;
                                char c18 = cArr[i6];
                                while (c18 >= '0' && c18 <= '9') {
                                    i6++;
                                    c18 = cArr[i6];
                                }
                                if (i6 == i4 + i11) {
                                    i = 7;
                                } else {
                                    i = 6;
                                }
                            }
                        } else if (i6 == i4 + i11) {
                            i = 7;
                        } else {
                            i = 6;
                        }
                    } else {
                        this.l = TJAdUnitConstants.String.FALSE;
                    }
                    i = 8;
                } else {
                    this.l = "null";
                }
                this.j = i;
                if (i != 6) {
                    return i;
                }
                u();
                throw null;
            }
        } while (b(1));
        if (sb == null) {
            this.m = this.e;
            string = null;
        } else if (this.o) {
            string = "skipped!";
        } else {
            sb.append(this.d, this.e, i8);
            string = sb.toString();
        }
        i2 = this.n + i8;
        this.n = i2;
        this.e += i8;
        this.l = string;
        if (i2 != 0) {
            b("Expected literal value");
            throw null;
        }
        i3 = this.m;
        if (i3 != -1) {
            i = 6;
        } else if (i2 == 4) {
            if (i2 != 4) {
                if (i2 == 5) {
                }
                this.l = this.f2742b.a(this.d, i3, i2);
                cArr = this.d;
                i4 = this.m;
                int i13 = this.n;
                c = cArr[i4];
                if (c == '-') {
                    int i14 = i4 + 1;
                    i5 = i14;
                    c = cArr[i14];
                } else {
                    i5 = i4;
                }
                if (c == '0') {
                    i6 = i5 + 1;
                    c2 = cArr[i6];
                } else {
                    if (c >= '1') {
                    }
                    i = 6;
                }
                if (c2 == '.') {
                    i6++;
                    c2 = cArr[i6];
                    while (c2 >= '0') {
                        i6++;
                        c2 = cArr[i6];
                    }
                }
                if (c2 != 'e') {
                    i7 = i6 + 1;
                    c3 = cArr[i7];
                    if (c3 != '+') {
                        i7++;
                        c3 = cArr[i7];
                    } else {
                        i7++;
                        c3 = cArr[i7];
                    }
                    if (c3 >= '0') {
                    }
                } else {
                    i7 = i6 + 1;
                    c3 = cArr[i7];
                    if (c3 != '+') {
                        i7++;
                        c3 = cArr[i7];
                    } else {
                        i7++;
                        c3 = cArr[i7];
                    }
                    if (c3 >= '0') {
                    }
                }
                i = 6;
            } else {
                if (i2 == 5) {
                }
                this.l = this.f2742b.a(this.d, i3, i2);
                cArr = this.d;
                i4 = this.m;
                int i15 = this.n;
                c = cArr[i4];
                if (c == '-') {
                    int i16 = i4 + 1;
                    i5 = i16;
                    c = cArr[i16];
                } else {
                    i5 = i4;
                }
                if (c == '0') {
                    i6 = i5 + 1;
                    c2 = cArr[i6];
                } else {
                    if (c >= '1') {
                    }
                    i = 6;
                }
                if (c2 == '.') {
                    i6++;
                    c2 = cArr[i6];
                    while (c2 >= '0') {
                        i6++;
                        c2 = cArr[i6];
                    }
                }
                if (c2 != 'e') {
                    i7 = i6 + 1;
                    c3 = cArr[i7];
                    if (c3 != '+') {
                        i7++;
                        c3 = cArr[i7];
                    } else {
                        i7++;
                        c3 = cArr[i7];
                    }
                    if (c3 >= '0') {
                    }
                } else {
                    i7 = i6 + 1;
                    c3 = cArr[i7];
                    if (c3 != '+') {
                        i7++;
                        c3 = cArr[i7];
                    } else {
                        i7++;
                        c3 = cArr[i7];
                    }
                    if (c3 >= '0') {
                    }
                }
                i = 6;
            }
        } else if (i2 != 4) {
            if (i2 == 5) {
            }
            this.l = this.f2742b.a(this.d, i3, i2);
            cArr = this.d;
            i4 = this.m;
            int i17 = this.n;
            c = cArr[i4];
            if (c == '-') {
                int i18 = i4 + 1;
                i5 = i18;
                c = cArr[i18];
            } else {
                i5 = i4;
            }
            if (c == '0') {
                i6 = i5 + 1;
                c2 = cArr[i6];
            } else {
                if (c >= '1') {
                }
                i = 6;
            }
            if (c2 == '.') {
                i6++;
                c2 = cArr[i6];
                while (c2 >= '0') {
                    i6++;
                    c2 = cArr[i6];
                }
            }
            if (c2 != 'e') {
                i7 = i6 + 1;
                c3 = cArr[i7];
                if (c3 != '+') {
                    i7++;
                    c3 = cArr[i7];
                } else {
                    i7++;
                    c3 = cArr[i7];
                }
                if (c3 >= '0') {
                }
            } else {
                i7 = i6 + 1;
                c3 = cArr[i7];
                if (c3 != '+') {
                    i7++;
                    c3 = cArr[i7];
                } else {
                    i7++;
                    c3 = cArr[i7];
                }
                if (c3 >= '0') {
                }
            }
            i = 6;
        } else {
            if (i2 == 5) {
            }
            this.l = this.f2742b.a(this.d, i3, i2);
            cArr = this.d;
            i4 = this.m;
            int i19 = this.n;
            c = cArr[i4];
            if (c == '-') {
                int i110 = i4 + 1;
                i5 = i110;
                c = cArr[i110];
            } else {
                i5 = i4;
            }
            if (c == '0') {
                i6 = i5 + 1;
                c2 = cArr[i6];
            } else {
                if (c >= '1') {
                }
                i = 6;
            }
            if (c2 == '.') {
                i6++;
                c2 = cArr[i6];
                while (c2 >= '0') {
                    i6++;
                    c2 = cArr[i6];
                }
            }
            if (c2 != 'e') {
                i7 = i6 + 1;
                c3 = cArr[i7];
                if (c3 != '+') {
                    i7++;
                    c3 = cArr[i7];
                } else {
                    i7++;
                    c3 = cArr[i7];
                }
                if (c3 >= '0') {
                }
            } else {
                i7 = i6 + 1;
                c3 = cArr[i7];
                if (c3 != '+') {
                    i7++;
                    c3 = cArr[i7];
                } else {
                    i7++;
                    c3 = cArr[i7];
                }
                if (c3 >= '0') {
                }
            }
            i = 6;
        }
        this.j = i;
        if (i != 6) {
            return i;
        }
        u();
        throw null;
    }

    public final void y() {
        this.i.add(e4.f);
    }

    public final void a(int i) throws IOException {
        q();
        if (this.j != i) {
            throw new IllegalStateException("Expected " + f4.a(i) + " but was " + f4.a(q()));
        }
        t();
    }

    public final int b(boolean z) throws n4, EOFException {
        if (!z) {
            int iW = w();
            if (iW != 44 && iW != 59) {
                if (iW != 125) {
                    b("Unterminated object");
                    throw null;
                }
                ArrayList arrayList = this.i;
                this.j = 4;
                return 4;
            }
        } else {
            if (w() == 125) {
                ArrayList arrayList2 = this.i;
                this.j = 4;
                return 4;
            }
            this.e--;
        }
        int iW2 = w();
        if (iW2 != 34) {
            if (iW2 != 39) {
                u();
                throw null;
            }
            u();
            throw null;
        }
        this.k = a((char) iW2);
        e4 e4Var = e4.d;
        ArrayList arrayList3 = this.i;
        arrayList3.set(arrayList3.size() - 1, e4Var);
        this.j = 5;
        return 5;
    }

    public final int a(boolean z) throws n4, EOFException {
        if (z) {
            e4 e4Var = e4.f2749b;
            ArrayList arrayList = this.i;
            arrayList.set(arrayList.size() - 1, e4Var);
        } else {
            int iW = w();
            if (iW != 44) {
                if (iW == 59) {
                    u();
                    throw null;
                }
                if (iW == 93) {
                    ArrayList arrayList2 = this.i;
                    this.j = 2;
                    return 2;
                }
                b("Unterminated array");
                throw null;
            }
        }
        int iW2 = w();
        if (iW2 != 44 && iW2 != 59) {
            if (iW2 != 93) {
                this.e--;
                return x();
            }
            if (z) {
                ArrayList arrayList3 = this.i;
                this.j = 2;
                return 2;
            }
        }
        u();
        throw null;
    }

    public final boolean b(int i) throws IOException {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            i2 = this.e;
            if (i5 >= i2) {
                break;
            }
            if (this.d[i5] == '\n') {
                this.g++;
                this.h = 1;
            } else {
                this.h++;
            }
            i5++;
        }
        int i6 = this.f;
        if (i6 != i2) {
            int i7 = i6 - i2;
            this.f = i7;
            char[] cArr = this.d;
            System.arraycopy(cArr, i2, cArr, 0, i7);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.c;
            char[] cArr2 = this.d;
            int i8 = this.f;
            int i9 = reader.read(cArr2, i8, cArr2.length - i8);
            if (i9 == -1) {
                return false;
            }
            i3 = this.f + i9;
            this.f = i3;
            if (this.g == 1 && (i4 = this.h) == 1 && i3 > 0 && this.d[0] == 65279) {
                this.e++;
                this.h = i4 - 1;
            }
        } while (i3 < i);
        return true;
    }

    public final String a(char c) throws n4 {
        StringBuilder sb = null;
        do {
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 < this.f) {
                    char[] cArr = this.d;
                    int i3 = i2 + 1;
                    this.e = i3;
                    char c2 = cArr[i2];
                    if (c2 == c) {
                        if (this.o) {
                            return "skipped!";
                        }
                        if (sb == null) {
                            return this.f2742b.a(cArr, i, (i3 - i) - 1);
                        }
                        sb.append(cArr, i, (i3 - i) - 1);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append(this.d, i, (this.e - i) - 1);
                        if (this.e == this.f && !b(1)) {
                            b("Unterminated escape sequence");
                            throw null;
                        }
                        char[] cArr2 = this.d;
                        int i4 = this.e;
                        int i5 = i4 + 1;
                        this.e = i5;
                        char c3 = cArr2[i4];
                        if (c3 == 'b') {
                            c3 = '\b';
                        } else if (c3 == 'f') {
                            c3 = '\f';
                        } else if (c3 == 'n') {
                            c3 = '\n';
                        } else if (c3 == 'r') {
                            c3 = '\r';
                        } else if (c3 == 't') {
                            c3 = '\t';
                        } else if (c3 == 'u') {
                            if (i5 + 4 > this.f && !b(4)) {
                                b("Unterminated escape sequence");
                                throw null;
                            }
                            String strA = this.f2742b.a(this.d, this.e, 4);
                            this.e += 4;
                            c3 = (char) Integer.parseInt(strA, 16);
                        }
                        sb.append(c3);
                        i = this.e;
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.d, i, this.e - i);
        } while (b(1));
        b("Unterminated string");
        throw null;
    }

    public final void b(String str) throws n4 {
        StringBuilder sbAppend = new StringBuilder().append(str).append(" at line ");
        int i = this.g;
        for (int i2 = 0; i2 < this.e; i2++) {
            if (this.d[i2] == '\n') {
                i++;
            }
        }
        StringBuilder sbAppend2 = sbAppend.append(i).append(" column ");
        int i3 = this.h;
        for (int i4 = 0; i4 < this.e; i4++) {
            i3 = this.d[i4] == '\n' ? 1 : i3 + 1;
        }
        throw new n4(sbAppend2.append(i3).toString());
    }
}
