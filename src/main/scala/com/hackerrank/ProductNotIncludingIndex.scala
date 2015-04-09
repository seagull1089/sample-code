package com.hackerrank

/**
 * Created by aragipindi on 3/5/15.
 */
object ProductNotIncludingIndex {
	def get_products_of_all_ints_except_at_index(lst:Array[Int])={

		def get_val(index:Int,products:Array[Int])={
			if(index < 0 || index > products.size-1){
				1
			}else{
				products(index)
			}
		}

		val forwardProducts = lst.scanLeft(1)((a,b) => a*b).tail
		println(forwardProducts.toList)
		val backwardProduct = lst.scanRight(1)((a,b) => a*b).take(lst.size)
		println(backwardProduct.toList)

		(0 to lst.size -1).map{
			case i => get_val(i+1,backwardProduct)*get_val((i-1),forwardProducts)
		}
	}

	def main(args:Array[String])={
		println(get_products_of_all_ints_except_at_index(Array(2,3,4,5)))
		println(get_products_of_all_ints_except_at_index(Array(5)))
		println(get_products_of_all_ints_except_at_index(Array[Int]()))

	}



}
