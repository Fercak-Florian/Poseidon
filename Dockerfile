# telechargement de l'image de base
FROM eclipse-temurin:17-jdk-alpine

# creation d'un repertoire "app"
RUN mkdir /app

# copie du fichier jar dans mon image docker, dans le repertoire "app"
COPY ./target/poseidon-0.0.1-SNAPSHOT.jar /app/

# aller dans le repertoire "app"
WORKDIR /app

# on expose le port 8082 de l'image docker
EXPOSE 8087

# commande qui est lancee au demarage du conteneur
CMD "java" "-jar" poseidon-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod