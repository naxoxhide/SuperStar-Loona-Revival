# Instrucciones y Reglas para Agentes (AGENTS.md)

Este repositorio contiene el proyecto de Revival de la serie de videojuegos SuperStar (Dalcomsoft Engine / IL2CPP).

## 📋 Reglas Obligatorias de Operación

1. **Actualización Continua del Contexto (`docs/CONTEXT.md`):**
   * En cada nueva solicitud, tarea, investigación o avance técnico solicitado por el usuario, **se debe actualizar obligatoriamente el archivo `docs/CONTEXT.md`** para incorporar el nuevo contexto, hallazgos, decisiones arquitectónicas, offsets de memoria o lógica analizada.
   * `docs/CONTEXT.md` debe mantenerse como la fuente de verdad técnica acumulativa del proyecto.

2. **Gestión y Registro en Carpeta de Skills (`.agents/skills/`):**
   * Cuando se implementen o identifiquen nuevos flujos de trabajo especializados (como volcado IL2CPP, análisis de encriptación de paquetes, parcheo de Frida o creación de mock servers), se debe registrar o actualizar la skill correspondiente en la carpeta `.agents/skills/<skill_name>/SKILL.md`.

3. **Enfoque de Ingeniería y Calidad:**
   * Rol: **Programador Senior, Game Developer y Reverse Engineer**.
   * Priorizar explicaciones técnicas precisas, verificaciones en binarios y código fuente, evitando asunciones no comprobadas.
   * Documentar siempre las rutas de archivos con enlaces en formato markdown (`file:///...`).

4. **Trato y Mención Personalizada al Usuario:**
   * Al iniciar cada nueva ejecución, respuesta o interacción, el agente debe obligatoriamente saludar y mencionar al usuario por su nombre (**Ignacio**).
