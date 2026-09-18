package com.igaworks.adpopcorn.interfaces;

import com.igaworks.adpopcorn.cores.model.APClientRewardItem;

/* JADX INFO: loaded from: classes2.dex */
public interface IAPClientRewardCallbackListener {
    void onDidGiveRewardItemResult(boolean z, String str, int i, String str2);

    void onGetRewardInfo(boolean z, String str, APClientRewardItem[] aPClientRewardItemArr);
}
