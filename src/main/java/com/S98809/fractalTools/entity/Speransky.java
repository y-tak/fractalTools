package com.S98809.fractalTools.entity;


import javax.swing.*;
import java.awt.*;

public class Speransky {


    private  String iteration;

    public  void drawSperansky()
    {
        JFrame window = new JFrame("SperanskyFract");

        window.setSize(650, 650);
        window.setContentPane(new SperanskyFractal(Integer.parseInt(iteration)));
        window.setBackground(Color.WHITE);
       // window.se"src/SperanskyFract.png")));
        window.setResizable(false);
        window.setDefaultCloseOperation(3);
        window.setVisible(false);

        System.out.println(" нарисовал " );
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }
}
