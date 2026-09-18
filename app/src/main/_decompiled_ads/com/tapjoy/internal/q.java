package com.tapjoy.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q {
    public static q a;

    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    public static void a(Activity activity) {
        ma maVar;
        boolean z;
        boolean z2;
        Intent intent;
        ComponentName component;
        q qVar = a;
        if (qVar != null) {
            s sVar = (s) qVar;
            if (activity != null) {
                int taskId = activity.getTaskId();
                if (taskId == -1 || (intent = activity.getIntent()) == null) {
                    z2 = false;
                } else {
                    Set<String> categories = intent.getCategories();
                    if ((categories != null && categories.contains("android.intent.category.LAUNCHER") && "android.intent.action.MAIN".equals(intent.getAction())) && (component = intent.getComponent()) != null) {
                        Integer num = (Integer) sVar.f2809b.put(component.getClassName(), Integer.valueOf(taskId));
                        if (num == null || num.intValue() != taskId) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    sVar.e.c();
                } else if (!sVar.d) {
                    maVar = sVar.c;
                    maVar.getClass();
                    if (SystemClock.elapsedRealtime() - maVar.f2784b > maVar.a) {
                    }
                    if (z) {
                        sVar.e.c();
                    }
                }
            } else if (!sVar.d) {
                maVar = sVar.c;
                maVar.getClass();
                try {
                    z = SystemClock.elapsedRealtime() - maVar.f2784b > maVar.a;
                } catch (NullPointerException unused) {
                }
                if (z) {
                    sVar.e.c();
                }
            }
            sVar.d = true;
        }
    }
}
