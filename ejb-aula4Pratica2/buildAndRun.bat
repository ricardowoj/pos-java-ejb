@echo off
call mvn clean package
call docker build -t com.mycompany/ejb-aula4Pratica2 .
call docker rm -f ejb-aula4Pratica2
call docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica2 com.mycompany/ejb-aula4Pratica2