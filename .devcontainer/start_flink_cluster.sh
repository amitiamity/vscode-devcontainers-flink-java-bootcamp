#!/bin/bash

# Start Flink Cluster in the background
$FLINK_HOME/bin/start-cluster.sh

# Keep the container running and show logs
echo "Flink is running. Watching logs..."
tail -f $FLINK_HOME/log/*.log
