@echo off

:: Enable delayed variable expansion
setlocal enabledelayedexpansion

set "batchFile=%~f0"

:: Get the directory of the batch file
set BASE_DIR=%~dp0

:: Set directory paths
set SRC_DIR=%BASE_DIR%src\main\java
set BIN_DIR=%BASE_DIR%bin
set LIB_DIR=%BASE_DIR%lib

:: Ensure bin directory exists
if not exist "%BIN_DIR%" (
    mkdir "%BIN_DIR%"
)

echo Deleting Old compiles in the bin directory...
@RD /S /Q "%BIN_DIR%"

:: Recreate the bin directory
mkdir "%BIN_DIR%"

:: Create an empty classpath variable for jar files
set CLASSPATH=

:: Loop through all JAR files in the LIB_DIR and add them to CLASSPATH
for %%f in ("%LIB_DIR%\*.jar") do (
    set CLASSPATH=!CLASSPATH!;%%f
)

:: Remove leading semicolon if exists
if "!CLASSPATH:~0,1!"==";" (
    set CLASSPATH=!CLASSPATH:~1!
)

:: Compile all Java files
echo Compiling Java files...

:: Create a variable to store all Java files
set JAVA_FILES=

:: Find all Java files in the SRC_DIR
for /r "%SRC_DIR%" %%f in (*.java) do (
    set JAVA_FILES=!JAVA_FILES! "%%f"
)

:: Check if JAVA_FILES is not empty
if not "!JAVA_FILES!"=="" (
    javac -d "%BIN_DIR%" -cp "%CLASSPATH%" !JAVA_FILES!
) else (
    echo No Java files found to compile.
    PAUSE
    exit /b 1
)

:: Check if compilation succeeded
if %ERRORLEVEL% neq 0 (
    echo Compilation failed. Aborting.
    PAUSE
    exit /b %ERRORLEVEL%
)

echo Done compiling!

echo ---------------------------------------Starting Engine-------------------------------------------------------
cls

:: Run the main class with Lanterna configuration
javaw -Dcom.googlecode.lanterna.terminal=com.googlecode.lanterna.terminal.ansi.UnixTerminal -cp "%BIN_DIR%;%CLASSPATH%" io.github.pws.unkillmini.Program.Aplication

if %ERRORLEVEL% neq 0 (
    echo Execution failed. Aborting.
    PAUSE
    exit /b %ERRORLEVEL%
)

PAUSE
