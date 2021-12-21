@echo off
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.5.0_22
setx JAVA_HOME "%JAVA_HOME%"
set Path=%JAVA_HOME%\bin;%Path%
echo Java 5 activated as user default.
