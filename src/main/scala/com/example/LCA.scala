package com.example

/**
 * Created by aragipindi on 4/28/15.
 */
object LCA {

	case class Node(data:Int,left:Option[Node],right:Option[Node])


	def lowestCommonAncestor(root:Option[Node],a:Node,b:Node):Option[Node]={
		if(!root.isDefined){
			None
		}else if(root.exists(n => n==a || n==b )){
			root
		}else{
			val left:Option[Node] = lowestCommonAncestor(root.flatMap(_.left),a,b)
			val right:Option[Node] = lowestCommonAncestor(root.flatMap(_.right),a,b)

			if(left.isDefined && right.isDefined){
				root
			}else if(left.isDefined){
				left
			}else{
				right
			}
		}
	}

	def main(args:Array[String])={

	}


}
