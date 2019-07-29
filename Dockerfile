FROM docker-hub-green.tools.huawei.com/openjdk:8-jre-alpine

MAINTAINER="DevCloud <devcloud@huawei.com>"

COPY ./target/plh0729.war  /tomcat/webapps/

CMD ["/tomcat/bin/catalina.sh", "run"]

EXPOSE 8080
