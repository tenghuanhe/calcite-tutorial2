package jp.co.worksap.calcite.tutorial;

import java.sql.*;
import java.util.Properties;

import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.SchemaPlus;

/**
 * Created by tenghuanhe on 17-4-11.
 */
public class CalciteTest {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("org.apache.calcite.jdbc.Driver");
    Properties info = new Properties();
    Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
    CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);

    ReflectiveSchema hrSchema = new ReflectiveSchema(new Department());

    SchemaPlus rootSchema = calciteConnection.getRootSchema();
    rootSchema.add("department", hrSchema);

    Statement statement = calciteConnection.createStatement();

    ResultSet resultSet = statement.executeQuery(
        "SELECT * FROM \"department\".\"students\" AS s JOIN \"department\".\"professors\" AS p ON s.\"supervisorNo\" = p.\"id\"");
    // The escape " is a disaster
//    ResultSet resultSet = statement.executeQuery("SELECT * FROM \"department\".\"students\"");
    while (resultSet.next()) {
      for (int i = 1; i < resultSet.getMetaData().getColumnCount() + 1; i++) {
        System.out.print(resultSet.getObject(i) + "\t");
      }
      System.out.println();
    }
  }
}
