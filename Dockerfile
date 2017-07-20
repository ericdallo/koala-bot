FROM openjdk:8

RUN mkdir -p /opt/app

ENV KOALA_HOME /opt/app

COPY . /opt/koala-bot
WORKDIR /opt/app

ENTRYPOINT /opt/koala-bot/docker/startup.sh
