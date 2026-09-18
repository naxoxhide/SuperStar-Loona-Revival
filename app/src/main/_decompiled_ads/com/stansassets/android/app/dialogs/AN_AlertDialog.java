package com.stansassets.android.app.dialogs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AN_AlertDialog {
    private static final int NEGATIVE = 2;
    private static final int NEUTRAL = 0;
    private static final int POSITIVE = 1;
    private static HashMap<String, AlertDialog> m_dialogs = new HashMap<>();

    public class AN_ProgressDialogHolder {
        public AlertDialog Dialog;
        public AN_CallbackJsonHandler callback;

        public AN_ProgressDialogHolder() {
        }
    }

    public class AN_ButtonInfo {
        public String m_id;
        public String m_text;
        public int m_type;

        public AN_ButtonInfo() {
        }
    }

    public class AN_AlertDialogInfo {
        public List<AN_ButtonInfo> m_buttons;
        public boolean m_cancelable;
        public String m_id;
        public String m_message;
        public int m_themeId;
        public String m_title;

        public AN_AlertDialogInfo() {
        }
    }

    public static void Show(String str, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AN_AlertDialogInfo aN_AlertDialogInfo = (AN_AlertDialogInfo) AN_UnityBridge.fromJson(str, AN_AlertDialogInfo.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(AN_UnityBridge.currentActivity, AN_ProgressDialog.GetPlatformDependentTheme(aN_AlertDialogInfo.m_themeId)));
        builder.setTitle(aN_AlertDialogInfo.m_title);
        builder.setMessage(aN_AlertDialogInfo.m_message);
        builder.setCancelable(aN_AlertDialogInfo.m_cancelable);
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.stansassets.android.app.dialogs.AN_AlertDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        for (final AN_ButtonInfo aN_ButtonInfo : aN_AlertDialogInfo.m_buttons) {
            int i = aN_ButtonInfo.m_type;
            if (i == 0) {
                builder.setNeutralButton(aN_ButtonInfo.m_text, new DialogInterface.OnClickListener() { // from class: com.stansassets.android.app.dialogs.AN_AlertDialog.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        AN_AlertDialogCloseInfo aN_AlertDialogCloseInfo = new AN_AlertDialogCloseInfo();
                        aN_AlertDialogCloseInfo.m_buttonid = aN_ButtonInfo.m_id;
                        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_AlertDialogCloseInfo);
                    }
                });
            } else if (i == 1) {
                builder.setPositiveButton(aN_ButtonInfo.m_text, new DialogInterface.OnClickListener() { // from class: com.stansassets.android.app.dialogs.AN_AlertDialog.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        AN_AlertDialogCloseInfo aN_AlertDialogCloseInfo = new AN_AlertDialogCloseInfo();
                        aN_AlertDialogCloseInfo.m_buttonid = aN_ButtonInfo.m_id;
                        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_AlertDialogCloseInfo);
                    }
                });
            } else if (i == 2) {
                builder.setNegativeButton(aN_ButtonInfo.m_text, new DialogInterface.OnClickListener() { // from class: com.stansassets.android.app.dialogs.AN_AlertDialog.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        AN_AlertDialogCloseInfo aN_AlertDialogCloseInfo = new AN_AlertDialogCloseInfo();
                        aN_AlertDialogCloseInfo.m_buttonid = aN_ButtonInfo.m_id;
                        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_AlertDialogCloseInfo);
                    }
                });
            }
        }
        m_dialogs.put(aN_AlertDialogInfo.m_id, builder.show());
    }

    public static void Hide(String str) {
        AN_AlertDialogInfo aN_AlertDialogInfo = (AN_AlertDialogInfo) AN_UnityBridge.fromJson(str, AN_AlertDialogInfo.class);
        if (m_dialogs.containsKey(aN_AlertDialogInfo.m_id)) {
            m_dialogs.get(aN_AlertDialogInfo.m_id).hide();
        } else {
            AN_Logger.LogWarning("Alert Dialog with id: " + aN_AlertDialogInfo.m_id + " is not on screen, Hide request is ignored");
        }
    }
}
