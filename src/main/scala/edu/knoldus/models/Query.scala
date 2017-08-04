package edu.knoldus.models

/**
  * Created by Neelaksh on 1/8/17.
  */
case class QueryInfo(id:Int,description:String,precondition:String,query:String,postcondition:String)

object QueryInfo{
  val QUERYID = 0
  val QUERYDESC = 1
  val PRECOND = 2
  val QUERY = 3
  val POSTCOND = 4
  def apply(queryInfo:List[String]): QueryInfo ={
    new QueryInfo(queryInfo(QUERYID).toInt,queryInfo(QUERYDESC),queryInfo(PRECOND),queryInfo(QUERY),queryInfo(POSTCOND))
  }
}
