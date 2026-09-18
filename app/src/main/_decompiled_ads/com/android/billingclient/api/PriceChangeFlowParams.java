package com.android.billingclient.api;

import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@5.1.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class PriceChangeFlowParams {
    private SkuDetails skuDetails;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@5.1.0 */
    @Deprecated
    public static class Builder {
        private SkuDetails skuDetails;

        private Builder setSkuDetails(String str) {
            try {
                this.skuDetails = new SkuDetails(str);
                return this;
            } catch (JSONException e) {
                throw new IllegalArgumentException("Incorrect skuDetails JSON object!", e);
            }
        }

        public PriceChangeFlowParams build() {
            SkuDetails skuDetails = this.skuDetails;
            if (skuDetails == null) {
                throw new IllegalArgumentException("SkuDetails must be set");
            }
            PriceChangeFlowParams priceChangeFlowParams = new PriceChangeFlowParams();
            priceChangeFlowParams.skuDetails = skuDetails;
            return priceChangeFlowParams;
        }

        public Builder setSkuDetails(SkuDetails skuDetails) {
            this.skuDetails = skuDetails;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public SkuDetails getSkuDetails() {
        return this.skuDetails;
    }
}
