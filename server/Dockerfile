FROM openjdk:8
COPY . server
WORKDIR server
RUN javac Server.java
# Note: we don't have a CMD statement because that's run after the container is created
