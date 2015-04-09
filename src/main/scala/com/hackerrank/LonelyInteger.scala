package com.hackerrank

/**
 * Created by aragipindi on 3/9/15.
 */
object LonelyInteger {
	def main(args: Array[String]) = {
		val N = scala.io.StdIn.readInt()
		val oddOne = scala.io.StdIn.readLine().trim.split("\\s").map(_.toInt).foldLeft(Map[Int, Int]()) {
			case (acc, in) =>
				acc + (in -> (acc.getOrElse(in, 0) + 1))
		}.toSeq.filter(_._2 % 2 == 1).map(_._1).head
		println(oddOne)

	}
}

object MaximizingXor {
	def maxXor(l: Int, r: Int): Int = {
			(l to r).flatMap {
				case i => (l to r).map {
					case j => i ^ j
				}
			}.max
	}

	def main(args: Array[String])={
		val _l: Int = Console.readInt
		val _r: Int = Console.readInt
		val res = maxXor(_l, _r)
		println(res)
	}
}

object MaxMin {
	def main(args:Array[String])={
		val N = scala.io.StdIn.readInt()
		val K = scala.io.StdIn.readInt()
		val nums = (1 to N).map{
			_ => scala.io.StdIn.readInt()
		}.sorted

		val min_unfairness = (K-1 to nums.length-1).map{
			i =>
				val max = nums(i)
				val min = nums(i-K+1)
				max-min
		}.min
		println(min_unfairness)
	}
}


