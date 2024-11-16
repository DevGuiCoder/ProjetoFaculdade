# Usar uma imagem base do Node.js
FROM node:18-alpine

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar os arquivos do frontend para o diretório de trabalho do container
COPY . .

# Instalar dependências (se houver um package.json)
# RUN npm install

# Expor a porta 3000 (você pode mudar a porta se necessário)
EXPOSE 3000

# Iniciar um servidor estático com o comando 'npx serve' (serve é um pacote npm que serve arquivos estáticos)
CMD ["npx", "serve", "-s", ".", "-l", "3000"]
