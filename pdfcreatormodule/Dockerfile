FROM maven:3-jdk-8-alpine as builder
ADD . /usr/src/mymaven/
WORKDIR /usr/src/mymaven
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-alpine
COPY --from=builder /usr/src/mymaven/target/pdfcreatormodule*.jar .
CMD java -jar pdfcreatormodule*.jar
