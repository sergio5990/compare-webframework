FROM openjdk:17-alpine as build

WORKDIR /app
RUN apk add binutils # for objcopy, needed by jlink
RUN jlink --output jre --compress=2 --no-header-files --no-man-pages --strip-debug --add-modules \
    java.base,jdk.httpserver,java.sql,java.net.http,jdk.crypto.ec,java.naming,java.management,jdk.unsupported

FROM alpine as final
RUN adduser -S user
WORKDIR /app

COPY --from=build /app/jre /app/jre
COPY build/libs/starter-1.0.0-SNAPSHOT-fat.jar /app/starter-1.0.0-SNAPSHOT-fat.jar

# Run under non-privileged user with minimal write permissions
USER user

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=80"
CMD jre/bin/java -jar starter-1.0.0-SNAPSHOT-fat.jar

# Heroku redefines exposed port
ENV PORT=8080
EXPOSE $PORT
