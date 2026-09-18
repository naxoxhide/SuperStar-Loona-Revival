package com.stansassets.android.app.dialogs;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AN_WheelPickerDialog {
    private static String m_chosenValue;

    public class AN_WheelPickerInfo {
        public int m_Default;
        public List<String> m_Values;

        public AN_WheelPickerInfo() {
        }
    }

    public static void Show(String str, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        final AN_WheelPickerInfo aN_WheelPickerInfo = (AN_WheelPickerInfo) AN_UnityBridge.fromJson(str, AN_WheelPickerInfo.class);
        NumberPicker numberPicker = new NumberPicker(AN_UnityBridge.currentActivity);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(aN_WheelPickerInfo.m_Values.size() - 1);
        numberPicker.setDisplayedValues((String[]) aN_WheelPickerInfo.m_Values.toArray(new String[aN_WheelPickerInfo.m_Values.size()]));
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setValue(aN_WheelPickerInfo.m_Default);
        m_chosenValue = aN_WheelPickerInfo.m_Values.get(numberPicker.getValue());
        setDividerColor(numberPicker, -3355444);
        numberPicker.setDescendantFocusability(393216);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: com.stansassets.android.app.dialogs.AN_WheelPickerDialog.1
            @Override // android.widget.NumberPicker.OnValueChangeListener
            public void onValueChange(NumberPicker numberPicker2, int i, int i2) {
                String unused = AN_WheelPickerDialog.m_chosenValue = aN_WheelPickerInfo.m_Values.get(numberPicker2.getValue());
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_WheelPickerResult(AN_WheelPickerDialog.m_chosenValue, AN_WheelPickerState.InProgress));
            }
        });
        FrameLayout frameLayout = new FrameLayout(AN_UnityBridge.currentActivity);
        frameLayout.addView(numberPicker, new FrameLayout.LayoutParams(-1, -2, 17));
        new AlertDialog.Builder(AN_UnityBridge.currentActivity).setView(frameLayout).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.stansassets.android.app.dialogs.AN_WheelPickerDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_WheelPickerResult(AN_WheelPickerDialog.m_chosenValue, AN_WheelPickerState.Done));
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.stansassets.android.app.dialogs.AN_WheelPickerDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_WheelPickerResult(AN_WheelPickerDialog.m_chosenValue, AN_WheelPickerState.Canceled));
            }
        }).show();
    }

    private static void setDividerColor(NumberPicker numberPicker, int i) {
        for (Field field : NumberPicker.class.getDeclaredFields()) {
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, new ColorDrawable(i));
                    return;
                } catch (Resources.NotFoundException e) {
                    AN_Logger.LogError("Error at AN_WheelPickerDialog get NumberPicker Divider" + e.getMessage());
                    return;
                } catch (IllegalAccessException e2) {
                    AN_Logger.LogError("Error at AN_WheelPickerDialog get NumberPicker Divider" + e2.getMessage());
                    return;
                } catch (IllegalArgumentException e3) {
                    AN_Logger.LogError("Error at AN_WheelPickerDialog get NumberPicker Divider" + e3.getMessage());
                    return;
                }
            }
        }
    }
}
