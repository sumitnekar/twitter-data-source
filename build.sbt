
name := "twitter-data-source"

version := "0.1"

scalaVersion := "2.12.6"

import LibraryVersions._

libraryDependencies ++= Seq(
  "org.apache.flink" % "flink-java" % FlinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % FlinkVersion,
  "org.apache.flink" %% "flink-connector-kafka-0.11" % FlinkVersion,
  "org.apache.flink" %% "flink-statebackend-rocksdb" % FlinkVersion,
  "org.apache.flink" %% "flink-connector-elasticsearch6" % FlinkVersion,
  "org.apache.flink" % "flink-avro-confluent-registry" % FlinkVersion,
  "org.apache.flink" %% "flink-connector-twitter" % FlinkVersion,
  "com.typesafe" % "config" % TypeSafeConfig,
  "org.scalatest" %% "scalatest" % ScalaTestVersion % Test,
  "org.mockito" % "mockito-all" % MockitoVersion,
  "org.apache.flink" %% "flink-test-utils" % FlinkVersion


)