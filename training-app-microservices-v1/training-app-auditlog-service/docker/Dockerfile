FROM openjdk:11-jre-slim

COPY docker-entrypoint.sh /
COPY *.jar /usr/local/lib/service.jar

RUN chmod 775 /docker-entrypoint.sh

EXPOSE 8080
EXPOSE 8081

ENTRYPOINT ["/docker-entrypoint.sh"]
