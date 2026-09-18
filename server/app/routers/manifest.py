from fastapi import APIRouter, Request
from fastapi.responses import JSONResponse, Response, PlainTextResponse

router = APIRouter(tags=["Manifest & Config"])

@router.api_route("/superstar-loona/version/{path:path}", methods=["GET", "POST", "HEAD", "OPTIONS"])
@router.api_route("/superstar-loona/{path:path}", methods=["GET", "POST", "HEAD", "OPTIONS"])
@router.api_route("/version/{path:path}", methods=["GET", "POST", "HEAD", "OPTIONS"])
@router.api_route("/manifest.json", methods=["GET", "POST", "HEAD", "OPTIONS"])
@router.api_route("/server/manifest.json", methods=["GET", "POST", "HEAD", "OPTIONS"])
async def get_manifest(request: Request, path: str = ""):
    """
    Entrega la configuración inicial y URLs del servidor para NetworkControl.ManifestJsonInfo
    """
    host = request.headers.get("host", "10.0.2.2:8000")
    base_url = f"http://{host}"

    manifest_data = {
        "ActiveVersion_Android": "3.12.4",
        "ActiveVersion_IOS": "3.12.4",
        "ServerUrl": "http://10.0.2.2:8000/server_info.json",
        "TermsVersion": "1",
        "MusicRankServerUrl": "http://10.0.2.2:8000/rank",
        "Cryption": "0",  # Desactiva encriptación obligatoria en el cliente
        "OfferwallSuffix": "",
        "MaintenanceUrl": "",  # Vacío indica servidor ONLINE sin mantenimiento
        "Liapp": "0",  # Desactiva verificación de anti-cheat LIAPP
        "ProbabilityUrl": "http://10.0.2.2:8000/prob",
        "DateOfBirth": "0",
        "TesterIp": [],
        "TitleBackgroundUrl": f"{base_url}/static/title_bg_{{0}}.png",
        "TitleBackgroundCount": "8",
        "TitleBackgroundVideoUrl": "",
        "DalcomAccountDev": "0",
        "AssetLoadingVersion": "23"
    }
    return JSONResponse(content=manifest_data)

from app.routers import api_rpc

@router.api_route("/server_info.json", methods=["GET", "POST", "HEAD", "OPTIONS"])
async def get_server_info(request: Request):
    """
    Entrega el endpoint de la API principal en GET, o despacha RPC directamente si es POST.
    """
    if request.method == "POST":
        return await api_rpc.handle_rpc_api(request)
    return JSONResponse(content={
        "api": "http://10.0.2.2:8000/api",
        "notice": "",
        "sn": 1
    })
