import json
import logging
from typing import Any, Dict, List, Optional
from fastapi import APIRouter, Request
from fastapi.responses import JSONResponse

logger = logging.getLogger("dalcom.rpc")
router = APIRouter(tags=["RPC API Router"])

@router.api_route("/api", methods=["GET", "POST", "PUT", "OPTIONS", "HEAD"])
@router.api_route("/api/{path:path}", methods=["GET", "POST", "PUT", "OPTIONS", "HEAD"])
async def handle_rpc_api(request: Request, path: str = ""):
    """
    Router principal RPC para com.dalcomsoft.project.client.Client
    Recibe peticiones con la firma: { clazz, method, paramz, clazzVersion, ... }
    """
    raw_body = await request.body()
    body_str = raw_body.decode("utf-8", errors="ignore")
    
    clazz = "Unknown"
    method = "Unknown"
    paramz = []
    
    try:
        data = json.loads(body_str)
        clazz = data.get("clazz", "Unknown")
        method = data.get("method", "Unknown")
        paramz = data.get("paramz", [])
        logger.info(f"📥 [RPC CALL] Clazz: \033[92m{clazz}\033[0m | Method: \033[94m{method}\033[0m | Paramz: {paramz}")
    except Exception:
        logger.warning(f"📥 [RAW PAYLOAD]: {body_str}")
        data = {}

    # Despachador de RPCs conocidos
    result = dispatch_rpc(clazz, method, paramz, data)

    response_payload = {
        "code": 1000,
        "result": result,
        "invoke": None
    }
    
    logger.info(f"📤 [RPC RESPONSE] {clazz}.{method} -> Code: 1000")
    return JSONResponse(content=response_payload)


def dispatch_rpc(clazz: str, method: str, paramz: List[Any], full_data: Dict[str, Any]) -> Any:
    """
    Maneja la lógica de respuesta para cada servicio RPC del cliente
    """
    # 1. Módulo de Usuario y Autenticación
    if clazz in ["User", "Account", "Login"]:
        if method == "createAuthentication":
            return {
                "userObjectID": 100001,
                "provider": 0,
                "userID": "guest_orbit",
                "localPassword": "password123"
            }
        elif method == "createAccount":
            return {
                "userObjectID": 100001,
                "nickname": "Orbit"
            }
        elif method in ["login", "getUserInfo", "getAccount"]:
            return {
                "objectID": 100001,
                "userObjectID": 100001,
                "nickname": "DalcomStar",
                "specialUserCode": 0,
                "userType": 1,
                "profileCode": 10001,
                "channel": 1,
                "language": 1,
                "tutorialStep": 10,
                "cardInvenExpandCount": 0,
                "maxCardInvenCount": 200,
                "diamond": 510,
                "freeDiamond": 510,
                "rhythmPoint": 5006774,
                "freeRhythmPoint": 5006774,
                "headphone": 28,
                "freeHeadphone": 28,
                "nicknameChanger": 0,
                "lastHeadphoneCharge": 1788400000000,
                "dalcomCoin": 5000,
                "freeDalcomCoin": 5000,
                "themeChanger": 0,
                "equipedLobbyBgList": [1001],
                "lastLogin": 1788400000000,
                "artistPack": 1
            }
        elif method == "getProfile":
            return {"objectID": 100001, "userObjectID": 100001, "nickname": "DalcomStar", "profileCode": 10001}

    # 2. Módulo de Lobby y Fondos
    elif clazz in ["Lobby", "MyLobby", "LobbyBg"]:
        if method in ["getMyLobby", "showLobby", "getMyLobbyBgList"]:
            return [
                {"bgCode": 1001, "isEquipped": True},
                {"bgCode": 1002, "isEquipped": False},
                {"bgCode": 1003, "isEquipped": False}
            ]

    # 3. Módulo de Inventario de Cartas
    elif clazz in ["Card", "Inventory"]:
        if method in ["getInventory", "getMyCardList", "getCardList"]:
            return [
                {
                    "cardCode": 1001,
                    "grade": 5, # R Grade
                    "level": 99,
                    "maxLevel": 99,
                    "isEquipped": True,
                    "isLock": False
                }
            ]
        elif method == "getCollection":
            return {"total": 1462, "current": 1462}

    # 3.1 Módulo de CardBook
    elif clazz == "CardBook":
        if method in ["getList", "getCardBookList", "cardBookGetList"]:
            cards = []
            for cid in range(1001, 1013):
                cards.append({
                    "cardID": cid,
                    "grade": 5,  # R Grade
                    "createdAt": 1788400000000
                })
            return {
                "cardList": cards,
                "themePointList": [
                    {
                        "groupID": 1001,
                        "themeID": 1001,
                        "themePoint": 1000
                    }
                ],
                "cardRewardCode": 0,
                "themeRewardCode": 0,
                "totalBuff": 100
            }
        elif method in ["getFavoriteGroup", "getMyFavoriteGroupList"]:
            return [1001]
        elif method == "setFavoriteGroup":
            return True
        elif method == "regist":
            return [
                {
                    "groupID": 1001,
                    "themeID": 1001,
                    "themePoint": 1000
                }
            ]
        elif method == "getReward":
            return []

    # 4. Módulo de Música y Récords
    elif clazz in ["Music", "MusicContent", "MusicBattle"]:
        if method in ["getMusicList", "getMusicContent"]:
            return []
        elif method in ["getMyRecord", "getRecord"]:
            return {
                "highScore": 9999999,
                "allSuperPerfect": True,
                "fullCombo": True,
                "clearCount": 10
            }

    # 5. Módulo de Asistencia y Eventos
    elif clazz in ["Attendance", "Event"]:
        if method in ["check", "getAttendance", "getEventList"]:
            return {"isReceived": True, "rewardType": 1, "rewardCount": 100}

    # 6. Módulo de Avisos y Notificaciones
    elif clazz in ["Notice", "News"]:
        return []

    # 7. Módulo de Platform (Region, Time, CheckAssetBundle)
    elif clazz in ["Platform"]:
        if method == "getTimestamp":
            import time
            return int(time.time() * 1000)
        elif method == "getClientIP":
            return "127.0.0.1"
        elif method == "getRegion":
            return {
                "region": "KR",
                "isStreaming": False,
                "isEU": False,
                "isEu": False,
                "isGDPR": False,
                "isGdpr": False,
                "code": "KR",
                "country": "KR"
            }
        elif method == "checkAssetBundle":
            return {
                "version": 23,
                "context": {}
            }

    # 8. Módulo de Tutorial y Juego
    elif clazz in ["Tutorial", "Game", "TutorialControl", "TutorialAssist"]:
        if method in ["tutorialStepComplete", "stepComplete", "setStepComplete", "getTutorial"]:
            return []
        elif method in ["stageStart", "rehearsalStageStart", "arenaLeagueStart"]:
            return {
                "simpleNotices": [],
                "userStageCode": 1,
                "freePlayCount": 10,
                "gameToken": 99999999
            }
        elif method in ["stageComplete", "rehearsalStageComplete", "arenaStageComplete", "superstarLeagueComplete"]:
            return {
                "highScore": 9999999,
                "highScoreRecord": True,
                "rewardRhythmPoint": 5000,
                "exp": 100,
                "dropCards": []
            }

    # Fallback por defecto: Objeto vacío para llamadas no críticas
    return {}
