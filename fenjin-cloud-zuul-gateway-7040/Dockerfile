FROM java
ADD fenjin-cloud-zuul-gateway-7040-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]