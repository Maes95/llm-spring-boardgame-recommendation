# 🎲 LLM Spring Boardgame Recommendation

Aplicación de recomendación de juegos de mesa inteligente utilizando **Spring Boot**, **Spring AI** y **OpenRouter** para proporcionar recomendaciones personalizadas basadas en las preferencias del usuario.

## 📋 Descripción

Esta aplicación utiliza un modelo de lenguaje (LLM) a través de OpenRouter para analizar las preferencias del usuario y recomendar el juego de mesa más adecuado de una base de datos precargada con 10 juegos populares.

### Características principales:

- 🤖 **Integración con LLM** mediante Spring AI y OpenRouter
- 💾 **Base de datos H2** en memoria con 10 juegos de mesa precargados
- 🎯 **Recomendaciones personalizadas** basadas en texto libre del usuario
- 🔄 **API REST** para fácil integración

### Juegos de mesa incluidos:

1. **Catan** - Estrategia
2. **Pandemic** - Cooperativo
3. **Ticket to Ride** - Familiar
4. **Carcassonne** - Estrategia
5. **Codenames** - Fiesta
6. **Azul** - Abstracto
7. **Wingspan** - Estrategia
8. **Splendor** - Estrategia
9. **Dixit** - Fiesta
10. **Terraforming Mars** - Estrategia

## 🚀 Requisitos previos

- **Java 21** o superior
- **Maven 3.6+**
- **Clave API de OpenRouter** (obtener en [openrouter.ai](https://openrouter.ai))

## ⚙️ Configuración

### 1. Configurar la API Key

Debes configurar tu clave API de OpenRouter como variable de entorno antes de lanzar la aplicación:

**En Linux/Mac:**
```bash
export OPENROUTER_API_KEY=tu_clave_api_aqui
```

**En Windows (CMD):**
```cmd
set OPENROUTER_API_KEY=tu_clave_api_aqui
```

**En Windows (PowerShell):**
```powershell
$env:OPENROUTER_API_KEY="tu_clave_api_aqui"
```

### 2. Compilar el proyecto

```bash
mvn clean package
```

## 🏃 Cómo lanzar la aplicación

### Opción 1: Con Maven
```bash
mvn spring-boot:run
```

### Opción 2: Con el JAR compilado
```bash
java -jar target/boardgame-recommendator-0.0.1-SNAPSHOT.jar
```

La aplicación se iniciará en `http://localhost:8080`

## 🧪 Cómo probar la aplicación

### Usando cURL desde Bash

**Ejemplo 1: Juego para familia**
```bash
curl -X POST http://localhost:8080/api/boardgames/recommend \
  -H "Content-Type: application/json" \
  -d '{
    "user_input": "Busco un juego para jugar con mi familia, que sea fácil de aprender y divertido"
  }'
```

**Ejemplo 2: Juego estratégico**
```bash
curl -X POST http://localhost:8080/api/boardgames/recommend \
  -H "Content-Type: application/json" \
  -d '{
    "user_input": "Quiero un juego de estrategia complejo para jugadores experimentados"
  }'
```

**Ejemplo 3: Juego para fiesta**
```bash
curl -X POST http://localhost:8080/api/boardgames/recommend \
  -H "Content-Type: application/json" \
  -d '{
    "user_input": "Necesito algo divertido para una noche de juegos con amigos, que genere risas"
  }'
```

**Ejemplo 4: Juego cooperativo**
```bash
curl -X POST http://localhost:8080/api/boardgames/recommend \
  -H "Content-Type: application/json" \
  -d '{
    "user_input": "Prefiero juegos donde todos trabajemos juntos en vez de competir"
  }'
```

### Respuesta esperada

```json
{
  "user_input": "Busco un juego para jugar con mi familia, que sea fácil de aprender y divertido",
  "recommendation": "¡Te recomiendo Ticket to Ride! Es perfecto para jugar en familia porque tiene reglas sencillas de entender pero ofrece decisiones interesantes en cada turno. Los jugadores recolectan cartas de trenes para reclamar rutas ferroviarias que conectan ciudades en un mapa, lo que resulta muy visual y entretenido. Con un precio de 49.99€, es una inversión excelente para horas de diversión familiar. Además, la combinación de estrategia ligera y emoción lo hace ideal tanto para adultos como para niños mayores de 8 años. ¡Prepárate para viajar por todo el país construyendo tu imperio ferroviario!"
}
```

## 📚 Estructura del proyecto

```
src/
├── main/
│   ├── java/dev/maes/boardgame_recommendator/
│   │   ├── BoardgameRecommendatorApplication.java  # Clase principal
│   │   ├── BoardGame.java                          # Modelo de datos
│   │   ├── BoardGameRepository.java                # Repositorio JPA
│   │   ├── DatabaseInitializer.java                # Inicialización de datos
│   │   └── DemoApp.java                            # Controlador REST
│   └── resources/
│       └── application.properties                   # Configuración de Spring
```

## 🔧 Tecnologías utilizadas

- **Spring Boot 3.5.7** - Framework principal
- **Spring AI 1.0.3** - Integración con modelos de IA
- **Spring Data JPA** - Persistencia de datos
- **H2 Database** - Base de datos en memoria
- **OpenRouter API** - Acceso a modelos de lenguaje
- **Maven** - Gestión de dependencias

## 🎯 Endpoint API

### POST `/api/boardgames/recommend`

Recomienda un juego de mesa basado en las preferencias del usuario.

**Request Body:**
```json
{
  "user_input": "descripción de preferencias del usuario"
}
```

**Response:**
```json
{
  "user_input": "texto original del usuario",
  "recommendation": "recomendación generada por el LLM"
}
```

## 📝 Notas

- La base de datos H2 se reinicia cada vez que se lanza la aplicación
- Los 10 juegos de mesa se cargan automáticamente al inicio
- El modelo LLM utilizado es configurable en `application.properties`
- La aplicación requiere conexión a internet para comunicarse con OpenRouter