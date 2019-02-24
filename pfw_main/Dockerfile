# Build the application using maven container
FROM maven:3-jdk-8-alpine as builder
ADD . /usr/src/mymaven/
WORKDIR /usr/src/mymaven
RUN mvn clean package -DskipTests


# Run on alpine using the package created previously
FROM openjdk:8-jre-alpine

# Environment variables with default values
ENV SERVER_PORT "8080"

# The port in which the app listens should be open
EXPOSE $SERVER_PORT

COPY --from=builder /usr/src/mymaven/target/personalizedfitworkouts*.jar .

# The application will use environment variables to setup its properties
# Apart from the following variables, the applicacion also expects two more
# vars: PDF_CREATOR_HOST and PDF_CREATOR_PORT, in order to connect to PDFcreator
CMD java -jar personalizedfitworkouts*.jar \
 --spring.datasource.url=jdbc:mysql://$DB_HOST:$DB_PORT/$DB_NAME \
 --spring.datasource.username=$DB_USERNAME \
 --spring.datasource.password=$DB_PASSWORD \
 --server.port=$SERVER_PORT
