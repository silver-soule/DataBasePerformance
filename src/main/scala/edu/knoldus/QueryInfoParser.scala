package edu.knoldus

import edu.knoldus.models.QueryInfo

/**
  * Created by Neelaksh on 2/8/17.
  */
class QueryInfoParser {
  def parsedata(csvData:List[List[String]]) : List[QueryInfo] = {
    csvData.map(x=>QueryInfo.apply(x))
  }
}
