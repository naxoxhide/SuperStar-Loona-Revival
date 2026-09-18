package b.b.a.a.d.d.i;

import android.text.TextUtils;
import android.widget.TextView;
import b.b.a.a.d.f.m;
import com.bytedance.sdk.component.utils.t;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LayoutUnitSizeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f102b;

    public static a.c a(String str, String str2, String str3, boolean z, boolean z2, int i, b.b.a.a.d.d.h.h hVar, double d, int i2, double d2, String str4, m mVar) {
        int i3;
        int i4;
        float f;
        String str5 = str;
        String strA = mVar.a();
        int iF = mVar.f();
        if (b.b.a.a.d.c.c() && i2 != 4 && (TextUtils.equals(str2, "text_star") || TextUtils.equals(str2, "score-count") || TextUtils.equals(str2, "score-count-type-1") || TextUtils.equals(str2, "score-count-type-2"))) {
            return new a.c(0.0f, 0.0f);
        }
        a.c cVar = new a.c();
        if (str5.startsWith("<svg") || a.contains(str2)) {
            try {
                if ("close".equals(str2)) {
                    float fOptDouble = (float) new JSONObject(str3).optDouble("fontSize");
                    cVar.a = fOptDouble;
                    cVar.f96b = fOptDouble;
                    return cVar;
                }
            } catch (Exception unused) {
            }
            cVar.a = 10.0f;
            cVar.f96b = 10.0f;
            return cVar;
        }
        if ("logo".equals(str2)) {
            if (!b.b.a.a.d.c.c() && ((!TextUtils.isEmpty(str) && str5.contains("adx:")) || b())) {
                return b() ? a(cVar, str5, str3, f102b) : a(cVar, str5, str3, "");
            }
            cVar.a = "union".equals(str5) ? 10.0f : 20.0f;
            cVar.f96b = 10.0f;
            if (b.b.a.a.d.c.c()) {
                String str6 = str2 + str5;
                float fB = (float) b(str3);
                if (str6.contains("logoad")) {
                    a.c cVarA = a("AD", str3);
                    cVarA.f96b = fB;
                    return cVarA;
                }
                cVar.f96b = fB;
            }
            return cVar;
        }
        if ("development-name".equals(str2)) {
            str5 = t.k(b.b.a.a.d.c.a(), "tt_text_privacy_development") + str5;
        }
        if ("app-version".equals(str2)) {
            str5 = t.k(b.b.a.a.d.c.a(), "tt_text_privacy_app_version") + str5;
        }
        if ("score-count".equals(str2)) {
            try {
                i3 = Integer.parseInt(str5);
            } catch (NumberFormatException unused2) {
                i3 = 0;
            }
            return (!b.b.a.a.d.c.c() || i3 >= 0) ? a("(" + String.format(t.k(b.b.a.a.d.c.a(), "tt_comment_num"), Integer.valueOf(i3)) + ")", str3) : new a.c(0.0f, 0.0f);
        }
        if ("score-count-type-2".equals(str2)) {
            try {
                i4 = Integer.parseInt(str5);
            } catch (NumberFormatException unused3) {
                i4 = 0;
            }
            return (!b.b.a.a.d.c.c() || i4 >= 0) ? a("(" + String.format(new DecimalFormat("###,###,###").format(i4), Integer.valueOf(i4)) + ")", str3) : new a.c(0.0f, 0.0f);
        }
        if ("feedback-dislike".equals(str2)) {
            a.c cVarA2 = a(t.k(b.b.a.a.d.c.a(), "tt_reward_feedback"), str3);
            if (b.b.a.a.d.c.c()) {
                cVarA2.a = cVarA2.f96b;
            }
            return cVarA2;
        }
        if ("skip-with-time-countdown".equals(str2) || TextUtils.equals("skip-with-countdowns-video-countdown", str2)) {
            if (mVar.b() && b.b.a.a.d.g.c.a(strA)) {
                return ((int) (d + 0.5d)) - iF < 10 ? a(String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip"), "0"), str3) : a(String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip"), "00"), str3);
            }
            return d < 10.0d ? a("0S", str3) : a("00S", str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-btn", str2)) {
            return a("| " + t.k(b.b.a.a.d.c.a(), "tt_reward_screen_skip_tx"), str3);
        }
        if (TextUtils.equals("skip-with-countdowns-skip-countdown", str2)) {
            return a("| " + String.format(t.k(b.b.a.a.d.c.a(), "tt_reward_full_skip_count_down"), "00"), str3);
        }
        if ("skip-with-time-skip-btn".equals(str2)) {
            a.c cVarA3 = a("| " + t.k(b.b.a.a.d.c.a(), "tt_reward_screen_skip_tx"), str3);
            if (b.b.a.a.d.c.c()) {
                try {
                    cVarA3.f96b = (float) ((((double) cVarA3.f96b) * new JSONObject(str3).optDouble("lineHeight")) / 1.2d);
                } catch (Throwable unused4) {
                }
                cVarA3.a = cVarA3.f96b;
            }
            return cVarA3;
        }
        if ("skip".equals(str2)) {
            return a(t.k(b.b.a.a.d.c.a(), "tt_reward_screen_skip_tx"), str3);
        }
        if ("timedown".equals(str2)) {
            return a(IdManager.DEFAULT_VERSION_NAME, str3);
        }
        if ("text_star".equals(str2)) {
            return (!b.b.a.a.d.c.c() || (d2 >= 0.0d && d2 <= 5.0d)) ? a(IdManager.DEFAULT_VERSION_NAME, str3) : new a.c(0.0f, 0.0f);
        }
        if (TextUtils.equals("privacy-detail", str2)) {
            return a("Permission list | Privacy policy", str3);
        }
        if ("arrowButton".equals(str2)) {
            return a("Download", str3);
        }
        if ("title".equals(str2)) {
            try {
                return a(str5.replace('\n', ' '), str3, true);
            } catch (Exception unused5) {
            }
        }
        if ("fillButton".equals(str2) || "text".equals(str2) || "button".equals(str2) || "downloadWithIcon".equals(str2) || "downloadButton".equals(str2) || "laceButton".equals(str2) || "cardButton".equals(str2) || "colourMixtureButton".equals(str2) || "arrowButton".equals(str2) || "source".equals(str2) || TextUtils.equals("app-version", str2) || TextUtils.equals("development-name", str2)) {
            return a(str5, str3);
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            int length = str5.length();
            float fOptDouble2 = (float) jSONObject.optDouble("fontSize");
            float fOptDouble3 = (float) jSONObject.optDouble("letterSpacing");
            float fOptDouble4 = (float) jSONObject.optDouble("lineHeight");
            float fOptDouble5 = (float) jSONObject.optDouble("maxWidth");
            float f2 = (length * (fOptDouble2 + fOptDouble3)) - fOptDouble3;
            com.bytedance.sdk.component.utils.m.b("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + fOptDouble3 + ",lineHeight==" + fOptDouble4 + ",maxWidth ==" + fOptDouble5 + ",totalStrLength" + f2);
            if ("muted".equals(str2)) {
                cVar.a = fOptDouble2;
                cVar.f96b = fOptDouble2;
                return cVar;
            }
            if ("star".equals(str2)) {
                if (b.b.a.a.d.c.c() && (d2 < 0.0d || d2 > 5.0d || i2 != 4)) {
                    return new a.c(0.0f, 0.0f);
                }
                a.c cVarA4 = a("str", str3);
                cVarA4.a = fOptDouble2 * 5.0f;
                return cVarA4;
            }
            if (RewardPlus.ICON.equals(str2)) {
                cVar.a = fOptDouble2;
                cVar.f96b = fOptDouble2;
                return cVar;
            }
            if (z) {
                int i5 = ((int) (f2 / fOptDouble5)) + 1;
                if (z2 && i5 >= i) {
                    i5 = i;
                }
                f = (float) (((double) (fOptDouble4 * fOptDouble2 * i5)) * 1.2d);
            } else {
                float f3 = (float) (((double) (fOptDouble4 * fOptDouble2)) * 1.2d);
                if (f2 <= fOptDouble5) {
                    fOptDouble5 = f2;
                }
                f = f3;
            }
            cVar.a = fOptDouble5;
            cVar.f96b = f;
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static double b(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString("fontSize"));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] b(String str, float f, boolean z) {
        int[] iArrA = a(str, f, z);
        return new int[]{b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), iArrA[0]), b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), iArrA[1])};
    }

    public static boolean b() {
        return !TextUtils.isEmpty(f102b);
    }

    public static String a(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static a.c a(a.c cVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            cVar.a = 0.0f;
            cVar.f96b = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = a(str);
            }
            if (TextUtils.isEmpty(str3)) {
                cVar.a = 0.0f;
                cVar.f96b = 0.0f;
            } else {
                return a(str3, str2);
            }
        }
        return cVar;
    }

    public static a.c a(String str, String str2) {
        return a(str, str2, false);
    }

    public static a.c a(String str, String str2, boolean z) {
        a.c cVar = new a.c();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrB = b(str, (float) b(str2), z);
            cVar.a = iArrB[0];
            cVar.f96b = iArrB[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                cVar.f96b = 0.0f;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cVar;
    }

    public static int[] a(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(b.b.a.a.d.c.a());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String a() {
        return f102b;
    }
}
