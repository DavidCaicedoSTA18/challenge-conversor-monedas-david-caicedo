💱 Conversor de Monedas - Java
📋 Descripción
Aplicación de consola desarrollada en Java que permite realizar conversiones entre diferentes monedas latinoamericanas y el dólar estadounidense. El proyecto consume la API de ExchangeRate para obtener tasas de cambio actualizadas en tiempo real.
✨ Características

🔄 Conversión en tiempo real entre 6 monedas diferentes
🌐 Consumo de API REST para obtener tasas actualizadas
💻 Interfaz de consola intuitiva y fácil de usar
🏗️ Arquitectura orientada a objetos
⚡ Manejo eficiente de solicitudes HTTP
🛡️ Manejo robusto de errores y excepciones

🚀 Tecnologías Utilizadas

Java 11 o superior
Maven - Gestión de dependencias
Gson 2.10.1 - Parseo de JSON
HttpClient - Solicitudes HTTP nativas de Java
ExchangeRate API - Servicio de tasas de cambio

📦 Estructura del Proyecto
conversor-monedas/
│
├── src/
│   └── main/
│       └── java/
│           ├── Principal.java           # Clase principal con método main
│           ├── MenuConversor.java       # Interfaz de usuario y menú
│           ├── ConversorMoneda.java     # Lógica de conversión
│           ├── ClienteAPI.java          # Cliente HTTP para la API
│           ├── RespuestaAPI.java        # Modelo para respuesta JSON
│           └── Moneda.java              # Modelo de moneda
│
├── pom.xml                              # Configuración Maven
└── README.md                            # Este archivo
🛠️ Instalación y Configuración
Prerrequisitos

Java JDK 11 o superior instalado
Maven 3.6 o superior (opcional, pero recomendado)
Conexión a Internet para consumir la API

Pasos de Instalación

Clonar o descargar el proyecto
bashgit clone https://github.com/tu-usuario/conversor-monedas.git
cd conversor-monedas

Compilar el proyecto con Maven
bashmvn clean compile

Ejecutar la aplicación
bashmvn exec:java -Dexec.mainClass="Principal"


Alternativa: Crear JAR ejecutable

Generar el JAR con todas las dependencias
bashmvn clean package

Ejecutar el JAR
bashjava -jar target/conversor-monedas-1.0-SNAPSHOT-jar-with-dependencies.jar


💰 Monedas Soportadas
CódigoMonedaPaísUSDDólar estadounidenseEstados UnidosARSPeso argentinoArgentinaBRLReal brasileñoBrasilCOPPeso colombianoColombiaCLPPeso chilenoChileBOBBolivianoBolivia
📖 Cómo Usar

Iniciar la aplicación

Ejecuta el programa según las instrucciones de instalación


Seleccionar opción del menú

El programa mostrará 6 opciones de conversión predefinidas
Ingresa el número de la opción deseada (1-6)
Opción 7 para salir


Ingresar el monto

Escribe la cantidad que deseas convertir
El programa solo acepta valores numéricos positivos


Ver el resultado

La aplicación mostrará el valor convertido con el formato:

El valor 100.0 [USD] corresponde al valor final de --> 81275.0 [ARS]


📸 Ejemplo de Uso
*******************************************
Sea bienvenido/a al Conversor de Moneda =]
*******************************************

1) Dólar --> Peso argentino
2) Peso argentino --> Dólar
3) Dólar --> Real brasileño
4) Real brasileño --> Dólar
5) Dólar --> Peso colombiano
6) Peso colombiano --> Dólar
7) Salir
Elija una opción válida:
*******************************************
1
Ingrese el valor que deseas convertir:
50
El valor 50.0 [USD] corresponde al valor final de --> 40587.50 [ARS]
🔑 API Key
El proyecto incluye una API Key de ExchangeRate configurada. Si necesitas usar tu propia clave:

Regístrate en ExchangeRate-API
Obtén tu API Key gratuita
Reemplaza la clave en ClienteAPI.java:
javaprivate static final String API_KEY = "TU_API_KEY_AQUI";


🧪 Características Técnicas Implementadas
Fase 1-3: Cliente HTTP

✅ Implementación de HttpClient con timeout configurado
✅ Construcción de HttpRequest con headers apropiados
✅ Manejo de HttpResponse con validación de código de estado

Fase 4-5: Procesamiento JSON

✅ Análisis de respuesta JSON usando Gson
✅ Mapeo automático a objetos Java
✅ Filtrado de monedas específicas desde el JSON

Fase 6-7: Lógica de Negocio

✅ Conversión de valores con tasas actualizadas
✅ Interfaz de usuario interactiva con Scanner
✅ Validación de entrada del usuario
✅ Manejo de errores y excepciones

🐛 Manejo de Errores
La aplicación maneja los siguientes escenarios de error:

❌ Conexión a Internet no disponible
❌ API no responde o está caída
❌ Entrada inválida del usuario
❌ Valores negativos o no numéricos
❌ Opciones fuera del rango permitido

📝 Notas Adicionales

La aplicación requiere conexión a Internet para funcionar
Las tasas de cambio se obtienen en tiempo real
La API gratuita tiene un límite de 1500 solicitudes mensuales
Los valores se muestran con 2 decimales para mayor precisión

🤝 Contribuciones
Las contribuciones son bienvenidas. Para contribuir:

Fork el proyecto
Crea una rama para tu feature (git checkout -b feature/AmazingFeature)
Commit tus cambios (git commit -m 'Add some AmazingFeature')
Push a la rama (git push origin feature/AmazingFeature)
Abre un Pull Request

📄 Licencia
Este proyecto es de código abierto y está disponible bajo la Licencia MIT.
👨‍💻 Autor
Desarrollado como proyecto de práctica para el aprendizaje de:

Programación Orientada a Objetos en Java
Consumo de APIs REST
Manejo de JSON con Gson
Uso de HttpClient en Java 11+

🙏 Agradecimientos

ExchangeRate-API por proporcionar el servicio de tasas de cambio
Google Gson por la biblioteca de procesamiento JSON
