@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-16.0.2
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 16 activated as user default.
