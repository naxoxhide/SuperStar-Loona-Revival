package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.v0;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes2.dex */
public class v extends f {
    public String f;

    public static v c(Node node) {
        v vVar = new v();
        super.b(node);
        vVar.f = v0.a(v0.d(node, "VASTAdTagURI"));
        return vVar;
    }
}
