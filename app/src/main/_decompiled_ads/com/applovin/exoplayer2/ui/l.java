package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.exoplayer2.l.ai;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class l extends FrameLayout implements SubtitleView.a {
    private c VU;
    private float VV;
    private int YW;
    private float YX;
    private final b Zd;
    private List<com.applovin.exoplayer2.i.a> Ze;
    private final WebView webView;

    private static String fc(int i) {
        if (i != 1) {
            return i != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    private static int fd(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ze = Collections.emptyList();
        this.VU = c.VW;
        this.YX = 0.0533f;
        this.YW = 0;
        this.VV = 0.08f;
        b bVar = new b(context, attributeSet);
        this.Zd = bVar;
        WebView webView = new WebView(context, attributeSet) { // from class: com.applovin.exoplayer2.ui.l.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                super.onTouchEvent(motionEvent);
                return false;
            }

            @Override // android.view.View
            public boolean performClick() {
                super.performClick();
                return false;
            }
        };
        this.webView = webView;
        webView.setBackgroundColor(0);
        addView(bVar);
        addView(webView);
    }

    @Override // com.applovin.exoplayer2.ui.SubtitleView.a
    public void a(List<com.applovin.exoplayer2.i.a> list, c cVar, float f, int i, float f2) {
        this.VU = cVar;
        this.YX = f;
        this.YW = i;
        this.VV = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.applovin.exoplayer2.i.a aVar = list.get(i2);
            if (aVar.NZ != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.Ze.isEmpty() || !arrayList2.isEmpty()) {
            this.Ze = arrayList2;
            nZ();
        }
        this.Zd.a(arrayList, cVar, f, i, f2);
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.Ze.isEmpty()) {
            return;
        }
        nZ();
    }

    public void destroy() {
        this.webView.destroy();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0102  */
    /* JADX WARN: Code duplicated, block: B:26:0x0112  */
    /* JADX WARN: Code duplicated, block: B:29:0x012c  */
    /* JADX WARN: Code duplicated, block: B:30:0x012f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0146  */
    /* JADX WARN: Code duplicated, block: B:35:0x0149 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x014b  */
    /* JADX WARN: Code duplicated, block: B:37:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0153  */
    /* JADX WARN: Code duplicated, block: B:48:0x0169  */
    /* JADX WARN: Code duplicated, block: B:52:0x0191  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:62:0x022e  */
    /* JADX WARN: Code duplicated, block: B:63:0x024e  */
    private void nZ() {
        String strA;
        int iFd;
        int i;
        String strA2;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        String str4;
        int i5;
        h.a aVarA;
        Iterator it;
        h.a aVar;
        String str5;
        boolean z;
        l lVar = this;
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        int i7 = 1;
        float f = 1.2f;
        sb.append(ai.a("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", e.eX(lVar.VU.Qa), lVar.d(lVar.YW, lVar.YX), Float.valueOf(1.2f), a(lVar.VU)));
        HashMap map = new HashMap();
        map.put(e.aJ("default_bg"), ai.a("background-color:%s;", e.eX(lVar.VU.Qc)));
        int i8 = 0;
        while (i8 < lVar.Ze.size()) {
            com.applovin.exoplayer2.i.a aVar2 = lVar.Ze.get(i8);
            float f2 = aVar2.Od != -3.4028235E38f ? aVar2.Od * 100.0f : 50.0f;
            int iFd2 = fd(aVar2.Oe);
            if (aVar2.Oa != -3.4028235E38f) {
                if (aVar2.Ob != i7) {
                    Object[] objArr = new Object[i7];
                    objArr[i6] = Float.valueOf(aVar2.Oa * 100.0f);
                    strA = ai.a("%.2f%%", objArr);
                    if (aVar2.Ol == i7) {
                        iFd = -fd(aVar2.Oc);
                    } else {
                        iFd = fd(aVar2.Oc);
                    }
                } else if (aVar2.Oa >= 0.0f) {
                    Object[] objArr2 = new Object[i7];
                    objArr2[i6] = Float.valueOf(aVar2.Oa * f);
                    strA = ai.a("%.2fem", objArr2);
                    iFd = i6;
                    i = iFd;
                } else {
                    Object[] objArr3 = new Object[i7];
                    objArr3[i6] = Float.valueOf(((-aVar2.Oa) - 1.0f) * f);
                    strA = ai.a("%.2fem", objArr3);
                    iFd = i6;
                    i = i7;
                }
                if (aVar2.Of != -3.4028235E38f) {
                    Object[] objArr4 = new Object[i7];
                    objArr4[i6] = Float.valueOf(aVar2.Of * 100.0f);
                    strA2 = ai.a("%.2f%%", objArr4);
                } else {
                    strA2 = "fit-content";
                }
                String strE = e(aVar2.NX);
                String strFc = fc(aVar2.Ol);
                String strD = lVar.d(aVar2.Oj, aVar2.Ok);
                if (aVar2.Oh) {
                    i2 = aVar2.Oi;
                } else {
                    i2 = lVar.VU.Oi;
                }
                String strEX = e.eX(i2);
                i3 = iFd;
                i4 = aVar2.Ol;
                str = "right";
                str2 = "left";
                str3 = "top";
                if (i4 != 1) {
                    if (i != 0) {
                        str = "left";
                    }
                    str2 = "top";
                    str3 = str;
                } else if (i4 != 2) {
                    if (i == 0) {
                        str = "left";
                    }
                    str2 = "top";
                    str3 = str;
                } else if (i != 0) {
                    str3 = TJAdUnitConstants.String.BOTTOM;
                }
                if (aVar2.Ol != 2 || aVar2.Ol == 1) {
                    str4 = "height";
                    i5 = i3;
                    i3 = iFd2;
                } else {
                    str4 = "width";
                    i5 = iFd2;
                }
                aVarA = h.a(aVar2.NW, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    h.a aVar3 = aVarA;
                    str5 = (String) map.put(str6, (String) map.get(str6));
                    if (str5 != null || str5.equals(map.get(str6))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.applovin.exoplayer2.l.a.checkState(z);
                    it = it2;
                    aVarA = aVar3;
                }
                aVar = aVarA;
                sb.append(ai.a("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i8), str2, Float.valueOf(f2), str3, strA, str4, strA2, strE, strFc, strD, strEX, Integer.valueOf(i5), Integer.valueOf(i3), c(aVar2))).append(ai.a("<span class='%s'>", "default_bg"));
                if (aVar2.NY != null) {
                    sb.append(ai.a("<span style='display:inline-block; text-align:%s;'>", e(aVar2.NY))).append(aVar.Yk).append("</span>");
                } else {
                    sb.append(aVar.Yk);
                }
                sb.append("</span>").append("</div>");
                i8++;
                f = 1.2f;
                i6 = 0;
                lVar = this;
                i7 = 1;
            } else {
                Object[] objArr5 = new Object[i7];
                objArr5[i6] = Float.valueOf((1.0f - lVar.VV) * 100.0f);
                strA = ai.a("%.2f%%", objArr5);
                iFd = -100;
            }
            i = i6;
            if (aVar2.Of != -3.4028235E38f) {
                Object[] objArr6 = new Object[i7];
                objArr6[i6] = Float.valueOf(aVar2.Of * 100.0f);
                strA2 = ai.a("%.2f%%", objArr6);
            } else {
                strA2 = "fit-content";
            }
            String strE2 = e(aVar2.NX);
            String strFc2 = fc(aVar2.Ol);
            String strD2 = lVar.d(aVar2.Oj, aVar2.Ok);
            if (aVar2.Oh) {
                i2 = aVar2.Oi;
            } else {
                i2 = lVar.VU.Oi;
            }
            String strEX2 = e.eX(i2);
            i3 = iFd;
            i4 = aVar2.Ol;
            str = "right";
            str2 = "left";
            str3 = "top";
            if (i4 != 1) {
                if (i != 0) {
                    str = "left";
                }
                str2 = "top";
                str3 = str;
            } else if (i4 != 2) {
                if (i == 0) {
                    str = "left";
                }
                str2 = "top";
                str3 = str;
            } else if (i != 0) {
                str3 = TJAdUnitConstants.String.BOTTOM;
            }
            if (aVar2.Ol != 2) {
                str4 = "height";
                i5 = i3;
                i3 = iFd2;
            } else {
                str4 = "height";
                i5 = i3;
                i3 = iFd2;
            }
            aVarA = h.a(aVar2.NW, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str7 = (String) it.next();
                h.a aVar4 = aVarA;
                str5 = (String) map.put(str7, (String) map.get(str7));
                if (str5 != null) {
                    z = true;
                } else {
                    z = true;
                }
                com.applovin.exoplayer2.l.a.checkState(z);
                it = it3;
                aVarA = aVar4;
            }
            aVar = aVarA;
            sb.append(ai.a("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i8), str2, Float.valueOf(f2), str3, strA, str4, strA2, strE2, strFc2, strD2, strEX2, Integer.valueOf(i5), Integer.valueOf(i3), c(aVar2))).append(ai.a("<span class='%s'>", "default_bg"));
            if (aVar2.NY != null) {
                sb.append(ai.a("<span style='display:inline-block; text-align:%s;'>", e(aVar2.NY))).append(aVar.Yk).append("</span>");
            } else {
                sb.append(aVar.Yk);
            }
            sb.append("</span>").append("</div>");
            i8++;
            f = 1.2f;
            i6 = 0;
            lVar = this;
            i7 = 1;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str8 : map.keySet()) {
            sb2.append(str8).append("{").append((String) map.get(str8)).append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.webView.loadData(Base64.encodeToString(sb.toString().getBytes(Charsets.UTF_8), 1), "text/html", "base64");
    }

    private static String c(com.applovin.exoplayer2.i.a aVar) {
        if (aVar.Om != 0.0f) {
            return ai.a("%s(%.2fdeg)", (aVar.Ol == 2 || aVar.Ol == 1) ? "skewY" : "skewX", Float.valueOf(aVar.Om));
        }
        return "";
    }

    private String d(int i, float f) {
        float fA = j.a(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fA == -3.4028235E38f ? "unset" : ai.a("%.2fpx", Float.valueOf(fA / getContext().getResources().getDisplayMetrics().density));
    }

    private static String a(c cVar) {
        int i = cVar.VX;
        if (i == 1) {
            return ai.a("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", e.eX(cVar.VY));
        }
        if (i == 2) {
            return ai.a("0.1em 0.12em 0.15em %s", e.eX(cVar.VY));
        }
        if (i != 3) {
            return i != 4 ? "unset" : ai.a("-0.05em -0.05em 0.15em %s", e.eX(cVar.VY));
        }
        return ai.a("0.06em 0.08em 0.15em %s", e.eX(cVar.VY));
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.ui.l$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] Zg;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            Zg = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Zg[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Zg[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static String e(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = AnonymousClass2.Zg[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }
}
