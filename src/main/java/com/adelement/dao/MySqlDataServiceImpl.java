package com.adelement.dao;

import com.adelement.model.HeadLine;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MySqlDataServiceImpl
implements DataService {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public MySqlDataServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<HeadLine> getAllHeadlines() {
		String SQL = "select * from headlines";
		List <HeadLine> headlines = jdbcTemplate.query(SQL,
				new RowMapper<HeadLine>() {
					@Override
					public HeadLine mapRow(ResultSet rs, int i) throws SQLException {
						HeadLine headline = new HeadLine();
						headline.setHid(rs.getInt("hid"));
						headline.setHeadline(rs.getString("headline"));
						return headline;
					}
				});
		return headlines;
	}

	public List<String> getAllSubHeadlines() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getImagesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getAllButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveAds(String headline, String subHeadline, String image,
			String button) {
		// TODO Auto-generated method stub
		return false;
	}

}
