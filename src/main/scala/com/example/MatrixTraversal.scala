package com.example

/**
 * Created by aragipindi on 5/14/15.
 */
object MatrixTraversal {

	def printMatrixInZigZag(matrix:Array[Array[Int]])={
		val n = matrix.length
		val m = matrix(0).length
		println(n+m)
		for{k <- 0 to  m+n
			i <- math.min(k,n-1) to 0 by -1
			j <- k-i to k-i if j >= 0 && j < m
	}{

			println(matrix(i)(j))
		}
	}

	def main(args:Array[String])={
		printMatrixInZigZag(Array( Array(1,3,6,9,12),
			                       Array(2,5,8,11,14),
			                        Array(4,7,10,13,15)
							))
	}

	/**
	 * 1 3 6 9 12
	 * 2 5 8 11 14
	 * 4 7 10 13 15
	 */


	def replaceCharsWithAsterisk(name:Array[Char])={
		for(i <- 0 to name.length-1 if name(i) != '*'){
			val n_name = name

		}
	}
}
