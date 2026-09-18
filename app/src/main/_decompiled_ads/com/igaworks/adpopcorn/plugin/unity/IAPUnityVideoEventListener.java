package com.igaworks.adpopcorn.plugin.unity;

/* JADX INFO: loaded from: classes2.dex */
public interface IAPUnityVideoEventListener {
    void OnLoadVideoAdFailure(int i, String str);

    void OnLoadVideoAdSuccess();

    void OnShowVideoAdFailure(int i, String str);

    void OnShowVideoAdSuccess();

    void OnVideoAdClose();
}
