package com.example

/**
 * Created by aragipindi on 4/16/15.
 */
object MaxNumberOfPasswords {
	def getMaxPasswords(state:Array[Array[Int]],row:Int,col:Int) ={
		if(state(row)(col) == 1){
			0
		}else{
			var numSolutions = 1


		}
	}


	def squareRoot(n:Int,guess:Double):Double = {
		val diff = guess*guess - n
		if(math.abs(diff) < 0.000001){
			guess
		}else{
			squareRoot(n,0.5f*(guess + n.toFloat/guess))
		}
	}

	def main(args:Array[String])={
		println(squareRoot(11,1.00))
		println(squareRoot(9,1.00))

	}
}
