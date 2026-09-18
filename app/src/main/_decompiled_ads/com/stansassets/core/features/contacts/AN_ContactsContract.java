package com.stansassets.core.features.contacts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.facebook.internal.AnalyticsEvents;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_Base64;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ContactsContract {
    public static void RetrieveAsync(final int i, final int i2, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        AsyncTask.execute(new Runnable() { // from class: com.stansassets.core.features.contacts.AN_ContactsContract.1
            @Override // java.lang.Runnable
            public void run() {
                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, AN_ContactsContract.RetrievePrivate(i, i2), true);
            }
        });
    }

    public static final String Retrieve(int i, int i2) {
        return AN_UnityBridge.toJson(RetrievePrivate(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AN_ContactsResult RetrievePrivate(int i, int i2) {
        int i3;
        ContentResolver contentResolver = AN_UnityBridge.currentActivity.getContentResolver();
        Cursor cursorQuery = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, "display_name COLLATE LOCALIZED ASC");
        AN_ContactsResult aN_ContactsResult = new AN_ContactsResult();
        if (cursorQuery.getCount() >= i) {
            cursorQuery.moveToPosition(i - 1);
            int i4 = 0;
            while (cursorQuery.moveToNext() && (i3 = i4 + 1) <= i2) {
                AN_ContactInfo aN_ContactInfo = new AN_ContactInfo();
                aN_ContactInfo.m_id = cursorQuery.getString(cursorQuery.getColumnIndex(APEZProvider.FILEID));
                aN_ContactInfo.m_name = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                Cursor cursorQuery2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ? ", new String[]{aN_ContactInfo.m_id}, null);
                if (cursorQuery2.moveToFirst()) {
                    aN_ContactInfo.m_phone = cursorQuery2.getString(cursorQuery2.getColumnIndex("data1"));
                }
                cursorQuery2.close();
                Cursor cursorQuery3 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id = ?", new String[]{aN_ContactInfo.m_id}, null);
                if (cursorQuery3.moveToNext()) {
                    aN_ContactInfo.m_email = cursorQuery3.getString(cursorQuery3.getColumnIndex("data1"));
                }
                cursorQuery3.close();
                Cursor cursorQuery4 = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, "contact_id = ? AND mimetype = ?", new String[]{aN_ContactInfo.m_id, "vnd.android.cursor.item/note"}, null);
                if (cursorQuery4.moveToFirst()) {
                    aN_ContactInfo.m_note = cursorQuery4.getString(cursorQuery4.getColumnIndex("data1"));
                }
                cursorQuery4.close();
                Cursor cursorQuery5 = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, "contact_id = ? AND mimetype = ?", new String[]{aN_ContactInfo.m_id, "vnd.android.cursor.item/organization"}, null);
                if (cursorQuery5.moveToFirst()) {
                    AN_ContactOrganization aN_ContactOrganization = new AN_ContactOrganization();
                    aN_ContactOrganization.m_name = cursorQuery5.getString(cursorQuery5.getColumnIndex("data1"));
                    aN_ContactOrganization.m_title = cursorQuery5.getString(cursorQuery5.getColumnIndex("data4"));
                    aN_ContactInfo.m_organization = aN_ContactOrganization;
                }
                cursorQuery5.close();
                Cursor cursorQuery6 = contentResolver.query(Uri.withAppendedPath(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(aN_ContactInfo.m_id)), AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO), new String[]{"data15"}, null, null, null);
                if (cursorQuery6.moveToFirst()) {
                    aN_ContactInfo.m_photoData = AN_Base64.encode(cursorQuery6.getBlob(0));
                }
                cursorQuery6.close();
                Cursor cursorQuery7 = contentResolver.query(ContactsContract.Data.CONTENT_URI, null, "contact_id = ? AND mimetype = ?", new String[]{aN_ContactInfo.m_id, "vnd.android.cursor.item/postal-address_v2"}, null);
                if (cursorQuery7.moveToNext()) {
                    AN_ContactPostalAddress aN_ContactPostalAddress = new AN_ContactPostalAddress();
                    aN_ContactPostalAddress.m_poBox = cursorQuery7.getString(cursorQuery7.getColumnIndex("data5"));
                    aN_ContactPostalAddress.m_street = cursorQuery7.getString(cursorQuery7.getColumnIndex("data4"));
                    aN_ContactPostalAddress.m_city = cursorQuery7.getString(cursorQuery7.getColumnIndex("data7"));
                    aN_ContactPostalAddress.m_state = cursorQuery7.getString(cursorQuery7.getColumnIndex("data8"));
                    aN_ContactPostalAddress.m_postalCode = cursorQuery7.getString(cursorQuery7.getColumnIndex("data9"));
                    aN_ContactPostalAddress.m_country = cursorQuery7.getString(cursorQuery7.getColumnIndex("data10"));
                    aN_ContactPostalAddress.m_type = cursorQuery7.getString(cursorQuery7.getColumnIndex("data2"));
                    aN_ContactInfo.m_address = aN_ContactPostalAddress;
                }
                cursorQuery7.close();
                aN_ContactsResult.AddContact(aN_ContactInfo);
                i4 = i3;
            }
        }
        cursorQuery.close();
        return aN_ContactsResult;
    }

    public static final int GetContactsCount() {
        Cursor cursorQuery = AN_UnityBridge.currentActivity.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, "display_name COLLATE LOCALIZED ASC");
        int count = cursorQuery.getCount();
        cursorQuery.close();
        return count;
    }
}
