package com.hackerrank

/**
 * Created by aragipindi on 3/30/15.
 */
object CoinChange {


	def getWaysToGetChange(denominations:Seq[Int],numCents:Int):Int={
		def helper(d:Seq[Int],n:Int):Int={
			if((n > 0 && d.size == 0) || n <0 ) { 0}
			else if(n == 0) { 1}
			else {
				println(d.tail + ":" + n  + "\t" + d + ":" + (n-d.head))
				helper(d.tail,n) + helper(d,n-d.head)
			}
		}
		helper(denominations,numCents)
	}

	def main(args:Array[String])={
		println(getWaysToGetChange(Seq(1,2,3),4))
	}

}
