package com.adelement.dao;

import com.adelement.model.Ads;
import com.adelement.model.Button;
import com.adelement.model.HeadLine;
import com.adelement.model.SubHeadLine;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MySqlDataServiceImpl implements DataService {

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

	public List<SubHeadLine> getAllSubHeadlines() {
		String SQL = "select * from subheadlines";
		List <SubHeadLine> headlines = jdbcTemplate.query(SQL,
				new RowMapper<SubHeadLine>() {
					@Override
					public SubHeadLine mapRow(ResultSet rs, int i) throws SQLException {
						SubHeadLine subHeadLine = new SubHeadLine();
						subHeadLine.setShid(rs.getInt("shid"));
						subHeadLine.setSubheadline(rs.getString("subheadline"));
						return subHeadLine;
					}
				});
		return headlines;
	}

	public List<String> getImagesPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Button> getAllButtons() {
		String SQL = "select * from buttons";
		List <Button> headlines = jdbcTemplate.query(SQL,
				new RowMapper<Button>() {
					@Override
					public Button mapRow(ResultSet rs, int i) throws SQLException {
						Button button = new Button();
						button.setBtbid(rs.getInt("btnid"));
						button.setBtnLabel(rs.getString("label"));
						return button;
					}
				});
		return headlines;
	}

	public boolean saveAds(Ads ads) {
		String headline = ads.getHeadline();
		String subHeadline = ads.getSubheadline();
		String image = ads.getImageurl();
		String button = ads.getButton();
		int hashCode = (headline + subHeadline + image + button).hashCode();
		String update = "INSERT INTO saved_ads (adsid,headline,subheadline,imagesurl,button) VALUES(?,?,?,?,?);";
		System.out.println("Saving Ads : " + ads);
		jdbcTemplate.update(update,new Object[]{hashCode, headline,subHeadline,image,button});
		return false;
	}

}
