---
name: dalcomsoft-network-bypass
description: Guía y procedimientos para interceptar, redirigir el tráfico de red de BestHTTP/Unity e implementar bypass de SSL pinning y mock servers para juegos de Dalcomsoft.
---

# Skill: Dalcomsoft Network Interception & Server Redirection

Esta skill documenta la arquitectura de red del cliente Dalcomsoft (basado en **BestHTTP**) y las técnicas para redirigir peticiones a un servidor privado o mock local.

## 1. Arquitectura de Red (BestHTTP en Unity/IL2CPP)

El cliente utiliza la librería **BestHTTP** (`BestHTTP.dll` compilado en `libil2cpp.so`) para todas las comunicaciones REST y WebSocket.

### Clases y Métodos Clave Identificados en `dump.cs`:
* **Controlador de Arranque y Estado del Servidor:**
  * `com.dalcomsoft.project.app.control.NetworkControl`
  * `NetworkControl.CheckServerUrl` (`RVA: 0x244C408`)
  * `NetworkControl.get_IsOpened` (`RVA: 0x244B010`) -> Forzar retorno `1` (true)
  * `NetworkControl.get_IsMaintenanceChecked` (`RVA: 0x244B0E0`) -> Forzar retorno `1` (true)
  * `NetworkControl.get_ServerState` (`RVA: 0x244C148`) -> Forzar retorno `0` (Normal)
* **Cliente RPC y Peticiones API:**
  * `com.dalcomsoft.project.client.Client`
  * `Client.request` (`RVA: 0xCBD03C`)
  * `Client.requestFake` (`RVA: 0xCBD700`)
  * `Client.isEncrypted` (`Field Offset: 0x10`) -> Si es `false`, permite JSON en texto plano.
  * `Client.endpoint` (`Field Offset: 0x8`) -> URL del endpoint de API.
* **Capa Criptográfica:**
  * `com.dalcomsoft.project.client.CipherSimple` (Rijndael / AES)
  * `CipherSimple.encrypt` (`RVA: 0xCBB1F4`)
  * `CipherSimple.decrypt` (`RVA: 0xCBACC0`)


---

## 2. Métodos de Redirección (Bypass a Servidor Externo)

### A. Redirección en Memoria con Frida Gadget (`libscript.so`)
Interceptar el constructor de `BestHTTP.HTTPRequest` o el método que despacha URLs:
```javascript
// Ejemplo conceptual de intercepción de URI en BestHTTP:
var HTTPRequest_ctor = il2cpp.add(ptr(OFFSET_HTTPREQUEST_CTOR));
Interceptor.attach(HTTPRequest_ctor, {
    onEnter: function (args) {
        // args[1] = System.Uri pointer o String URL
        var originalUrl = readIl2CppString(args[1]);
        if (originalUrl.includes("dalcomsoft.net") || originalUrl.includes("dalcomsoft.com")) {
            var newUrl = originalUrl.replace(/https:\/\/[^\/]+/, "http://10.0.2.2:8080");
            args[1] = createIl2CppString(newUrl);
            console.log("[*] Redirected URL: " + originalUrl + " -> " + newUrl);
        }
    }
});
```

### B. Bypass de SSL Pinning & Validación de Certificados
Para permitir tráfico `https://` con certificados autofirmados o herramientas como mitmproxy:
* Hookear el delegado `CustomCertificationValidator` en `HTTPRequest` o la función nativa de validación TLS (`libunity.so` / `UnityEngine.TLSModule.dll`) para retornar siempre `1` (true).

### C. Habilitar Tráfico Cleartext (HTTP) en Android
Modificar `AndroidManifest.xml` dentro de `<application>`:
```xml
<application
    android:usesCleartextTraffic="true"
    android:networkSecurityConfig="@xml/network_security_config" ...>
```

---

## 3. Protocolo de Respuesta Estándar de Dalcomsoft (JSON)

Las respuestas del backend esperan la estructura:
```json
{
  "code": 1000,
  "result": {},
  "invoke": null,
  "message": ""
}
```
* `code: 1000` = Éxito / Operación completada.
* `code: != 1000` = Error o pantalla de mantenimiento.
