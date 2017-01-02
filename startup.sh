#!/bin/sha
PATH_TO_JAR=hedwig-0.1.1-SNAPSHOT.jar

echo "Starting hedwig..."

java -jar $PATH_TO_JAR --defaultEmail=$1 --defaultPassword=$2 --defaultPhonenumber=$3 --api.key=$4 --api.id=$5 --api.sendNumber=$6
