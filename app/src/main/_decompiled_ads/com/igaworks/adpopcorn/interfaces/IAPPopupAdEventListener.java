package com.igaworks.adpopcorn.interfaces;

import com.igaworks.adpopcorn.cores.common.APPopupAdError;

/* JADX INFO: loaded from: classes2.dex */
public interface IAPPopupAdEventListener {
    void OnLoadPopupAdFailure(APPopupAdError aPPopupAdError);

    void OnLoadPopupAdSuccess();

    void OnPopupAdClose();

    void OnShowPopupAdFailure(APPopupAdError aPPopupAdError);

    void OnShowPopupAdSuccess();
}
