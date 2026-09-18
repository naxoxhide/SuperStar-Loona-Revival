package com.fyber.inneractive.sdk.web;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public class q implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f1366b;

    public q(i iVar, String str) {
        this.f1366b = iVar;
        this.a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1366b.a(this.a);
    }
}
