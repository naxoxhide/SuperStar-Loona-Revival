package com.kakao.adfit.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakao.adfit.AdFitSdk;
import com.kakao.adfit.h.MatrixApp;
import com.kakao.adfit.h.MatrixContexts;
import com.kakao.adfit.h.MatrixDebugImage;
import com.kakao.adfit.h.MatrixDebugMeta;
import com.kakao.adfit.h.MatrixDevice;
import com.kakao.adfit.h.MatrixOs;
import com.kakao.adfit.h.MatrixThread;
import com.kakao.adfit.h.MatrixUser;
import com.kakao.adfit.k.a0;
import com.kakao.adfit.k.t;
import com.kakao.adfit.k.v;
import com.kakao.adfit.k.w;
import com.kakao.adfit.k.y;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidEventProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\t\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000fH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R(\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/kakao/adfit/e/a;", "Lcom/kakao/adfit/e/c;", "", "", "", "e", "Lcom/kakao/adfit/e/h;", "event", "", "a", "Lcom/kakao/adfit/h/a;", "Landroid/content/Context;", "context", "c", "Lcom/kakao/adfit/h/g;", "Lcom/kakao/adfit/h/k;", "Lcom/kakao/adfit/h/q;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "Lcom/kakao/adfit/h/f;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", ViewHierarchyConstants.HINT_KEY, "Landroid/content/Context;", "Ljava/util/concurrent/Future;", "Ljava/util/concurrent/Future;", "contextData", "<init>", "(Landroid/content/Context;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class a implements c {
    private static final com.kakao.adfit.h.d d = com.kakao.adfit.h.d.INSTANCE.a();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Context context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Future<Map<String, Object>> contextData;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<Map<String, Object>> futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: com.kakao.adfit.e.-$$Lambda$a$hYOjhekWUMzEO6hmvK5XmkOBa0Q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return a.a(this.f$0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "executorService.submit<M…y>> { loadContextData() }");
        this.contextData = futureSubmit;
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map a(a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.e();
    }

    private final MatrixDebugMeta b() {
        List list;
        try {
            Object obj = this.contextData.get().get("proguardUuids");
            if (!(obj instanceof List)) {
                obj = null;
            }
            list = (List) obj;
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Error getting proguardUuids.", e);
            list = null;
        }
        if (!(list != null && (list.isEmpty() ^ true))) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new MatrixDebugImage("proguard", (String) it.next()));
        }
        return new MatrixDebugMeta(arrayList);
    }

    private final Map<String, String> c(Context context) {
        String strC;
        String strB;
        String strA;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        PackageInfo packageInfoA = w.a(context, packageName, 0, 4, null);
        String strA2 = w.a(context);
        String str = "unknown";
        if (packageInfoA == null || (strC = w.c(packageInfoA)) == null) {
            strC = "unknown";
        }
        if (packageInfoA == null || (strB = w.b(packageInfoA)) == null) {
            strB = "unknown";
        }
        if (packageInfoA != null && (strA = w.a(packageInfoA)) != null) {
            str = strA;
        }
        HashMap map = new HashMap();
        map.put("service_id", packageName);
        map.put("service_app", strA2 + ' ' + strC + '_' + strB);
        map.put("service_target_sdk_version", str);
        return map;
    }

    private final MatrixUser d() {
        String str;
        try {
            Object obj = this.contextData.get().get("androidId");
            if (!(obj instanceof String)) {
                obj = null;
            }
            str = (String) obj;
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Error getting androidId.", e);
            str = null;
        }
        if (str == null) {
            return null;
        }
        return new MatrixUser(str);
    }

    private final Map<String, Object> e() {
        HashMap map = new HashMap();
        List<String> listB = b(this.context);
        if (listB != null) {
            map.put("proguardUuids", listB);
        }
        map.put("rooted", Boolean.valueOf(y.c(this.context)));
        map.put("androidId", a0.a.c(this.context));
        map.put("kernelVersion", v.b());
        map.put("emulator", Boolean.valueOf(com.kakao.adfit.k.i.m()));
        return map;
    }

    @Override // com.kakao.adfit.e.c
    public MatrixEvent a(MatrixEvent event, Object hint) {
        Intrinsics.checkNotNullParameter(event, "event");
        MatrixContexts contexts = event.getContexts();
        if (contexts == null) {
            contexts = new MatrixContexts(null, null, null, 7, null);
            event.a(contexts);
        }
        if (!(hint instanceof com.kakao.adfit.g.a)) {
            a(event);
        }
        if (contexts.getDevice() == null) {
            contexts.a(a(this.context));
        }
        if (contexts.getOs() == null) {
            contexts.a(c());
        }
        return event;
    }

    private final MatrixOs c() {
        String str;
        Boolean bool;
        String strC = v.c();
        String strD = v.d();
        String strA = v.a();
        try {
            Object obj = this.contextData.get().get("kernelVersion");
            if (!(obj instanceof String)) {
                obj = null;
            }
            str = (String) obj;
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Error getting kernelVersion.", e);
            str = null;
        }
        try {
            Object obj2 = this.contextData.get().get("rooted");
            if (!(obj2 instanceof Boolean)) {
                obj2 = null;
            }
            bool = (Boolean) obj2;
        } catch (Exception e2) {
            com.kakao.adfit.k.f.b("Error getting rooted.", e2);
            bool = null;
        }
        return new MatrixOs(strC, strD, strA, str, bool);
    }

    private final void a(MatrixEvent event) {
        MatrixContexts contexts = event.getContexts();
        Intrinsics.checkNotNull(contexts);
        if (contexts.getApp() == null) {
            contexts.a(a());
            if (event.getDist() == null) {
                MatrixApp app = contexts.getApp();
                Intrinsics.checkNotNull(app);
                String versionCode = app.getVersionCode();
                if (versionCode != null) {
                    event.a(versionCode);
                }
            }
        }
        if (event.l() == null) {
            event.a(c(this.context));
        }
        if (event.getEnvironment() == null) {
            Map<String, String> mapL = event.l();
            event.b(mapL != null ? mapL.get("service_id") : null);
        }
        if (event.getUser() == null) {
            event.a(d());
        }
        if (event.getDebugMeta() == null) {
            event.a(b());
        }
        List<MatrixThread> listM = event.m();
        if (listM != null) {
            long id = Looper.getMainLooper().getThread().getId();
            for (MatrixThread matrixThread : listM) {
                Long id2 = matrixThread.getId();
                matrixThread.b(Boolean.valueOf(id2 != null && id2.longValue() == id));
            }
        }
    }

    private final MatrixApp a() {
        return new MatrixApp("com.kakao.adfit.ads", "AdFit Android (" + StringsKt.capitalize("network") + ')', AdFitSdk.SDK_VERSION, "1684116561", d);
    }

    private final MatrixDevice a(Context context) {
        Boolean bool;
        ActivityManager.MemoryInfo memoryInfoC = com.kakao.adfit.k.i.c(context);
        StatFs statFsE = com.kakao.adfit.k.i.e(context);
        Display displayA = com.kakao.adfit.k.j.a(context);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayA.getMetrics(displayMetrics);
        String strB = MatrixDevice.INSTANCE.b(com.kakao.adfit.k.j.a(displayA));
        Intent intentB = com.kakao.adfit.k.i.b(context);
        String strA = com.kakao.adfit.k.i.a(context);
        String strD = com.kakao.adfit.k.i.d(context);
        String strF = com.kakao.adfit.k.i.f();
        String strB2 = com.kakao.adfit.k.i.b();
        String strD2 = com.kakao.adfit.k.i.d();
        String strH = com.kakao.adfit.k.i.h();
        String strG = com.kakao.adfit.k.i.g();
        try {
            Object obj = this.contextData.get().get("emulator");
            if (!(obj instanceof Boolean)) {
                obj = null;
            }
            bool = (Boolean) obj;
        } catch (Exception e) {
            com.kakao.adfit.k.f.b("Error getting emulator.", e);
            bool = null;
        }
        List<String> listI = com.kakao.adfit.k.i.i();
        boolean zC = t.c(context);
        String strA2 = MatrixDevice.INSTANCE.a(t.b(context));
        return new MatrixDevice(strA, strD, strF, strB2, strD2, strH, strG, bool, listI, memoryInfoC != null ? Long.valueOf(com.kakao.adfit.k.i.b(memoryInfoC)) : null, memoryInfoC != null ? Long.valueOf(com.kakao.adfit.k.i.a(memoryInfoC)) : null, memoryInfoC != null ? Boolean.valueOf(com.kakao.adfit.k.i.c(memoryInfoC)) : null, statFsE != null ? Long.valueOf(com.kakao.adfit.k.i.b(statFsE)) : null, statFsE != null ? Long.valueOf(com.kakao.adfit.k.i.a(statFsE)) : null, Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Float.valueOf(displayMetrics.density), Integer.valueOf(displayMetrics.densityDpi), strB, Boolean.valueOf(zC), strA2, intentB != null ? Float.valueOf(com.kakao.adfit.k.i.a(intentB)) : null, intentB != null ? Float.valueOf(com.kakao.adfit.k.i.c(intentB)) : null, intentB != null ? Boolean.valueOf(com.kakao.adfit.k.i.d(intentB)) : null, com.kakao.adfit.h.d.INSTANCE.a(com.kakao.adfit.k.i.a()), com.kakao.adfit.k.i.k(), com.kakao.adfit.k.i.e());
    }

    private final List<String> b(Context context) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open("kakao-adfit-matrix-debug-meta.properties"));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("com.kakao.adfit.matirx.ProguardUuids");
                boolean z = false;
                if (property != null) {
                    Intrinsics.checkNotNullExpressionValue(property, "property");
                    if (property.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    Intrinsics.checkNotNullExpressionValue(property, "property");
                    List<String> listSplit$default = StringsKt.split$default((CharSequence) property, new String[]{"\\|"}, false, 0, 6, (Object) null);
                    CloseableKt.closeFinally(bufferedInputStream, null);
                    return listSplit$default;
                }
                com.kakao.adfit.k.f.a("com.kakao.adfit.matirx.ProguardUuids property was not found or it is invalid.");
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedInputStream, null);
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedInputStream, th);
                    throw th2;
                }
            }
        } catch (FileNotFoundException unused) {
            com.kakao.adfit.k.f.a("kakao-adfit-matrix-debug-meta.properties file was not found.");
        } catch (IOException e) {
            com.kakao.adfit.k.f.b("Error getting Proguard UUIDs.", e);
        } catch (RuntimeException e2) {
            com.kakao.adfit.k.f.b("kakao-adfit-matrix-debug-meta.properties file is malformed.", e2);
        }
    }
}
