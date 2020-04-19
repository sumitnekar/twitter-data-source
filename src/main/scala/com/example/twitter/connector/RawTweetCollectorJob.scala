package com.example.twitter.connector

import java.util.Properties

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.twitter.TwitterSource

object RawTweetCollectorJob extends App with TypeInfoImplicits {

  val twitterCredentials = AppConfig.twitterAccountSettings
  val env = StreamExecutionEnvironment.getExecutionEnvironment

  val twitterProperties = new Properties()
  twitterProperties.put(TwitterSource.CONSUMER_KEY, twitterCredentials.consumerKey)
  twitterProperties.put(TwitterSource.CONSUMER_SECRET, twitterCredentials.consumerSecret)
  twitterProperties.put(TwitterSource.TOKEN, twitterCredentials.accessToken)
  twitterProperties.put(TwitterSource.TOKEN_SECRET, twitterCredentials.accessTokenSecret)


  val tweetSource = env.addSource(new TwitterSource(twitterProperties))

  println("Collecting tweets")

  val tweets = tweetSource.map(TweetExtractor.mapFunction)
  tweets.print()


  env.execute(AppConfig.jobName)

}
