# 💰 Financial control app 💰
financial-control is an web application destinated to manage expenses and incomes, based on CNPJ.
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
