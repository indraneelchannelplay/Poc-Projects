package com.vertexwebsocketverticles;


import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.Route;



public class VertexApplication {

	public static void main(String args[]) {
		
		Vertx vertex = Vertx.factory.vertx();
		
		HttpServer server = vertex.createHttpServer();
		
		
		Router router = Router.router(vertex);

		Route handler = router.post("/getMessage").consumes("*/json").produces("*/json").handler(routingContext ->{

			String requestBody = routingContext.getBodyAsString();
			
			System.out.println("Request Message " + requestBody);
			HttpServerResponse serverResponse = routingContext.response();
			serverResponse.setChunked(true).end(Json.encodePrettily("Pong"));
		});
		
		server.requestHandler(router :: accept).listen(8080);
	}
}
