```sh
mkdir -p src/main/webapp/WEB-INF
touch src/main/webapp/index.jsp
touch pom.xml
```

```sh
mkdir -p src/main/java/io/lindx/web
touch src/main/java/io/lindx/web/MainServlet.java
rm -r src/main/webapp/index.jsp 
```

```sh 
rm -r ~/deploy-contaner/webapps/myapp && sleep 5 && mvn compile war:war
```

```sh 
mvn compile && rm -r ~/deploy-contaner/webapps/myapp & sleep 5 && mvn war:war
```

```sh
mvn compile && rm -r ~/deploy-contaner/webapps/myapp & sleep 5 && mvn war:exploded
```
```sh
mvn compile && rm -r ~/deploy-contaner/webapps/myapp & sleep 3 & mkdir -p ~/deploy-contaner/webapps/myapp &  sleep 5 && mvn war:exploded
```