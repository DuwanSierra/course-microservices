@echo off
set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80
setx JAVA_HOME "%JAVA_HOME%" /M
set Path=%JAVA_HOME%\bin;%Path%
echo Java 7 activated as system-wide default.
