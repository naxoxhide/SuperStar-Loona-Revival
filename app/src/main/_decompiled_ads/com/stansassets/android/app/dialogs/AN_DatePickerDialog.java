package com.stansassets.android.app.dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.widget.DatePicker;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AN_DatePickerDialog {
    private static boolean picked = false;

    public class AN_DatePickerInfo {
        public List<AN_AlertDialog.AN_ButtonInfo> m_buttons;
        public int m_day;
        public int m_month;
        public int m_year;

        public AN_DatePickerInfo() {
        }
    }

    public static void Show(String str, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        picked = false;
        AN_DatePickerInfo aN_DatePickerInfo = (AN_DatePickerInfo) AN_UnityBridge.fromJson(str, AN_DatePickerInfo.class);
        DatePickerDialog datePickerDialog = new DatePickerDialog(AN_UnityBridge.currentActivity, new DatePickerDialog.OnDateSetListener() { // from class: com.stansassets.android.app.dialogs.AN_DatePickerDialog.1
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                boolean unused = AN_DatePickerDialog.picked = true;
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_DatePickerResult(i, i2, i3));
            }
        }, aN_DatePickerInfo.m_year, aN_DatePickerInfo.m_month, aN_DatePickerInfo.m_day);
        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stansassets.android.app.dialogs.AN_DatePickerDialog.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (AN_DatePickerDialog.picked) {
                    return;
                }
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_DatePickerResult(1, "User canceled"));
            }
        });
        datePickerDialog.show();
    }
}
