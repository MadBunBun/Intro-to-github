@echo off
cd /d "%~dp0Calculator"
echo Compiling Calculator...
javac Calculator.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)

echo Starting Calculator...
java Calculator
