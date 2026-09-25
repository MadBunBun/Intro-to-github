@echo off
echo Compiling Calculator...
javac Calculator.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)

echo Starting Calculator...
java Calculator
