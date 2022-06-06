#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-aula4Pratica4 .
docker rm -f ejb-aula4Pratica4 || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aula4Pratica4 com.mycompany/ejb-aula4Pratica4