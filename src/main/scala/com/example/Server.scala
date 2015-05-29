package com.example

import java.net.{Socket, ServerSocket}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by aragipindi on 4/28/15.
 */
object Server {
	def process(conn:Socket):Future[Unit]=Future{
		val out = conn.getOutputStream
		Thread.sleep(10000)
		out.write("Hello World".toString.getBytes())
		out.close()
		conn.close()
	}

	def main(args:Array[String])={
		val socket = new ServerSocket(9000)
		while(true){
			process(socket.accept())
		}
		socket.close()
	}
}
