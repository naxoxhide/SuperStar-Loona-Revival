package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.applovin.impl.sdk.e.a {
    private final com.applovin.impl.sdk.d.e aHe;
    private final String aTj;
    private final List<String> aTk;
    private final a aTl;
    private StringBuffer aTm;
    private final Object aTn;
    private final ExecutorService aTo;
    private List<c> aTp;
    private final com.applovin.impl.sdk.ad.e aiL;

    public interface a {
        void d(String str, boolean z);
    }

    public b(String str, com.applovin.impl.sdk.ad.e eVar, List<String> list, com.applovin.impl.sdk.d.e eVar2, ExecutorService executorService, com.applovin.impl.sdk.n nVar, a aVar) {
        super("AsyncTaskCacheHTMLResources", nVar);
        this.aTj = str;
        this.aiL = eVar;
        this.aTk = list;
        this.aHe = eVar2;
        this.aTo = executorService;
        this.aTl = aVar;
        this.aTm = new StringBuffer(str);
        this.aTn = new Object();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: Ka, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        HashSet<c> hashSetKb;
        if (this.aTi.get()) {
            return false;
        }
        if (TextUtils.isEmpty(this.aTj)) {
            dt(this.aTj);
            return false;
        }
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLH)).booleanValue()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Resource caching is disabled, skipping cache...");
            }
            dt(this.aTj);
            return false;
        }
        HashSet hashSet = new HashSet();
        HashSet<c> hashSetKc = Kc();
        if (hashSetKc != null) {
            hashSet.addAll(hashSetKc);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPE)).booleanValue() && (hashSetKb = Kb()) != null) {
            hashSet.addAll(hashSetKb);
        }
        this.aTp = new ArrayList(hashSet);
        if (this.aTi.get()) {
            return false;
        }
        List<c> list = this.aTp;
        if (list == null || list.isEmpty()) {
            dt(this.aTj);
            return false;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Executing " + this.aTp.size() + " caching operations...");
        }
        this.aTo.invokeAll(this.aTp);
        synchronized (this.aTn) {
            dt(this.aTm.toString());
        }
        return true;
    }

    private void dt(String str) {
        a aVar;
        if (this.aTi.get() || (aVar = this.aTl) == null) {
            return;
        }
        aVar.d(str, false);
    }

    private HashSet<c> Kb() {
        HashSet<c> hashSet = new HashSet<>();
        for (final String str : StringUtils.getRegexMatches(StringUtils.match(this.aTj, (String) this.sdk.a(com.applovin.impl.sdk.c.b.aPF)), 1)) {
            if (this.aTi.get()) {
                return null;
            }
            if (!StringUtils.isValidString(str)) {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "Skip caching of non-resource " + str);
                }
            } else {
                hashSet.add(new c(str, this.aiL, Collections.emptyList(), false, this.aHe, this.sdk, new c.a() { // from class: com.applovin.impl.sdk.e.b.1
                    @Override // com.applovin.impl.sdk.e.c.a
                    public void q(Uri uri) {
                        if (uri != null) {
                            synchronized (b.this.aTn) {
                                int iIndexOf = b.this.aTm.indexOf(str);
                                b.this.aTm.replace(iIndexOf, str.length() + iIndexOf, uri.toString());
                            }
                            b.this.aiL.k(uri);
                            b.this.aHe.JR();
                            return;
                        }
                        com.applovin.impl.sdk.x xVar2 = b.this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            b.this.logger.f(b.this.tag, "Failed to cache JavaScript resource " + str);
                        }
                        if (b.this.aTl != null) {
                            b.this.aTl.d(b.this.aTj, true);
                        }
                        b.this.aHe.JS();
                    }
                }));
            }
        }
        return hashSet;
    }

    private HashSet<c> Kc() {
        HashSet<c> hashSet = new HashSet<>();
        Collection<Character> collectionKd = Kd();
        for (final String str : this.aTk) {
            char c = 0;
            int iIndexOf = 0;
            int i = 0;
            while (iIndexOf < this.aTj.length()) {
                if (this.aTi.get()) {
                    return null;
                }
                iIndexOf = this.aTj.indexOf(str, i);
                if (iIndexOf == -1) {
                    break;
                }
                int length = this.aTj.length();
                int i2 = iIndexOf;
                while (!collectionKd.contains(Character.valueOf(this.aTj.charAt(i2))) && i2 < length) {
                    i2++;
                }
                if (i2 > iIndexOf && i2 != length) {
                    final String strSubstring = this.aTj.substring(str.length() + iIndexOf, i2);
                    if (StringUtils.isValidString(strSubstring)) {
                        if (this.aiL.Hx() && this.aiL.FB().equals(str + strSubstring)) {
                            com.applovin.impl.sdk.x xVar = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Postponing caching for \"" + strSubstring + "\" video resource");
                            }
                        } else {
                            final String str2 = str + strSubstring;
                            com.applovin.impl.sdk.ad.e eVar = this.aiL;
                            String[] strArr = new String[1];
                            strArr[c] = str;
                            hashSet.add(new c(str2, eVar, Arrays.asList(strArr), true, this.aHe, this.sdk, new c.a() { // from class: com.applovin.impl.sdk.e.b.2
                                @Override // com.applovin.impl.sdk.e.c.a
                                public void q(Uri uri) {
                                    if (uri != null) {
                                        synchronized (b.this.aTn) {
                                            int iIndexOf2 = b.this.aTm.indexOf(str2);
                                            b.this.aTm.replace(iIndexOf2, str2.length() + iIndexOf2, uri.toString());
                                        }
                                        b.this.aiL.k(uri);
                                        b.this.aHe.JR();
                                        return;
                                    }
                                    if (b.this.aiL.Gu().contains(str + strSubstring) && b.this.aTl != null) {
                                        b.this.aTl.d(b.this.aTj, true);
                                    }
                                    b.this.aHe.JS();
                                }
                            }));
                        }
                    } else {
                        com.applovin.impl.sdk.x xVar2 = this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.f(this.tag, "Skip caching of non-resource " + strSubstring);
                        }
                    }
                    i = i2;
                    c = 0;
                } else {
                    com.applovin.impl.sdk.x xVar3 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return null;
                }
            }
        }
        return hashSet;
    }

    private Collection<Character> Kd() {
        HashSet hashSet = new HashSet();
        for (char c : ((String) this.sdk.a(com.applovin.impl.sdk.c.b.aLG)).toCharArray()) {
            hashSet.add(Character.valueOf(c));
        }
        hashSet.add(Character.valueOf(Typography.quote));
        return hashSet;
    }
}
