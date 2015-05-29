package com.example

/**
 * Created by aragipindi on 4/28/15.
 */
object MaxContinuousSubArray {
	// O(n) solution
		def getMaxContinuousSum(nums:Array[Int]):Int ={
			val initialSums = nums.clone()
			for(i <- 1 until nums.length){
				if(initialSums(i) < initialSums(i-1) + nums(i)){
					initialSums(i) = initialSums(i-1) + nums(i)
				}
			}
			initialSums.max
		}

		// O(n) solution.
		def getMaxNonContinuousSum(nums:Array[Int]):Int = {
			val initialSums = nums.clone()
			var maxSum = initialSums.headOption.getOrElse(0)
			for(i <- 1 until nums.length){
				if(initialSums(i) < maxSum + nums(i)){
					initialSums(i) = maxSum + nums(i)
				}
				if(initialSums(i) > maxSum){
					maxSum = initialSums(i)
				}
			}
			maxSum
		}
		def main(args:Array[String])={
			val T = scala.io.StdIn.readInt()
			for( i <- 0 until T){
				val N = scala.io.StdIn.readInt()
				val nums:Array[Int] = scala.io.StdIn.readLine().split("\\s+").map(_.toInt)
				println(getMaxContinuousSum(nums) + " " + getMaxNonContinuousSum(nums))
			}
		}

}
