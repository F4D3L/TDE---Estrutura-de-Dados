@echo off
echo === Compilando e Executando Algoritmo Flood Fill ===
echo.

REM Criar diretórios necessários
if not exist bin mkdir bin
if not exist images mkdir images
if not exist images\input mkdir images\input
if not exist images\output mkdir images\output

echo Compilando arquivos Java...
javac -d bin src\datastructures\*.java src\model\*.java src\utils\*.java src\algorithms\*.java src\Main.java

if %ERRORLEVEL% EQU 0 (
    echo Compilacao concluida com sucesso!
    echo.
    echo Executando o programa...
    echo.
    java -cp bin Main
) else (
    echo Erro na compilacao!
    pause
)

echo.
echo Pressione qualquer tecla para sair...
pause > nul