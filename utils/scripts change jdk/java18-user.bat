@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-18-ea
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 18 activated as user default.
