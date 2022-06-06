@echo off
call mvn clean package
call docker build -t com.mycompany/ejb-aula4Pratica3Web .
call docker rm -f ejb-aula4Pratica3Web
call docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica3Web com.mycompany/ejb-aula4Pratica3Web