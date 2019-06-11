package com.S98809.fractalTools.controller;
import com.S98809.fractalTools.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class FractalController {
    @RequestMapping(value = "/speransky",method = RequestMethod.POST)

    public String submitForm(@ModelAttribute ("speransky") Speransky speransky, Model model) throws IOException {

        speransky.drawFractal();
        model.addAttribute("addInfo"," "+speransky.getIteration());
        model.addAttribute("imgname","speransky.png");
        return "add_speransky";
    }

    @RequestMapping(value = "/speransky",method = RequestMethod.GET)
    public String showForm(@ModelAttribute Speransky speransky, Model model)
    {
        model.addAttribute("speransky",new Speransky());

        return "add_speransky";

    }


///-------------------------------------------------------------------------------
    @RequestMapping(value = "/circus",method = RequestMethod.POST)
    public String submitFormC(@ModelAttribute ("circus") Circus circus, Model model) throws IOException {

        circus.drawFractal();
        model.addAttribute("addInfo"," "+circus.getIteration());
        model.addAttribute("imgname","circus.png");
        return "add_circus";
    }

    @RequestMapping(value = "/circus",method = RequestMethod.GET)
    public String showFormC(@ModelAttribute Circus circus, Model model)
    {

        model.addAttribute("circus",new Circus());
        return "add_circus";
    }

    ///------------------------------------------------------------------
    @RequestMapping(value = "/tfractal",method = RequestMethod.POST)
    public String submitFormТ(@ModelAttribute ("tfractal") TFractal tfractal, Model model) throws IOException {

        tfractal.drawFractal();
        model.addAttribute("addInfo"," "+ tfractal.getIteration());
        model.addAttribute("imgname","tfract.bmp");

        return "add_tfract";
    }


    @RequestMapping(value = "tfractal",method = RequestMethod.GET)
    public String showFormТ(@ModelAttribute TFractal tfractal, Model model)
    {
        model.addAttribute("tfractal",new TFractal());
        return "add_tfract";

    }
    /////////////////////------------------------------------------------

    @RequestMapping(value = "/mandelbrot",method = RequestMethod.POST)
    public String submitFormM(@ModelAttribute ("mandelbrot") Mandelbrot mandelbrotFract, Model model) throws IOException {

        mandelbrotFract.drawFractal();

        model.addAttribute("addInfo"," "+ mandelbrotFract.getIteration());
        model.addAttribute("imgname","mandelbrot.bmp");

        return "add_mandelbrot";
    }


    @RequestMapping(value = "/mandelbrot",method = RequestMethod.GET)
    public String showFormM(@ModelAttribute Mandelbrot mandelbrotFract, Model model)
    {
        model.addAttribute("mandelbrot",new Mandelbrot());
        return "add_mandelbrot";

    }

    ///-------------------------------------------------------------------
    @RequestMapping(value = "/julia",method = RequestMethod.POST)
    public String submitFormJ(@ModelAttribute ("julia") Julia juliaFractal, Model model)  {

        try {
            juliaFractal.drawFractal();
            System.out.println(" нарисовал ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("addInfo"," x "+juliaFractal.getAx()+" y "+juliaFractal.getBx());
        model.addAttribute("imgname","julia.bmp");

        return "add_julia";
    }


    @RequestMapping(value = "/julia",method = RequestMethod.GET)
    public String showFormJ(@ModelAttribute Julia  juliaFractal, Model model)
    {
        model.addAttribute("julia",new Julia());
        return "add_julia";

    }


}
