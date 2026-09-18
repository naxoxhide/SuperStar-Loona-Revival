package com.igaworks.adpopcorn.a.h.b;

import android.content.Context;
import com.igaworks.adpopcorn.a.d;
import com.igaworks.adpopcorn.cores.model.APClientRewardItem;

/* JADX INFO: loaded from: classes2.dex */
public class a implements APClientRewardItem {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1497b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;
    private Context h;

    public a(Context context, String str, String str2, String str3, String str4, String str5, long j) {
        this.h = context;
        this.a = str;
        this.f1497b = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = j;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public void didGiveRewardItem() {
        d.a(this.h).b(getRTID());
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getCV() {
        return this.f;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getCampaignKey() {
        return this.a;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getCampaignTitle() {
        return this.f1497b;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getItemKey() {
        return this.c;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getItemName() {
        return this.d;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public String getRTID() {
        return this.e;
    }

    @Override // com.igaworks.adpopcorn.cores.model.APClientRewardItem
    public long getRewardQuantity() {
        return this.g;
    }
}
