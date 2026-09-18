package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.v0;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f971b;
    public String c;

    public static s a(Node node) {
        if (node == null) {
            return null;
        }
        s sVar = new s();
        sVar.a = v0.b(node, "event");
        sVar.f971b = v0.a(node);
        sVar.c = v0.b(node, "offset");
        return sVar;
    }

    public String toString() {
        return "VTracking:  name:" + this.a + " url:" + this.f971b + " offset:" + this.c;
    }
}
