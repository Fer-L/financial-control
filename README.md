# Financial control app

### Creating docker database image: 
docker run --name financedb -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres

### Start it again:
sudo docker start finance-db
