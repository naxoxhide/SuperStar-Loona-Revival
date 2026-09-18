package b.b.a.a.d.g;

import android.text.TextUtils;

/* JADX INFO: compiled from: RitScreenUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a(String str) {
        return b.b.a.a.d.c.c() && b(str);
    }

    public static boolean b(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }
}
