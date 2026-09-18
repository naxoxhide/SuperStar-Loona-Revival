package com.bytedance.sdk.openadsdk.m;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: ITTProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int a(Uri uri, ContentValues contentValues, String str, String[] strArr);

    int a(Uri uri, String str, String[] strArr);

    Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    Uri a(Uri uri, ContentValues contentValues);

    String a(Uri uri);

    void a();

    String b();
}
