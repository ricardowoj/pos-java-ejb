#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-aula4Pratica7 .
docker rm -f ejb-aula4Pratica7 || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica7 com.mycompany/ejb-aula4Pratica7