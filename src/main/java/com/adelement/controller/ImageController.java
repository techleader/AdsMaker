package com.adelement.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Meetansh on 13-09-2016.
 */
@RestController
public class ImageController  {

    @Value("${IMAGES_LOCATION}")
    String IMAGES_LOCATION;

    @RequestMapping(value = "/adselement/images/{keyId}.{imageType}", headers="Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    public byte[] getKeyScreenshot(@PathVariable String keyId,@PathVariable String imageType, OutputStream outputStream) {
        try {
            // TODO: this just returns a hardcoded image
            System.out.println("Opening image : " + keyId);
            BufferedImage img=  ImageIO.read(new File(IMAGES_LOCATION  + "/"+keyId+"."+imageType));
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", bao);
            return bao.toByteArray();
        } catch(IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Unable to load image : " + keyId);
        }

    }
}
