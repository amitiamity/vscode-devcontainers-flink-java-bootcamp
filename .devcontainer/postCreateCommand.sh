#!/bin/bash
set -e

echo "Setting up project..."

# Ensure gradle and flink are in the PATH
source /etc/profile.d/gradle.sh
source /etc/profile.d/flink.sh

# Initialize Gradle project if not exists
if [ ! -f "build.gradle" ]; then
    bash .devcontainer/gradle_init.sh
fi

echo "Dev Container setup complete!"

echo "Running Flink Cluster"
bash .devcontainer/start_flink_cluster.sh
