package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameOptimizedController.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ac {
    public volatile JSONObject a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Boolean> f2198b;
    private volatile ConcurrentHashMap<String, Integer> c;
    private volatile com.mbridge.msdk.c.c d;
    private final Object e;
    private final Object f;
    private final Object g;
    private String h;

    private ac() {
        this.e = new Object();
        this.f = new Object();
        this.g = new Object();
    }

    public static ac a() {
        return a.a;
    }

    public final int a(String str, String str2, int i) {
        Integer numValueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> concurrentHashMapD = d();
                Integer numB = b(str3, concurrentHashMapD);
                if (numB != null) {
                    return numB.intValue();
                }
                try {
                    numValueOf = Integer.valueOf(b(str, str2, i));
                } catch (Exception unused) {
                    numValueOf = Integer.valueOf(i);
                }
                concurrentHashMapD.put(str3, numValueOf);
                return numValueOf.intValue();
            }
            return a(str2, i);
        } catch (Exception unused2) {
            return i;
        }
    }

    private int b(String str, String str2, int i) {
        if (b()) {
            return i;
        }
        try {
            String strOptString = this.a.optString(str, "");
            if (TextUtils.isEmpty(strOptString)) {
                return i;
            }
            String strB = u.b(strOptString);
            return TextUtils.isEmpty(strB) ? i : new JSONObject(strB).optInt(str2, i);
        } catch (Exception unused) {
            return i;
        }
    }

    public final int a(String str, int i) {
        Integer numValueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i;
            }
            ConcurrentHashMap<String, Integer> concurrentHashMapD = d();
            Integer numB = b(str, concurrentHashMapD);
            if (numB != null) {
                return numB.intValue();
            }
            try {
                numValueOf = Integer.valueOf(b(str, i));
            } catch (Exception unused) {
                numValueOf = Integer.valueOf(i);
            }
            concurrentHashMapD.put(str, numValueOf);
            return numValueOf.intValue();
        } catch (Exception unused2) {
            return i;
        }
    }

    public final boolean a(String str, boolean z) {
        Boolean boolValueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            ConcurrentHashMap<String, Boolean> concurrentHashMapC = c();
            Boolean boolA = a(str, concurrentHashMapC);
            if (boolA != null) {
                return boolA.booleanValue();
            }
            try {
                boolValueOf = Boolean.valueOf(b(str, z));
            } catch (Exception unused) {
                boolValueOf = Boolean.valueOf(z);
            }
            concurrentHashMapC.put(str, boolValueOf);
            return boolValueOf.booleanValue();
        } catch (Exception unused2) {
            return z;
        }
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(String str, boolean z) {
        if (b()) {
            return z;
        }
        try {
            return this.a.optInt(str, z ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z;
        }
    }

    private int b(String str, int i) {
        if (b()) {
            return i;
        }
        try {
            return this.a.optInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[Catch: Exception -> 0x0037, all -> 0x0051, TryCatch #1 {Exception -> 0x0037, blocks: (B:11:0x0016, B:13:0x001e, B:14:0x002a), top: B:33:0x0016, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x003e A[Catch: all -> 0x0051, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:18:0x003a, B:20:0x003e, B:21:0x0046, B:11:0x0016, B:13:0x001e, B:14:0x002a, B:17:0x0038), top: B:31:0x0003, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private boolean b() {
        synchronized (this.g) {
            if (this.d == null) {
                try {
                    if (TextUtils.isEmpty(this.h)) {
                        this.h = com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID);
                    }
                    this.d = com.mbridge.msdk.c.d.a().g(this.h);
                } catch (Exception unused) {
                    this.d = null;
                }
                if (this.d != null) {
                    this.a = this.d.j();
                }
            } else {
                if (this.d.aG() == 1) {
                    if (TextUtils.isEmpty(this.h)) {
                        this.h = com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.SDK_APP_ID);
                    }
                    this.d = com.mbridge.msdk.c.d.a().g(this.h);
                    if (this.d != null) {
                        this.a = this.d.j();
                    }
                } else if (this.d != null) {
                    this.a = this.d.j();
                }
            }
            throw th;
        }
        return this.d == null || this.a == null;
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.e) {
            if (this.f2198b == null) {
                this.f2198b = new ConcurrentHashMap<>();
            }
        }
        return this.f2198b;
    }

    private ConcurrentHashMap<String, Integer> d() {
        synchronized (this.f) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
        }
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SameOptimizedController.java */
    static final class a {
        private static final ac a = new ac();
    }
}
