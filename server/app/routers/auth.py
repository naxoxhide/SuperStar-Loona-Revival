from fastapi import APIRouter, Request
from fastapi.responses import JSONResponse
import logging

logger = logging.getLogger("dalcom.auth")
router = APIRouter(tags=["Auth & Sequential Login"])

@router.post("/enter/{user_id}")
async def sequential_login_enter(user_id: str, request: Request):
    """
    Maneja el handshake de login inicial (ProjectInfo.LoginControlInfo.SEQUENTIAL_LOGIN_ENTER)
    """
    logger.info(f"🔑 [AUTH] Sequential Login ENTER recibido para User UID: {user_id}")
    return JSONResponse(content={
        "code": 1000,
        "result": {
            "sessionID": 1001,
            "accessToken": "revival_access_token_sslo_2026",
            "accessTokenNext": "revival_access_token_sslo_2026_next",
            "isNewMessage": False,
            "isComebackAttendance": False,
            "starNoteCount": 10,
            "diamondPaid": 1000,
            "diamondFree": 5000,
            "selectCardCode": 1001
        },
        "invoke": None
    })

@router.post("/leave/{user_id}")
async def sequential_login_leave(user_id: str):
    logger.info(f"🚪 [AUTH] Sequential Login LEAVE para User UID: {user_id}")
    return JSONResponse(content={"code": 1000, "result": True, "invoke": None})

@router.post("/kangdaniel")
@router.post("/insert-liapp-user/kangdaniel")
async def liapp_mock():
    """
    Mock para las verificaciones de integridad LIAPP (ProjectInfo.LIAPPAgentInfo)
    """
    return JSONResponse(content={"code": 1000, "result": "OK", "invoke": None})
