# vscode-devcontainers-flink-java-bootcamp

This project includes a pre-configured DevContainer for Flink development, which allows you to quickly spin up a consistent development environment without needing to install Flink and other dependencies manually on your local machine. This is especially helpful for consistent workflows and collaboration across different developers. Once the DevContainer is initialized and Flink is running inside the container, you can access the Flink Web UI (http://localhost:8081) to monitor the status and progress of your job.

## Project Structure
```
.devcontainer/          # Contains Docker container configuration for development environments
  ├── devcontainer.json # Development container configuration
  ├── Dockerfile        # Dockerfile for building the development environment container
  ├── gradle_init.sh    # Initialization script for Gradle
  ├── postCreateCommand.sh # Commands to run post container creation
  ├── start_flink_cluster.sh # Commands to start flink cluster post container creation
.gitignore              # Specifies files and directories to be ignored by git
.gradle/                # Gradle wrapper directory
build.gradle            # Gradle build configuration file
gradle/                 # Contains Gradle configuration files
gradlew                 # Gradle wrapper script for Linux/macOS
gradlew.bat             # Gradle wrapper script for Windows
README.md               # This README file
settings.gradle         # Gradle settings configuration file
src/                    # Source files
  ├── main/             # Main source code
  ├── test/             # Test source code
```
## Getting Started

### Prerequisites

- Docker
- Visual Studio Code
- Remote - Containers extension for Visual Studio Code

### Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-repo/vscode-devcontainers-flink-java-bootcamp.git
    cd vscode-devcontainers-flink-java-bootcamp
    ```

2. **Open the project in Visual Studio Code:**

    ```sh
    code .
    ```

3. **Reopen in Container:**

    - Press `F1` and select `Remote-Containers: Reopen in Container`.

### Running the Flink Job

1. **Build the project:**

    ```sh
    ./gradlew build
    ```

2. **(Option 1) Run the Flink job:**

    ```sh
    ./gradlew run
    ```
    This will run the the Flink job in local execution mode.

3. **(Option 2) Submit the Flink job to the running Flink cluster (could be a remote machine):**

    ```sh
    $FLINK_HOME/bin/flink run build/libs/<your-flink-job>.jar
    ```
    Access the Flink Web UI: Once the container is initialized, the Flink Web UI will be available at http://localhost:8081.

    This UI provides detailed information about the Flink cluster, job execution, task status, logs, metrics, and more.
    You can track your job’s progress, see task-level details, and manage the execution of jobs.

### Running Tests

To run the tests, use the following command:

```sh
./gradlew test
```
### Contact
https://www.linkedin.com/in/amitptl/
