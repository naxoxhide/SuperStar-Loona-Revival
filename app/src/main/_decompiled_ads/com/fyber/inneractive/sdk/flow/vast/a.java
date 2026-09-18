package com.fyber.inneractive.sdk.flow.vast;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public int d;
    public String e;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f933b = null;
    public boolean c = false;
    public EnumC0268a f = EnumC0268a.HIGH;

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.vast.a$a, reason: collision with other inner class name */
    public enum EnumC0268a {
        HIGH,
        LOW
    }

    public static class b implements Comparator<a> {
        @Override // java.util.Comparator
        public int compare(a aVar, a aVar2) {
            return aVar.f.ordinal() - aVar2.f.ordinal();
        }
    }

    public void a(View view) {
        this.f933b = view;
    }

    public void a() {
        this.f933b = null;
        this.a = false;
    }
}
