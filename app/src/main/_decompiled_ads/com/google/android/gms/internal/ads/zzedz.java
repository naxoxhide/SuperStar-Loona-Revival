package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.webkit.ProxyConfig;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedz extends zzbsn {
    private final Context zza;
    private final zzdso zzb;
    private final zzcay zzc;
    private final zzedo zzd;
    private final zzfib zze;
    private String zzf;
    private String zzg;

    public zzedz(Context context, zzedo zzedoVar, zzcay zzcayVar, zzdso zzdsoVar, zzfib zzfibVar) {
        this.zza = context;
        this.zzb = zzdsoVar;
        this.zzc = zzcayVar;
        this.zzd = zzedoVar;
        this.zze = zzfibVar;
    }

    public static void zzc(Context context, zzdso zzdsoVar, zzfib zzfibVar, zzedo zzedoVar, String str, String str2, Map map) {
        String strZza;
        String str3 = true != com.google.android.gms.ads.internal.zzt.zzo().zzx(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzir)).booleanValue() || zzdsoVar == null) {
            zzfia zzfiaVarZzb = zzfia.zzb(str2);
            zzfiaVarZzb.zza("gqi", str);
            zzfiaVarZzb.zza("device_connectivity", str3);
            zzfiaVarZzb.zza("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zzfiaVarZzb.zza((String) entry.getKey(), (String) entry.getValue());
            }
            strZza = zzfibVar.zza(zzfiaVarZzb);
        } else {
            zzdsn zzdsnVarZza = zzdsoVar.zza();
            zzdsnVarZza.zzb("gqi", str);
            zzdsnVarZza.zzb("action", str2);
            zzdsnVarZza.zzb("device_connectivity", str3);
            zzdsnVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            for (Map.Entry entry2 : map.entrySet()) {
                zzdsnVarZza.zzb((String) entry2.getKey(), (String) entry2.getValue());
            }
            strZza = zzdsnVarZza.zzf();
        }
        zzedoVar.zzd(new zzedq(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), str, strZza, 2));
    }

    private static String zzo(int i, String str) {
        Resources resourcesZzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
        return resourcesZzd == null ? str : resourcesZzd.getString(i);
    }

    private final void zzp(String str, String str2, Map map) {
        zzc(this.zza, this.zzb, this.zze, this.zzd, str, str2, map);
    }

    private final void zzq() {
        try {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzy(this.zza).zzf(ObjectWrapper.wrap(this.zza), this.zzg, this.zzf)) {
                return;
            }
        } catch (RemoteException e) {
            zzcat.zzh("Failed to schedule offline notification poster.", e);
        }
        this.zzd.zzc(this.zzf);
        zzp(this.zzf, "offline_notification_worker_not_scheduled", zzfvv.zzd());
    }

    private final void zzr(final Activity activity, final com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        com.google.android.gms.ads.internal.zzt.zzp();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzq();
            zzs(activity, zzlVar);
        } else {
            if (Build.VERSION.SDK_INT >= 33) {
                activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
                zzp(this.zzf, "asnpdi", zzfvv.zzd());
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(activity);
            builderZzJ.setTitle(zzo(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzo(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedr
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzd(activity, zzlVar, dialogInterface, i);
                }
            }).setNegativeButton(zzo(R.string.notifications_permission_decline, "Don't allow"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzeds
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zza.zzj(zzlVar, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedt
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.zza.zzk(zzlVar, dialogInterface);
                }
            });
            builderZzJ.create().show();
            zzp(this.zzf, "rtsdi", zzfvv.zzd());
        }
    }

    private final void zzs(Activity activity, final com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        String strZzo = zzo(R.string.offline_opt_in_confirmation, "You'll get a notification with the link when you're back online");
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(activity);
        builderZzJ.setMessage(strZzo).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedx
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                com.google.android.gms.ads.internal.overlay.zzl zzlVar2 = zzlVar;
                if (zzlVar2 != null) {
                    zzlVar2.zzb();
                }
            }
        });
        AlertDialog alertDialogCreate = builderZzJ.create();
        alertDialogCreate.show();
        Timer timer = new Timer();
        timer.schedule(new zzedy(this, alertDialogCreate, timer, zzlVar), 3000L);
    }

    private static final PendingIntent zzt(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClassName(context, AdService.CLASS_NAME);
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra(ShareConstants.MEDIA_URI, str3);
        return zzfqb.zza(context, 0, intent, zzfqb.zza | 1073741824, 0);
    }

    final /* synthetic */ void zzd(Activity activity, com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzp(this.zzf, "rtsdc", map);
        activity.startActivity(com.google.android.gms.ads.internal.zzt.zzq().zzg(activity));
        zzq();
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbso
    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra(ShareConstants.MEDIA_URI);
            boolean zZzx = com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza);
            HashMap map = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                map.put("offline_notification_action", "offline_notification_clicked");
                c = true == zZzx ? (char) 1 : (char) 2;
                map.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                map.put("olaih", String.valueOf(stringExtra3.startsWith(ProxyConfig.MATCH_HTTP)));
                try {
                    Intent launchIntentForPackage = this.zza.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zza.startActivity(launchIntentForPackage);
                    map.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    map.put("olaa", "olaf");
                }
            } else {
                map.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzp(stringExtra2, "offline_notification_action", map);
            try {
                SQLiteDatabase writableDatabase = this.zzd.getWritableDatabase();
                if (c == 1) {
                    this.zzd.zzg(writableDatabase, this.zzc, stringExtra2);
                } else {
                    zzedo.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e) {
                zzcat.zzg("Failed to get writable offline buffering database: ".concat(e.toString()));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbso
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                zzeeb zzeebVar = (zzeeb) ObjectWrapper.unwrap(iObjectWrapper);
                Activity activityZza = zzeebVar.zza();
                com.google.android.gms.ads.internal.overlay.zzl zzlVarZzb = zzeebVar.zzb();
                HashMap map = new HashMap();
                if (iArr[i] == 0) {
                    map.put("dialog_action", "confirm");
                    zzq();
                    zzs(activityZza, zzlVarZzb);
                } else {
                    map.put("dialog_action", "dismiss");
                    if (zzlVarZzb != null) {
                        zzlVarZzb.zzb();
                    }
                }
                zzp(this.zzf, "asnpdc", map);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbso
    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzeeb zzeebVar = (zzeeb) ObjectWrapper.unwrap(iObjectWrapper);
        final Activity activityZza = zzeebVar.zza();
        final com.google.android.gms.ads.internal.overlay.zzl zzlVarZzb = zzeebVar.zzb();
        this.zzf = zzeebVar.zzc();
        this.zzg = zzeebVar.zzd();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbci.zzik)).booleanValue()) {
            zzr(activityZza, zzlVarZzb);
            return;
        }
        zzp(this.zzf, "dialog_impression", zzfvv.zzd());
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(activityZza);
        builderZzJ.setTitle(zzo(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzo(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzo(R.string.offline_opt_in_confirm, "OK"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedu
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzl(activityZza, zzlVarZzb, dialogInterface, i);
            }
        }).setNegativeButton(zzo(R.string.offline_opt_in_decline, "No thanks"), new DialogInterface.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzedv
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.zza.zzm(zzlVarZzb, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.google.android.gms.internal.ads.zzedw
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.zza.zzn(zzlVarZzb, dialogInterface);
            }
        });
        builderZzJ.create().show();
    }

    @Override // com.google.android.gms.internal.ads.zzbso
    public final void zzh() {
        final zzcay zzcayVar = this.zzc;
        this.zzd.zze(new zzfgu() { // from class: com.google.android.gms.internal.ads.zzedh
            @Override // com.google.android.gms.internal.ads.zzfgu
            public final Object zza(Object obj) throws Exception {
                zzedo.zzb(zzcayVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbso
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        String str3;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        com.google.android.gms.ads.internal.zzt.zzq().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "offline_notification_channel").setContentTitle(zzo(R.string.offline_notification_title, "View the ad you saved when you were offline")).setContentText(zzo(R.string.offline_notification_text, "Tap to open ad")).setAutoCancel(true).setDeleteIntent(zzt(context, "offline_notification_dismissed", str2, str)).setContentIntent(zzt(context, "offline_notification_clicked", str2, str)).setSmallIcon(context.getApplicationInfo().icon);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap map = new HashMap();
        try {
            notificationManager.notify(str2, 54321, smallIcon.build());
            str3 = "offline_notification_impression";
        } catch (IllegalArgumentException e) {
            map.put("notification_not_shown_reason", e.getMessage());
            str3 = "offline_notification_failed";
        }
        zzp(str2, str3, map);
    }

    final /* synthetic */ void zzj(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i) {
        this.zzd.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", map);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    final /* synthetic */ void zzk(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzp(this.zzf, "rtsdc", map);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    final /* synthetic */ void zzl(Activity activity, com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i) {
        HashMap map = new HashMap();
        map.put("dialog_action", "confirm");
        zzp(this.zzf, "dialog_click", map);
        zzr(activity, zzlVar);
    }

    final /* synthetic */ void zzm(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface, int i) {
        this.zzd.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", map);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }

    final /* synthetic */ void zzn(com.google.android.gms.ads.internal.overlay.zzl zzlVar, DialogInterface dialogInterface) {
        this.zzd.zzc(this.zzf);
        HashMap map = new HashMap();
        map.put("dialog_action", "dismiss");
        zzp(this.zzf, "dialog_click", map);
        if (zzlVar != null) {
            zzlVar.zzb();
        }
    }
}
