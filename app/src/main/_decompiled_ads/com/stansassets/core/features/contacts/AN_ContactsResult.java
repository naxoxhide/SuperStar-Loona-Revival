package com.stansassets.core.features.contacts;

import com.stansassets.core.templates.SA_Result;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ContactsResult extends SA_Result {
    public ArrayList<AN_ContactInfo> m_contacts = new ArrayList<>();

    public void AddContact(AN_ContactInfo aN_ContactInfo) {
        this.m_contacts.add(aN_ContactInfo);
    }
}
