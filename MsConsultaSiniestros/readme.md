# Proyecto Template para microservicios JAVA para Openshift :computer:


**Compilar** -> ./gradlew clean build jacocoTestReport     :wrench:


**Windows** -> Si al subir el nuevo proyecto, el pipeline falla con el error: Permission Denied, ejecutar **git update-index --chmod=+x gradlew** A continuación hacer commit del cambio


**Lombok** -> Para insalar Lombok https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/


**Run** -> java -jar MsConsultaSiniestros-0.2.9.jar :runner:


**Features**: :rocket:

- Despliegue automático para el ambiente de desarrollo
- Publicación automática de artefactos a Nexus
- Configuración de integración continua
- Configuración de gradle wrapper
- Configuración de Log4j2 y SLF4j
- Configuración de Swagger
- Configuración de Lombok
- Configuración de conexión a Base de datos y JPA
- Creación de servicios Rest
- Códigos de llamados HTTP
- Configuración de Springboot Actuator
- Manejo de errores y pruebas
- Springboot 2
- Pruebas unitarias
- Base de datos en memoria
- Creación de Mocks
- Control de calidad por checkstyle
- Control de calidad por Sonar
- Control de cobertura de código por jacoco
- Configuración de proyecto via yml.


**Versionamiento automático**. A continuación se indica la nomenclatura para los Branch :hash:

- fix-branchName (0.0.X)
- hotfix-branchName (0.0.X)
- patch-branchName (0.0.X)
- feature-branchName (0.X.0)
- major-branchName (X.0.0)

**Logging**. Se proporcionan las siguientes recomendaciones :pencil2:

- FATAL -> Información de cualquier error que forza a detener el servicio o aplicación con el fin de prevenir la pérdida de datos
 
- ERROR -> Información de cualquier error que detiene la operación pero no la aplicación. (Error de request)
 
- WARN  -> Información que puede causar un comportamiento extraño en la aplicación, pero de la cual podemos recuperarnos.
 
- INFO  -> Información general de la aplicación (Inicio del servicio, Detención del servicio, llamada a servicios externos, fin de tx)
 
- DEBUG -> Información que ayuda como diagnóstico complementario para personas ajenas al desarrollo

- TRACE -> Información para rastrear código y capturar el flujo de la aplicación. 

