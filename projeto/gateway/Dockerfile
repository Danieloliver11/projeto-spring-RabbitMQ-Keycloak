# Estágio de build (compilação do projeto com Maven)
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copia todos os arquivos do projeto para o diretório /app no contêiner
COPY . .

# Executa o comando Maven para construir o projeto, ignorando os testes
RUN mvn clean package -DskipTests

# Estágio final (imagem leve para execução)
FROM openjdk:17

WORKDIR /app

# Copia o arquivo .jar gerado no estágio de build
COPY --from=build /app/target/*.jar app.jar

ARG KEYCLOAK_SERVER=Keycloak
ARG KEYCLOAK_PORT=8080


# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]




# docker run --name projeto-fila-gateway -p 8080:8080 -e KEYCLOAK_SERVER=Keycloak -e KEYCLOAK_PORT=8080 --network projeto-fila-network -d projeto-fila-gateway
