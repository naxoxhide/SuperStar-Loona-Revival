package com.bytedance.sdk.openadsdk.d.p;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: EventProviderWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements com.bytedance.sdk.openadsdk.m.a {
    private b.b.a.a.i.a.k.f.b a;

    public e(b.b.a.a.i.a.k.f.b bVar) {
        this.a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String b() {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String a(Uri uri) {
        m.a("wrapper getType1");
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Uri a(Uri uri, ContentValues contentValues) {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, String str, String[] strArr) {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        b.b.a.a.i.a.k.f.b bVar = this.a;
        if (bVar != null) {
            return bVar.a(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
