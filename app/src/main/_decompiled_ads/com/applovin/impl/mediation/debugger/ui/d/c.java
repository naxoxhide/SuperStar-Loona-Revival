package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class c {
    protected int ahg;
    protected int apH;
    protected String apI;
    protected String aqQ;
    protected b asr;
    protected SpannedString ass;
    protected SpannedString ast;
    protected int asu;
    protected int asv;
    protected int asw;
    protected int asx;
    protected boolean asy;
    protected boolean iV;

    public enum b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);

        private final int ahF;

        b(int i) {
            this.ahF = i;
        }

        public int wX() {
            return this.ahF;
        }

        public int wS() {
            if (this == SECTION) {
                return R.layout.mediation_debugger_list_section;
            }
            if (this == SECTION_CENTERED) {
                return R.layout.mediation_debugger_list_section_centered;
            }
            if (this == SIMPLE) {
                return android.R.layout.simple_list_item_1;
            }
            if (this == DETAIL) {
                return R.layout.applovin_debugger_list_item_detail;
            }
            return R.layout.mediation_debugger_list_item_right_detail;
        }
    }

    public static int getViewTypeCount() {
        return b.COUNT.wX();
    }

    protected c(b bVar) {
        this.asu = 0;
        this.asv = 0;
        this.ahg = -16777216;
        this.apH = -16777216;
        this.asw = 0;
        this.asx = 0;
        this.asr = bVar;
    }

    private c(a aVar) {
        this.asu = 0;
        this.asv = 0;
        this.ahg = -16777216;
        this.apH = -16777216;
        this.asw = 0;
        this.asx = 0;
        this.asr = aVar.asr;
        this.iV = aVar.iV;
        this.ass = aVar.ass;
        this.ast = aVar.ast;
        this.aqQ = aVar.aqQ;
        this.apI = aVar.apI;
        this.asu = aVar.asu;
        this.asv = aVar.asv;
        this.ahg = aVar.ahg;
        this.apH = aVar.apH;
        this.asw = aVar.asw;
        this.asx = aVar.asx;
        this.asy = aVar.asy;
    }

    public int wR() {
        return this.asr.wX();
    }

    public int wS() {
        return this.asr.wS();
    }

    public boolean isEnabled() {
        return this.iV;
    }

    public SpannedString wT() {
        return this.ass;
    }

    public SpannedString wF() {
        return this.ast;
    }

    public String wj() {
        return this.aqQ;
    }

    public String vP() {
        return this.apI;
    }

    public int wA() {
        return this.asu;
    }

    public int tO() {
        return this.asv;
    }

    public int getTextColor() {
        return this.ahg;
    }

    public int vO() {
        return this.apH;
    }

    public int wU() {
        return this.asw;
    }

    public int tP() {
        return this.asx;
    }

    public boolean wG() {
        return this.asy;
    }

    public static a wV() {
        return a(b.RIGHT_DETAIL);
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public static class a {
        String apI;
        String aqQ;
        final b asr;
        SpannedString ass;
        SpannedString ast;
        boolean asy;
        boolean iV;
        int asu = 0;
        int asv = 0;
        int ahg = -16777216;
        int apH = -16777216;
        int asw = 0;
        int asx = 0;

        public a(b bVar) {
            this.asr = bVar;
        }

        public a aF(boolean z) {
            this.iV = z;
            return this;
        }

        public a bO(String str) {
            return a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a a(SpannedString spannedString) {
            this.ass = spannedString;
            return this;
        }

        public a bP(String str) {
            return b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        public a b(SpannedString spannedString) {
            this.ast = spannedString;
            return this;
        }

        public a bQ(String str) {
            this.aqQ = str;
            return this;
        }

        public a bR(String str) {
            this.apI = str;
            return this;
        }

        public a gk(int i) {
            this.asv = i;
            return this;
        }

        public a gl(int i) {
            this.ahg = i;
            return this;
        }

        public a gm(int i) {
            this.apH = i;
            return this;
        }

        public a gn(int i) {
            this.asx = i;
            return this;
        }

        public a aG(boolean z) {
            this.asy = z;
            return this;
        }

        public a y(Context context) {
            this.asv = R.drawable.applovin_ic_disclosure_arrow;
            this.asx = g.a(R.color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        public c wW() {
            return new c(this);
        }
    }
}
