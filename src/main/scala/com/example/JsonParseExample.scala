package com.example
import play.api.libs.json._
/**
 * Created by aragipindi on 1/21/15.
 */
object JsonParseExample {

	def testSample()={
		val json: JsValue = Json.parse("""
                    {
                      "name" : "Watership Down",
                      "location" : {
                        "lat" : 51.235685,
                        "long" : -1.309197
                      },
                      "residents" : [ {
                        "name" : "Fiver",
                        "age" : 4,
                        "role" : null
                      }, {
                        "name" : "Bigwig",
                        "age" : 6,
                        "role" : "Owsla"
                      } ]
                    }
                """)
      println(json \ "name")
	}

	def main(args:Array[String])={
		testSample()
	}

}
