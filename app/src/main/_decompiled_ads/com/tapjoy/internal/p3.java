package com.tapjoy.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tapjoy.TJContentActivity;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class p3 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Activity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f2795b;
    public final /* synthetic */ r3 c;

    public p3(r3 r3Var, Activity activity, g2 g2Var) {
        this.c = r3Var;
        this.a = activity;
        this.f2795b = g2Var;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        LinkedHashMap linkedHashMap;
        String string;
        h5 h5Var;
        r3.l = null;
        Activity activity = this.a;
        String str = this.c.f.g;
        if (!TextUtils.isEmpty(str)) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
            }
        }
        r3 r3Var = this.c;
        v1 v1Var = r3Var.d;
        LinkedHashMap linkedHashMap2 = r3Var.f.k;
        SystemClock.elapsedRealtime();
        long j = this.c.i;
        p1 p1Var = v1Var.f;
        p1Var.getClass();
        n1 n1VarA = p1Var.a(r1.CAMPAIGN, "view");
        if (linkedHashMap2 != null) {
            StringWriter stringWriter = new StringWriter();
            g4 g4Var = new g4(stringWriter);
            try {
                g4Var.a(linkedHashMap2);
                try {
                    g4Var.a.flush();
                    stringWriter.toString();
                } catch (IOException e) {
                    s9.a(e);
                    throw null;
                }
            } catch (IOException e2) {
                s9.a(e2);
                throw null;
            }
        }
        p1Var.a(n1VarA);
        r3 r3Var2 = this.c;
        if (!r3Var2.a) {
            this.f2795b.a(r3Var2.e, r3Var2.c, r3Var2.f.h);
        }
        r3 r3Var3 = this.c;
        if (r3Var3.k && (linkedHashMap = r3Var3.f.k) != null && linkedHashMap.containsKey("action_id") && (string = this.c.f.k.get("action_id").toString()) != null && string.length() > 0 && (h5Var = this.c.d.f2824b) != null) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            String strB = h5Var.f2764b.b();
            String strB2 = h5Var.a.b();
            if (strB2 == null || !str2.equals(strB2)) {
                h5Var.a.a(str2);
                strB = "";
            }
            if (!(strB.length() == 0)) {
                string = !strB.contains(string) ? strB.concat(",".concat(string)) : strB;
            }
            h5Var.f2764b.a(string);
        }
        Activity activity2 = this.a;
        if (activity2 instanceof TJContentActivity) {
            activity2.finish();
        }
    }
}
