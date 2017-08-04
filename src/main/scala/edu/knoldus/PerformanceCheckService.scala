package edu.knoldus

import edu.knoldus.csvinterface.CSVWriter
import edu.knoldus.database.{MySql, Sqlite}

/**
  * Created by Neelaksh on 2/8/17.
  */
object PerformanceCheckService extends App{
  val OUTPUTFILE1 = "/home/gitika/IdeaProjects/databasespeedtester/src/main/resources/mysql.csv"
  val dataBase1 = new MySql("root","potato123")
  val pc1 = new PerformanceCheck(dataBase1)
  val data1 = pc1.testFile("/home/gitika/IdeaProjects/databasespeedtester/src/main/resources/mycsv.csv")
  new CSVWriter(OUTPUTFILE1).write(data1)

  val OUTPUTFILE2 = "/home/gitika/IdeaProjects/databasespeedtester/src/main/resources/sqlite.csv"
  val dataBase2 = new Sqlite("","")
  val pc2 = new PerformanceCheck(dataBase2)
  val data2 = pc2.testFile("/home/gitika/IdeaProjects/databasespeedtester/src/main/resources/mycsv.csv")
  new CSVWriter(OUTPUTFILE2).write(data2)

}
