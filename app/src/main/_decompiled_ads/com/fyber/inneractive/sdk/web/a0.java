package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    public static final Pattern g = Pattern.compile("max-age=(\\d+)");
    public static final SimpleDateFormat h = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f1354b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;

    public a0(byte[] bArr, Map<String, String> map, String str, String str2, int i, String str3) {
        this.a = bArr;
        this.f1354b = map;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = str3;
    }

    public boolean a() {
        boolean z;
        String str;
        if (TextUtils.isEmpty(this.f)) {
            return false;
        }
        loop0: while (true) {
            z = true;
            for (String str2 : this.f1354b.keySet()) {
                if (!z) {
                    break loop0;
                }
                if (str2 == null || !str2.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                    if (str2 == null || !str2.equalsIgnoreCase(HttpHeaders.VARY)) {
                        if (str2 != null && str2.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                            String str3 = this.f1354b.get(str2);
                            if (str3 != null) {
                                z = !str3.equalsIgnoreCase("no-cache");
                            }
                        } else if (str2 != null && str2.equalsIgnoreCase(HttpHeaders.EXPIRES) && (str = this.f1354b.get(str2)) != null) {
                            try {
                                Date date = h.parse(str);
                                if (date != null && date.getTime() + TimeUnit.MILLISECONDS.convert(1L, TimeUnit.HOURS) > System.currentTimeMillis()) {
                                }
                            } catch (ParseException unused) {
                                continue;
                            }
                        }
                    }
                    z = false;
                } else {
                    String str4 = this.f1354b.get(str2);
                    if (str4 != null) {
                        Pattern pattern = g;
                        Locale locale = Locale.ENGLISH;
                        Matcher matcher = pattern.matcher(str4.toLowerCase(locale));
                        int iA = (matcher.find() && matcher.groupCount() == 1) ? com.fyber.inneractive.sdk.util.q.a(matcher.group(1), 0) : 0;
                        if ((str4.toLowerCase(locale).contains("public") || str4.toLowerCase(locale).contains("private") || iA > TimeUnit.SECONDS.convert(1L, TimeUnit.HOURS)) && !str4.toLowerCase(locale).contains("no-") && !str4.toLowerCase(locale).contains("must-")) {
                        }
                        z = false;
                    } else {
                        continue;
                    }
                }
            }
            break loop0;
        }
        return z;
    }

    public WebResourceResponse b() {
        return new WebResourceResponse(this.c, this.d, this.e, this.f, this.f1354b, new ByteArrayInputStream(this.a));
    }
}
