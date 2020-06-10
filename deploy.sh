#!/bin/bash
sed -i 's/local/dev/g' ./src/main/resources/application.yml
mvn clean install -Dmaven.test.skip=true
scp ./target/mikan-attendance-0.0.1-SNAPSHOT.jar rika@111.230.131.247:/home/rika/MikanAttendance/
sed -i 's/dev/local/g' ./src/main/resources/application.yml