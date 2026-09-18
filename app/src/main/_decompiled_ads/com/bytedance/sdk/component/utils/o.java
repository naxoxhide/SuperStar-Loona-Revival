package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MimeDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    private static volatile o d;
    private Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f329b = false;
    private Context c;

    /* JADX INFO: compiled from: MimeDetector.java */
    class a implements PrivilegedAction<List<String>> {
        a() {
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<String> run() {
            InputStream inputStreamOpen;
            BufferedReader bufferedReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                inputStreamOpen = o.this.c.getAssets().open("tt_mime_type.pro");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpen));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            if (!TextUtils.isEmpty(line)) {
                                arrayList.add(line);
                            }
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader2;
                            try {
                                return Collections.emptyList();
                            } finally {
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                            }
                        }
                    }
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused5) {
                    }
                    return arrayList;
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamOpen = null;
            }
        }
    }

    private o(Context context) {
        if (context != null && this.c == null) {
            this.c = context.getApplicationContext();
            a();
        }
        this.c = context;
    }

    private String c(String str) {
        String str2;
        String strA = a(str);
        if (strA.isEmpty()) {
            return null;
        }
        a();
        Map<String, String> map = this.a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.a.get(strA);
            if (str2 == null) {
                strA = a(strA);
            }
            if (str2 != null) {
                break;
            }
        } while (!strA.isEmpty());
        return str2;
    }

    private static boolean d(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String e(String str) {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String strTrim = str.substring(0, iIndexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = strTrim.toLowerCase(locale);
        if (!d(lowerCase)) {
            return null;
        }
        String lowerCase2 = (iIndexOf2 < 0 ? str.substring(iIndexOf + 1) : str.substring(iIndexOf + 1, iIndexOf2)).trim().toLowerCase(locale);
        if (!d(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    private void f(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) <= 0) {
            String[] strArrSplit = strReplaceAll.split("\\s+");
            for (int i = 1; i < strArrSplit.length; i++) {
                a(strArrSplit[i], strArrSplit[0]);
            }
            return;
        }
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
        if (matcher.find()) {
            String strSubstring = matcher.group().substring(5);
            if (strSubstring.charAt(0) == '\"') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher2.find()) {
                String strSubstring2 = matcher2.group().substring(5);
                if (strSubstring2.charAt(0) == '\"') {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                }
                for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                    a(str2, strSubstring);
                }
            }
        }
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return e(strC);
    }

    public static String a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith(ProxyConfig.MATCH_HTTP) && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(context).b(str);
    }

    static o a(Context context) {
        if (d == null) {
            synchronized (o.class) {
                if (d == null) {
                    d = new o(context);
                }
            }
        }
        return d;
    }

    private static boolean a(char c) {
        return c > ' ' && c < 127 && "()<>@,;:/[]?=\\\"".indexOf(c) < 0;
    }

    private static String a(String str) {
        int iIndexOf;
        return (str == null || str.isEmpty() || (iIndexOf = str.indexOf(46)) < 0 || iIndexOf >= str.length() + (-1)) ? "" : str.substring(iIndexOf + 1);
    }

    private void a() {
        if (this.c == null || this.f329b) {
            return;
        }
        synchronized (this) {
            if (!this.f329b) {
                List list = (List) AccessController.doPrivileged(new a());
                this.a = new HashMap(list.size());
                String strSubstring = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = strSubstring + ((String) it.next());
                    if (str.endsWith("\\")) {
                        strSubstring = str.substring(0, str.length() - 1);
                    } else {
                        f(str);
                        strSubstring = "";
                    }
                }
                if (!strSubstring.isEmpty()) {
                    f(strSubstring);
                }
                this.f329b = true;
            }
        }
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.a.containsKey(str)) {
            return;
        }
        this.a.put(str, str2);
    }
}
