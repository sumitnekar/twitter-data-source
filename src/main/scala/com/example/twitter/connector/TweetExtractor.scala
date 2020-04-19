package com.example.twitter.connector

import org.apache.flink.api.common.functions.{FilterFunction, MapFunction}
import org.codehaus.jackson.JsonNode
import org.codehaus.jackson.map.ObjectMapper

case object TweetExtractor {


  def mapFunction: MapFunction[String, String] = new MapFunction[String, String] {

    override def map(value: String): String = {
      val jsonParser: ObjectMapper = new ObjectMapper()
      val jsonNode = jsonParser.readValue(value, classOf[JsonNode])
      val isEnglish = jsonNode.has("lang") && jsonNode.get("lang").asText().equals("en")
      val hasUser = jsonNode.has("text")

      if (isEnglish && hasUser) jsonNode.get("text").asText() else "No tweets"
    }
  }


}
