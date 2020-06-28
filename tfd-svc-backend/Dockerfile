FROM openjdk:8-jdk-alpine
# Environment Variable that defines the endpoint of sentiment-analysis python api.
ENV TFD_LOGIC_API_URL http://localhost:5000
ADD /target/tfd-svc-backend-0.0.1-SNAPSHOT.jar /
EXPOSE 8080
CMD ["java", "-jar", "tfd-svc-backend-0.0.1-SNAPSHOT.jar", "--tfd.logic.api.url=${TFD_LOGIC_API_URL}"]