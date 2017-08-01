package edu.knoldus

import java.sql.Connection

/**
  * Created by Neelaksh on 1/8/17.
  */
trait DataBase {
  val driver :String
  val url :String
  protected val username:String
  protected val password:String

}
