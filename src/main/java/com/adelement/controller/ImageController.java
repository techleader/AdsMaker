package com.adelement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Meetansh on 13-09-2016.
 */
@RestController
public class ImageController  {

    @Value("${IMAGES_LOCATION}")
    String IMAGES_LOCATION;
    ThumbnailGenerator thumbnailGenerator = new ThumbnailGenerator();

    @RequestMapping(value = "/adelement/images/{keyId}.{imageType}", headers="Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    public byte[] getImage(@PathVariable String keyId,@PathVariable String imageType, OutputStream outputStream) {
        try {
            BufferedImage img=  ImageIO.read(new File(IMAGES_LOCATION  + "/"+keyId+"."+imageType));
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch(IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Unable to load image : " + keyId);
        }
    }

    @RequestMapping(value = "/adelement/images/thumbnail/{keyId}.{imageType}", headers="Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    public byte[] getThumbnailImage(@PathVariable String keyId,@PathVariable String imageType, OutputStream outputStream) {
        try {
            File image = new File(IMAGES_LOCATION  + "/"+keyId+"."+imageType);
            File thumb = getThumbNail(image);
            BufferedImage img=  ImageIO.read(thumb);
            thumb.delete();
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch(IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Unable to load image : " + keyId);
        }
    }

    @RequestMapping(value = "/adelement/images/list")
    public String[] getAllImagesNames(){
        List<String> images = new ArrayList<>();
        File file = new File(IMAGES_LOCATION);
        return file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.endsWith("thumbnail");
            }
        });
    }

    private File getThumbNail(File imageUrl) {
        File thumbnail = new File(imageUrl.getAbsolutePath()+"_thumbnail");
        if(thumbnail.exists()) {
            return thumbnail;
        } else {
            try {
                thumbnailGenerator.transform(imageUrl.getAbsolutePath(),thumbnail.getAbsolutePath(),30,30,100);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error while creating thumbnail " + imageUrl);
            }
            return thumbnail;
        }

    }

}
