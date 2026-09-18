package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class h5 {
    public final l7 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l7 f2764b;

    public h5(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("fiverocks", 0);
        this.a = new l7(sharedPreferences, "noMoreToday.date");
        this.f2764b = new l7(sharedPreferences, "noMoreToday.actionIds");
        a();
    }

    public final void a() {
        String strB = this.a.b();
        if (strB == null || new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()).equals(strB)) {
            return;
        }
        this.a.a(null);
        this.f2764b.a(null);
    }
}
