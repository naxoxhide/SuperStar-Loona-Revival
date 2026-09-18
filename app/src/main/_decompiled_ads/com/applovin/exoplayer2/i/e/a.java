package com.applovin.exoplayer2.i.e;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class a extends com.applovin.exoplayer2.i.d {
    private static final Pattern Rs = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean Rt;
    private final b Ru;
    private Map<String, c> Rv;
    private float Rw;
    private float Rx;

    private static float ez(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        this.Rw = -3.4028235E38f;
        this.Rx = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.Rt = true;
            String strJ = ai.J(list.get(0));
            com.applovin.exoplayer2.l.a.checkArgument(strJ.startsWith("Format:"));
            this.Ru = (b) com.applovin.exoplayer2.l.a.checkNotNull(b.ac(strJ));
            ad(new y(list.get(1)));
            return;
        }
        this.Rt = false;
        this.Ru = null;
    }

    @Override // com.applovin.exoplayer2.i.d
    protected f c(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        y yVar = new y(bArr, i);
        if (!this.Rt) {
            ad(yVar);
        }
        a(yVar, arrayList, arrayList2);
        return new d(arrayList, arrayList2);
    }

    private void ad(y yVar) {
        while (true) {
            String strPJ = yVar.pJ();
            if (strPJ == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strPJ)) {
                ae(yVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strPJ)) {
                this.Rv = af(yVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(strPJ)) {
                q.g("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strPJ)) {
                return;
            }
        }
    }

    private void ae(y yVar) {
        while (true) {
            String strPJ = yVar.pJ();
            if (strPJ == null) {
                return;
            }
            if (yVar.pj() != 0 && yVar.pm() == 91) {
                return;
            }
            String[] strArrSplit = strPJ.split(CertificateUtil.DELIMITER);
            if (strArrSplit.length == 2) {
                String lowerCase = Ascii.toLowerCase(strArrSplit[0].trim());
                lowerCase.hashCode();
                if (lowerCase.equals("playresx")) {
                    this.Rw = Float.parseFloat(strArrSplit[1].trim());
                } else if (lowerCase.equals("playresy")) {
                    try {
                        this.Rx = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map<String, c> af(y yVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVarAi = null;
        while (true) {
            String strPJ = yVar.pJ();
            if (strPJ == null || (yVar.pj() != 0 && yVar.pm() == 91)) {
                break;
            }
            if (strPJ.startsWith("Format:")) {
                aVarAi = c.a.ai(strPJ);
            } else if (strPJ.startsWith("Style:")) {
                if (aVarAi == null) {
                    q.h("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strPJ);
                } else {
                    c cVarA = c.a(strPJ, aVarAi);
                    if (cVarA != null) {
                        linkedHashMap.put(cVarA.name, cVarA);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private void a(y yVar, List<List<com.applovin.exoplayer2.i.a>> list, List<Long> list2) {
        b bVarAc = this.Rt ? this.Ru : null;
        while (true) {
            String strPJ = yVar.pJ();
            if (strPJ == null) {
                return;
            }
            if (strPJ.startsWith("Format:")) {
                bVarAc = b.ac(strPJ);
            } else if (strPJ.startsWith("Dialogue:")) {
                if (bVarAc == null) {
                    q.h("SsaDecoder", "Skipping dialogue line before complete format: " + strPJ);
                } else {
                    a(strPJ, bVarAc, list, list2);
                }
            }
        }
    }

    private void a(String str, b bVar, List<List<com.applovin.exoplayer2.i.a>> list, List<Long> list2) {
        com.applovin.exoplayer2.l.a.checkArgument(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", bVar.fR);
        if (strArrSplit.length != bVar.fR) {
            q.h("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jAb = ab(strArrSplit[bVar.Ry]);
        if (jAb == -9223372036854775807L) {
            q.h("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jAb2 = ab(strArrSplit[bVar.Rz]);
        if (jAb2 == -9223372036854775807L) {
            q.h("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        c cVar = (this.Rv == null || bVar.RA == -1) ? null : this.Rv.get(strArrSplit[bVar.RA].trim());
        String str2 = strArrSplit[bVar.RB];
        com.applovin.exoplayer2.i.a aVarA = a(c.b.ak(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), cVar, c.b.aj(str2), this.Rw, this.Rx);
        int iA = a(jAb2, list2, list);
        for (int iA2 = a(jAb, list2, list); iA2 < iA; iA2++) {
            list.get(iA2).add(aVarA);
        }
    }

    private static long ab(String str) {
        Matcher matcher = Rs.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) ai.R(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) ai.R(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) ai.R(matcher.group(3))) * 1000000) + (Long.parseLong((String) ai.R(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static com.applovin.exoplayer2.i.a a(String str, c cVar, c.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        com.applovin.exoplayer2.i.a.C0098a c0098aM = new com.applovin.exoplayer2.i.a.C0098a().m(spannableString);
        if (cVar != null) {
            if (cVar.RD != null) {
                spannableString.setSpan(new ForegroundColorSpan(cVar.RD.intValue()), 0, spannableString.length(), 33);
            }
            if (cVar.RE != -3.4028235E38f && f2 != -3.4028235E38f) {
                c0098aM.c(cVar.RE / f2, 1);
            }
            if (cVar.RF && cVar.RG) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (cVar.RF) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (cVar.RG) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (cVar.Pn) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (cVar.RH) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = -1;
        if (bVar.RC != -1) {
            i = bVar.RC;
        } else if (cVar != null) {
            i = cVar.RC;
        }
        c0098aM.a(ew(i)).eg(ey(i)).ef(ex(i));
        if (bVar.RV != null && f2 != -3.4028235E38f && f != -3.4028235E38f) {
            c0098aM.o(bVar.RV.x / f);
            c0098aM.b(bVar.RV.y / f2, 0);
        } else {
            c0098aM.o(ez(c0098aM.lS()));
            c0098aM.b(ez(c0098aM.lR()), 0);
        }
        return c0098aM.lU();
    }

    private static Layout.Alignment ew(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    private static int ex(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    private static int ey(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                q.h("SsaDecoder", "Unknown alignment: " + i);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    private static int a(long j, List<Long> list, List<List<com.applovin.exoplayer2.i.a>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }
}
