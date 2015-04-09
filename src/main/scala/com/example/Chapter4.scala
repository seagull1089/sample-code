package com.example

/**
 * Created by aragipindi on 12/10/14.
 */
object Chapter4 {

	// Think of redoing this with flatMap
	def variance(xs:Seq[Double]):Double={
		val mean = xs.sum / xs.length
		xs.map(x => math.pow(x- mean,2)).sum/xs.length
	}


	def sequence[A](xs:List[Option[A]]): Option[List[A]] = {
		xs match {
			case t:: Nil => t.map{ a => a :: Nil}
			case x::rs => x.flatMap( a => sequence(rs).map { lst => a :: lst } )
			case Nil => None
		}
	}

	def sum(a: Option[Int], b:Option[Int]) : Option[Int]={
		a.flatMap{
			x => b.map{
				y => x+y
			}
		}
	}

}
