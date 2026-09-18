package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private final Context E;
    private final com.applovin.impl.privacy.a.C0133a arT;
    private final boolean arU;

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public boolean isEnabled() {
        return false;
    }

    public b(com.applovin.impl.privacy.a.C0133a c0133a, boolean z, Context context) {
        super(c.b.RIGHT_DETAIL);
        this.arT = c0133a;
        this.E = context;
        this.ass = new SpannedString(c0133a.getName());
        this.arU = z;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public SpannedString wF() {
        return new SpannedString(this.arT.C(this.E));
    }

    @Override // com.applovin.impl.mediation.debugger.ui.d.c
    public boolean wG() {
        Boolean boolB = this.arT.B(this.E);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.arU));
        }
        return false;
    }
}
