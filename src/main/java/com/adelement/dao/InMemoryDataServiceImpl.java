package com.adelement.dao;

import com.adelement.model.Button;
import com.adelement.model.HeadLine;
import com.adelement.model.SubHeadLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meetansh on 11-09-2016.
 */
public class InMemoryDataServiceImpl implements DataService {

    @Override
    public List<HeadLine> getAllHeadlines() {

        HeadLine headLine=new HeadLine();
        headLine.setHeadline("this is headline");
        List<HeadLine> list=new ArrayList<>();
        list.add(headLine);
        return list;
    }
    @Override
    public List<SubHeadLine> getAllSubHeadlines() {
        return null;
    }

    @Override
    public List<String> getImagesPath() {
        return null;
    }

    @Override
    public List<Button> getAllButtons() {
        return null;
    }

    @Override
    public boolean saveAds(String headline, String subHeadline, String image, String button) {
        return false;
    }
}
