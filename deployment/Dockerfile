FROM amazoncorretto:17-alpine
VOLUME /tmp
COPY *.jar java_avanzando_crud.jar
RUN adduser -D -g '' appuser && chown appuser: /java_avanzando_crud.jar
USER appuser
RUN sh -c 'touch /ms_ch_primero.jar'
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar java_avanzando_crud.jar" ]
