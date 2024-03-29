FROM openjdk:17-alpine as build

WORKDIR /app
RUN apk add binutils # for objcopy, needed by jlink
RUN jlink --output jre --compress=2 --no-header-files --no-man-pages --strip-debug --add-modules \
    java.base,jdk.httpserver,java.sql,java.net.http,jdk.crypto.ec,java.naming,java.management

FROM alpine as final
RUN adduser -S user
WORKDIR /app

COPY --from=build /app/jre /app/jre
COPY build/libs/klite-all.jar /app/klite-all.jar

# Run under non-privileged user with minimal write permissions
USER user

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=80"
CMD jre/bin/java -jar klite-all.jar

# Heroku redefines exposed port
ENV PORT=8080
EXPOSE $PORT
