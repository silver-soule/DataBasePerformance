package edu.knoldus.models

/**
  * Created by Neelaksh on 1/8/17.
  */
case class QueryInfo(id:Int,description:String,precondition:String,query:String,postcondition:String)

object QueryInfo{
  def apply(queryInfo:List[String]): QueryInfo ={

    new QueryInfo(queryInfo(0).toInt,queryInfo(1),queryInfo(2),queryInfo(3),queryInfo(4))
  }
}