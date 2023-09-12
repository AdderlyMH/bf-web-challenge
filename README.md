# Web automation challenge

Este es un repositorio que contiene el proyecto bf-web-challenge. Este proyecto es un desafío web y puede contener código, recursos y archivos que inclyen:

* BDD con Cucumber y Gherkin
* Cross-browser testing
* Page Factory
* Implicit / Explicit waits
* TDD aplicando Data Providers con arrayLists, Maps y archivos json
* Extent Reports
* Listeners
* Retry flaky tests
* TakeScreenshot
* TestNG
* Ejecución de pruebas con comandos en terminal y Jenkins

## Clonar repositorio

Para clonar este repositorio en tu máquina local, puedes seguir estos pasos:

1. Abre tu terminal o línea de comandos.

2. Navega al directorio donde desees clonar el repositorio.

3. Ejecuta el siguiente comando:

   ```bash
   git clone https://github.com/AdderlyMH/bf-web-challenge.git
   ```

## Data de prueba

La data de prueba se puede ingresar, modificar de distintas formas:

1. Modificando los datos de entrada y/o salida en los archivos *feature* ubicados en:

   ```bash
   src/test/java/features/
   ```
   
2. Modificando los datos de las funciones con la anotación *@DataProvider* de los casos de prueba ubicados en:

   ```bash
   src/test/java/standalone/
   ```
   
3. Modificando la inclusión de clases y métodos a probar con TestNG dentro del archivo ubicado en:

   ```bash
   testsuites/testng.xml
   ```

## Ejecución de Pruebas

Es posible ejecutar las pruebas de distintas formas:

1. Ejecutando el archivo que se encuentra en la siguiente ubicación del proyecto:

   ```bash
   src/test/java/testexecutors/EcommerceTest.java
   ```
   
   Al terminar, se creará un reporte HTML en la siguiente ubicación del proyecto:

   ```bash
   target/cucumber.html
   ```
   
   Así como también se guardarán capturas de pantalla de los casos fallidos con extensión PNG.

2. Ejecutando el archivo que se encuentra en la siguiente ubicación del proyecto:

   ```bash
   testsuites/testng.xml
   ```

   Al terminar, se creará un reporte HTML en la siguiente ubicación del proyecto:

   ```bash
   reports/index.html

3. Ejecutando los casos de prueba que se encuentran en la siguiente ubicación del proyecto:

   ```bash
   src/test/java/standalone/
   ```

4. Vía comando en el terminal usando un perfil. Existe un perfil nombrado *Regression* dentro del proyecto que se puede ejecutar con el siguiente comando:

   ```bash
   mvn test -P"Regression" -D"browser"="chrome"
   ```