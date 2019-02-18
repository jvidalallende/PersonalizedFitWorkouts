# Build the application using maven container
FROM maven:3-jdk-8-alpine as builder
WORKDIR /usr/src/mymaven
ADD . /usr/src/mymaven/
RUN mvn clean package -DskipTests


# Run on alpine using the package created previously
FROM openjdk:8-jre-alpine

# Environment variables with default values
ENV SERVER_PORT "8090"
ENV DB_PORT "3306"
ENV DB_NAME "test"
ENV DB_HOST ""
ENV DB_USERNAME ""
ENV DB_PASSWORD ""

# The port in which the app listens should be open
EXPOSE $SERVER_PORT

COPY --from=builder /usr/src/mymaven/target/pdfcreatormodule*.jar .

# The application will use environment variables to setup its properties
CMD java -jar pdfcreatormodule*.jar \
 --spring.datasource.url=jdbc:mysql://$DB_HOST:$DB_PORT/$DB_NAME \
 --spring.datasource.username=$DB_USERNAME \
 --spring.datasource.password=$DB_PASSWORD \
 --server.port=$SERVER_PORT
