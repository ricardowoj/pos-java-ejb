@echo off
call mvn clean package
call docker build -t com.mycompany/ejb-aulaPratica1 .
call docker rm -f ejb-aulaPratica1
call docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aulaPratica1 com.mycompany/ejb-aulaPratica1