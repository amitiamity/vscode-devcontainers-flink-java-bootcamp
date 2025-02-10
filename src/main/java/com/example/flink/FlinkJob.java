package com.example.flink;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkJob {
    public static void main(String[] args) throws Exception {
        // Set up Flink execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // Sample DataStream
        DataStream<String> data = env.fromElements("Hello", "Flink", "World");

        // Transformation: Convert to Uppercase
        DataStream<String> transformed = data.map((MapFunction<String, String>) String::toUpperCase);

        // Print the result
        transformed.print();

        // Execute the job
        env.execute("Flink Java Example");
    }
}
