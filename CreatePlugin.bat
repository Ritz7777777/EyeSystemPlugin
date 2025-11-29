@echo off
echo Creating EyeSystem Plugin from scratch...
mkdir EyeSystemPlugin-Fresh
cd EyeSystemPlugin-Fresh

echo Creating folder structure...
mkdir src\main\java\com\youreyesystem\data
mkdir src\main\java\com\youreyesystem\managers
mkdir src\main\java\com\youreyesystem\listeners
mkdir src\main\resources

echo Creating pom.xml...
echo ^<?xml version="1.0" encoding="UTF-8"?^> > pom.xml
echo ^<project xmlns="http://maven.apache.org/POM/4.0.0" >> pom.xml
echo          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" >> pom.xml
echo          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"^> >> pom.xml
echo     ^<modelVersion^>4.0.0^</modelVersion^> >> pom.xml
echo     ^<groupId^>com.youreyesystem^</groupId^> >> pom.xml
echo     ^<artifactId^>EyeSystem^</artifactId^> >> pom.xml
echo     ^<version^>1.0.0^</version^> >> pom.xml
echo     ^<packaging^>jar^</packaging^> >> pom.xml
echo     ^<properties^> >> pom.xml
echo         ^<maven.compiler.source^>21^</maven.compiler.source^> >> pom.xml
echo         ^<maven.compiler.target^>21^</maven.compiler.target^> >> pom.xml
echo         ^<project.build.sourceEncoding^>UTF-8^</project.build.sourceEncoding^> >> pom.xml
echo     ^</properties^> >> pom.xml
echo     ^<repositories^> >> pom.xml
echo         ^<repository^> >> pom.xml
echo             ^<id^>papermc^</id^> >> pom.xml
echo             ^<url^>https://repo.papermc.io/repository/maven-public/^</url^> >> pom.xml
echo         ^</repository^> >> pom.xml
echo     ^</repositories^> >> pom.xml
echo     ^<dependencies^> >> pom.xml
echo         ^<dependency^> >> pom.xml
echo             ^<groupId^>io.papermc.paper^</groupId^> >> pom.xml
echo             ^<artifactId^>paper-api^</artifactId^> >> pom.xml
echo             ^<version^>1.21.1-R0.1-SNAPSHOT^</version^> >> pom.xml
echo             ^<scope^>provided^</scope^> >> pom.xml
echo         ^</dependency^> >> pom.xml
echo     ^</dependencies^> >> pom.xml
echo     ^<build^> >> pom.xml
echo         ^<plugins^> >> pom.xml
echo             ^<plugin^> >> pom.xml
echo                 ^<groupId^>org.apache.maven.plugins^</groupId^> >> pom.xml
echo                 ^<artifactId^>maven-compiler-plugin^</artifactId^> >> pom.xml
echo                 ^<version^>3.11.0^</version^> >> pom.xml
echo                 ^<configuration^> >> pom.xml
echo                     ^<source^>21^</source^> >> pom.xml
echo                     ^<target^>21^</target^> >> pom.xml
echo                 ^</configuration^> >> pom.xml
echo             ^</plugin^> >> pom.xml
echo             ^<plugin^> >> pom.xml
echo                 ^<groupId^>org.apache.maven.plugins^</groupId^> >> pom.xml
echo                 ^<artifactId^>maven-shade-plugin^</artifactId^> >> pom.xml
echo                 ^<version^>3.4.1^</version^> >> pom.xml
echo                 ^<executions^> >> pom.xml
echo                     ^<execution^> >> pom.xml
echo                         ^<phase^>package^</phase^> >> pom.xml
echo                         ^<goals^> >> pom.xml
echo                             ^<goal^>shade^</goal^> >> pom.xml
echo                         ^</goals^> >> pom.xml
echo                     ^</execution^> >> pom.xml
echo                 ^</executions^> >> pom.xml
echo             ^</plugin^> >> pom.xml
echo         ^</plugins^> >> pom.xml
echo     ^</build^> >> pom.xml
echo ^</project^> >> pom.xml

echo Creating plugin.yml...
echo name: EyeSystem > src\main\resources\plugin.yml
echo version: 1.0.0 >> src\main\resources\plugin.yml
echo main: com.youreyesystem.EyeSystemPlugin >> src\main\resources\plugin.yml
echo api-version: "1.21" >> src\main\resources\plugin.yml
echo author: YourName >> src\main\resources\plugin.yml
echo description: Immersive eye-based ability system for Minecraft >> src\main\resources\plugin.yml
echo commands: >> src\main\resources\plugin.yml
echo   eye: >> src\main\resources\plugin.yml
echo     description: Manage your eye abilities >> src\main\resources\plugin.yml
echo     usage: /eye [select^|info] >> src\main\resources\plugin.yml
echo   ability: >> src\main\resources\plugin.yml
echo     description: Use your eye ability >> src\main\resources\plugin.yml
echo     usage: /ability >> src\main\resources\plugin.yml

echo.
echo Project structure created! Now open the 'EyeSystemPlugin-Fresh' folder in IntelliJ.
echo You'll need to manually create the Java files in IntelliJ.
pause
