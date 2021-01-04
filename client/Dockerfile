FROM openjdk:8
COPY . client
WORKDIR client
RUN javac Client.java
# Note: we don't have a CMD statement because that's run after the container is created
