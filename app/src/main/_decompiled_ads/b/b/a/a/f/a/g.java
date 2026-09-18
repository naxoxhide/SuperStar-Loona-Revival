package b.b.a.a.f.a;

import androidx.webkit.ProxyConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: compiled from: HttpUrl.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    private static final char[] h = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f143b;
    private final String c;
    final String d;
    final int e;
    private final List<String> f;
    private final String g;

    /* JADX INFO: compiled from: HttpUrl.java */
    public static final class a {
        String a;
        String d;
        final List<String> f;
        List<String> g;
        String h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f144b = "";
        String c = "";
        int e = -1;

        /* JADX INFO: renamed from: b.b.a.a.f.a.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.java */
        enum EnumC0031a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = b.b.a.a.f.a.q.f.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private boolean e(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        int b() {
            int i = this.e;
            return i != -1 ? i : g.a(this.a);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.f144b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.f144b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int iB = b();
            if (iB != g.a(this.a)) {
                sb.append(':');
                sb.append(iB);
            }
            g.b(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                g.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        public a a(String str) {
            Objects.requireNonNull(str, "encodedPathSegments == null");
            return a(str, true);
        }

        public a b(String str) {
            this.g = str != null ? g.c(g.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        private a a(String str, boolean z) {
            int i = 0;
            do {
                int iA = b.b.a.a.f.a.q.f.a(str, i, str.length(), "/\\");
                a(str, i, iA, iA < str.length(), z);
                i = iA + 1;
            } while (i <= str.length());
            return this;
        }

        private static int b(String str, int i, int i2) {
            try {
                int i3 = Integer.parseInt(g.a(str, i, i2, "", false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
            }
        }

        private static int e(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public a c(String str) {
            Objects.requireNonNull(str, "host == null");
            String strA = a(str, 0, str.length());
            if (strA == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = strA;
            return this;
        }

        private void c() {
            List<String> list = this.f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f.isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, "");
            } else {
                this.f.add("");
            }
        }

        public a f(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                this.a = ProxyConfig.MATCH_HTTP;
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        private static int f(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(g.a(str, " \"'<>#&=", true, false, true, true));
            this.g.add(str2 != null ? g.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public g a() {
            if (this.a != null) {
                if (this.d != null) {
                    return new g(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        EnumC0031a a(g gVar, String str) {
            int iA;
            int i;
            int iB = b.b.a.a.f.a.q.f.b(str, 0, str.length());
            int iC = b.b.a.a.f.a.q.f.c(str, iB, str.length());
            if (e(str, iB, iC) != -1) {
                if (str.regionMatches(true, iB, "https:", 0, 6)) {
                    this.a = "https";
                    iB += 6;
                } else if (str.regionMatches(true, iB, "http:", 0, 5)) {
                    this.a = ProxyConfig.MATCH_HTTP;
                    iB += 5;
                } else {
                    return EnumC0031a.UNSUPPORTED_SCHEME;
                }
            } else if (gVar != null) {
                this.a = gVar.a;
            } else {
                return EnumC0031a.MISSING_SCHEME;
            }
            int iF = f(str, iB, iC);
            char c = '?';
            char c2 = '#';
            if (iF < 2 && gVar != null && gVar.a.equals(this.a)) {
                this.f144b = gVar.d();
                this.c = gVar.a();
                this.d = gVar.d;
                this.e = gVar.e;
                this.f.clear();
                this.f.addAll(gVar.b());
                if (iB == iC || str.charAt(iB) == '#') {
                    b(gVar.c());
                }
            } else {
                boolean z = false;
                boolean z2 = false;
                int i2 = iB + iF;
                while (true) {
                    iA = b.b.a.a.f.a.q.f.a(str, i2, iC, "@/\\?#");
                    byte bCharAt = iA != iC ? str.charAt(iA) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iA2 = b.b.a.a.f.a.q.f.a(str, i2, iA, ':');
                            i = iA;
                            String strA = g.a(str, i2, iA2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strA = this.f144b + "%40" + strA;
                            }
                            this.f144b = strA;
                            if (iA2 != i) {
                                this.c = g.a(str, iA2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iA;
                            this.c += "%40" + g.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int iC2 = c(str, i2, iA);
                int i3 = iC2 + 1;
                if (i3 < iA) {
                    this.d = a(str, i2, iC2);
                    int iB2 = b(str, i3, iA);
                    this.e = iB2;
                    if (iB2 == -1) {
                        return EnumC0031a.INVALID_PORT;
                    }
                } else {
                    this.d = a(str, i2, iC2);
                    this.e = g.a(this.a);
                }
                if (this.d == null) {
                    return EnumC0031a.INVALID_HOST;
                }
                iB = iA;
            }
            int iA3 = b.b.a.a.f.a.q.f.a(str, iB, iC, "?#");
            d(str, iB, iA3);
            if (iA3 < iC && str.charAt(iA3) == '?') {
                int iA4 = b.b.a.a.f.a.q.f.a(str, iA3, iC, '#');
                this.g = g.c(g.a(str, iA3 + 1, iA4, " \"'<>#", true, false, true, true, null));
                iA3 = iA4;
            }
            if (iA3 < iC && str.charAt(iA3) == '#') {
                this.h = g.a(str, 1 + iA3, iC, "", true, false, false, false, null);
            }
            return EnumC0031a.SUCCESS;
        }

        private boolean d(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = g.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (d(strA)) {
                return;
            }
            if (e(strA)) {
                c();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, strA);
            } else {
                this.f.add(strA);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            return b.b.a.a.f.a.q.f.a(g.a(str, i, i2, false));
        }
    }

    g(a aVar) {
        this.a = aVar.a;
        this.f143b = a(aVar.f144b, false);
        this.c = a(aVar.c, false);
        this.d = aVar.d;
        this.e = aVar.b();
        a(aVar.f, false);
        List<String> list = aVar.g;
        this.f = list != null ? a(list, true) : null;
        String str = aVar.h;
        if (str != null) {
            a(str, false);
        }
        this.g = aVar.toString();
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public String a() {
        if (this.c.isEmpty()) {
            return "";
        }
        return this.g.substring(this.g.indexOf(58, this.a.length() + 3) + 1, this.g.indexOf(64));
    }

    public String c() {
        if (this.f == null) {
            return null;
        }
        int iIndexOf = this.g.indexOf(63) + 1;
        String str = this.g;
        return this.g.substring(iIndexOf, b.b.a.a.f.a.q.f.a(str, iIndexOf, str.length(), '#'));
    }

    public String d() {
        if (this.f143b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.g;
        return this.g.substring(length, b.b.a.a.f.a.q.f.a(str, length, str.length(), ":@"));
    }

    public URL e() {
        try {
            return new URL(this.g);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && ((g) obj).g.equals(this.g);
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public String toString() {
        return this.g;
    }

    public List<String> b() {
        int iIndexOf = this.g.indexOf(47, this.a.length() + 3);
        String str = this.g;
        int iA = b.b.a.a.f.a.q.f.a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i = iIndexOf + 1;
            int iA2 = b.b.a.a.f.a.q.f.a(this.g, i, iA, '/');
            arrayList.add(this.g.substring(i, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    public static int a(String str) {
        if (str.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static g b(String str) {
        a aVar = new a();
        if (aVar.a((g) null, str) == a.EnumC0031a.SUCCESS) {
            return aVar.a();
        }
        return null;
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                b.b.a.a.f.a.q.a aVar = new b.b.a.a.f.a.q.a();
                aVar.a(str, i, i3);
                a(aVar, str, i3, i2, z);
                return aVar.e();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    static void a(b.b.a.a.f.a.q.a aVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                int iA = b.b.a.a.f.a.q.f.a(str.charAt(i + 1));
                int iA2 = b.b.a.a.f.a.q.f.a(str.charAt(i3));
                if (iA != -1 && iA2 != -1) {
                    aVar.c((iA << 4) + iA2);
                    i = i3;
                } else {
                    aVar.d(iCodePointAt);
                }
            } else if (iCodePointAt == 43 && z) {
                aVar.c(32);
            } else {
                aVar.d(iCodePointAt);
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && b.b.a.a.f.a.q.f.a(str.charAt(i + 1)) != -1 && b.b.a.a.f.a.q.f.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            b.b.a.a.f.a.q.a aVar = new b.b.a.a.f.a.q.a();
            aVar.a(str, i, iCharCount);
            a(aVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return aVar.e();
        }
        return str.substring(i, i2);
    }

    static void a(b.b.a.a.f.a.q.a aVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        b.b.a.a.f.a.q.a aVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    aVar.a(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    aVar.d(iCodePointAt);
                } else {
                    if (aVar2 == null) {
                        aVar2 = new b.b.a.a.f.a.q.a();
                    }
                    if (charset != null && !charset.equals(b.b.a.a.f.a.q.f.a)) {
                        aVar2.a(str, i, Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        aVar2.d(iCodePointAt);
                    }
                    while (!aVar2.c()) {
                        int iD = aVar2.d() & 255;
                        aVar.c(37);
                        char[] cArr = h;
                        aVar.c(cArr[(iD >> 4) & 15]);
                        aVar.c(cArr[iD & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
