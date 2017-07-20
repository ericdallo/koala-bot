#!/bin/bash
set -ve

git clone https://github.com/ericdallo/koala-bot.git $KOALA_HOME
KOALA_PROPERTIES=/opt/application.properties

cd $KOALA_HOME
./gradlew build

SPRING_CONFIG="--spring.config.location=file://$KOALA_PROPERTIES"
exec java -jar $KOALA_HOME/build/libs/koala-bot.jar $SPRING_CONFIG

