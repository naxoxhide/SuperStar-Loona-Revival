package com.applovin.impl.mediation.debugger.ui.d;

import android.text.SpannedString;

/* JADX INFO: loaded from: classes.dex */
public class e extends c {
    public e(String str) {
        super(c.b.SECTION);
        this.ass = new SpannedString(str);
    }

    public String toString() {
        return "SectionListItemViewModel{text=" + ((Object) this.ass) + "}";
    }
}
