package com.stansassets.android.app.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.stansassets.core.utility.AN_BitmapFactory;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_NotificationBuilder {
    private int m_BadgeIcon;
    private int m_BadgeNumber;
    private String m_ChanelId;
    private int m_Defaults;
    private String m_IconBase64;
    private String m_IconName;
    private String m_SoundName;
    private AN_NotificationStyle m_Style;
    private String m_Text;
    private String m_Title;
    private PendingIntent m_contentIntent;

    public Notification build(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, this.m_ChanelId);
        builder.setContentTitle(this.m_Title);
        builder.setContentText(this.m_Text);
        int i = this.m_BadgeNumber;
        if (i != -1) {
            builder.setNumber(i);
        }
        int i2 = this.m_BadgeIcon;
        if (i2 != -1) {
            builder.setBadgeIconType(i2);
        }
        try {
            Resources resources = context.getResources();
            int identifier = resources != null ? resources.getIdentifier(this.m_IconName, "drawable", context.getPackageName()) : 0;
            if (identifier == 0) {
                identifier = context.getApplicationInfo().icon;
                AN_Logger.Log("AN_NotificationBuilder: Using default app icon. Wasn't able to locate icon resource Identifier. Icon Name: " + this.m_IconName);
            }
            builder.setSmallIcon(identifier);
        } catch (Exception e) {
            AN_Logger.LogError("AN_NotificationBuilder: Failed to define notification icon Id + " + e.getMessage());
            e.printStackTrace();
        }
        try {
            builder.setLargeIcon(AN_BitmapFactory.Decode(this.m_IconBase64));
            try {
                Uri soundUri = getSoundUri(context, this.m_SoundName);
                if (soundUri != null) {
                    builder.setSound(soundUri);
                }
                try {
                    builder.setDefaults(this.m_Defaults);
                    int i3 = this.m_Style.m_type;
                    if (i3 == 1) {
                        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                        Bitmap bitmapDecode = AN_BitmapFactory.Decode(this.m_Style.m_picture);
                        Bitmap bitmapDecode2 = AN_BitmapFactory.Decode(this.m_Style.m_largeIcon);
                        bigPictureStyle.bigPicture(bitmapDecode);
                        bigPictureStyle.bigLargeIcon(bitmapDecode2);
                        builder.setStyle(bigPictureStyle);
                    } else if (i3 == 2) {
                        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                        bigTextStyle.bigText(this.m_Style.m_bigText);
                        builder.setStyle(bigTextStyle);
                    }
                    PendingIntent pendingIntent = this.m_contentIntent;
                    if (pendingIntent != null) {
                        builder.setContentIntent(pendingIntent);
                    }
                    return builder.build();
                } catch (Exception e2) {
                    AN_Logger.LogError("AN_NotificationBuilder: Failed to apply notification style + " + e2.getMessage());
                    return null;
                }
            } catch (Exception e3) {
                AN_Logger.LogError("AN_NotificationBuilder: Failed to define notification sound + " + e3.getLocalizedMessage());
                return null;
            }
        } catch (Exception e4) {
            AN_Logger.LogError("AN_NotificationBuilder: Failed to decode LargeIcon + " + e4.getMessage());
            return null;
        }
    }

    public void setContentIntent(PendingIntent pendingIntent) {
        this.m_contentIntent = pendingIntent;
    }

    public static int Build(String str) {
        Notification notificationBuild = ((AN_NotificationBuilder) AN_UnityBridge.fromJson(str, AN_NotificationBuilder.class)).build(AN_UnityBridge.currentActivity);
        AN_HashStorage.add(notificationBuild);
        return notificationBuild.hashCode();
    }

    public static Uri getSoundUri(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "raw", context.getPackageName());
        if (identifier != 0) {
            return Uri.parse("android.resource://" + context.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + identifier);
        }
        return null;
    }
}
