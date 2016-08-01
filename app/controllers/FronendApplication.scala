package controllers

import javax.inject.Inject
import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.ws._
import play.api.http.HttpEntity
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import akka.stream.scaladsl._
//import akka.util.ByteString
import scala.concurrent.ExecutionContext.Implicits.global
import com.fasterxml.jackson.databind.JsonNode
import play.api.libs.json.JsValue
import play.api.libs.ws.WSResponse
import java.util.concurrent.CompletionStage
import play.api.libs.ws.WSResponse
import play.api.libs.json.Json


class FronendApplication @Inject() (ws: WSClient) extends Controller {
  
  def getProducts = Action.async {
    ws.url("http://products-service:9000/products").post("content").map { response =>
    val json: JsValue = Json.parse(response.body)
    
      Ok(response.body)
    }
  }
  
  def testService = Action {
    Ok("frontend service is working")
  }
  
}