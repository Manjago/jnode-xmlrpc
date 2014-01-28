#!/bin/sh
CLASSPATH=".";
for I in ./lib/*.jar; do
    CLASSPATH="$CLASSPATH:$I"
done
java -Xmx100m -cp "$CLASSPATH" jnode.App ./config.properties