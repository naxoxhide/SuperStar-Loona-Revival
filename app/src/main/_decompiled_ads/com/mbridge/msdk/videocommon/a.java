package com.mbridge.msdk.videocommon;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TemplateWebviewCache.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static ConcurrentHashMap<String, C0524a> a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0524a> f2649b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> f = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> h = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> i = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, C0524a> j = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TemplateWebviewCache.java */
    public static class C0524a {
        private WindVaneWebView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2650b;

        public final WindVaneWebView a() {
            return this.a;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.f2650b;
        }

        public final void a(boolean z) {
            this.f2650b = z;
        }
    }

    public static C0524a a(String str) {
        if (g.containsKey(str)) {
            return g.get(str);
        }
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (i.containsKey(str)) {
            return i.get(str);
        }
        if (j.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, C0524a c0524a, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                h.put(str, c0524a);
                return;
            } else {
                g.put(str, c0524a);
                return;
            }
        }
        if (z2) {
            j.put(str, c0524a);
        } else {
            i.put(str, c0524a);
        }
    }

    public static void b(String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (i.containsKey(str)) {
            i.remove(str);
        }
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (j.containsKey(str)) {
            j.remove(str);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : g.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    g.remove(str2);
                }
            }
        } else {
            g.clear();
        }
        h.clear();
    }

    public static void a() {
        i.clear();
        j.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0524a> entry : g.entrySet()) {
            if (entry.getKey().contains(str)) {
                g.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0524a> entry : h.entrySet()) {
            if (entry.getKey().contains(str)) {
                h.remove(entry.getKey());
            }
        }
    }

    public static C0524a a(int i2, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i2 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i2 != 94) {
                if (i2 != 287) {
                    if (i2 == 288) {
                        ConcurrentHashMap<String, C0524a> concurrentHashMap = d;
                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                            return d.get(requestIdNotice);
                        }
                    } else {
                        ConcurrentHashMap<String, C0524a> concurrentHashMap2 = a;
                        if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                            return a.get(requestIdNotice);
                        }
                    }
                } else if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0524a> concurrentHashMap3 = c;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return c.get(requestIdNotice);
                    }
                } else {
                    ConcurrentHashMap<String, C0524a> concurrentHashMap4 = f;
                    if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                        return f.get(requestIdNotice);
                    }
                }
            } else if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0524a> concurrentHashMap5 = f2649b;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f2649b.get(requestIdNotice);
                }
            } else {
                ConcurrentHashMap<String, C0524a> concurrentHashMap6 = e;
                if (concurrentHashMap6 != null && concurrentHashMap6.size() > 0) {
                    return e.get(requestIdNotice);
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i2, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            String requestIdNotice = campaignEx.getRequestIdNotice();
            if (i2 == 288) {
                requestIdNotice = campaignEx.getKeyIaUrl();
            }
            if (i2 == 94) {
                if (campaignEx.isBidCampaign()) {
                    ConcurrentHashMap<String, C0524a> concurrentHashMap = f2649b;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0524a> concurrentHashMap2 = e;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (i2 != 287) {
                if (i2 == 288) {
                    ConcurrentHashMap<String, C0524a> concurrentHashMap3 = d;
                    if (concurrentHashMap3 != null) {
                        concurrentHashMap3.remove(requestIdNotice);
                        return;
                    }
                    return;
                }
                ConcurrentHashMap<String, C0524a> concurrentHashMap4 = a;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(requestIdNotice);
                    return;
                }
                return;
            }
            if (campaignEx.isBidCampaign()) {
                ConcurrentHashMap<String, C0524a> concurrentHashMap5 = c;
                if (concurrentHashMap5 != null) {
                    concurrentHashMap5.remove(requestIdNotice);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, C0524a> concurrentHashMap6 = f;
            if (concurrentHashMap6 != null) {
                concurrentHashMap6.remove(requestIdNotice);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i2, String str, C0524a c0524a) {
        try {
            if (i2 == 94) {
                if (f2649b == null) {
                    f2649b = new ConcurrentHashMap<>();
                }
                f2649b.put(str, c0524a);
            } else {
                if (i2 != 287) {
                    return;
                }
                if (c == null) {
                    c = new ConcurrentHashMap<>();
                }
                c.put(str, c0524a);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(int i2, String str, C0524a c0524a) {
        try {
            if (i2 == 94) {
                if (e == null) {
                    e = new ConcurrentHashMap<>();
                }
                e.put(str, c0524a);
            } else if (i2 == 287) {
                if (f == null) {
                    f = new ConcurrentHashMap<>();
                }
                f.put(str, c0524a);
            } else if (i2 == 288) {
                if (d == null) {
                    d = new ConcurrentHashMap<>();
                }
                d.put(str, c0524a);
            } else {
                if (a == null) {
                    a = new ConcurrentHashMap<>();
                }
                a.put(str, c0524a);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
