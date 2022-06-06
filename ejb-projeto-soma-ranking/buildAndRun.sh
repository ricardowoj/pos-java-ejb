#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-projeto-soma-ranking .
docker rm -f ejb-projeto-soma-ranking || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-projeto-soma-ranking com.mycompany/ejb-projeto-soma-ranking