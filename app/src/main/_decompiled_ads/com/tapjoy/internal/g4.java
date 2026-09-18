package com.tapjoy.internal;

import com.facebook.internal.security.CertificateUtil;
import com.tapjoy.TJAdUnitConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class g4 implements Closeable {
    public final Writer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2759b;
    public final String c;

    public g4(StringWriter stringWriter) {
        ArrayList arrayList = new ArrayList();
        this.f2759b = arrayList;
        arrayList.add(e4.f);
        this.c = CertificateUtil.DELIMITER;
        this.a = stringWriter;
    }

    public final void a(boolean z) throws IOException {
        ArrayList arrayList = this.f2759b;
        int iOrdinal = ((e4) arrayList.get(arrayList.size() - 1)).ordinal();
        if (iOrdinal == 0) {
            e4 e4Var = e4.f2749b;
            ArrayList arrayList2 = this.f2759b;
            arrayList2.set(arrayList2.size() - 1, e4Var);
            return;
        }
        if (iOrdinal == 1) {
            this.a.append(',');
            return;
        }
        if (iOrdinal == 3) {
            this.a.append((CharSequence) this.c);
            e4 e4Var2 = e4.e;
            ArrayList arrayList3 = this.f2759b;
            arrayList3.set(arrayList3.size() - 1, e4Var2);
            return;
        }
        if (iOrdinal != 5) {
            if (iOrdinal == 6) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            throw new IllegalStateException("Nesting problem: " + this.f2759b);
        }
        if (!z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        e4 e4Var3 = e4.g;
        ArrayList arrayList4 = this.f2759b;
        arrayList4.set(arrayList4.size() - 1, e4Var3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
        ArrayList arrayList = this.f2759b;
        if (((e4) arrayList.get(arrayList.size() - 1)) != e4.g) {
            throw new IOException("Incomplete document");
        }
    }

    public final void a(Object obj) throws IOException {
        if (obj == null) {
            a(false);
            this.a.write("null");
            return;
        }
        if (obj instanceof Boolean) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            a(false);
            this.a.write(zBooleanValue ? "true" : TJAdUnitConstants.String.FALSE);
            return;
        }
        if (obj instanceof Number) {
            if (obj instanceof Long) {
                long jLongValue = ((Number) obj).longValue();
                a(false);
                this.a.write(Long.toString(jLongValue));
                return;
            }
            if (obj instanceof Double) {
                double dDoubleValue = ((Number) obj).doubleValue();
                if (!Double.isNaN(dDoubleValue) && !Double.isInfinite(dDoubleValue)) {
                    a(false);
                    this.a.append((CharSequence) Double.toString(dDoubleValue));
                    return;
                }
                throw new IllegalArgumentException("Numeric values must be finite, but was " + dDoubleValue);
            }
            Number number = (Number) obj;
            String string = number.toString();
            if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
                a(false);
                this.a.append((CharSequence) string);
                return;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        if (obj instanceof String) {
            a(false);
            a((String) obj);
            return;
        }
        if (!(obj instanceof v3)) {
            if (obj instanceof Collection) {
                e4 e4Var = e4.a;
                a(true);
                this.f2759b.add(e4Var);
                this.a.write("[");
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                e4 e4Var2 = e4.a;
                e4 e4Var3 = e4.f2749b;
                ArrayList arrayList = this.f2759b;
                e4 e4Var4 = (e4) arrayList.get(arrayList.size() - 1);
                if (e4Var4 != e4Var3 && e4Var4 != e4Var2) {
                    throw new IllegalStateException("Nesting problem: " + this.f2759b);
                }
                ArrayList arrayList2 = this.f2759b;
                arrayList2.remove(arrayList2.size() - 1);
                this.a.write("]");
                return;
            }
            if (obj instanceof Map) {
                e4 e4Var5 = e4.c;
                a(true);
                this.f2759b.add(e4Var5);
                this.a.write("{");
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    String strValueOf = String.valueOf(entry.getKey());
                    ArrayList arrayList3 = this.f2759b;
                    e4 e4Var6 = (e4) arrayList3.get(arrayList3.size() - 1);
                    if (e4Var6 == e4.e) {
                        this.a.write(44);
                    } else if (e4Var6 != e4.c) {
                        throw new IllegalStateException("Nesting problem: " + this.f2759b);
                    }
                    e4 e4Var7 = e4.d;
                    ArrayList arrayList4 = this.f2759b;
                    arrayList4.set(arrayList4.size() - 1, e4Var7);
                    a(strValueOf);
                    a(entry.getValue());
                }
                e4 e4Var8 = e4.c;
                e4 e4Var9 = e4.e;
                ArrayList arrayList5 = this.f2759b;
                e4 e4Var10 = (e4) arrayList5.get(arrayList5.size() - 1);
                if (e4Var10 != e4Var9 && e4Var10 != e4Var8) {
                    throw new IllegalStateException("Nesting problem: " + this.f2759b);
                }
                ArrayList arrayList6 = this.f2759b;
                arrayList6.remove(arrayList6.size() - 1);
                this.a.write("}");
                return;
            }
            if (obj instanceof Date) {
                String str = ((DateFormat) d1.a.get()).format((Date) obj);
                if (str == null) {
                    a(false);
                    this.a.write("null");
                    return;
                } else {
                    a(false);
                    a(str);
                    return;
                }
            }
            if (obj instanceof Object[]) {
                e4 e4Var11 = e4.a;
                a(true);
                this.f2759b.add(e4Var11);
                this.a.write("[");
                for (Object obj2 : (Object[]) obj) {
                    a(obj2);
                }
                e4 e4Var12 = e4.a;
                e4 e4Var13 = e4.f2749b;
                ArrayList arrayList7 = this.f2759b;
                e4 e4Var14 = (e4) arrayList7.get(arrayList7.size() - 1);
                if (e4Var14 != e4Var13 && e4Var14 != e4Var12) {
                    throw new IllegalStateException("Nesting problem: " + this.f2759b);
                }
                ArrayList arrayList8 = this.f2759b;
                arrayList8.remove(arrayList8.size() - 1);
                this.a.write("]");
                return;
            }
            throw new IllegalArgumentException("Unknown type: ".concat(obj.getClass().getName()));
        }
        v3 v3Var = (v3) obj;
        a(false);
        try {
            v3Var.getClass();
            throw null;
        } catch (IOException e) {
            s9.a(e);
            throw null;
        }
    }

    public final void a(String str) throws IOException {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                this.a.write("\\f");
            } else if (cCharAt == '\r') {
                this.a.write("\\r");
            } else if (cCharAt != '\"' && cCharAt != '\\') {
                if (cCharAt == 8232 || cCharAt == 8233) {
                    this.a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    switch (cCharAt) {
                        case '\b':
                            this.a.write("\\b");
                            break;
                        case '\t':
                            this.a.write("\\t");
                            break;
                        case '\n':
                            this.a.write("\\n");
                            break;
                        default:
                            if (cCharAt <= 31) {
                                this.a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            } else {
                                this.a.write(cCharAt);
                            }
                            break;
                    }
                }
            } else {
                this.a.write(92);
                this.a.write(cCharAt);
            }
        }
        this.a.write("\"");
    }
}
