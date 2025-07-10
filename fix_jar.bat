@echo off
echo Fixing JAR file to include classpath...

REM Create MANIFEST.MF with classpath
echo Manifest-Version: 1.0 > MANIFEST.MF
echo Main-Class: Rest.ApiApplication >> MANIFEST.MF
echo Class-Path: . >> MANIFEST.MF

REM Add lib/* to classpath
for %%f in (lib\*.jar) do (
    echo Class-Path: lib\%%~nxf >> MANIFEST.MF
)

REM Update the JAR with new manifest
jar ufm LAB3_LOG430.jar MANIFEST.MF

REM Clean up
del MANIFEST.MF

echo Done! Now you can run: java -jar LAB3_LOG430.jar 