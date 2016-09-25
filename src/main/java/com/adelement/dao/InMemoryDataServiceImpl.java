package com.adelement.dao;

import ch.qos.logback.core.util.FileUtil;
import com.adelement.model.Ads;
import com.adelement.model.Button;
import com.adelement.model.HeadLine;
import com.adelement.model.SubHeadLine;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileSystemUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Meetansh on 11-09-2016.
 */
public class InMemoryDataServiceImpl implements DataService {

    @Override
    public List<HeadLine> getAllHeadlines() {
        return readHeadLines();
    }
    @Override
    public List<SubHeadLine> getAllSubHeadlines() {
        return readSubHeadLines();
    }

    @Override
    public List<String> getImagesPath() {
        return readImages();
    }

    @Override
    public List<Button> getAllButtons() {
        return readButton();
    }

    @Override
    public boolean saveAds(Ads ads) {
        return false;
    }

    private List<HeadLine> readHeadLines(){
        List<HeadLine> list=new ArrayList<>();
        int counter = 0;
        Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("filedatasource/headlines"))).lines();
        stream.forEach(line -> {
            String[] split = line.split(",");
            HeadLine headLine=new HeadLine();
            headLine.setHid(Integer.parseInt(split[0]));
            headLine.setHeadline(split[1]);
            list.add(headLine);
        });

        return list;
    }
    private List<SubHeadLine> readSubHeadLines(){
        List<SubHeadLine> list=new ArrayList<>();
        int counter = 0;
        Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("filedatasource/subheadlines"))).lines();
        stream.forEach(line -> {
            String[] split = line.split(",");
            SubHeadLine subheadLine=new SubHeadLine();
            subheadLine.setShid(Integer.parseInt(split[0]));
            subheadLine.setSubheadline(split[1]);
            list.add(subheadLine);
        });
        return list;
    }

    private List<String> readImages(){
        List<String> list=new ArrayList<>();
        int counter = 0;
        Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("filedatasource/images"))).lines();
        stream.forEach(line -> {
            list.add(line);
        });
        return list;
    }

    private List<Button> readButton(){
        List<Button> list=new ArrayList<>();
        int counter = 0;
        Stream<String> stream = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("filedatasource/buttons"))).lines();
        stream.forEach(line -> {
            Button btn = new Button();
            String[] split = line.split(",");
            btn.setBtbid(Integer.parseInt(split[0]));
            btn.setBtnLabel(split[1]);
            list.add(btn);
        });
        return list;
    }
}

