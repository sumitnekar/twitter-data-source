package com.example.twitter.connector

import com.typesafe.config.ConfigFactory

object AppConfig {

  private val appId = "twitter-connector-app"
  private val appConfig = ConfigFactory.load()

  //Twitter account credentials
  private val consumerKey = appConfig.getString(s"$appId.twitter.credentials.consumerKey")
  private val consumerSecret = appConfig.getString(s"$appId.twitter.credentials.consumerSecret")
  private val accessToken = appConfig.getString(s"$appId.twitter.credentials.accessToken")
  private val accessTokenSecret = appConfig.getString(s"$appId.twitter.credentials.accessTokenSecret")

  val jobName = appConfig.getString(s"$appId.job.name")

  val twitterAccountSettings =
    TwitterAccountSettings(consumerKey, consumerSecret, accessToken, accessTokenSecret)


}


case class TwitterAccountSettings(consumerKey: String, consumerSecret: String,
                                  accessToken: String, accessTokenSecret: String)