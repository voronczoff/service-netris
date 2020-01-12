FROM maven:3.6-jdk-8-alpine as builder
WORKDIR /usr/src/fx-sync-service
COPY ./src /usr/src/fx-sync-service/src
COPY ./pom.xml /usr/src/fx-sync-service/pom.xml
RUN mvn install

FROM openjdk:8-jre-alpine
RUN apk add bash curl

USER root

RUN apk update && apk add ca-certificates && rm -rf /var/cache/apk/* \
  mkdir /usr/local/share/ca-certificates/extra

COPY ./netris.crt /usr/local/share/ca-certificates/netris.crt
COPY ./corp-ADC1-CA-1.cer /usr/local/share/ca-certificates/corp-ADC1-CA-1.cer
COPY ./corp-ADC1-CA.cer /usr/local/share/ca-certificates/corp-ADC1-CA.cer


RUN update-ca-certificates

COPY --from=builder /usr/src/fx-sync-service/target/sync-service-0.0.1.jar /fx-sync-service.jar
CMD ["java", "-jar", "/fx-sync-service.jar"]