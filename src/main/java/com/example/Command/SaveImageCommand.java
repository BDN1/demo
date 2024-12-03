package com.example.Command;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import com.example.Modele.ImageModel;
import com.example.Modele.Perspective;

public class SaveImageCommand implements ICommand{
    private Perspective perspective;
    private ImageModel imageModel;
    private String imagePath;
    private String newPath;

    public SaveImageCommand(Perspective perspective,String newPath,ImageModel imageModel,String imagePath){
        this.perspective = perspective;
        this.newPath = newPath;
        this.imagePath = imagePath;
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        try {
            BufferedImage img = ImageIO.read(new File(imagePath));

            BufferedImage iBufferedImage = new BufferedImage((int)(img.getWidth()), (int)(img.getHeight()),BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = iBufferedImage.createGraphics();
            g2d.scale(perspective.getScale(), perspective.getScale());
            g2d.drawImage(img, (int)(perspective.getX()), (int)(perspective.getY()),null);
            g2d.dispose();

            FileOutputStream fileOutputStream = new FileOutputStream(newPath);
            ImageIO.write(iBufferedImage, "png", fileOutputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
