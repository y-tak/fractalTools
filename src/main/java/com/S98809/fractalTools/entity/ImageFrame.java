package com.S98809.fractalTools.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageFrame extends JFrame
{

    private  String nameFile;
    public ImageFrame(String nameFile)

    {
        this.nameFile=nameFile;
        setTitle(nameFile.substring(0, nameFile.lastIndexOf('.')));

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Добавление компонента к фрейму.

        ImageComponent component = new ImageComponent(nameFile);
        add(component);
    }
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

class ImageComponent extends JComponent {
    public ImageComponent(String nameFile) {

        // Получаем изображения.
        try {
            image = ImageIO.read(new File("src/" + nameFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        if (image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // Отображение рисунка в левом верхнем углу.
        g.drawImage(image, 0, 0, null);

    }

    private Image image;
}
