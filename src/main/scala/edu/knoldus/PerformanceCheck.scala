package edu.knoldus
import java.sql.Connection

import edu.knoldus.csvinterface.CSVFileReader
import edu.knoldus.database.DataBase
import edu.knoldus.models.QueryInfo

/**
  * Created by Neelaksh on 2/8/17.
  */
class PerformanceCheck(val dataBase: DataBase) {

  def testQueryPerformance(query: String, connection: Connection): Long = {
    val current = System.currentTimeMillis()
    dataBase.executeQuery(query, connection)
    System.currentTimeMillis() - current
  }


  def testFile(fileName: String): List[List[String]] = {
    val csvData = new CSVFileReader(fileName).read()
    val parsedData = new QueryInfoParser().parsedata(csvData)
    getTimeOfAllQueries(parsedData)

  }

  def getTimeOfAllQueries(parsedData:List[QueryInfo]):List[List[String]] = {
    lazy val connection = dataBase.createConnection()
    try {
      for {
        queryInfo <- parsedData
        _ = testQueryPerformance(queryInfo.precondition, connection)
        time = testQueryPerformance(queryInfo.query, connection)
        _ = testQueryPerformance(queryInfo.postcondition, connection)
      } yield List(queryInfo.id.toString,queryInfo.description,time.toString)
    }
    catch {
      case e:Exception => throw e
    }
    finally {
      connection.close()
    }
  }
}
