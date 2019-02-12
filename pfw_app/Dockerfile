FROM maven:3-jdk-8-alpine as builder
ADD . /usr/src/mymaven/
WORKDIR /usr/src/mymaven
RUN mvn clean package -DskipTests
#COPY app.go    .
#RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .

FROM openjdk:8-jre-alpine
#RUN apk --no-cache add ca-certificates
#WORKDIR /root/
#COPY --from=builder /usr/src/mymaven/target/personalizedfitworkouts-0.0.1-SNAPSHOT.jar
COPY --from=builder /usr/src/mymaven/target/personalizedfitworkouts*.jar .
CMD java -jar personalizedfitworkouts*.jar
