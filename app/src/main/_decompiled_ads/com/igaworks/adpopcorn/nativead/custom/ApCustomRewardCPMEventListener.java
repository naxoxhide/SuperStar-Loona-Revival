package com.igaworks.adpopcorn.nativead.custom;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ApCustomRewardCPMEventListener {
    void onCustomRewardCPMClickFailed(ApCustomRewardCPMError apCustomRewardCPMError);

    void onCustomRewardCPMClickSuccess();

    void onCustomRewardCPMLoadFailed(ApCustomRewardCPMError apCustomRewardCPMError);

    void onCustomRewardCPMLoadSuccess(List<ApCustomRewardCPMModel> list);
}
