package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends d implements com.applovin.impl.mediation.h.a {
    private final com.applovin.impl.sdk.t aBC;
    protected final com.applovin.impl.sdk.d.e aHe;
    private AppLovinAdLoadListener aTB;
    private final Collection<Character> aTC;
    private boolean aTD;
    protected ExecutorService aTE;
    protected List<com.applovin.impl.sdk.e.a> aTF;
    protected String aTG;
    protected ExecutorService aTo;
    protected final com.applovin.impl.sdk.ad.e aiL;

    public interface a {
        void dy(String str);
    }

    f(String str, com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.sdk.n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, nVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.aiL = eVar;
        this.aTB = appLovinAdLoadListener;
        this.aBC = nVar.Ca();
        this.aTC = Kd();
        this.aHe = new com.applovin.impl.sdk.d.e();
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aLL)).booleanValue()) {
            this.aTG = StringUtils.isValidString(eVar.Gz()) ? eVar.Gz() : UUID.randomUUID().toString();
            this.aTo = nVar.BM().f("com.applovin.sdk.caching." + this.aTG, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aLM)).intValue());
            this.aTE = nVar.BM().f("com.applovin.sdk.caching.html." + this.aTG, ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aLN)).intValue());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aiL.Gy()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Subscribing to timeout events...");
            }
            this.sdk.Cy().a(this);
        }
    }

    @Override // com.applovin.impl.mediation.h.a
    public void f(com.applovin.impl.mediation.b.a aVar) {
        if (aVar.xz().equalsIgnoreCase(this.aiL.Gz())) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Updating flag for timeout...");
            }
            Ki();
        }
        this.sdk.Cy().b(this);
    }

    protected void Kg() {
        this.sdk.Cy().b(this);
        ExecutorService executorService = this.aTo;
        if (executorService != null) {
            executorService.shutdown();
            this.aTo = null;
        }
        ExecutorService executorService2 = this.aTE;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.aTE = null;
        }
    }

    protected boolean Kh() {
        return this.aTD;
    }

    protected void Ki() {
        this.aTD = true;
        List<com.applovin.impl.sdk.e.a> list = this.aTF;
        if (list != null && !list.isEmpty()) {
            Iterator<com.applovin.impl.sdk.e.a> it = this.aTF.iterator();
            while (it.hasNext()) {
                it.next().be(true);
            }
        }
        ExecutorService executorService = this.aTo;
        if (executorService != null) {
            executorService.shutdown();
            this.aTo = null;
        }
        ExecutorService executorService2 = this.aTE;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.aTE = null;
        }
    }

    protected List<Future<Boolean>> K(List<com.applovin.impl.sdk.e.a> list) {
        this.aTF = list;
        return this.sdk.BM().a(list, this.aTo);
    }

    protected c a(String str, c.a aVar) {
        return new c(str, this.aiL, this.aHe, this.sdk, aVar);
    }

    protected List<com.applovin.impl.sdk.e.a> Kj() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiL.Ht() != null) {
            arrayList.add(a(this.aiL.Ht().toString(), new c.a() { // from class: com.applovin.impl.sdk.e.f.1
                @Override // com.applovin.impl.sdk.e.c.a
                public void q(Uri uri) {
                    f.this.aiL.n(uri);
                    com.applovin.impl.sdk.x xVar2 = f.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        f.this.logger.f(f.this.tag, "Ad updated with muteImageUri = " + uri);
                    }
                }
            }));
        }
        if (this.aiL.Hu() != null) {
            arrayList.add(a(this.aiL.Hu().toString(), new c.a() { // from class: com.applovin.impl.sdk.e.f.2
                @Override // com.applovin.impl.sdk.e.c.a
                public void q(Uri uri) {
                    f.this.aiL.o(uri);
                    com.applovin.impl.sdk.x xVar2 = f.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        f.this.logger.f(f.this.tag, "Ad updated with unmuteImageUri = " + uri);
                    }
                }
            }));
        }
        return arrayList;
    }

    protected c b(String str, c.a aVar) {
        return a(str, this.aiL.Gv(), true, aVar);
    }

    protected c a(String str, List<String> list, boolean z, final c.a aVar) {
        if (TextUtils.isEmpty(str)) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (!com.applovin.impl.sdk.x.Fk()) {
                return null;
            }
            this.logger.f(this.tag, "No video to cache, skipping...");
            return null;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching video " + str + "...");
        }
        return new c(str, this.aiL, list, z, this.aHe, this.sdk, new c.a() { // from class: com.applovin.impl.sdk.e.f.3
            @Override // com.applovin.impl.sdk.e.c.a
            public void q(Uri uri) {
                if (uri != null) {
                    com.applovin.impl.sdk.x xVar3 = f.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        f.this.logger.f(f.this.tag, "Finish caching video for ad #" + f.this.aiL.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
                    }
                    aVar.q(uri);
                    return;
                }
                com.applovin.impl.sdk.x xVar4 = f.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    f.this.logger.i(f.this.tag, "Failed to cache video");
                }
                f.this.Kl();
            }
        });
    }

    protected b a(String str, List<String> list, final a aVar) {
        return new b(str, this.aiL, list, this.aHe, this.aTE, this.sdk, new b.a() { // from class: com.applovin.impl.sdk.e.f.4
            @Override // com.applovin.impl.sdk.e.b.a
            public void d(String str2, boolean z) {
                if (z) {
                    f.this.Kl();
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.dy(str2);
                }
            }
        });
    }

    void Kk() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching mute images...");
        }
        Uri uriC = c(this.aiL.Ht(), CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (uriC != null) {
            this.aiL.n(uriC);
        }
        Uri uriC2 = c(this.aiL.Hu(), CampaignEx.JSON_NATIVE_VIDEO_UNMUTE);
        if (uriC2 != null) {
            this.aiL.o(uriC2);
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Ad updated with muteImageFilename = " + this.aiL.Ht() + ", unmuteImageFilename = " + this.aiL.Hu());
        }
    }

    Uri dv(String str) {
        return a(str, this.aiL.Gv(), true);
    }

    Uri a(String str, List<String> list, boolean z) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching video " + str + "...");
        }
        String strA = this.aBC.a(rQ(), str, this.aiL.getCachePrefix(), list, z, this.aHe);
        if (StringUtils.isValidString(strA)) {
            File fileA = this.aBC.a(strA, rQ());
            if (fileA != null) {
                Uri uriFromFile = Uri.fromFile(fileA);
                if (uriFromFile != null) {
                    com.applovin.impl.sdk.x xVar2 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f(this.tag, "Finish caching video for ad #" + this.aiL.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
                    }
                    return uriFromFile;
                }
                com.applovin.impl.sdk.x xVar3 = this.logger;
                if (!com.applovin.impl.sdk.x.Fk()) {
                    return null;
                }
                this.logger.i(this.tag, "Unable to create URI from cached video file = " + fileA);
                return null;
            }
            com.applovin.impl.sdk.x xVar4 = this.logger;
            if (!com.applovin.impl.sdk.x.Fk()) {
                return null;
            }
            this.logger.i(this.tag, "Unable to cache video = " + str + "Video file was missing or null");
            return null;
        }
        com.applovin.impl.sdk.x xVar5 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Failed to cache video");
        }
        Kl();
        return null;
    }

    protected Uri c(Uri uri, String str) {
        if (uri == null) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Failed to cache " + str + " image");
            }
            return null;
        }
        com.applovin.impl.sdk.x xVar3 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching " + str + " image...");
        }
        return dw(string);
    }

    protected Uri dw(String str) {
        return b(str, this.aiL.Gv(), true);
    }

    Uri b(String str, List<String> list, boolean z) {
        try {
            String strA = this.aBC.a(rQ(), str, this.aiL.getCachePrefix(), list, z, this.aHe);
            if (StringUtils.isValidString(strA)) {
                File fileA = this.aBC.a(strA, rQ());
                if (fileA != null) {
                    Uri uriFromFile = Uri.fromFile(fileA);
                    if (uriFromFile != null) {
                        return uriFromFile;
                    }
                    com.applovin.impl.sdk.x xVar = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Unable to extract Uri from image file");
                    }
                } else {
                    com.applovin.impl.sdk.x xVar2 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Unable to retrieve File from cached image filename = " + strA);
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (!com.applovin.impl.sdk.x.Fk()) {
                return null;
            }
            this.logger.c(this.tag, "Failed to cache image at url = " + str, th);
            return null;
        }
    }

    String c(String str, List<String> list) {
        InputStream inputStreamA;
        if (StringUtils.isValidString(str)) {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "Nothing to cache, skipping...");
                }
                return null;
            }
            try {
                File fileA = this.aBC.a(com.applovin.impl.sdk.utils.u.a(uri, this.aiL.getCachePrefix(), this.sdk), rQ());
                if (this.aBC.g(fileA)) {
                    return this.aBC.a(fileA);
                }
                try {
                    inputStreamA = this.aBC.a(str, list, true, this.aHe);
                    if (inputStreamA != null) {
                        try {
                            this.aBC.a(inputStreamA, fileA);
                        } catch (Throwable th) {
                            th = th;
                            com.applovin.impl.sdk.utils.u.a((Closeable) inputStreamA, this.sdk);
                            throw th;
                        }
                    }
                    com.applovin.impl.sdk.utils.u.a((Closeable) inputStreamA, this.sdk);
                    return this.aBC.a(fileA);
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamA = null;
                }
            } catch (Throwable th3) {
                com.applovin.impl.sdk.x xVar2 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.c(this.tag, "Resource at " + str + " failed to load.", th3);
                }
            }
        }
        return null;
    }

    String a(String str, List<String> list, com.applovin.impl.sdk.ad.e eVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLH)).booleanValue()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Resource caching is disabled, skipping cache...");
            }
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean zShouldCancelHtmlCachingIfShown = eVar.shouldCancelHtmlCachingIfShown();
        boolean zHx = eVar.Hx();
        List<String> listGu = eVar.Gu();
        for (String str2 : list) {
            int iIndexOf = 0;
            int i = 0;
            while (iIndexOf < sb.length()) {
                if (Kh()) {
                    return str;
                }
                iIndexOf = sb.indexOf(str2, i);
                if (iIndexOf == -1) {
                    break;
                }
                int length = sb.length();
                int i2 = iIndexOf;
                while (!this.aTC.contains(Character.valueOf(sb.charAt(i2))) && i2 < length) {
                    i2++;
                }
                if (i2 > iIndexOf && i2 != length) {
                    String strSubstring = sb.substring(str2.length() + iIndexOf, i2);
                    if (StringUtils.isValidString(strSubstring)) {
                        if (zShouldCancelHtmlCachingIfShown && eVar.hasShown()) {
                            com.applovin.impl.sdk.x xVar2 = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Cancelling HTML caching due to ad being shown already");
                            }
                            this.aHe.JQ();
                            return str;
                        }
                        if (zHx && eVar.FB().equals(str2 + strSubstring)) {
                            com.applovin.impl.sdk.x xVar3 = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Postponing caching for \"" + strSubstring + "\" video resource");
                            }
                        } else {
                            Uri uriK = K(str2, strSubstring);
                            if (uriK != null) {
                                sb.replace(iIndexOf, i2, uriK.toString());
                                eVar.k(uriK);
                                this.aHe.JR();
                            } else {
                                if (listGu.contains(str2 + strSubstring)) {
                                    Kl();
                                    this.aTD = true;
                                }
                                this.aHe.JS();
                            }
                        }
                    } else {
                        com.applovin.impl.sdk.x xVar4 = this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.f(this.tag, "Skip caching of non-resource " + strSubstring);
                        }
                    }
                    i = i2;
                } else {
                    com.applovin.impl.sdk.x xVar5 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Unable to cache resource; ad HTML is invalid.");
                    }
                    return str;
                }
            }
        }
        return sb.toString();
    }

    void b(AppLovinAdBase appLovinAdBase) {
        com.applovin.impl.sdk.d.d.a(this.aHe, appLovinAdBase, this.sdk);
    }

    private Uri K(String str, String str2) {
        String strA;
        String cachePrefix = this.aiL.getCachePrefix();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLT)).booleanValue()) {
            strA = com.applovin.impl.sdk.utils.u.a(Uri.parse(str2), cachePrefix, this.sdk);
        } else {
            String strReplace = str2.replace(RemoteSettings.FORWARD_SLASH_STRING, "_");
            strA = StringUtils.isValidString(cachePrefix) ? cachePrefix + strReplace : strReplace;
        }
        File fileA = this.aBC.a(strA, com.applovin.impl.sdk.n.getApplicationContext());
        if (fileA == null) {
            return null;
        }
        if (this.aBC.g(fileA)) {
            this.aHe.bX(fileA.length());
            return Uri.parse("file://" + fileA.getAbsolutePath());
        }
        if (this.aBC.a(fileA, str + str2, Arrays.asList(str), this.aHe)) {
            return Uri.parse("file://" + fileA.getAbsolutePath());
        }
        return null;
    }

    String dx(final String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.applovin.impl.sdk.network.c cVarIe = com.applovin.impl.sdk.network.c.D(this.sdk).da(str).db("GET").ad("").gC(0).Ie();
        final AtomicReference atomicReference = new AtomicReference(null);
        this.sdk.BO().a(cVarIe, new com.applovin.impl.sdk.network.b.a(), new com.applovin.impl.sdk.network.b.d<String>() { // from class: com.applovin.impl.sdk.e.f.5
            @Override // com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void d(String str2, int i) {
                atomicReference.set(str2);
            }

            @Override // com.applovin.impl.sdk.network.b.d
            public void a(int i, String str2, String str3) {
                com.applovin.impl.sdk.x xVar = f.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    f.this.logger.i(f.this.tag, "Failed to load resource from '" + str + "'");
                }
            }
        });
        String str2 = (String) atomicReference.get();
        if (str2 != null) {
            this.aHe.bW(str2.length());
        }
        return str2;
    }

    void Kl() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.aTB;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            this.aTB = null;
        }
        Ki();
    }

    void Km() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Rendered new ad:" + this.aiL);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.e.-$$Lambda$f$832uY5PQI7e8F_7OG_nJ8rl8ykI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Kn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kn() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.aTB;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.aiL);
            this.aTB = null;
        }
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
