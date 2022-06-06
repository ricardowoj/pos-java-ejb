#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-aula4Pratica2 .
docker rm -f ejb-aula4Pratica2 || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica2 com.mycompany/ejb-aula4Pratica2