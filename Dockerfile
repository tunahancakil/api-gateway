FROM openjdk:17-alpine

WORKDIR /

COPY build/libs/api-gateway-1.0-SNAPSHOT.jar /opt/app/api-gateway-1.0-SNAPSHOT.jar

CMD java -Xmx1024m -jar /opt/app/api-gateway-1.0-SNAPSHOT.jar