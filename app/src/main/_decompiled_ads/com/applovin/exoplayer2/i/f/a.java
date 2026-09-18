package com.applovin.exoplayer2.i.f;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.r;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {
    private static final Pattern RX = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern RY = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder RZ;
    private final ArrayList<String> Sa;

    public a() {
        super("SubripDecoder");
        this.RZ = new StringBuilder();
        this.Sa = new ArrayList<>();
    }

    @Override // com.applovin.exoplayer2.i.d
    protected f c(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        r rVar = new r();
        y yVar = new y(bArr, i);
        while (true) {
            String strPJ = yVar.pJ();
            if (strPJ == null) {
                break;
            }
            if (strPJ.length() != 0) {
                try {
                    Integer.parseInt(strPJ);
                    String strPJ2 = yVar.pJ();
                    if (strPJ2 == null) {
                        q.h("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = RX.matcher(strPJ2);
                    if (matcher.matches()) {
                        rVar.bo(a(matcher, 1));
                        rVar.bo(a(matcher, 6));
                        this.RZ.setLength(0);
                        this.Sa.clear();
                        for (String strPJ3 = yVar.pJ(); !TextUtils.isEmpty(strPJ3); strPJ3 = yVar.pJ()) {
                            if (this.RZ.length() > 0) {
                                this.RZ.append("<br>");
                            }
                            this.RZ.append(a(strPJ3, this.Sa));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.RZ.toString());
                        String str = null;
                        for (int i2 = 0; i2 < this.Sa.size(); i2++) {
                            String str2 = this.Sa.get(i2);
                            if (str2.matches("\\{\\\\an[1-9]\\}")) {
                                str = str2;
                                break;
                            }
                        }
                        arrayList.add(a(spannedFromHtml, str));
                        arrayList.add(com.applovin.exoplayer2.i.a.NV);
                    } else {
                        q.h("SubripDecoder", "Skipping invalid timing: " + strPJ2);
                    }
                } catch (NumberFormatException unused) {
                    q.h("SubripDecoder", "Skipping invalid index: " + strPJ);
                }
            }
        }
        return new b((com.applovin.exoplayer2.i.a[]) arrayList.toArray(new com.applovin.exoplayer2.i.a[0]), rVar.pa());
    }

    private String a(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = RY.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007b  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    private com.applovin.exoplayer2.i.a a(Spanned spanned, String str) {
        byte b2;
        byte b3;
        com.applovin.exoplayer2.i.a.C0098a c0098aM = new com.applovin.exoplayer2.i.a.C0098a().m(spanned);
        if (str == null) {
            return c0098aM.lU();
        }
        switch (str) {
            case "{\an1}":
                b2 = 0;
                break;
            case "{\an2}":
                b2 = 6;
                break;
            case "{\an3}":
                b2 = 3;
                break;
            case "{\an4}":
                b2 = 1;
                break;
            case "{\an5}":
                b2 = 7;
                break;
            case "{\an6}":
                b2 = 4;
                break;
            case "{\an7}":
                b2 = 2;
                break;
            case "{\an8}":
                b2 = 8;
                break;
            case "{\an9}":
                b2 = 5;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0 || b2 == 1 || b2 == 2) {
            c0098aM.eg(0);
        } else if (b2 == 3 || b2 == 4 || b2 == 5) {
            c0098aM.eg(2);
        } else {
            c0098aM.eg(1);
        }
        switch (str) {
            case "{\an1}":
                b3 = 0;
                break;
            case "{\an2}":
                b3 = 1;
                break;
            case "{\an3}":
                b3 = 2;
                break;
            case "{\an4}":
                b3 = 6;
                break;
            case "{\an5}":
                b3 = 7;
                break;
            case "{\an6}":
                b3 = 8;
                break;
            case "{\an7}":
                b3 = 3;
                break;
            case "{\an8}":
                b3 = 4;
                break;
            case "{\an9}":
                b3 = 5;
                break;
            default:
                b3 = -1;
                break;
        }
        if (b3 == 0 || b3 == 1 || b3 == 2) {
            c0098aM.ef(2);
        } else if (b3 == 3 || b3 == 4 || b3 == 5) {
            c0098aM.ef(0);
        } else {
            c0098aM.ef(1);
        }
        return c0098aM.o(eB(c0098aM.lS())).b(eB(c0098aM.lR()), 0).lU();
    }

    private static long a(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(i + 2))) * 60 * 1000) + (Long.parseLong((String) com.applovin.exoplayer2.l.a.checkNotNull(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    static float eB(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }
}
