#!/bin/sh

java $JAVA_OPTS -jar /usr/local/lib/service.jar \
    --db.host=$DB_HOST \
    --db.port=$DB_PORT \
    $@
