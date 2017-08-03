package edu.knoldus.csvinterface

import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.BeforeAndAfter

import scala.io.BufferedSource

/**
  * Created by Neelaksh on 3/8/17.
  */
class CSVFileReaderTest extends org.scalatest.FunSuite with BeforeAndAfter with MockitoSugar{
  test("check Io"){
    val data = List(List("1"),List("random query"),List("Drop table if exists CUSTOMERS;"),
      List("CREATE TABLE CUSTOMERS(ID   INT  NOT NULL,NAME VARCHAR (20) NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ,SALARY DECIMAL (18, 2), PRIMARY KEY (ID));"),
      List("Drop table if exists CUSTOMERS;"))
    val bufferedIterator = mock[BufferedSource]

    when(bufferedIterator.getLines())
      .thenReturn(Iterator("1, random query, \"Drop table if exists CUSTOMERS;\"," +
        "\"CREATE TABLE CUSTOMERS(ID   INT  NOT NULL,NAME VARCHAR (20) NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ,SALARY DECIMAL (18, 2), PRIMARY KEY (ID));\"," +
        " \"Drop table if exists CUSTOMERS;\"",
        "1, random query, \"Drop table if exists CUSTOMERS;\",\"CREATE TABLE CUSTOMERS(ID INT  NOT NULL,NAME VARCHAR (20)NOT NULL, AGE  INT NOT NULL, ADDRESS  CHAR (25) ,SALARY   DECIMAL (18, 2), PRIMARY KEY (ID));\", \"Drop table if exists CUSTOMERS;\""))

    val actualop =new CSVFileReader("Abc").generateData(bufferedIterator).head
    assert(actualop == data)

  }
}
