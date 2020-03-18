FROM registry.access.redhat.com/ubi7/ubi
USER root
LABEL maintainer="Nikhil Gaikwad"

# Update image
RUN yum update --disableplugin=subscription-manager -y && rm -rf /var/cache/yum
RUN yum install --disableplugin=subscription-manager httpd -y && rm -rf /var/cache/yum
RUN yum install --disableplugin=subscription-manager -y java-1.8.0-openjdk

# Add default Web page and expose port
#RUN echo "The Web Server is Running" > /var/www/html/index.html
#EXPOSE 80

# Start the service
#CMD ["-D", "FOREGROUND"]
#ENTRYPOINT ["/usr/sbin/httpd"]

# Make port 8080 available to the world outside this container
EXPOSE 8081

# The application's jar file
ARG JAR_FILE=target/URLShortener-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} URL_Shortener.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/URL_Shortener.jar"]
#ENTRYPOINT ["tail", "-f", "/dev/null"]