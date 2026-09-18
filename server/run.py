import uvicorn
import os
import sys

# Añadir el directorio server a sys.path
sys.path.insert(0, os.path.dirname(__file__))

if __name__ == "__main__":
    print("=========================================================")
    print("🎮 INICIANDO SERVIDOR REVIVAL SUPERSTAR DALCOMSOFT")
    print("📡 Escuchando en: http://0.0.0.0:8000 (Local / Android Emulator: http://10.0.2.2:8000)")
    print("=========================================================")
    uvicorn.run("app.main:app", host="0.0.0.0", port=8000, reload=True)
