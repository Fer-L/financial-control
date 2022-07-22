# 💰 Financial control app 💰
financial-control is an web application destinated to manage expenses and incomes, based on CNPJ.

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB"/>
  
</p>

## 📦 Set up Docker container
###  Creating docker database image: 
docker run --name financedb -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres

### Start it again:
sudo docker start financedb

## ▶ Executing front-end
### 1 - Clone financial-control-front repository
https://github.com/Leandrovargas0/financial-control-
### 2 - Run the following commands:
```
yarn install 
```
```
yarn start
```

<footer>
<p>Feito com ❤️ por Fernanda Luna, Leandro Vargas, Adahylton Tenório e Rodrigo Moura</p>
</footer>
