package com.forms.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcConnectionFactory {
	public DataSource dataSource;

	public JdbcConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/adriana");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
