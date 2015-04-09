package com.example

/**
 * Created by aragipindi on 4/8/15.
 */
object SudokuChecker {
	def check(numbers: Array[Array[Int]]):Boolean={
		lazy val requiredSum = (1 to 9).sum

		val rowSum = Array[Int](9)
		val colSum = Array[Int](9)

		for(i <- 0 to 8; j <- 0 to 8) {
			rowSum(i) += numbers(i)(j)
			colSum(j) += numbers(i)(j)
		}
		!(rowSum.exists(p=> p!= requiredSum) || colSum.exists(p=> p != requiredSum))
	}

	def main(args:Array[String]): Unit ={
		scala.io.StdIn.readInt()

	}

}
