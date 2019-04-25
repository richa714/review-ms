FROM openjdk:8
COPY ./target/review-ms-0.0.1-SNAPSHOT.jar review-ms-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","review-ms-0.0.1-SNAPSHOT.jar"]