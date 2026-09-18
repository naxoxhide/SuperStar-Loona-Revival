package com.fyber.inneractive.sdk.measurement;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.response.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements i {
    public final /* synthetic */ List a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f949b;

    public e(f fVar, List list, g gVar) {
        this.a = list;
        this.f949b = gVar;
    }

    @Override // com.fyber.inneractive.sdk.response.i
    public List<String> a(t tVar) {
        if (this.a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.a) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str.replace("[REASON]", String.valueOf(this.f949b.mReason)));
            }
        }
        return arrayList;
    }
}
