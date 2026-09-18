package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import com.android.billingclient.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@5.1.0 */
/* JADX INFO: loaded from: classes.dex */
class BillingClientImpl extends BillingClient {
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzp zzd;
    private Context zze;
    private volatile com.google.android.gms.internal.play_billing.zze zzf;
    private volatile zzaq zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private ExecutorService zzv;

    private BillingClientImpl(Activity activity, boolean z, String str) {
        this(activity.getApplicationContext(), z, new zzau(), str, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, boolean z, zzc zzcVar) {
        this.zze = context.getApplicationContext();
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzp(this.zze, purchasesUpdatedListener, zzcVar);
        this.zzt = z;
        this.zzu = zzcVar != null;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, long j) {
        launchPriceChangeConfirmationFlow(activity, priceChangeFlowParams, new zzau(j));
    }

    private void startConnection(long j) {
        zzau zzauVar = new zzau(j);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
            zzauVar.onBillingSetupFinished(zzbc.zzl);
            return;
        }
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
            zzauVar.onBillingSetupFinished(zzbc.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzauVar.onBillingSetupFinished(zzbc.zzm);
            return;
        }
        this.zza = 1;
        this.zzd.zze();
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Starting in-app billing setup.");
        this.zzg = new zzaq(this, zzauVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzg, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Billing service unavailable on device.");
        zzauVar.onBillingSetupFinished(zzbc.zzc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzF() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzG(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzE(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzH() {
        return (this.zza == 0 || this.zza == 3) ? zzbc.zzm : zzbc.zzj;
    }

    private static String zzI() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future zzJ(Callable callable, long j, final Runnable runnable, Handler handler) {
        if (this.zzv == null) {
            this.zzv = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzam(this));
        }
        try {
            final Future futureSubmit = this.zzv.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzag
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    Runnable runnable2 = runnable;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    private final void zzK(final BillingResult billingResult, final PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (Thread.interrupted()) {
            return;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzy
            @Override // java.lang.Runnable
            public final void run() {
                priceChangeConfirmationListener.onPriceChangeConfirmationResult(billingResult);
            }
        });
    }

    private final void zzL(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbc.zzm, null);
        } else if (zzJ(new zzak(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzx
            @Override // java.lang.Runnable
            public final void run() {
                purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbc.zzn, null);
            }
        }, zzF()) == null) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzH(), null);
        }
    }

