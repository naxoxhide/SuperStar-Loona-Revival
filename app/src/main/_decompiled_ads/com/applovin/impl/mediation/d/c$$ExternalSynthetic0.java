package com.applovin.impl.mediation.d;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: com.applovin.impl.mediation.d.c-$$ExternalSynthetic0, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class c$$ExternalSynthetic0 {
    public static /* synthetic */ String m0(CharSequence charSequence, Iterable iterable) {
        Objects.requireNonNull(charSequence, "delimiter");
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append(charSequence);
            }
        }
        return sb.toString();
    }
}
