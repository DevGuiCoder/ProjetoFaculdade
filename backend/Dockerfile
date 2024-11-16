# Usar uma imagem base com OpenJDK 21
FROM openjdk:21-jdk

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo .jar do backend para o diretório de trabalho no container
COPY gym.jar /app/gym.jar

# Expor a porta 8080 (ou a porta que sua aplicação utiliza)
EXPOSE 8080

# Comando para rodar a aplicação Java (Spring Boot, por exemplo)
CMD ["java", "-jar", "gym.jar"]
