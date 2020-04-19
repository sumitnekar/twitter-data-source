package com.example.twitter.connector

import org.apache.flink.api.common.typeinfo.TypeInformation

trait TypeInfoImplicits {

  implicit val tweetsType = TypeInformation.of(classOf[String])

}
