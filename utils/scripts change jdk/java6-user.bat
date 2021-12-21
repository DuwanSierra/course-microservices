@echo off
set JAVA_HOME=C:\Program Files\Java\jdk1.6.0_45
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 6 activated as user default.
