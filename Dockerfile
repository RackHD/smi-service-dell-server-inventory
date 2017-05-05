FROM openjdk:8-jre
VOLUME /tmp
ADD build/libs/service-server-inventory*.jar app.jar
COPY application.yml /application.yml
EXPOSE 46011
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
