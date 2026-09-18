package com.tnkfactory.ad.pub.a;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class d0 extends e {
    public d0(Context context, com.tnkfactory.ad.pub.a aVar) {
        super(context, aVar.Z, aVar.a0, aVar, false);
    }

    public static d0 a(Context context, com.tnkfactory.ad.pub.a aVar) {
        try {
            System.currentTimeMillis();
            d0 d0Var = new d0(context, aVar);
            if (aVar.L == 4) {
                d0Var.e();
            }
            return d0Var;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.tnkfactory.ad.pub.a.e
    public final void a(int i, boolean z) {
    }
}
