package edu.knoldus.database

import java.sql.{Connection, DriverManager}

/**
  * Created by Neelaksh on 1/8/17.
  */
trait DataBase {
  val driver :String
  val url :String
  protected val userName:String
  protected val password:String

  def createConnection(): Connection = {
    try{
      DriverManager.getConnection(url, userName, password)
    }
    catch{
      case ex:Throwable=> throw ex
    }
  }

  def executeQuery(query:String,connection: Connection) : Boolean = {
    val statement = connection.createStatement()
    statement.execute(query)
  }

}
