# Use an official OpenJDK image compatible with ARM64
FROM mcr.microsoft.com/devcontainers/java:17-bullseye

# Define user
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=1000

# Install dependencies
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    git \
    curl \
    && apt-get clean

# Install Gradle (latest version)
RUN wget https://services.gradle.org/distributions/gradle-8.6-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-8.6-bin.zip && \
    echo "export PATH=/opt/gradle/gradle-8.6/bin:$PATH" >> /etc/profile.d/gradle.sh

# Install Flink 1.20 (latest stable version)
RUN wget https://dlcdn.apache.org/flink/flink-1.20.0/flink-1.20.0-bin-scala_2.12.tgz -P /tmp && \
    tar -xzf /tmp/flink-1.20.0-bin-scala_2.12.tgz -C /opt/ && \
    ln -s /opt/flink-1.20.0 /opt/flink && \
    echo "export PATH=/opt/flink/bin:$PATH" >> /etc/profile.d/flink.sh

# Set work directory
WORKDIR /workspaces/flink-java-devcontainer

# Expose Flink UI Port
EXPOSE 8081

# Set Flink environment variables
ENV FLINK_HOME=/opt/flink
ENV PATH=$FLINK_HOME/bin:$PATH

# Ensure the log directory is writable by vscode
RUN mkdir -p $FLINK_HOME/log && chown -R vscode:vscode $FLINK_HOME/log && chmod -R 777 $FLINK_HOME/log && chmod +x ${FLINK_HOME}/bin

# Ensure Flink scripts are executable
RUN chmod +x $FLINK_HOME/bin/*.sh


# Switch to vscode user
USER vscode

# Start Flink Cluster & Keep Container Running
CMD ["/bin/bash", "-c", "$FLINK_HOME/bin/start-cluster.sh && tail -f /dev/null"]
