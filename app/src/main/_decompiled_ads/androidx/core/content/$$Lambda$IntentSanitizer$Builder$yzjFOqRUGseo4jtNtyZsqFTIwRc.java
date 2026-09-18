package androidx.core.content;

import androidx.core.util.Predicate;

/* JADX INFO: renamed from: androidx.core.content.-$$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ $$Lambda$IntentSanitizer$Builder$yzjFOqRUGseo4jtNtyZsqFTIwRc(String str) {
        this.f$0 = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return this.f$0.equals((String) obj);
    }
}
