package com.fyber.inneractive.sdk.click;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.w;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k implements w<c> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f861b;
    public final /* synthetic */ l c;

    public k(l lVar, String str, String str2) {
        this.c = lVar;
        this.a = str;
        this.f861b = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.w
    public void a(c cVar, Exception exc, boolean z) {
        c cVar2 = cVar;
        if (exc != null) {
            l.a(this.c, (String) null, this.a, this.f861b);
            return;
        }
        if (cVar2 != null) {
            String str = this.a;
            if (cVar2.a.size() > 1) {
                List<String> list = cVar2.a;
                str = list.get(list.size() - 1);
            }
            b bVarA = this.c.a(str);
            if ((bVarA == null || bVarA.a == l.d.FAILED) && !TextUtils.isEmpty(cVar2.f856b)) {
                l.a(this.c, cVar2, str, true);
                l.a(this.c, cVar2.f856b, str, this.f861b);
            } else {
                l.a(this.c, cVar2, str, false);
                if (this.c.e.size() == 0) {
                    this.c.e.add(new i(str, false, l.d.INTERNAL_REDIRECT, null));
                }
                this.c.a(l.a(str, "followRedirects", "Invalid response"));
            }
        }
    }
}
