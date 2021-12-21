@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-14.0.2
setx JAVA_HOME "%JAVA_HOME%" /M
set Path=%JAVA_HOME%\bin;%Path%
echo Java 14 activated as system-wide default.
