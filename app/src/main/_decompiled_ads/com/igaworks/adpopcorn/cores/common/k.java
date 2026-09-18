package com.igaworks.adpopcorn.cores.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static int a(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(int i) {
        String hexString = Integer.toHexString(Math.round((i * 255) / 100));
        return (hexString.length() < 2 ? "0" : "") + hexString;
    }

    public static String a(g gVar, int i) {
        String str = gVar.N1;
        if (i != 2 && i != 18 && i != 29 && i != 35) {
            return str;
        }
        try {
            return gVar.O1;
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(TextView textView, String str, int i, int i2, Typeface typeface, int i3, int i4, TextUtils.TruncateAt truncateAt, boolean z) {
        if (str != null) {
            textView.setText(Html.fromHtml(str.replaceAll("\n", "<br>")));
        }
        textView.setTextSize(1, i);
        textView.setTextColor(i2);
        Typeface typefaceE = com.igaworks.adpopcorn.style.a.b().e(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT);
        if (typefaceE != null) {
            textView.setTypeface(typefaceE, i3);
        } else if (typeface == null) {
            typefaceE = Typeface.DEFAULT;
            textView.setTypeface(typefaceE, i3);
        } else {
            textView.setTypeface(typeface, i3);
        }
        if (i4 == 1) {
            textView.setSingleLine(true);
        } else if (i4 > 1) {
            textView.setMaxLines(i4);
        }
        textView.setEllipsize(truncateAt);
        if (z) {
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setPaintFlags(textView.getPaintFlags() | 32);
        }
    }

    public static boolean a(int i, int i2) {
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return i2 == 1 || i2 == 7 || i2 == 23 || i2 == 6 || i2 == 28 || i2 == 31 || i2 == 32 || i2 == 33 || i2 == 36 || i2 == 34 || i2 == 37 || i2 == 38 || i2 == 39 || i2 == 40 || i2 == 41 || i2 == 42;
        }
        if (i == 2) {
            return i2 == 2 || i2 == 18 || i2 == 29 || i2 == 30;
        }
        if (i == 3) {
            return i2 == 7 || i2 == 23;
        }
        if (i == 4) {
            return i2 == 6;
        }
        if (i == 5) {
            return i2 == 2;
        }
        if (i == 6) {
            return i2 == 28 || i2 == 31 || i2 == 32 || i2 == 33 || i2 == 36 || i2 == 37 || i2 == 38 || i2 == 39 || i2 == 40 || i2 == 41 || i2 == 42 || i2 == 44 || i2 == 45;
        }
        if (i == 7) {
            return i2 == 29;
        }
        if (i == 9) {
            return i2 == 35;
        }
        if (i == 10) {
            return i2 == 43 || i2 == 48;
        }
        return i != 11 || i2 == 46;
    }

    public static boolean a(View view) {
        if (view != null) {
            try {
                if (view.isShown() && view.getWindowVisibility() != 8) {
                    Rect rect = new Rect();
                    view.getWindowVisibleDisplayFrame(rect);
                    Context context = view.getContext();
                    Rect rect2 = new Rect(rect.left, rect.top + ((Build.VERSION.SDK_INT < 11 || !(context instanceof Activity) || ((Activity) context).getActionBar() == null) ? 0 : ((Activity) context).getActionBar().getHeight()), rect.right, rect.bottom);
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    Rect rect3 = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
                    if (view.getWidth() != 0 && view.getHeight() != 0) {
                        return rect2.intersect(rect3);
                    }
                    return false;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return str.length() > 0 && !str.equals("null");
        } catch (Exception unused) {
            return false;
        }
    }

    public static int b(int i) {
        com.igaworks.adpopcorn.style.a aVarB;
        com.igaworks.adpopcorn.style.a aVarB2 = com.igaworks.adpopcorn.style.a.b();
        String str = ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_COLOR;
        int iC = aVarB2.c(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_COLOR);
        try {
            if (i == 7 || i == 23) {
                aVarB = com.igaworks.adpopcorn.style.a.b();
                str = ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_COLOR;
            } else if (i == 6 || i == 25 || i == 24) {
                aVarB = com.igaworks.adpopcorn.style.a.b();
                str = ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_COLOR;
            } else {
                aVarB = com.igaworks.adpopcorn.style.a.b();
            }
            return aVarB.c(str);
        } catch (Exception unused) {
            return iC;
        }
    }

    public static String b(int i, int i2) {
        try {
            String strSubstring = Integer.toHexString(i).toUpperCase().substring(2);
            if (strSubstring.isEmpty() || i2 >= 100) {
                return "#" + Integer.toHexString(i).toUpperCase().substring(2);
            }
            return strSubstring.trim().length() == 6 ? "#" + a(i2) + strSubstring : a(i2) + strSubstring;
        } catch (Exception unused) {
            return "#" + Integer.toHexString(i).toUpperCase().substring(2);
        }
    }

    public static void b(TextView textView, String str, int i, int i2, Typeface typeface, int i3, int i4, TextUtils.TruncateAt truncateAt, boolean z) {
        if (str != null) {
            textView.setText(Html.fromHtml(str.replaceAll("\n", "<br>")));
        }
        textView.setTextSize(1, i);
        textView.setTextColor(i2);
        Typeface typefaceE = com.igaworks.adpopcorn.style.a.b().e(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_FONT);
        if (typefaceE != null) {
            textView.setTypeface(typefaceE, i3);
        } else if (typeface == null) {
            typefaceE = Typeface.DEFAULT;
            textView.setTypeface(typefaceE, i3);
        } else {
            textView.setTypeface(typeface, i3);
        }
        if (i4 == 1) {
            textView.setSingleLine(true);
        } else if (i4 > 1) {
            textView.setMaxLines(i4);
        }
        textView.setEllipsize(truncateAt);
        if (z) {
            textView.setTypeface(textView.getTypeface(), 1);
            textView.setPaintFlags(textView.getPaintFlags() | 32);
        }
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TEXTVIEW_LINE_SPACE);
        if (iC > 0 && i4 != 1) {
            textView.setLineSpacing(d.a(textView.getContext(), iC), 1.0f);
        }
        textView.setIncludeFontPadding(false);
    }

    public static int c(int i) {
        com.igaworks.adpopcorn.style.a aVarB;
        com.igaworks.adpopcorn.style.a aVarB2 = com.igaworks.adpopcorn.style.a.b();
        String str = ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_TEXT_COLOR;
        int iC = aVarB2.c(ApStyleManager.CustomStyle.OTHER_TYPE_BADGE_TEXT_COLOR);
        try {
            if (i == 7 || i == 23) {
                aVarB = com.igaworks.adpopcorn.style.a.b();
                str = ApStyleManager.CustomStyle.INSTALL_TYPE_BADGE_TEXT_COLOR;
            } else if (i == 6 || i == 25 || i == 24) {
                aVarB = com.igaworks.adpopcorn.style.a.b();
                str = ApStyleManager.CustomStyle.EXECUTE_TYPE_BADGE_TEXT_COLOR;
            } else {
                aVarB = com.igaworks.adpopcorn.style.a.b();
            }
            return aVarB.c(str);
        } catch (Exception unused) {
            return iC;
        }
    }
}
