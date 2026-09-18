package com.kakao.adfit.d;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import kotlin.Metadata;

/* JADX INFO: compiled from: ViewBindings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H$R$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/kakao/adfit/d/y;", "", "", "h", "g", "", "<set-?>", "a", "Z", InneractiveMediationDefs.GENDER_FEMALE, "()Z", "isBinding", "<init>", "()V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public abstract class y {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private boolean isBinding = true;

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getIsBinding() {
        return this.isBinding;
    }

    protected abstract void g();

    public final void h() {
        if (this.isBinding) {
            this.isBinding = false;
            g();
        }
    }
}
