@echo off
echo [Pre-Requirement] Makesure install JDK 6.0+ and set the JAVA_HOME.
echo [Pre-Requirement] Makesure install Maven 3.0.5+ and set the PATH.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=256m

echo [Step 1] Init project database to ready develope.

cd %~dp0
cd ..
call mvn clean test -Pcreate-db
call mvn clean test -Pinit-db
if errorlevel 1 goto error 
cd bin
pause