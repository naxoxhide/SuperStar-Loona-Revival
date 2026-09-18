package com.igaworks.adpopcorn.interfaces;

import com.igaworks.adpopcorn.cores.common.APVideoError;

/* JADX INFO: loaded from: classes2.dex */
public interface IAPShowVideoAdEventListener {
    void OnShowVideoAdFailure(APVideoError aPVideoError);

    void OnShowVideoAdSuccess();

    void OnVideoAdClose();
}
