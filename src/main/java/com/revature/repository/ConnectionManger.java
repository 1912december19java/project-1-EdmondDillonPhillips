package com.revature.repository;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionManger {

  public abstract Connection getConnection(String url,
      String user,
      String password)
               throws SQLException;
}
