@echo off
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-11.0.13.8-hotspot
setx JAVA_HOME "%JAVA_HOME%" /M
set Path=%JAVA_HOME%\bin;%Path%
echo Java 11 activated as system-wide default.
