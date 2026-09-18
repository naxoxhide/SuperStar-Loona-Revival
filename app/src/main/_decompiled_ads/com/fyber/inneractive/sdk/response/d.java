package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.u;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.x;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {
    public g e;
    public a0 f;
    public com.fyber.inneractive.sdk.model.vast.e g;
    public List<com.fyber.inneractive.sdk.model.vast.e> h = new ArrayList();
    public int i;
    public u j;

    @Override // com.fyber.inneractive.sdk.response.b
    public e a() {
        g gVar = new g();
        this.a = gVar;
        this.e = gVar;
        return gVar;
    }

    public void b(String str) throws Exception {
        r rVarA;
        try {
            String strReplaceFirst = str.replaceFirst("<\\?.*\\?>", "");
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setCoalescing(true);
            Document document = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new InputSource(new StringReader(strReplaceFirst)));
            if (document != null) {
                Node firstChild = document.getFirstChild();
                if (!firstChild.getNodeName().equalsIgnoreCase("VAST")) {
                    IAlog.a("XML does not contain a VAST tag as its first child!", new Object[0]);
                    throw new Exception("XML does not contain a VAST tag as its first child!");
                }
                rVarA = r.a(firstChild);
            } else {
                rVarA = null;
            }
            try {
                if (this.j == null) {
                    this.j = new u(rVarA.a);
                } else {
                    u uVar = new u(rVarA.a);
                    if (uVar.compareTo(this.j) >= 0) {
                        this.j = uVar;
                    }
                }
            } catch (u.a unused) {
            }
            List<com.fyber.inneractive.sdk.model.vast.e> list = rVarA.f970b;
            if (list == null || list.size() == 0) {
                IAlog.a("Vast response parser: no ads found in model. aborting", new Object[0]);
                throw new com.fyber.inneractive.sdk.flow.vast.i("ErrorNoMediaFiles", "No ads found in model. Empty Vast?");
            }
            com.fyber.inneractive.sdk.model.vast.e eVar = list.get(0);
            v vVar = eVar.f962b;
            if (vVar == null) {
                if (eVar.c == null) {
                    throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorInvalidFile", "A top level ad with no wrapper on inline found!");
                }
                this.g = eVar;
                return;
            }
            IAlog.a("Vast response parser: found VAST wrapper #%d", Integer.valueOf(this.h.size()));
            int size = this.h.size();
            int i = this.i;
            if (size >= i) {
                IAlog.a("Vast response parser: too many vast wrappers! Only %dallowed. stopping", Integer.valueOf(i));
                throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorTooManyWrappers", "More than " + this.i + " found");
            }
            this.h.add(eVar);
            String str2 = vVar.f;
            if (TextUtils.isEmpty(str2)) {
                IAlog.a("Vast response parser: found an empty tag uri in wrapper! aborting!", new Object[0]);
                throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorInvalidFile", "No ad tag URI for wrapper");
            }
            if (!x.f(str2)) {
                IAlog.a("Vast response parser: Unsecure Wrapper URL. Aborting! url: %s", str2);
                throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorUnsecure", "Unsecure ad tag URI for wrapper");
            }
            String strA = p.a(str2, 3000, 5000, 5);
            if (TextUtils.isEmpty(strA)) {
                throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorInvalidFile", "Failed getting data from ad tag URI");
            }
            this.e.O.put(str2, strA);
            b(strA);
        } catch (Exception e) {
            IAlog.a("Failed parsing Vast file! parsing error = %s", e.getMessage());
            throw new com.fyber.inneractive.sdk.flow.vast.i("VastErrorInvalidFile", e.getMessage());
        }
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public boolean b() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public void a(String str, a0 a0Var) throws Exception {
        this.f = a0Var;
        if (a0Var != null && a0Var.f != null) {
            this.e.J = System.currentTimeMillis();
            this.i = IAConfigManager.M.i.f898b;
            this.e.getClass();
            try {
                b(str);
                a(this.g, this.h);
                return;
            } catch (com.fyber.inneractive.sdk.flow.vast.i e) {
                this.e.i = e.getMessage();
                this.e.j = e.getCause().getMessage();
                return;
            } catch (InterruptedException e2) {
                throw e2;
            } catch (Exception e3) {
                this.e.j = String.format("%s", e3.getMessage());
                g gVar = this.e;
                gVar.i = "VastErrorInvalidFile";
                gVar.x = e3;
                if (IAlog.a == 2) {
                    e3.printStackTrace();
                    return;
                }
                return;
            }
        }
        this.a.i = "ErrorConfigurationMismatch";
    }

    public void a(com.fyber.inneractive.sdk.model.vast.e eVar, List<com.fyber.inneractive.sdk.model.vast.e> list) throws com.fyber.inneractive.sdk.flow.vast.i {
        com.fyber.inneractive.sdk.flow.vast.d dVar = new com.fyber.inneractive.sdk.flow.vast.d();
        int iIntValue = this.f.f.c.intValue();
        int iIntValue2 = this.f.f.f868b.intValue();
        int iIntValue3 = this.f.f.g.intValue();
        dVar.a = iIntValue;
        dVar.f935b = iIntValue2;
        dVar.c = iIntValue3;
        if (UnitDisplayType.VERTICAL.equals(this.f.f.j)) {
            dVar.d = true;
        }
        if (this.f.f.k.contains(2)) {
            dVar.e = true;
        }
        try {
            u uVar = this.j;
            this.e.K = dVar.a(eVar, list, uVar != null ? uVar.f972b : "");
        } catch (com.fyber.inneractive.sdk.flow.vast.i e) {
            g gVar = this.e;
            gVar.getClass();
            gVar.i = e.getMessage();
        }
        g gVar2 = this.e;
        Map<o, com.fyber.inneractive.sdk.flow.vast.g> map = dVar.f;
        gVar2.getClass();
        if (map != null) {
            gVar2.L.putAll(map);
        }
        g gVar3 = this.e;
        List<com.fyber.inneractive.sdk.model.vast.g> list2 = dVar.g;
        gVar3.getClass();
        if (list2 != null) {
            gVar3.M.addAll(list2);
        }
        g gVar4 = this.e;
        List<com.fyber.inneractive.sdk.measurement.f> list3 = dVar.i;
        gVar4.getClass();
        if (list3 != null) {
            gVar4.N.addAll(list3);
        }
        if (IAlog.a == 2) {
            Map<o, com.fyber.inneractive.sdk.flow.vast.g> map2 = dVar.f;
            if (map2.size() > 0) {
                IAlog.d(" VParser: Unsupported media files:", new Object[0]);
                for (o oVar : map2.keySet()) {
                    IAlog.d("VParser: %s", oVar);
                    IAlog.d("VParser: reason = %s", map2.get(oVar));
                }
                return;
            }
            IAlog.d("VParser: Unsupported media files: none", new Object[0]);
        }
    }
}
