package edu.knoldus

import edu.knoldus.csvinterface.CSVWriter
import edu.knoldus.database.{MySql, Sqlite}

/**
  * Created by Neelaksh on 2/8/17.
  */
object runStuff extends App{
  val dataBase = new MySql("root","potato123")
  val pc = new PerformanceCheck(dataBase)
  val data = pc.testFile("/home/gitika/IdeaProjects/databasespeedtester/src/main/resources/mycsv.csv")
  new CSVWriter()
}
