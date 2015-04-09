package com.example

/**
 * Created by aragipindi on 3/23/15.
 */
object Permutations {
	def permute(input:String)={
		def helper(prefix:String,rest:String):Seq[String]= rest match {
			case "" => Seq(prefix)
			case _ => (0 to rest.size-1).flatMap {
					case i => val remaining = rest.substring(0,i) + rest.substring(i+1)
					helper(prefix + rest.charAt(i), remaining)
			}
 		}
		helper("",input)
	}

	def main(args:Array[String]):Unit={
		permute("abcd").foreach(println)
	}
}
