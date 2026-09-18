package com.tnkfactory.ad.pub.a;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tnkfactory.ad.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class w {
    public Map<String, Integer> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2894b = 1;
    public Set<View> c = new HashSet();
    public Set<View> d = new HashSet();
    public Set<View> e = new HashSet();
    public Set<View> f = new HashSet();
    public Set<View> g = new HashSet();
    public Map<String, String> h = new HashMap();
    public Set<k0> i = new HashSet();
    public Map<String, String> j = new HashMap();
    public JSONObject k;
    public JSONObject l;
    public JSONArray m;

    public w(JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray) {
        this.k = jSONObject;
        this.l = jSONObject2;
        this.m = jSONArray;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.Integer>] */
    public final int a(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num != null) {
            return num.intValue();
        }
        this.a.put(str, Integer.valueOf(this.f2894b));
        int i = this.f2894b;
        this.f2894b = i + 1;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0363  */
    /* JADX WARN: Code duplicated, block: B:151:0x0368  */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.HashSet, java.util.Set<com.tnkfactory.ad.pub.a.k0>] */
    public final View a(Context context, int i, int i2, JSONObject jSONObject, int i3) {
        int i4;
        int i5;
        int i6;
        char c;
        int i7;
        int i8;
        LinearLayout.LayoutParams layoutParams;
        ImageView.ScaleType scaleType;
        JSONObject jSONObject2;
        View viewA;
        w wVar = this;
        int paddingRight = i;
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        String strOptString = jSONObject.optString(u.a("d2611193"));
        if (u.a("ca791899fc45").equals(strOptString)) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            int i9 = 0;
            String strA = a(relativeLayout, i, i2, jSONObject, i3);
            int i10 = relativeLayout.getLayoutParams().width;
            int paddingBottom = relativeLayout.getLayoutParams().height;
            if (i10 != -1) {
                paddingRight = i10;
            }
            if (paddingBottom == -1) {
                paddingBottom = i2;
            }
            if (paddingRight > 0) {
                paddingRight -= relativeLayout.getPaddingRight() + relativeLayout.getPaddingLeft();
            }
            if (paddingBottom > 0) {
                paddingBottom -= relativeLayout.getPaddingBottom() + relativeLayout.getPaddingTop();
            }
            int i11 = paddingBottom;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(u.a("c570089aed"));
            if (jSONArrayOptJSONArray != null) {
                if (paddingRight < 0 || i11 < 0) {
                    Logger.e("error #9001 : " + paddingRight + "," + i11);
                    return null;
                }
                while (i9 < jSONArrayOptJSONArray.length()) {
                    int i12 = i11;
                    String str = strA;
                    View viewA2 = a(context, paddingRight, i11, jSONArrayOptJSONArray.optJSONObject(i9), i3);
                    if (viewA2 != null) {
                        relativeLayout.addView(viewA2);
                    }
                    i9++;
                    strA = str;
                    i11 = i12;
                }
            }
            int i13 = i11;
            if (u.a("c5770f82ec5f85").equals(strA) && (jSONObject2 = wVar.l) != null && i3 == -1 && (viewA = a(context, paddingRight, i13, jSONObject2, i3)) != null) {
                relativeLayout.addView(viewA);
            }
            return relativeLayout;
        }
        if (u.a("cf750091ec").equals(strOptString)) {
            ImageView imageView = new ImageView(context);
            a(imageView, i, i2, jSONObject, i3);
            switch (jSONObject.optInt(u.a("d57b009aec"), 6)) {
                case 0:
                    scaleType = ImageView.ScaleType.MATRIX;
                    break;
                case 1:
                    scaleType = ImageView.ScaleType.FIT_XY;
                    break;
                case 2:
                    scaleType = ImageView.ScaleType.FIT_START;
                    break;
                case 3:
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                    break;
                case 4:
                    scaleType = ImageView.ScaleType.FIT_END;
                    break;
                case 5:
                    scaleType = ImageView.ScaleType.CENTER;
                    break;
                case 6:
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                    break;
                case 7:
                    scaleType = ImageView.ScaleType.CENTER_INSIDE;
                    break;
                default:
                    return imageView;
            }
            imageView.setScaleType(scaleType);
            return imageView;
        }
        if (u.a("d27d1982").equals(strOptString)) {
            TextView textView = new TextView(context);
            wVar.a(a(textView, i, i2, jSONObject, i3), textView, jSONObject, i3);
            return textView;
        }
        if (u.a("c46d1582e65f").equals(strOptString)) {
            Button button = new Button(context);
            wVar.a(a(button, i, i2, jSONObject, i3), button, jSONObject, i3);
            return button;
        }
        if (u.a("d2770691e554").equals(strOptString)) {
            ToggleButton toggleButton = new ToggleButton(context);
            wVar.a(a(toggleButton, i, i2, jSONObject, i3), toggleButton, jSONObject, i3);
            return toggleButton;
        }
        if (u.a("d17d03").equals(strOptString)) {
            FrameLayout frameLayout = new FrameLayout(context);
            a(frameLayout, i, i2, jSONObject, i3);
            return frameLayout;
        }
        if (u.a("cb6a009fed").equals(strOptString)) {
            FrameLayout frameLayout2 = new FrameLayout(context);
            a(frameLayout2, i, i2, jSONObject, i3);
            return frameLayout2;
        }
        if (!u.a("d6790693").equals(strOptString)) {
            if (u.a("d479159fe756").equals(strOptString)) {
                z0 z0Var = new z0(context);
                a(z0Var, i, i2, jSONObject, i3);
                z0Var.setNumStars(jSONObject.optInt(u.a("c86d0ca9fa459079"), 5));
                z0Var.setMaxRating((float) jSONObject.optDouble(u.a("cb7919a9fb508562fd78"), 5.0d));
                z0Var.setStepSize((float) jSONObject.optDouble(u.a("d56c0486d6429871f6"), 0.0d));
                String strOptString2 = jSONObject.optString(u.a("c5770d99fb"));
                if (strOptString2.length() > 0) {
                    String[] strArrSplit = strOptString2.split(",");
                    if (strArrSplit.length > 0 && strArrSplit[0].trim().length() > 0) {
                        z0Var.setTintColor((int) l0.a(strArrSplit[0]));
                    }
                    if (strArrSplit.length > 1 && strArrSplit[1].trim().length() > 0) {
                        z0Var.setGrayColor((int) l0.a(strArrSplit[1]));
                    }
                }
                return z0Var;
            }
            if (!u.a("d0710593e6").equals(strOptString)) {
                if (u.a("df771482fc5394").equals(strOptString)) {
                    com.tnkfactory.ad.pub.f fVar = new com.tnkfactory.ad.pub.f(context, jSONObject.optInt(u.a("d0770d83e454ae6ae7"), 0));
                    a(fVar, i, i2, jSONObject, i3);
                    return fVar;
                }
                if (u.a("d2710c93fb").equals(strOptString)) {
                    long jOptLong = jSONObject.optLong(u.a("c27d0d97f0"));
                    String strOptString3 = jSONObject.optString(u.a("d2791391ec45"));
                    if (jOptLong > 0 && strOptString3.length() > 0) {
                        this.i.add(new k0(strOptString3, jOptLong));
                    }
                }
                return null;
            }
            com.tnkfactory.ad.pub.d dVar = new com.tnkfactory.ad.pub.d(context, jSONObject.optInt(u.a("d66a0e91fb548278cc7d6551"), 1), jSONObject.optBoolean(u.a("cd7d0486d6419d6aea"), false), jSONObject.optInt(u.a("d0770d83e454ae6ae7"), 0));
            a(dVar, i, i2, jSONObject, i3);
            dVar.setKeepRatio(jSONObject.optBoolean(u.a("cd7d0486d643907ffa70"), true));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            String strOptString4 = jSONObject.optString(u.a("d0710593e66e9067fa786a"));
            if (strOptString4.length() > 0) {
                a(strOptString4, layoutParams2);
            } else {
                layoutParams2.addRule(13);
            }
            String strOptString5 = jSONObject.optString(u.a("d0710593e66e9c6ae1786d4d"));
            if (strOptString5.length() > 0) {
                int[] iArrA = l0.a(context, paddingRight, i2, strOptString5);
                layoutParams2.leftMargin = iArrA[0];
                layoutParams2.topMargin = iArrA[1];
                layoutParams2.rightMargin = iArrA[2];
                layoutParams2.bottomMargin = iArrA[3];
            } else {
                layoutParams2.leftMargin = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.bottomMargin = 0;
            }
            dVar.setVideoFrameLayoutParams(layoutParams2);
            String strOptString6 = jSONObject.optString(u.a("d0710593e66e8364e67160"));
            if (strOptString6.length() > 0) {
                dVar.setVideoClipRound((int) l0.a(context, paddingRight, strOptString6));
            }
            return dVar;
        }
        if (i3 > -1) {
            return null;
        }
        String strTrim = jSONObject.optString(u.a("c96a0893e745907ffa706a")).trim();
        int i14 = (strTrim.length() <= 0 || !strTrim.startsWith("v")) ? 0 : 1;
        String strTrim2 = jSONObject.optString(u.a("d6790693d6509d62f471")).trim();
        if (strTrim2.length() > 0) {
            i4 = (strTrim2.startsWith("t") || strTrim2.startsWith("l")) ? 1 : 0;
            if (strTrim2.startsWith(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                i4 = 2;
            }
            if (strTrim2.startsWith(CampaignEx.JSON_KEY_AD_R)) {
                i4 = 2;
            }
        } else {
            i4 = 0;
        }
        s0 s0Var = new s0(context, i14, i4);
        a(s0Var, i, i2, jSONObject, i3);
        String strOptString7 = jSONObject.optString(u.a("c76d1599d6429279fc7368"));
        if (strOptString7.length() > 0) {
            String[] strArrSplit2 = strOptString7.split(",");
            long jA = strArrSplit2.length > 1 ? l0.a(strArrSplit2[1]) : 0L;
            i5 = 0;
            s0Var.o = strArrSplit2.length > 0 ? l0.a(strArrSplit2[0]) : 0L;
            if (jA > 1000) {
                s0Var.p = jA;
            }
        } else {
            i5 = 0;
        }
        String strOptString8 = jSONObject.optString(u.a("d6790693d6439e7efd7b"));
        if (strOptString8.length() > 0) {
            s0Var.setPageClipRound((int) l0.a(context, paddingRight, strOptString8));
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(u.a("d6790693d65d9072fc6a70"));
        JSONArray jSONArray = wVar.m;
        if (jSONArray != null && jSONArray.length() > 0 && jSONObjectOptJSONObject != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) s0Var.getLayoutParams();
            int paddingRight2 = layoutParams3.width;
            int paddingBottom2 = layoutParams3.height;
            if (paddingRight2 > 0) {
                paddingRight2 -= s0Var.getPaddingRight() + s0Var.getPaddingLeft();
            }
            int i15 = paddingRight2;
            if (paddingBottom2 > 0) {
                paddingBottom2 -= s0Var.getPaddingBottom() + s0Var.getPaddingTop();
            }
            int i16 = paddingBottom2;
            if (i14 == 0) {
                i6 = i15;
            } else {
                paddingRight = i2;
                i6 = i16;
            }
            int iA = (int) l0.a(context, paddingRight, jSONObject.optString(u.a("d6790693d65c9079f4766a"), "10dp"));
            int i17 = i5;
            while (i17 < wVar.m.length()) {
                int i18 = i17;
                View viewA3 = a(context, i15, i16, jSONObjectOptJSONObject, i18);
                int i19 = viewA3.getLayoutParams().width;
                int i20 = viewA3.getLayoutParams().height;
                int i21 = (int) ((i6 - ((iA * 2) + (i14 == 1 ? i20 : i19))) / 2.0f);
                if (i18 == 0) {
                    i7 = i21 + iA;
                } else {
                    if (i18 == wVar.m.length() - 1) {
                        i8 = i21 + iA;
                        i7 = iA;
                    } else {
                        i7 = iA;
                    }
                    layoutParams = new LinearLayout.LayoutParams(i19, i20);
                    if (i14 == 1) {
                        layoutParams.topMargin = i7;
                        layoutParams.bottomMargin = i8;
                    } else {
                        layoutParams.leftMargin = i7;
                        layoutParams.rightMargin = i8;
                    }
                    viewA3.setLayoutParams(layoutParams);
                    s0Var.a(viewA3);
                    i17 = i18 + 1;
                    wVar = this;
                }
                i8 = 0;
                layoutParams = new LinearLayout.LayoutParams(i19, i20);
                if (i14 == 1) {
                    layoutParams.topMargin = i7;
                    layoutParams.bottomMargin = i8;
                } else {
                    layoutParams.leftMargin = i7;
                    layoutParams.rightMargin = i8;
                }
                viewA3.setLayoutParams(layoutParams);
                s0Var.a(viewA3);
                i17 = i18 + 1;
                wVar = this;
            }
            s0Var.setPageMargin(iA);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(u.a("cf76059fea508564e1"));
            if (jSONObjectOptJSONObject2 != null) {
                try {
                    String strOptString9 = jSONObjectOptJSONObject2.optString(u.a("d1710582e1"));
                    String strOptString10 = jSONObjectOptJSONObject2.optString(u.a("ce7d0891e145"));
                    if (i14 == 1) {
                        if (strOptString9.length() == 0) {
                            jSONObjectOptJSONObject2.put(u.a("d1710582e1"), -2);
                        }
                        if (strOptString10.length() == 0) {
                            jSONObjectOptJSONObject2.put(u.a("ce7d0891e145"), -1);
                        }
                    } else {
                        if (strOptString9.length() == 0) {
                            jSONObjectOptJSONObject2.put(u.a("d1710582e1"), -1);
                        }
                        if (strOptString10.length() == 0) {
                            jSONObjectOptJSONObject2.put(u.a("ce7d0891e145"), -2);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int i22 = i14 == 1 ? i16 : i15;
                r0 r0Var = new r0(context, i14);
                a(r0Var, i15, i16, jSONObjectOptJSONObject2, -1);
                String strOptString11 = jSONObjectOptJSONObject2.optString(u.a("ca710f93d646986fe777"));
                if (strOptString11.length() > 0) {
                    r0Var.setLineWidth(l0.a(context, i22, strOptString11));
                }
                String strOptString12 = jSONObjectOptJSONObject2.optString(u.a("c5770d99fb"));
                if (strOptString12.length() > 0) {
                    String[] strArrSplit3 = strOptString12.split(",");
                    c = 0;
                    if (strArrSplit3.length > 0 && strArrSplit3[0].trim().length() > 0) {
                        r0Var.setOnFillColor((int) l0.a(strArrSplit3[0]));
                    }
                    if (strArrSplit3.length > 1 && strArrSplit3[1].trim().length() > 0) {
                        r0Var.setLineColor((int) l0.a(strArrSplit3[1]));
                    }
                    if (strArrSplit3.length > 2 && strArrSplit3[2].trim().length() > 0) {
                        r0Var.setOffFillColor((int) l0.a(strArrSplit3[2]));
                    }
                } else {
                    c = 0;
                }
                String strOptString13 = jSONObjectOptJSONObject2.optString(u.a("d479059ffc42"));
                if (strOptString13.length() > 0) {
                    String[] strArrSplit4 = strOptString13.split(",");
                    if (strArrSplit4.length > 0 && strArrSplit4[c].trim().length() > 0) {
                        r0Var.setRadius(l0.a(context, i22, strArrSplit4[c]));
                    }
                    if (strArrSplit4.length > 1 && strArrSplit4[1].trim().length() > 0) {
                        r0Var.setOffRadius(l0.a(context, i22, strArrSplit4[1]));
                    }
                }
                s0Var.setPageIndicator(r0Var);
            }
        }
        return s0Var;
    }

    public final void a(String str, RelativeLayout.LayoutParams layoutParams) {
        int i;
        if (str.length() > 0) {
            for (String str2 : str.split(",")) {
                if (str2.startsWith("c")) {
                    i = 13;
                } else if (str2.endsWith("v")) {
                    i = 15;
                } else if (str2.endsWith("h")) {
                    i = 14;
                } else if (str2.startsWith("t")) {
                    i = 10;
                } else if (str2.startsWith("l")) {
                    i = 9;
                } else if (str2.startsWith(CampaignEx.JSON_KEY_AD_R)) {
                    i = 11;
                } else {
                    if (str2.startsWith(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        i = 12;
                    }
                }
                layoutParams.addRule(i);
            }
        }
    }

    public static com.tnkfactory.ad.pub.b a(Context context, int i, int i2, JSONObject jSONObject, JSONObject jSONObject2, JSONArray jSONArray, boolean z, com.tnkfactory.ad.pub.a aVar) {
        View viewA;
        if (jSONObject == null || jSONObject2 == null) {
            return null;
        }
        w wVar = new w(jSONObject, jSONObject2, jSONArray);
        JSONObject jSONObject3 = wVar.k;
        com.tnkfactory.ad.pub.b bVar = (jSONObject3 == null || (viewA = wVar.a(context, i, i2, jSONObject3, -1)) == null) ? null : new com.tnkfactory.ad.pub.b(context, viewA, wVar.d, wVar.g, wVar.c, wVar.e, wVar.f, wVar.i, wVar.h, wVar.a, wVar.j, aVar);
        if (bVar == null) {
            return null;
        }
        bVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:110:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:70:0x022f  */
    /* JADX WARN: Code duplicated, block: B:77:0x025b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0261  */
    /* JADX WARN: Code duplicated, block: B:82:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x0274  */
    /* JADX WARN: Code duplicated, block: B:87:0x0279  */
    /* JADX WARN: Code duplicated, block: B:96:0x02be  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final String a(View view, int i, int i2, JSONObject jSONObject, int i3) {
        float fA;
        float fA2;
        String str;
        String str2;
        ?? r2;
        int iA;
        float fA3;
        String[] strArrSplit;
        String str3;
        int iA2;
        v.a aVar;
        v.a aVar2;
        String str4;
        int iA3;
        int iA4;
        int i4;
        GradientDrawable gradientDrawableA;
        Context context = view.getContext();
        float fOptDouble = (float) jSONObject.optDouble(u.a("d479159fe6"), -1.0d);
        if (fOptDouble < 0.0f) {
            fA = l0.a(context, i, jSONObject.optString(u.a("d1710582e1"), "100"));
            fA2 = l0.a(context, i2, jSONObject.optString(u.a("ce7d0891e145"), "100"));
        } else {
            float fA4 = l0.a(context, i, jSONObject.optString(u.a("d1710582e1"), "-1"));
            float fA5 = l0.a(context, i2, jSONObject.optString(u.a("ce7d0891e145"), "-1"));
            if (fA4 > 0.0f) {
                fA5 = fA4 / fOptDouble;
            } else if (fA5 > 0.0f) {
                fA4 = fA5 * fOptDouble;
            } else {
                float f = i2;
                fA5 = f;
                fA4 = f * fOptDouble;
            }
            float f2 = i;
            if (fA4 > f2) {
                fA2 = f2 / fOptDouble;
                fA = f2;
            } else {
                float f3 = i2;
                if (fA5 > f3) {
                    fA = fOptDouble * f3;
                    fA2 = f3;
                } else {
                    fA = fA4;
                    fA2 = fA5;
                }
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) fA, (int) fA2);
        a(jSONObject.optString(u.a("c7740891e7")), layoutParams);
        String strOptString = jSONObject.optString(u.a("c47d0d99fe"));
        if (strOptString.length() > 0) {
            layoutParams.addRule(3, a(strOptString));
        }
        String strOptString2 = jSONObject.optString(u.a("c77a0e80ec"));
        if (strOptString2.length() > 0) {
            layoutParams.addRule(2, a(strOptString2));
        }
        String strOptString3 = jSONObject.optString(u.a("ca7d0782d65e97"));
        if (strOptString3.length() > 0) {
            layoutParams.addRule(0, a(strOptString3));
        }
        String strOptString4 = jSONObject.optString(u.a("d471069efd6e9e6d"));
        if (strOptString4.length() > 0) {
            layoutParams.addRule(1, a(strOptString4));
        }
        String strOptString5 = jSONObject.optString(u.a("cb791391e05f"));
        if (strOptString5.length() > 0) {
            int[] iArrA = l0.a(context, i, i2, strOptString5);
            layoutParams.leftMargin = iArrA[0];
            layoutParams.topMargin = iArrA[1];
            layoutParams.rightMargin = iArrA[2];
            layoutParams.bottomMargin = iArrA[3];
        } else {
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
        }
        view.setLayoutParams(layoutParams);
        String strOptString6 = jSONObject.optString(u.a("cf7c"));
        if (strOptString6.length() == 0) {
            strOptString6 = a.a("ID").append(view.hashCode()).toString();
        }
        if (i3 > -1) {
            str = strOptString6 + "_" + i3;
            view.setTag(String.valueOf(i3 + 1));
        } else {
            str = strOptString6;
        }
        view.setId(a(str));
        String strOptString7 = jSONObject.optString(u.a("d6790592e05f96"));
        if (strOptString7.length() > 0) {
            int[] iArrA2 = l0.a(view.getContext(), i, i2, strOptString7);
            view.setPadding(iArrA2[0], iArrA2[1], iArrA2[2], iArrA2[3]);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String strOptString8 = jSONObject.optString(u.a("c5740886d6439e7efd7b"));
            if (strOptString8.length() > 0) {
                view.setOutlineProvider(new w0((int) l0.a(view.getContext(), i, strOptString8)));
            }
        }
        String strOptString9 = jSONObject.optString(u.a("c47f3e95e65d9e79"));
        if (strOptString9.length() > 0) {
            String strOptString10 = jSONObject.optString(u.a("c47f3e84e6449f6f"));
            float fA6 = strOptString10.length() > 0 ? l0.a(view.getContext(), i, strOptString10) : -1.0f;
            String strOptString11 = jSONObject.optString(u.a("c47f3e85fd439e60f6"));
            if (strOptString11.length() > 0) {
                String[] strArrSplit2 = strOptString11.split(",");
                iA = strArrSplit2.length > 0 ? (int) l0.a(strArrSplit2[0]) : 0;
                fA3 = strArrSplit2.length > 1 ? l0.a(view.getContext(), i, strArrSplit2[1]) : -1.0f;
                strArrSplit = strOptString9.split(",");
                if (strArrSplit.length > 2) {
                    iA3 = (int) l0.a(strArrSplit[1]);
                    iA4 = (int) l0.a(strArrSplit[2]);
                    i4 = !strArrSplit[0].startsWith("h") ? 1 : 0;
                    if (fA6 <= 0.0f || (iA != 0 && fA3 > 0.0f)) {
                        gradientDrawableA = v.a(i4, iA3, iA4);
                        if (fA6 > 0.0f) {
                            gradientDrawableA.setCornerRadius(fA6);
                        }
                        if (fA3 > 0.0f && iA != 0) {
                            gradientDrawableA.setStroke((int) fA3, iA);
                        }
                        view.setBackground(gradientDrawableA);
                    } else {
                        view.setBackground(v.a(i4, iA3, iA4));
                    }
                } else {
                    str3 = strArrSplit[0];
                    if (strArrSplit.length > 1) {
                        str4 = strArrSplit[1];
                        if (fA6 > 0.0f && (iA == 0 || fA3 <= 0.0f)) {
                            StateListDrawable stateListDrawable = new StateListDrawable();
                            stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable((int) l0.a(str4)));
                            stateListDrawable.addState(new int[0], new ColorDrawable((int) l0.a(str3)));
                            view.setBackground(stateListDrawable);
                        } else {
                            ColorStateList colorStateListA = l0.a(str3, str4);
                            aVar2 = new v.a();
                            if (fA6 > 0.0f) {
                                aVar2.setCornerRadius(fA6);
                            }
                            aVar2.setColor(colorStateListA);
                            if (fA3 > 0.0f && iA != 0) {
                                aVar2.setStroke((int) fA3, iA);
                            }
                            view.setBackground(aVar2);
                        }
                    } else {
                        iA2 = (int) l0.a(str3);
                        if (fA6 <= 0.0f || (iA != 0 && fA3 > 0.0f)) {
                            aVar = new v.a();
                            if (fA6 > 0.0f) {
                                aVar.setCornerRadius(fA6);
                            }
                            aVar.setColor(iA2);
                            if (fA3 > 0.0f && iA != 0) {
                                aVar.setStroke((int) fA3, iA);
                            }
                            aVar2 = aVar;
                            view.setBackground(aVar2);
                        } else {
                            view.setBackgroundColor(iA2);
                        }
                    }
                }
            } else {
                str = str;
                iA = 0;
            }
            strArrSplit = strOptString9.split(",");
            if (strArrSplit.length > 2) {
                iA3 = (int) l0.a(strArrSplit[1]);
                iA4 = (int) l0.a(strArrSplit[2]);
                i4 = !strArrSplit[0].startsWith("h") ? 1 : 0;
                if (fA6 <= 0.0f) {
                    gradientDrawableA = v.a(i4, iA3, iA4);
                    if (fA6 > 0.0f) {
                        gradientDrawableA.setCornerRadius(fA6);
                    }
                    if (fA3 > 0.0f) {
                        gradientDrawableA.setStroke((int) fA3, iA);
                    }
                    view.setBackground(gradientDrawableA);
                } else {
                    gradientDrawableA = v.a(i4, iA3, iA4);
                    if (fA6 > 0.0f) {
                        gradientDrawableA.setCornerRadius(fA6);
                    }
                    if (fA3 > 0.0f) {
                        gradientDrawableA.setStroke((int) fA3, iA);
                    }
                    view.setBackground(gradientDrawableA);
                }
            } else {
                str3 = strArrSplit[0];
                if (strArrSplit.length > 1) {
                    str4 = strArrSplit[1];
                    if (fA6 > 0.0f) {
                    }
                    ColorStateList colorStateListA2 = l0.a(str3, str4);
                    aVar2 = new v.a();
                    if (fA6 > 0.0f) {
                        aVar2.setCornerRadius(fA6);
                    }
                    aVar2.setColor(colorStateListA2);
                    if (fA3 > 0.0f) {
                        aVar2.setStroke((int) fA3, iA);
                    }
                    view.setBackground(aVar2);
                } else {
                    iA2 = (int) l0.a(str3);
                    if (fA6 <= 0.0f) {
                    }
                    aVar = new v.a();
                    if (fA6 > 0.0f) {
                        aVar.setCornerRadius(fA6);
                    }
                    aVar.setColor(iA2);
                    if (fA3 > 0.0f) {
                        aVar.setStroke((int) fA3, iA);
                    }
                    aVar2 = aVar;
                    view.setBackground(aVar2);
                }
            }
        } else {
            str = str;
            view.setBackgroundColor(view instanceof z0 ? -1 : ViewCompat.MEASURED_SIZE_MASK);
        }
        String strOptString12 = jSONObject.optString(u.a("c47f3e90fb5e9c"));
        if (strOptString12.length() > 0) {
            str2 = str;
            this.j.put(str2, strOptString12.trim());
        } else {
            str2 = str;
        }
        if (!jSONObject.optBoolean(u.a("d071129feb5d94"), true)) {
            view.setVisibility(4);
        }
        String strOptString13 = jSONObject.optString(u.a("c776089be8459864fd"));
        if (strOptString13.length() > 0) {
            this.h.put(str2, strOptString13);
        }
        String strOptString14 = jSONObject.optString(u.a("c77b159fe65f"));
        if (u.a("c5740e85ec").equals(strOptString14)) {
            r2 = this.d;
        } else if (u.a("c5740895e2").equals(strOptString14)) {
            r2 = this.c;
        } else if (u.a("c3600882").equals(strOptString14)) {
            r2 = this.g;
        } else {
            if (!u.a("ca770699").equals(strOptString14)) {
                if (u.a("d5700e81").equals(strOptString14)) {
                    String strOptString15 = jSONObject.optString(u.a("d2791391ec45"));
                    if (strOptString15.length() > 0) {
                        if (i3 > -1) {
                            strOptString15 = strOptString15 + i3;
                        }
                        view.setTag(strOptString15);
                        r2 = this.e;
                    }
                }
                return strOptString6;
            }
            r2 = this.f;
        }
        r2.add(view);
        return strOptString6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, TextView textView, JSONObject jSONObject, int i) {
        String actionButtonLabel;
        JSONArray jSONArray;
        int i2;
        if (u.a("c07b0d99fa54").equals(str)) {
            actionButtonLabel = h.instance().getCloseButtonLabel();
        } else if (u.a("c07d199ffd").equals(str)) {
            actionButtonLabel = h.instance().getExitButtonLabel();
        } else if (u.a("c06c0882e554").equals(str)) {
            actionButtonLabel = h.instance().getFrameTitle();
        } else {
            actionButtonLabel = u.a("c0790282e05e9f").equals(str) ? h.instance().getActionButtonLabel() : null;
        }
        if (actionButtonLabel == null) {
            Object objOpt = jSONObject.opt(u.a("d27d1982"));
            if (objOpt instanceof String) {
                actionButtonLabel = (String) objOpt;
            } else if (objOpt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                String strOptString = jSONObject2.optString(Locale.getDefault().getLanguage());
                actionButtonLabel = strOptString.length() > 0 ? strOptString : jSONObject2.optString(ProxyConfig.MATCH_ALL_SCHEMES);
            } else {
                actionButtonLabel = "";
            }
        }
        if (actionButtonLabel.length() > 0) {
            textView.setText(actionButtonLabel);
        } else {
            textView.setText((CharSequence) null);
        }
        if (textView instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) textView;
            toggleButton.setTextOn(null);
            toggleButton.setTextOff(null);
        }
        String strOptString2 = jSONObject.optString(u.a("d27d1982d6529e67fc6d"));
        int i3 = 1;
        if (strOptString2.length() > 0) {
            String[] strArrSplit = strOptString2.split(",");
            String str2 = strArrSplit[0];
            textView.setTextColor(l0.a(str2, strArrSplit.length >= 2 ? strArrSplit[1] : str2));
        }
        String strOptString3 = jSONObject.optString(u.a("d27d1982d6429871f6"));
        if (strOptString3.length() > 0) {
            if (strOptString3.endsWith("dp")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
            } else if (strOptString3.endsWith("sp")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
                i3 = 2;
            } else if (strOptString3.endsWith("px")) {
                strOptString3 = strOptString3.substring(0, strOptString3.length() - 2);
                i3 = 0;
            }
            textView.setTextSize(i3, Integer.parseInt(strOptString3));
        }
        String strOptString4 = jSONObject.optString(u.a("d27d1982d645887bf6"));
        if (strOptString4.length() > 0) {
            boolean zContains = strOptString4.contains(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            if (strOptString4.contains("i")) {
                i2 = zContains;
                i2 = (zContains ? 1 : 0) | 2;
            }
            i2 = zContains;
            textView.setTypeface(null, i2);
        }
        textView.setSingleLine(jSONObject.optBoolean(u.a("d5710f91e554ae67fa7161"), false));
        textView.setGravity(jSONObject.optInt(u.a("c16a0080e04588"), 17));
        if (i <= -1 || (jSONArray = this.m) == null) {
            return;
        }
        textView.setText(jSONArray.optJSONObject(i).optString(str));
    }
}
