package com.applovin.exoplayer2.i.i;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private int Qc;
    private float RE;
    private int SL;
    private String Ts = "";
    private String Tt = "";
    private Set<String> Tu = Collections.emptySet();
    private String Tv = "";
    private String SK = null;
    private boolean SM = false;
    private boolean SN = false;
    private int SQ = -1;
    private int SR = -1;
    private int SS = -1;
    private int italic = -1;
    private int ST = -1;
    private int SV = -1;
    private boolean Tw = false;

    public void aw(String str) {
        this.Ts = str;
    }

    public void ax(String str) {
        this.Tt = str;
    }

    public void a(String[] strArr) {
        this.Tu = new HashSet(Arrays.asList(strArr));
    }

    public void ay(String str) {
        this.Tv = str;
    }

    public int a(String str, String str2, Set<String> set, String str3) {
        if (this.Ts.isEmpty() && this.Tt.isEmpty() && this.Tu.isEmpty() && this.Tv.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iA = a(a(a(0, this.Ts, str, 1073741824), this.Tt, str2, 2), this.Tv, str3, 4);
        if (iA == -1 || !set.containsAll(this.Tu)) {
            return 0;
        }
        return iA + (this.Tu.size() * 4);
    }

    public int mH() {
        int i = this.SS;
        if (i == -1 && this.italic == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.italic == 1 ? 2 : 0);
    }

    public boolean mI() {
        return this.SQ == 1;
    }

    public boolean mJ() {
        return this.SR == 1;
    }

    public d Y(boolean z) {
        this.SR = z ? 1 : 0;
        return this;
    }

    public d Z(boolean z) {
        this.SS = z ? 1 : 0;
        return this;
    }

    public d aa(boolean z) {
        this.italic = z ? 1 : 0;
        return this;
    }

    public String mK() {
        return this.SK;
    }

    public d az(String str) {
        this.SK = str == null ? null : Ascii.toLowerCase(str);
        return this;
    }

    public int mL() {
        if (!this.SM) {
            throw new IllegalStateException("Font color not defined");
        }
        return this.SL;
    }

    public d eI(int i) {
        this.SL = i;
        this.SM = true;
        return this;
    }

    public boolean mM() {
        return this.SM;
    }

    public int mN() {
        if (!this.SN) {
            throw new IllegalStateException("Background color not defined.");
        }
        return this.Qc;
    }

    public d eJ(int i) {
        this.Qc = i;
        this.SN = true;
        return this;
    }

    public boolean mO() {
        return this.SN;
    }

    public d u(float f) {
        this.RE = f;
        return this;
    }

    public d eK(int i) {
        this.ST = i;
        return this;
    }

    public int mX() {
        return this.ST;
    }

    public float mY() {
        return this.RE;
    }

    public d eL(int i) {
        this.SV = i;
        return this;
    }

    public int mS() {
        return this.SV;
    }

    public d ab(boolean z) {
        this.Tw = z;
        return this;
    }

    public boolean mZ() {
        return this.Tw;
    }

    private static int a(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }
}
