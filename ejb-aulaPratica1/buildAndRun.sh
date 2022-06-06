#!/bin/sh
mvn clean package && docker build -t com.mycompany/ejb-aulaPratica1 .
docker rm -f ejb-aulaPratica1 || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejb-aulaPratica1 com.mycompany/ejb-aulaPratica1