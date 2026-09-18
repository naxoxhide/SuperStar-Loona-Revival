package com.kakao.adfit.d;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewBindings.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/kakao/adfit/d/v;", "Lcom/kakao/adfit/d/y;", "", "g", "Landroid/widget/TextView;", "view", "", "text", "<init>", "(Landroid/widget/TextView;Ljava/lang/String;)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class v extends y {
    public v(TextView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setText(str == null ? "" : str);
    }

    @Override // com.kakao.adfit.d.y
    protected void g() {
    }
}
