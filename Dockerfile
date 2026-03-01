# STAGE 1 : Build avec Maven
FROM maven:3.8-eclipse-temurin-11 AS build

# Copier les fichiers du projet
COPY pom.xml .
COPY src ./src

# Compiler l'application
RUN mvn clean package -DskipTests

# STAGE 2 : Image finale
# telechargement de l'image de base
FROM eclipse-temurin:11-jdk-alpine

# creation d'un repertoire "app"
RUN mkdir /app

# copie du fichier jar dans mon image docker, dans le repertoire "app"
COPY ./target/spring-boot-skeleton-0.0.1-SNAPSHOT.jar /app/

# aller dans le repertoire "app"
WORKDIR /app

# on expose le port 8082 de l'image docker
EXPOSE 8082

# commande qui est lancee au demarage du conteneur
CMD "java" "-jar" spring-boot-skeleton-0.0.1-SNAPSHOT.jar