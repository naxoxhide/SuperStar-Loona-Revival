package b.a.a.a.a.a.b.c;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f42b;
    public final a c;

    /* JADX INFO: compiled from: Request.java */
    static final class a {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f43b;
        final String c;
        final int d;
        final int e;
        final List<String> f;

        private a(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.a = i;
            this.f43b = str;
            this.c = str2;
            this.d = i2;
            this.e = i3;
            this.f = list;
        }

        static a a(c cVar, List<b> list) throws d {
            String str;
            int i;
            int i2;
            int iIndexOf = cVar.f45b.indexOf("?");
            if (iIndexOf == -1) {
                throw new d("path format error, path: " + cVar.f45b);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : cVar.f45b.substring(iIndexOf + 1).split("&")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if (CampaignEx.JSON_KEY_AD_K.equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if (InneractiveMediationDefs.GENDER_FEMALE.equals(strArrSplit[0]) && b.a.a.a.a.a.b.d.a.c(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new d("rawKey or key is empty, path: " + cVar.f45b);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (b bVar : list) {
                    if (bVar != null && "Range".equalsIgnoreCase(bVar.a)) {
                        int iIndexOf2 = bVar.f44b.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new d("Range format error, Range: " + bVar.f44b);
                        }
                        if (!"bytes".equalsIgnoreCase(bVar.f44b.substring(0, iIndexOf2).trim())) {
                            throw new d("Range format error, Range: " + bVar.f44b);
                        }
                        String strSubstring = bVar.f44b.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new d("Range format error, Range: " + bVar.f44b);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new d("Range format error, Range: " + bVar.f44b);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new d("Range format error, Range: " + bVar.f44b);
                            }
                            str2 = bVar.f44b;
                        } catch (NumberFormatException unused) {
                            throw new d("Range format error, Range: " + bVar.f44b);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (arrayList.isEmpty()) {
                throw new d("no url found: path: " + cVar.f45b);
            }
            return new a(i3, strDecode, strDecode2, i2, i, str, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.a + ", rawKey='" + this.f43b + "', key='" + this.c + "', from=" + this.d + ", to=" + this.e + ", urls=" + this.f + '}';
        }
    }

    /* JADX INFO: compiled from: Request.java */
    public static final class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f44b;

        public b(String str, String str2) {
            this.a = str;
            this.f44b = str2;
        }

        static b a(String str) throws d {
            int iIndexOf = str.indexOf(CertificateUtil.DELIMITER);
            if (iIndexOf == -1) {
                throw new d("request header format error, header: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new d("request header format error, header: " + str);
            }
            return new b(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.a + "', value='" + this.f44b + "'}";
        }
    }

    /* JADX INFO: compiled from: Request.java */
    static final class c {
        final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f45b;
        final String c;

        private c(String str, String str2, String str3) {
            this.a = str;
            this.f45b = str2;
            this.c = str3;
        }

        static c a(String str) throws d {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new d("request line format error, line: " + str);
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new d("request line format error, line: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new d("request line format error, line: " + str);
            }
            return new c(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.a + "', path='" + this.f45b + "', version='" + this.c + "'}";
        }
    }

    /* JADX INFO: compiled from: Request.java */
    static final class d extends Exception {
        d(String str) {
            super(str);
        }
    }

    public i(c cVar, List<b> list, a aVar) {
        this.a = cVar;
        this.f42b = list;
        this.c = aVar;
    }

    public static i a(InputStream inputStream) throws IOException, d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, b.a.a.a.a.a.b.d.a.f58b));
        ArrayList arrayList = new ArrayList();
        c cVarA = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (cVarA == null) {
                cVarA = c.a(strTrim);
            } else {
                arrayList.add(b.a(strTrim));
            }
        }
        if (cVarA != null) {
            return new i(cVarA, arrayList, a.a(cVarA, arrayList));
        }
        throw new d("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.a + ", headers=" + this.f42b + ", extra=" + this.c + '}';
    }

    static String a(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strA = null;
        do {
            if (strA != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strA = a(sb, str, str2, list);
        } while (strA.length() > 3072);
        return strA;
    }

    private static String a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk").append("=").append(Uri.encode(str));
        sb.append("&").append(CampaignEx.JSON_KEY_AD_K).append("=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&").append("u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }
}
