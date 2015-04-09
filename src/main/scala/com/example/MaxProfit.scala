package com.example

/**
 * Created by aragipindi on 3/5/15.
 *  have an array stock_prices_yesterday where:
https://www.interviewcake.com/
The indices are the time, as a number of minutes past trade opening time, which was 9:30am local time.
The values are the price of Apple stock at that time, in dollars.
For example, the stock cost $500 at 10:30am, so stock_prices_yesterday[60] = 500.
 */
object MaxProfit {

	def getMaxProfitPossible(prices: Array[Int]):Int={
		var min = -1
		var maxProfit = 0
		prices.foreach{
			price =>
				val possibleProfit = if(min >= 0 ) {
					price - min
				}else{
					0
				}
				if(price < min || min < 0){
					min = price
				}
				if(possibleProfit > maxProfit){
					maxProfit = possibleProfit
				}
				//println(s"$min,$maxProfit")
		}
		maxProfit
	}

	def main(args:Array[String]): Unit ={
		println(getMaxProfitPossible(Array[Int](10,1,9,20)))
	}


}
