package edu.knoldus.database

/**
  * Created by Neelaksh on 2/8/17.
  */
class MySql (val userName:String , val password:String) extends DataBase {
  val driver :String = "com.mysql.jdbc.Driver"
  val url :String = "jdbc:mysql://localhost/potato?autoReconnect=true&useSSL=false"
}
