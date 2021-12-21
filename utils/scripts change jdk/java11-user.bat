@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.11
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 11 activated as user default.
