setlocal
set CATALINA_HOME=C:\Program Files\Tomcat

echo Suppression Webapps Tomcat
echo.

echo Etape 1 - Shutdown Tomcat
call "C:\Program Files\Tomcat\bin\shutdown.bat"
echo.

echo Etape 2 - Suppression wars
del "C:\Program Files\Tomcat\webapps\myapp.war" /s /f /q
rmdir "C:\Program Files\Tomcat\webapps\myapp" /s /q
echo.

echo Etape 3 - Startup Tomcat
call "C:\Program Files\Tomcat\bin\startup.bat"
echo.