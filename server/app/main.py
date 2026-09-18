import logging
from contextlib import asynccontextmanager
from fastapi import FastAPI, Request
from fastapi.middleware.cors import CORSMiddleware
from app.database import init_db
from app.routers import manifest, auth, api_rpc

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
    datefmt="%H:%M:%S",
    handlers=[
        logging.StreamHandler(),
        logging.FileHandler("server.log", mode="a")
    ]
)
logger = logging.getLogger("dalcom.main")

@asynccontextmanager
async def lifespan(app: FastAPI):
    logger.info("🚀 Inicializando base de datos y servidor Revival Dalcomsoft...")
    await init_db()
    logger.info("✅ Servidor Revival listo para recibir conexiones del juego!")
    yield
    logger.info("🛑 Deteniendo servidor...")

app = FastAPI(
    title="Dalcomsoft SuperStar Revival Server",
    description="Servidor privado y mock para revitalizar juegos móviles Dalcomsoft / Unity IL2CPP",
    version="1.0.0",
    lifespan=lifespan
)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Middleware de inspección de tráfico
@app.middleware("http")
async def log_requests(request: Request, call_next):
    client_host = request.client.host if request.client else "unknown"
    logger.info(f"📡 [HTTP {request.method}] {request.url.path} de {client_host}")
    response = await call_next(request)
    return response

# Registrar routers
app.include_router(manifest.router)
app.include_router(auth.router)
app.include_router(api_rpc.router)

import os
from fastapi.responses import Response, JSONResponse

STATIC_DIR = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), "static")
DUMMY_PNG = b'\x89PNG\r\n\x1a\n\x00\x00\x00\rIHDR\x00\x00\x00\x01\x00\x00\x00\x01\x08\x06\x00\x00\x00\x1f\x15c4\x00\x00\x00\rIDATx\x9cc`\x00\x00\x00\x02\x00\x01H\xaf\xa4q\x00\x00\x00\x00IEND\xaeB`\x82'

@app.api_route("/static/{path:path}", methods=["GET", "HEAD", "OPTIONS"])
async def serve_static(path: str):
    file_path = os.path.join(STATIC_DIR, path)
    if os.path.isfile(file_path):
        with open(file_path, "rb") as f:
            content = f.read()
        return Response(content=content, media_type="image/png")
    return Response(content=DUMMY_PNG, media_type="image/png")

@app.api_route("/DalcomData/{path:path}", methods=["GET", "POST", "HEAD", "OPTIONS"])
@app.api_route("/superstar-loona/{path:path}", methods=["GET", "POST", "HEAD", "OPTIONS"])
async def serve_mock_cdn(request: Request, path: str = ""):
    logger.info(f"🖼️ [MOCK CDN] Solicitud [{request.method}]: {path}")
    base_name = os.path.basename(path)
    candidate = os.path.join(STATIC_DIR, base_name)
    if os.path.isfile(candidate):
        with open(candidate, "rb") as f:
            return Response(content=f.read(), media_type="image/png")
    if path.endswith(".png") or path.endswith(".jpg") or path.endswith(".bytes"):
        return Response(content=DUMMY_PNG, media_type="image/png")
    if path.endswith(".txt"):
        return Response(content="31204\n", media_type="text/plain")
    return JSONResponse(content={"status": "ok", "code": 1000})

@app.api_route("/", methods=["GET", "POST", "HEAD", "OPTIONS"])
async def root():
    return {
        "status": "online",
        "service": "Dalcomsoft Revival Server",
        "version": "1.0.0",
        "endpoints": {
            "manifest": "/manifest.json",
            "server_info": "/server_info.json",
            "auth": "/enter/{user_id}",
            "api_rpc": "/api"
        }
    }

@app.api_route("/{path:path}", methods=["GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"])
async def catch_all(request: Request, path: str):
    body = await request.body()
    body_str = body.decode("utf-8", errors="ignore")
    logger.info(f"🌐 [FALLBACK CATCH-ALL] Method: {request.method} | Path: /{path} | Body: {body_str[:300]}")
    if path.endswith("download.json"):
        return JSONResponse(content={
            "PackFileCount": 0,
            "PackFileSize": 0,
            "UrlMap": {}
        })
    if path.endswith(".json"):
        return JSONResponse(content={"code": 1000, "status": "ok"})
    if path.endswith(".txt"):
        return Response(content="31204\n", media_type="text/plain")
    if path.endswith(".png") or path.endswith(".jpg") or path.endswith(".bytes"):
        return Response(content=DUMMY_PNG, media_type="image/png")
    return JSONResponse(content={"code": 1000, "result": {}, "invoke": None})