    private final void zzM(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            purchasesResponseListener.onQueryPurchasesResponse(zzbc.zzm, com.google.android.gms.internal.play_billing.zzu.zzl());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please provide a valid product type.");
            purchasesResponseListener.onQueryPurchasesResponse(zzbc.zzg, com.google.android.gms.internal.play_billing.zzu.zzl());
        } else if (zzJ(new zzaj(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                purchasesResponseListener.onQueryPurchasesResponse(zzbc.zzn, com.google.android.gms.internal.play_billing.zzu.zzl());
            }
        }, zzF()) == null) {
            purchasesResponseListener.onQueryPurchasesResponse(zzH(), com.google.android.gms.internal.play_billing.zzu.zzl());
        }
    }

    static /* bridge */ /* synthetic */ zzat zzg(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzh = com.google.android.gms.internal.play_billing.zzb.zzh(billingClientImpl.zzm, billingClientImpl.zzt, billingClientImpl.zzb);
        String string = null;
        while (billingClientImpl.zzk) {
            try {
                Bundle bundleZzh2 = billingClientImpl.zzf.zzh(6, billingClientImpl.zze.getPackageName(), str, string, bundleZzh);
                BillingResult billingResultZza = zzbk.zza(bundleZzh2, "BillingClient", "getPurchaseHistory()");
                if (billingResultZza != zzbc.zzl) {
                    return new zzat(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzh2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got an exception trying to decode the purchase!", e);
                        return new zzat(zzbc.zzj, null);
                    }
                }
                string = bundleZzh2.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzat(zzbc.zzl, arrayList);
                }
            } catch (RemoteException e2) {
                com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got exception trying to get purchase history, try to reconnect", e2);
                return new zzat(zzbc.zzm, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzat(zzbc.zzq, null);
    }

    static /* bridge */ /* synthetic */ zzbj zzi(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzh = com.google.android.gms.internal.play_billing.zzb.zzh(billingClientImpl.zzm, billingClientImpl.zzt, billingClientImpl.zzb);
        String string = null;
        do {
            try {
                Bundle bundleZzj = billingClientImpl.zzm ? billingClientImpl.zzf.zzj(9, billingClientImpl.zze.getPackageName(), str, string, bundleZzh) : billingClientImpl.zzf.zzi(3, billingClientImpl.zze.getPackageName(), str, string);
                BillingResult billingResultZza = zzbk.zza(bundleZzj, "BillingClient", "getPurchase()");
                if (billingResultZza != zzbc.zzl) {
                    return new zzbj(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got an exception trying to decode the purchase!", e);
                        return new zzbj(zzbc.zzj, null);
                    }
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new zzbj(zzbc.zzm, null);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzbj(zzbc.zzl, arrayList);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please provide a valid purchase token.");
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzi);
        } else if (!this.zzm) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzb);
        } else if (zzJ(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzk(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
            @Override // java.lang.Runnable
            public final void run() {
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzn);
            }
        }, zzF()) == null) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzH());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            consumeResponseListener.onConsumeResponse(zzbc.zzm, consumeParams.getPurchaseToken());
        } else if (zzJ(new Callable() { // from class: com.android.billingclient.api.zzv
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzl(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzw
            @Override // java.lang.Runnable
            public final void run() {
                consumeResponseListener.onConsumeResponse(zzbc.zzn, consumeParams.getPurchaseToken());
            }
        }, zzF()) == null) {
            consumeResponseListener.onConsumeResponse(zzH(), consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        try {
            this.zzd.zzd();
            if (this.zzg != null) {
                this.zzg.zzc();
            }
            if (this.zzg != null && this.zzf != null) {
                com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzg);
                this.zzg = null;
            }
            this.zzf = null;
            ExecutorService executorService = this.zzv;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzv = null;
            }
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "There was an exception while ending connection!", e);
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            return zzbc.zzm;
        }
        switch (str) {
            case "subscriptions":
                return this.zzh ? zzbc.zzl : zzbc.zzo;
            case "subscriptionsUpdate":
                return this.zzi ? zzbc.zzl : zzbc.zzp;
            case "priceChangeConfirmation":
                return this.zzl ? zzbc.zzl : zzbc.zzr;
            case "bbb":
                return this.zzo ? zzbc.zzl : zzbc.zzw;
            case "aaa":
                return this.zzq ? zzbc.zzl : zzbc.zzs;
            case "ddd":
                return this.zzp ? zzbc.zzl : zzbc.zzu;
            case "ccc":
            case "eee":
                return this.zzr ? zzbc.zzl : zzbc.zzt;
            case "fff":
                return this.zzs ? zzbc.zzl : zzbc.zzv;
            case "ggg":
                return this.zzs ? zzbc.zzl : zzbc.zzz;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                return zzbc.zzy;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return (this.zza != 2 || this.zzf == null || this.zzg == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:116:0x02da  */
    /* JADX WARN: Code duplicated, block: B:117:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:119:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:132:0x0321  */
    /* JADX WARN: Code duplicated, block: B:134:0x0325 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x032a  */
    /* JADX WARN: Code duplicated, block: B:138:0x032e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0331  */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        final String productId;
        final String productType;
        String str;
        Future futureZzJ;
        String str2;
        SkuDetails skuDetails;
        BillingFlowParams.ProductDetailsParams productDetailsParams;
        String str3;
        String str4;
        String str5;
        boolean z;
        Intent intent;
        String str6;
        int i;
        final BillingClientImpl billingClientImpl = this;
        if (!isReady()) {
            BillingResult billingResult = zzbc.zzm;
            billingClientImpl.zzG(billingResult);
            return billingResult;
        }
        ArrayList<SkuDetails> arrayListZze = billingFlowParams.zze();
        List listZzf = billingFlowParams.zzf();
        SkuDetails skuDetails2 = (SkuDetails) com.google.android.gms.internal.play_billing.zzz.zza(arrayListZze, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzz.zza(listZzf, null);
        if (skuDetails2 != null) {
            productId = skuDetails2.getSku();
            productType = skuDetails2.getType();
        } else {
            productId = productDetailsParams2.zza().getProductId();
            productType = productDetailsParams2.zza().getProductType();
        }
        if (productType.equals("subs") && !billingClientImpl.zzh) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult2 = zzbc.zzo;
            billingClientImpl.zzG(billingResult2);
            return billingResult2;
        }
        if (billingFlowParams.zzo() && !billingClientImpl.zzk) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult3 = zzbc.zzh;
            billingClientImpl.zzG(billingResult3);
            return billingResult3;
        }
        if (arrayListZze.size() > 1 && !billingClientImpl.zzr) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult4 = zzbc.zzt;
            billingClientImpl.zzG(billingResult4);
            return billingResult4;
        }
        if (!listZzf.isEmpty() && !billingClientImpl.zzs) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            BillingResult billingResult5 = zzbc.zzv;
            billingClientImpl.zzG(billingResult5);
            return billingResult5;
        }
        if (billingClientImpl.zzk) {
            final Bundle bundleZzf = com.google.android.gms.internal.play_billing.zzb.zzf(billingFlowParams, billingClientImpl.zzm, billingClientImpl.zzt, billingClientImpl.zzu, billingClientImpl.zzb);
            final String str7 = productType;
            if (arrayListZze.isEmpty()) {
                str2 = "proxyPackageVersion";
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                str3 = productId;
                str4 = "BillingClient";
                ArrayList<String> arrayList = new ArrayList<>(listZzf.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzf.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                for (int i2 = 0; i2 < listZzf.size(); i2++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) listZzf.get(i2);
                    ProductDetails productDetailsZza = productDetailsParams3.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    arrayList4.add(productDetailsParams3.zzb());
                    if (!TextUtils.isEmpty(productDetailsZza.zzc())) {
                        arrayList5.add(productDetailsZza.zzc());
                    }
                    if (i2 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzf.get(i2)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzf.get(i2)).zza().getProductType());
                    }
                }
                bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList3.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundleZzf.putStringArrayList("additionalSkus", arrayList);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<String> arrayList7 = new ArrayList<>();
                str3 = productId;
                ArrayList<String> arrayList8 = new ArrayList<>();
                str2 = "proxyPackageVersion";
                ArrayList<Integer> arrayList9 = new ArrayList<>();
                str4 = "BillingClient";
                ArrayList<String> arrayList10 = new ArrayList<>();
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                for (SkuDetails skuDetails3 : arrayListZze) {
                    if (!skuDetails3.zzf().isEmpty()) {
                        arrayList6.add(skuDetails3.zzf());
                    }
                    String strZzc = skuDetails3.zzc();
                    SkuDetails skuDetails4 = skuDetails2;
                    String strZzb = skuDetails3.zzb();
                    int iZza = skuDetails3.zza();
                    String strZze = skuDetails3.zze();
                    arrayList7.add(strZzc);
                    z2 |= !TextUtils.isEmpty(strZzc);
                    arrayList8.add(strZzb);
                    z3 |= !TextUtils.isEmpty(strZzb);
                    arrayList9.add(Integer.valueOf(iZza));
                    z4 |= iZza != 0;
                    z5 |= !TextUtils.isEmpty(strZze);
                    arrayList10.add(strZze);
                    productDetailsParams2 = productDetailsParams2;
                    skuDetails2 = skuDetails4;
                }
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                if (!arrayList6.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList6);
                }
                if (z2) {
                    bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                }
                if (z3) {
                    bundleZzf.putStringArrayList("SKU_OFFER_ID_LIST", arrayList8);
                }
                if (z4) {
                    bundleZzf.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList9);
                }
                if (z5) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList10);
                }
                if (arrayListZze.size() > 1) {
                    ArrayList<String> arrayList11 = new ArrayList<>(arrayListZze.size() - 1);
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListZze.size() - 1);
                    for (int i3 = 1; i3 < arrayListZze.size(); i3++) {
                        arrayList11.add(((SkuDetails) arrayListZze.get(i3)).getSku());
                        arrayList12.add(((SkuDetails) arrayListZze.get(i3)).getType());
                    }
                    bundleZzf.putStringArrayList("additionalSkus", arrayList11);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList12);
                }
            }
            billingClientImpl = this;
            if (bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !billingClientImpl.zzp) {
                BillingResult billingResult6 = zzbc.zzu;
                billingClientImpl.zzG(billingResult6);
                return billingResult6;
            }
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.zzd())) {
                if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                    str5 = null;
                    z = false;
                } else {
                    bundleZzf.putString("skuPackageName", productDetailsParams.zza().zza());
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundleZzf.putString("accountName", str5);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    str = str4;
                    com.google.android.gms.internal.play_billing.zzb.zzo(str, "Activity's intent is null.");
                } else {
                    str = str4;
                    if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                        bundleZzf.putString("proxyPackage", stringExtra);
                        try {
                            str6 = str2;
                            try {
                                bundleZzf.putString(str6, billingClientImpl.zze.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                            } catch (PackageManager.NameNotFoundException unused) {
                                bundleZzf.putString(str6, "package not found");
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str6 = str2;
                        }
                    }
                }
                if (!billingClientImpl.zzs && !listZzf.isEmpty()) {
                    i = 17;
                } else if (!billingClientImpl.zzq && z) {
                    i = 15;
                } else if (billingClientImpl.zzm) {
                    i = 9;
                } else {
                    i = 6;
                }
                final int i4 = i;
                final String str8 = str3;
                futureZzJ = zzJ(new Callable() { // from class: com.android.billingclient.api.zzac
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzc(i4, str8, str7, billingFlowParams, bundleZzf);
                    }
                }, 5000L, null, billingClientImpl.zzc);
            } else {
                bundleZzf.putString("skuPackageName", skuDetails.zzd());
            }
            str5 = null;
            z = true;
            if (!TextUtils.isEmpty(str5)) {
                bundleZzf.putString("accountName", str5);
            }
            intent = activity.getIntent();
            if (intent == null) {
                str = str4;
                com.google.android.gms.internal.play_billing.zzb.zzo(str, "Activity's intent is null.");
            } else {
                str = str4;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                    bundleZzf.putString("proxyPackage", stringExtra2);
                    str6 = str2;
                    bundleZzf.putString(str6, billingClientImpl.zze.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
                }
            }
            if (!billingClientImpl.zzs) {
                if (!billingClientImpl.zzq) {
                    if (billingClientImpl.zzm) {
                        i = 9;
                    } else {
                        i = 6;
                    }
                } else if (billingClientImpl.zzm) {
                    i = 9;
                } else {
                    i = 6;
                }
            } else if (!billingClientImpl.zzq) {
                if (billingClientImpl.zzm) {
                    i = 9;
                } else {
                    i = 6;
                }
            } else if (billingClientImpl.zzm) {
                i = 9;
            } else {
                i = 6;
            }
            final int i5 = i;
            final String str9 = str3;
            futureZzJ = zzJ(new Callable() { // from class: com.android.billingclient.api.zzac
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc(i5, str9, str7, billingFlowParams, bundleZzf);
                }
            }, 5000L, null, billingClientImpl.zzc);
        } else {
            str = "BillingClient";
            futureZzJ = zzJ(new Callable() { // from class: com.android.billingclient.api.zzad
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzd(productId, productType);
                }
            }, 5000L, null, billingClientImpl.zzc);
        }
        try {
            Bundle bundle = (Bundle) futureZzJ.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle, str);
            String strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundle, str);
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                activity.startActivity(intent2);
                return zzbc.zzl;
            }
            com.google.android.gms.internal.play_billing.zzb.zzo(str, "Unable to buy item, Error response code: " + iZzb);
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZzb);
            builderNewBuilder.setDebugMessage(strZzk);
            BillingResult billingResultBuild = builderNewBuilder.build();
            billingClientImpl.zzG(billingResultBuild);
            return billingResultBuild;
        } catch (CancellationException e) {
            e = e;
            com.google.android.gms.internal.play_billing.zzb.zzp(str, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult7 = zzbc.zzn;
            billingClientImpl.zzG(billingResult7);
            return billingResult7;
        } catch (TimeoutException e2) {
            e = e2;
            com.google.android.gms.internal.play_billing.zzb.zzp(str, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult8 = zzbc.zzn;
            billingClientImpl.zzG(billingResult8);
            return billingResult8;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzp(str, "Exception while launching billing flow. Try to reconnect", e3);
            BillingResult billingResult9 = zzbc.zzm;
            billingClientImpl.zzG(billingResult9);
            return billingResult9;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            productDetailsResponseListener.onProductDetailsResponse(zzbc.zzm, new ArrayList());
            return;
        }
        if (!this.zzs) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Querying product details is not supported.");
            productDetailsResponseListener.onProductDetailsResponse(zzbc.zzv, new ArrayList());
        } else if (zzJ(new Callable() { // from class: com.android.billingclient.api.zzt
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzm(queryProductDetailsParams, productDetailsResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzu
            @Override // java.lang.Runnable
            public final void run() {
                productDetailsResponseListener.onProductDetailsResponse(zzbc.zzn, new ArrayList());
            }
        }, zzF()) == null) {
            productDetailsResponseListener.onProductDetailsResponse(zzH(), new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzL(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzM(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please fix the input params. SKU type can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zzf, null);
            return;
        }
        if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zze, null);
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (String str : skusList) {
            zzbv zzbvVar = new zzbv(null);
            zzbvVar.zza(str);
            arrayList.add(zzbvVar.zzb());
        }
        final String str2 = null;
        if (zzJ(new Callable(skuType, arrayList, str2, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzr
            public final /* synthetic */ String zzb;
            public final /* synthetic */ List zzc;
            public final /* synthetic */ SkuDetailsResponseListener zzd;

            {
                this.zzd = skuDetailsResponseListener;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzn(this.zzb, this.zzc, null, this.zzd);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
            @Override // java.lang.Runnable
            public final void run() {
                skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zzn, null);
            }
        }, zzF()) == null) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzH(), null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Service disconnected.");
            return zzbc.zzm;
        }
        if (!this.zzo) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzbc.zzw;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.getInAppMessageCategoriesToShow());
        final zzal zzalVar = new zzal(this, this.zzc, inAppMessageResponseListener);
        zzJ(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzo(bundle, activity, zzalVar);
                return null;
            }
        }, 5000L, null, this.zzc);
        return zzbc.zzl;
    }

    final /* synthetic */ void zzE(BillingResult billingResult) {
        if (this.zzd.zzc() != null) {
            this.zzd.zzc().onPurchasesUpdated(billingResult, null);
        } else {
            this.zzd.zzb();
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ Bundle zzc(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzf.zzg(i, this.zze.getPackageName(), str, str2, null, bundle);
    }

    final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzf.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    final /* synthetic */ Bundle zze(String str, Bundle bundle) throws Exception {
        return this.zzf.zzm(8, this.zze.getPackageName(), str, "subs", bundle);
    }

    final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            Bundle bundleZzd = this.zzf.zzd(9, this.zze.getPackageName(), acknowledgePurchaseParams.getPurchaseToken(), com.google.android.gms.internal.play_billing.zzb.zzc(acknowledgePurchaseParams, this.zzb));
            int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzd, "BillingClient");
            String strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundleZzd, "BillingClient");
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZzb);
            builderNewBuilder.setDebugMessage(strZzk);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(builderNewBuilder.build());
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Error acknowledge purchase!", e);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzm);
            return null;
        }
    }

    final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int iZza;
        String strZzk;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzm) {
                Bundle bundleZze = this.zzf.zze(9, this.zze.getPackageName(), purchaseToken, com.google.android.gms.internal.play_billing.zzb.zzd(consumeParams, this.zzm, this.zzb));
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundleZze, "BillingClient");
            } else {
                iZza = this.zzf.zza(3, this.zze.getPackageName(), purchaseToken);
                strZzk = "";
            }
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZza);
            builderNewBuilder.setDebugMessage(strZzk);
            BillingResult billingResultBuild = builderNewBuilder.build();
            if (iZza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
                return null;
            }
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Error consuming purchase with token. Response code: " + iZza);
            consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Error consuming purchase!", e);
            consumeResponseListener.onConsumeResponse(zzbc.zzm, purchaseToken);
            return null;
        }
    }

    final /* synthetic */ Object zzm(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String strZzk;
        ArrayList arrayList = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzu zzuVarZza = queryProductDetailsParams.zza();
        int size = zzuVarZza.size();
        int iZzb = 0;
        int i = 0;
        while (true) {
            strZzk = "Item is unavailable for purchase.";
            if (i >= size) {
                strZzk = "";
                break;
            }
            int i2 = i + 20;
            ArrayList arrayList2 = new ArrayList(zzuVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                Bundle bundleZzl = this.zzf.zzl(17, this.zze.getPackageName(), strZzb, bundle, com.google.android.gms.internal.play_billing.zzb.zzg(this.zzb, arrayList2, null));
                if (bundleZzl != null) {
                    if (bundleZzl.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "queryProductDetailsAsync got null response list");
                        } else {
                            for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                                try {
                                    ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                                    com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                    arrayList.add(productDetails);
                                } catch (JSONException e) {
                                    com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                                    strZzk = "Error trying to decode SkuDetails.";
                                }
                            }
                            i = i2;
                        }
                    } else {
                        iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzl, "BillingClient");
                        strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundleZzl, "BillingClient");
                        if (iZzb != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb);
                            break;
                        }
                        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                    }
                    iZzb = 6;
                    break;
                }
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "queryProductDetailsAsync got empty product details response.");
                iZzb = 4;
                break;
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e2);
                strZzk = "An internal error occurred.";
            }
        }
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(iZzb);
        builderNewBuilder.setDebugMessage(strZzk);
        productDetailsResponseListener.onProductDetailsResponse(builderNewBuilder.build(), arrayList);
        return null;
    }

    final /* synthetic */ Object zzn(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        int i;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            String strZzk = "Item is unavailable for purchase.";
            if (i2 < size) {
                int i3 = i2 + 20;
                ArrayList arrayList2 = new ArrayList(list.subList(i2, i3 > size ? size : i3));
                ArrayList<String> arrayList3 = new ArrayList<>();
                int size2 = arrayList2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList3.add(((zzbx) arrayList2.get(i4)).zza());
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
                bundle.putString("playBillingLibraryVersion", this.zzb);
                try {
                    Bundle bundleZzl = this.zzn ? this.zzf.zzl(10, this.zze.getPackageName(), str, bundle, com.google.android.gms.internal.play_billing.zzb.zze(this.zzj, this.zzt, this.zzb, null, arrayList2)) : this.zzf.zzk(3, this.zze.getPackageName(), str, bundle);
                    if (bundleZzl == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "querySkuDetailsAsync got null sku details list");
                        break;
                    }
                    if (bundleZzl.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "querySkuDetailsAsync got null response list");
                            break;
                        }
                        for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                            try {
                                SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                                com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                arrayList.add(skuDetails);
                            } catch (JSONException e) {
                                com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e);
                                strZzk = "Error trying to decode SkuDetails.";
                                i = 6;
                            }
                        }
                        i2 = i3;
                        arrayList = null;
                    } else {
                        int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzl, "BillingClient");
                        strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundleZzl, "BillingClient");
                        if (iZzb != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getSkuDetails() failed. Response code: " + iZzb);
                            i = iZzb;
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                            i = 6;
                        }
                    }
                } catch (Exception e2) {
                    com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
                    i = -1;
                    strZzk = "Service connection is disconnected.";
                }
            } else {
                strZzk = "";
                i = 0;
            }
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(i);
            builderNewBuilder.setDebugMessage(strZzk);
            skuDetailsResponseListener.onSkuDetailsResponse(builderNewBuilder.build(), arrayList);
            return null;
        }
        i = 4;
        arrayList = null;
        BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
        builderNewBuilder2.setResponseCode(i);
        builderNewBuilder2.setDebugMessage(strZzk);
        skuDetailsResponseListener.onSkuDetailsResponse(builderNewBuilder2.build(), arrayList);
        return null;
    }

    final /* synthetic */ Object zzo(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzf.zzn(12, this.zze.getPackageName(), bundle, new zzas(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (!isReady()) {
            zzK(zzbc.zzm, priceChangeConfirmationListener);
            return;
        }
        if (priceChangeFlowParams == null || priceChangeFlowParams.getSkuDetails() == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            zzK(zzbc.zzk, priceChangeConfirmationListener);
            return;
        }
        final String sku = priceChangeFlowParams.getSkuDetails().getSku();
        if (sku == null) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            zzK(zzbc.zzk, priceChangeConfirmationListener);
            return;
        }
        if (!this.zzl) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Current client doesn't support price change confirmation flow.");
            zzK(zzbc.zzr, priceChangeConfirmationListener);
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putBoolean("subs_price_change", true);
        try {
            Bundle bundle2 = (Bundle) zzJ(new Callable() { // from class: com.android.billingclient.api.zzs
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zze(sku, bundle);
                }
            }, 5000L, null, this.zzc).get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle2, "BillingClient");
            String strZzk = com.google.android.gms.internal.play_billing.zzb.zzk(bundle2, "BillingClient");
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZzb);
            builderNewBuilder.setDebugMessage(strZzk);
            BillingResult billingResultBuild = builderNewBuilder.build();
            if (iZzb != 0) {
                com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Unable to launch price change flow, error response code: " + iZzb);
                zzK(billingResultBuild, priceChangeConfirmationListener);
                return;
            }
            zzai zzaiVar = new zzai(this, this.zzc, priceChangeConfirmationListener);
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra("SUBS_MANAGEMENT_INTENT", (PendingIntent) bundle2.getParcelable("SUBS_MANAGEMENT_INTENT"));
            intent.putExtra("result_receiver", zzaiVar);
            activity.startActivity(intent);
        } catch (CancellationException e) {
            e = e;
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Time out while launching Price Change Flow for sku: " + sku + "; try to reconnect", e);
            zzK(zzbc.zzn, priceChangeConfirmationListener);
        } catch (TimeoutException e2) {
            e = e2;
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Time out while launching Price Change Flow for sku: " + sku + "; try to reconnect", e);
            zzK(zzbc.zzn, priceChangeConfirmationListener);
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzp("BillingClient", "Exception caught while launching Price Change Flow for sku: " + sku + "; try to reconnect", e3);
            zzK(zzbc.zzm, priceChangeConfirmationListener);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzL(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzM(str, purchasesResponseListener);
    }

    private BillingClientImpl(Context context, boolean z, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, zzc zzcVar) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, z, null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = str;
    }

    BillingClientImpl(String str, boolean z, Context context, zzbf zzbfVar) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = zzI();
        this.zze = context.getApplicationContext();
        com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzp(this.zze, null);
        this.zzt = z;
    }

    BillingClientImpl(String str, boolean z, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzc zzcVar) {
        this(context, z, purchasesUpdatedListener, zzI(), null, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzl);
            return;
        }
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzm);
            return;
        }
        this.zza = 1;
        this.zzd.zze();
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Starting in-app billing setup.");
        this.zzg = new zzaq(this, billingClientStateListener, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzg, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzo("BillingClient", "Connection to Billing service is blocked.");
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzn("BillingClient", "Billing service unavailable on device.");
        billingClientStateListener.onBillingSetupFinished(zzbc.zzc);
    }
}
