package com.fyber.inneractive.sdk.click;

import com.facebook.appevents.integrity.IntegrityManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public final l.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f855b;
    public final String c;
    public final String d;
    public long e;
    public List<i> f = new ArrayList();

    public b(String str, l.d dVar, String str2, Throwable th) {
        this.d = str;
        this.a = dVar;
        this.c = str2;
        this.f855b = th;
    }

    public String toString() {
        l.d dVar = this.a;
        if (dVar != l.d.FAILED) {
            return String.format("Open result: Success! target: %s method: %s", dVar, this.c);
        }
        Object[] objArr = new Object[1];
        Throwable th = this.f855b;
        objArr[0] = th != null ? th.getMessage() : IntegrityManager.INTEGRITY_TYPE_NONE;
        return String.format("Open result: Failed! error: %s", objArr);
    }
}
