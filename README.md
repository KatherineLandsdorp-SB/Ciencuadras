Run any suite example

```sh
gradlew clean && gradlew assemble && gradlew  test -PsuiteFile="src/test/java/resources/suite.xml"

```
## Environment variables



| Variable | Value | Description |
| ------ | ------ | ------------- |
| MOBILE_DRIVER |android <br/> ios||
| WEB_DRIVER | chrome <br/> firefox ||
| DRIVER_LOCAL | true <br/> false |Si es true la automatizacion va a correr en la nube|
| SERVICES_AUT_BASE | https://autoqa-prod.auth.us-east-1.amazoncognito.com  | url para solicitar el token |
| SERVICES_USER_NAME |  | nombre de usuario para realizar la autenticacion por token |
| SERVICES_PASSWORD |  | password requerido para la autenticacion por token|
| SERVICES_BASE_URL | https://7scw0ywnt9.execute-api.us-east-1.amazonaws.com  | url base para hacer peticiones a los servicios|
| SERVICES_BASE_PATH | /prod  | |
| SERVICES_DATA | services/data   | |
| SERVICES_METRICS_SCOPE | services/metrics   | |
| AUTOMATION_PLATFORM_ID | | id de la plataforma que estamos automatizando|
| AUTOMATION_ENVIRONMENT_ID |1 <br/> 2 <br/> 3 <br/> 4 |1  STAGING <br/> 2  DEVELOPMENT <br/> 3 PRODUCTION <br/> 4 PREPRODUCTION |
| AUTOMATION_PROVIDER_ID | 1 | 1 Seguros Bolivar <br/> Para un proveedor diferente tomar el id del proveedeor de la base de datos |
| AUTOMATION_TYPE_EXECUTION_ID |1 <br/> 2 <br/> 3 <br/> 4   | 1 UI WEB <br/> 2 MOBILE <br/> 3 SERVICES <br/> 4 HYBRID |
| AUTOMATION_TYPE_AUTOMATION_ID |1 <br/> 2 | 1 PRUEBA (para cuando estamos en modo desarrollo) <br/> 2 PRODUCTIVA <br/> |
| AUTOMATION_STATE_EXECUTION | 2  | 2	EN PROCESO  |
| AUTOMATION_EXECUTOR_NAME | | Nombre de la persona que realiza la ejecucion |
| MOBILE_CAPABILITIES_UDID | | udid del dispositivo |
| MOBILE_CAPABILITIES_DEVICE_NAME | | Nombre del dispositivo |
| MOBILE_CAPABILITIES_APP_PACKAGE |  | paquete de la aplicacion que se va a automatizar <br/> Ejemplo: com.segurosbolivar.bolivarconmigo |
| MOBILE_CAPABILITIES_APP_ACTIVITY |  | Activity de la aplicacion que se va a automatizar <br/> Ejemplo: io.ionic.starter.MainActivity |
| MOBILE_CAPABILITIES_VERSION |  | Version del sistema operativo mobile. <br/>  Ejemplo si mi sistema operativo es Android 9 <br/> MOBILE_CAPABILITIES_VERSION = 9  |
| MOBILE_CAPABILITIES_HOST_URL |  | url host appium <br/> Local url: http://127.0.0.1:4723/wd/hub|