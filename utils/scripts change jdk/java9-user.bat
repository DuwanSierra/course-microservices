@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-9.0.4
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 9 activated as user default.
