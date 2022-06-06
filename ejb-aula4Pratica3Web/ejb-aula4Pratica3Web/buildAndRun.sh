#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-aula4Pratica3Web .
docker rm -f ejb-aula4Pratica3Web || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica3Web com.mycompany/ejb-aula4Pratica3Web