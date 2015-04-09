package com.example

/**
 * Created by aragipindi on 1/21/15.
 */
object FbQualificationRound1 {
	def getMaxAndMin(number:String)={
		val lowerToHigher = number.toCharArray.sorted
		val higherToLower = number.toCharArray.sorted(Ordering[Char].reverse)
		val nonZeroIndex:Int = lowerToHigher.indexWhere(a => a != '0')
		if(nonZeroIndex >= 0){
			val tmp = lowerToHigher(0)
			lowerToHigher(0) = lowerToHigher(nonZeroIndex)
			lowerToHigher(nonZeroIndex) = tmp
		}

		(lowerToHigher.mkString(""),higherToLower.mkString(""))
	}
	def main(args:Array[String])={
		println(getMaxAndMin("100076"))
	}

}
