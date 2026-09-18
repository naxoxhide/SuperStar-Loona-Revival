package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f964b;
    public String c;
    public j d;
    public String e;
    public String f;
    public String g;
    public List<String> h;
    public com.fyber.inneractive.sdk.flow.vast.d.a i;
    public List<s> j;

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Companion: ").append(" w:").append(this.a).append(" h:").append(this.f964b).append(" ctr:").append(this.g).append(" clt:").append(this.h);
        if (!TextUtils.isEmpty(this.f)) {
            sbAppend.append(" html:").append(this.f);
        }
        if (this.d != null) {
            sbAppend.append(" static:").append(this.d.f965b).append("creative:").append(this.d.a);
        }
        if (!TextUtils.isEmpty(this.e)) {
            sbAppend.append(" iframe:").append(this.e);
        }
        sbAppend.append(" events:").append(this.j);
        if (this.i != null) {
            sbAppend.append(" reason:").append(this.i.a);
        }
        return sbAppend.toString();
    }
}
