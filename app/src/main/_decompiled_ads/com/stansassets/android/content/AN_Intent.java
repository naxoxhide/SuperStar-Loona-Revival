package com.stansassets.android.content;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.stansassets.core.templates.AN_Image;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_ImageWrapper;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Intent {
    private static final int StringType = 0;
    private static final int StringsArrayType = 1;
    private static final int TextureType = 2;
    private static final int TexturesArrayType = 3;
    private static final int UriType = 4;
    private static final int UrisArrayType = 5;
    private String m_Action;
    private AN_IntentChooserInfo m_ChooserInfo;
    private int m_HashCode;
    private boolean m_IsChooser;
    private String m_PackageName;
    private String m_Type;
    private String m_Uri;
    private ArrayList<String> m_Categories = new ArrayList<>();
    private ArrayList<Integer> m_Flags = new ArrayList<>();
    private ArrayList<String> m_ExtraKeys = new ArrayList<>();
    private ArrayList<AN_IntentExtraValue> m_ExtraValues = new ArrayList<>();

    private Intent GetIntentInstance() {
        int i = this.m_HashCode;
        if (i != 0) {
            return (Intent) AN_HashStorage.get(i);
        }
        String str = this.m_Uri;
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent(this.m_Action, Uri.parse(this.m_Uri));
            intent.setAction(this.m_Action);
            return intent;
        }
        return new Intent();
    }

    public Intent toIntent() {
        Intent intentGetIntentInstance = GetIntentInstance();
        String str = this.m_Action;
        if (str != null && !str.isEmpty()) {
            intentGetIntentInstance.setAction(this.m_Action);
            AN_Logger.Log("intent.setAction " + this.m_Action);
        }
        String str2 = this.m_Type;
        if (str2 != null && !str2.isEmpty()) {
            AN_Logger.Log("intent.setType " + this.m_Type);
            intentGetIntentInstance.setType(this.m_Type);
        }
        String str3 = this.m_PackageName;
        if (str3 != null && !str3.isEmpty()) {
            AN_Logger.Log("intent.setPackage " + this.m_PackageName);
            intentGetIntentInstance.setPackage(this.m_PackageName);
        }
        for (String str4 : this.m_Categories) {
            intentGetIntentInstance.addCategory(str4);
            AN_Logger.Log("intent.addCategory " + str4);
        }
        Iterator<Integer> it = this.m_Flags.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            intentGetIntentInstance.addFlags(iIntValue);
            AN_Logger.Log("intent.addFlags " + iIntValue);
        }
        for (int i = 0; i < this.m_ExtraKeys.size(); i++) {
            String str5 = this.m_ExtraKeys.get(i);
            AN_IntentExtraValue aN_IntentExtraValue = this.m_ExtraValues.get(i);
            AN_Logger.Log("extra type: " + aN_IntentExtraValue.m_type);
            int i2 = aN_IntentExtraValue.m_type;
            if (i2 == 0) {
                intentGetIntentInstance.putExtra(str5, aN_IntentExtraValue.m_value);
                AN_Logger.Log("intent.putExtra: " + str5 + " / " + aN_IntentExtraValue.m_value);
            } else if (i2 == 1) {
                intentGetIntentInstance.putExtra(str5, (String[]) aN_IntentExtraValue.m_values.toArray(new String[0]));
                AN_Logger.Log("intent.putExtra: " + str5 + " / " + aN_IntentExtraValue.m_values);
            } else if (i2 == 2) {
                Uri uri = new AN_Image(aN_IntentExtraValue.m_value).getUri();
                intentGetIntentInstance.putExtra(str5, uri);
                AN_Logger.Log("intent.putExtra: " + str5 + " / " + uri);
            } else if (i2 == 3) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                Iterator<String> it2 = aN_IntentExtraValue.m_values.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new AN_Image(it2.next()).getUri());
                }
                intentGetIntentInstance.putParcelableArrayListExtra(str5, arrayList);
                AN_Logger.Log("intent.putParcelableArrayListExtra: " + str5 + " / " + arrayList);
            } else if (i2 == 4) {
                intentGetIntentInstance.putExtra(str5, Uri.parse(aN_IntentExtraValue.m_value));
                AN_Logger.Log("intent.putExtra: " + str5 + " / " + Uri.parse(aN_IntentExtraValue.m_value));
            } else if (i2 == 5) {
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                Iterator<String> it3 = aN_IntentExtraValue.m_values.iterator();
                while (it3.hasNext()) {
                    arrayList2.add(AN_ImageWrapper.GetImageUri(it3.next()));
                }
                intentGetIntentInstance.putParcelableArrayListExtra(str5, arrayList2);
                AN_Logger.Log("intent.putParcelableArrayListExtra: " + str5 + " / " + arrayList2);
            }
        }
        if (!this.m_IsChooser) {
            return intentGetIntentInstance;
        }
        Intent intentCreateChooser = Intent.createChooser(intentGetIntentInstance, this.m_ChooserInfo.m_title);
        AN_Logger.Log("Intent.createChooser");
        if (this.m_ChooserInfo.m_extra_initial_intents != null && this.m_ChooserInfo.m_extra_initial_intents.size() > 0) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<String> it4 = this.m_ChooserInfo.m_extra_initial_intents.iterator();
            while (it4.hasNext()) {
                arrayList3.add(((AN_Intent) AN_UnityBridge.fromJson(it4.next(), AN_Intent.class)).toIntent());
            }
            intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList3.toArray(new Parcelable[0]));
            AN_Logger.Log("chooser EXTRA_INITIAL_INTENTS");
        }
        return intentCreateChooser;
    }
}
