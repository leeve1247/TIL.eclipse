package kr.or.connect.guestbook.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer{
	private String driverClassName = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";
	private String username = "connectuser";
	private String password = "1234";
	
	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setJdbcUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}

}
