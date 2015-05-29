package com.example

import scala.io.StdIn._

/**
 * Created by aragipindi on 4/27/15.
 */
object LongestIncreasingSubSequence {

	def getMaxIncreasingSubSequenceLength(input:Array[Int]):Int = {
		val N = input.length
		val maxEndingLengths = Array.ofDim[Int](N)
		for(i <- 0 to N -1){ maxEndingLengths(i) = 1}
		for(i <- 0 to N -1 ;
			j <- 0 to i-1){
				if(input(i) > input(j) && maxEndingLengths(j) +1 > maxEndingLengths(i)){
					maxEndingLengths(i) = maxEndingLengths(j) +1
				}
		}
		maxEndingLengths.max
	}



	def main(args:Array[String])={
		val N = readInt()
		val input:Seq[Int] = for(i <- 0 to N -1) yield readInt()
		println(getMaxIncreasingSubSequenceLength(input.toArray))

	}

}
