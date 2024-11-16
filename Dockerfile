# Usar uma imagem base com Java
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo .jar para dentro do container
COPY backend/gym_v1.0.jar /app/gym_v1.0.jar

# Expor a porta 8080 
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "seu-backend.jar"]
