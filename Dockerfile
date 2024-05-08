# Build Stage (uses maven image for building)
FROM maven:3.9-eclipse-temurin-21 AS builder

# Only copy the necessary to pull only the dependencies from Intuit's registry
ADD ./pom.xml /opt/server/pom.xml

WORKDIR  /opt/server/

# # Prepare by downloading dependencies
# RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.5.0:go-offline

# Run the full packaging after copying the source
ADD ./src /opt/server/src
RUN mvn install -P embedded -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -B -e -T 1C verify

# Runtime Stage (uses slim OpenJDK image)
FROM openjdk:21-jdk-slim-buster

# Copy from the previous stage
COPY --from=builder /opt/server/target/*.jar /tmp/

# Just rename the built version
RUN mkdir /runtime && \
    find /tmp -name "*.jar" ! -name "*sources*" -exec cp -t /runtime {} + && \
    mv /runtime/*.jar /runtime/server.jar && \
    rm -f /tmp/*.jar

# Port used by the server
EXPOSE 8080

# What to execute on docker run
ENTRYPOINT sh -c "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom \
    $JAVA_PARAMS -jar /runtime/server.jar --server.port=8080 $SPRING_BOOT_APP_OPTS"