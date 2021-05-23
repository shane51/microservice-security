docker rm -f local-mysql
docker rmi sqlinjection_demo:latest
docker build -t sqlinjection_demo:latest .
docker run -p 3306:3306 --name local-mysql -e MYSQL_ROOT_PASSWORD=11asd097asd -d sqlinjection_demo:latest