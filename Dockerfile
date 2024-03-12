FROM registry.access.redhat.com/ubi9/openjdk-17-runtime:1.15-1.1686736681

EXPOSE 8080/tcp

ENV LOG_LAYOUT=json

# Remove SHA1 from banned crypto, temporary solution
USER root
RUN ["sed", "-i", "s/SHA1, //g", "/usr/share/crypto-policies/DEFAULT/java.txt"]
USER default

WORKDIR /
COPY target/app.jar /app.jar
COPY postgresql.crt /postgresql.crt
USER nobody

CMD [ "java", "-jar", "/app.jar" ]
