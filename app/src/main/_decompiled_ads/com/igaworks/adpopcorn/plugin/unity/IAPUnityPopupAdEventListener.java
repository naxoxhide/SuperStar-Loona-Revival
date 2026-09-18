package com.igaworks.adpopcorn.plugin.unity;

/* JADX INFO: loaded from: classes2.dex */
public interface IAPUnityPopupAdEventListener {
    void OnLoadPopupAdFailure(int i, String str);

    void OnLoadPopupAdSuccess();

    void OnPopupAdClose();

    void OnShowPopupAdFailure(int i, String str);

    void OnShowPopupAdSuccess();
}
