package edu.knoldus.database

/**
  * Created by Neelaksh on 2/8/17.
  */
class Sqlite(val userName:String, val password:String) extends DataBase {
  val driver :String = "org.sqlite.JDBC"
  val url :String = "jdbc:sqlite:/home/gitika/sample.db"

}
