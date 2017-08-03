package edu.knoldus

import edu.knoldus.models.QueryInfo
import org.scalatest.FunSuite

/**
  * Created by Neelaksh on 3/8/17.
  */
class QueryInfoParserTest extends FunSuite {

  test("testParseCSV") {
    val elementOne = QueryInfo(List("1","random query","Drop table if exists CUSTOMERS;",
                          "CREATE TABLE CUSTOMERS(ID INT NOT NULL,NAME VARCHAR (20)NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ;",
                           "Drop table if exists CUSTOMERS;"))
    val listOfQueryData = List(List(
        "1", "random query", "Drop table if exists CUSTOMERS;"
          ,"CREATE TABLE CUSTOMERS(ID INT NOT NULL,NAME VARCHAR (20)NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ;", "Drop table if exists CUSTOMERS;"),
      List("2", "random query", "Drop table if exists CUSTOMERS;"
          ,"CREATE TABLE CUSTOMERS(ID INT NOT NULL,NAME VARCHAR (20)NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ;", "Drop table if exists CUSTOMERS;"))
      assert(new QueryInfoParser().parsedata(listOfQueryData).head == elementOne)
  }

}
