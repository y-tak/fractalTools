package com.S98809.fractalTools.controller;
import com.S98809.fractalTools.entity.Circus;
import com.S98809.fractalTools.entity.Speransky;
import com.S98809.fractalTools.entity.Tfractal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FractalController {
    @RequestMapping(value = "/speransky",method = RequestMethod.POST)
//    public String submitForm(@RequestParam(name = "iteration",required=true,defaultValue = "1") String iteration,
//                                Model model)

    public String submitForm(@ModelAttribute Speransky speransky,Model model)
    {

        speransky.drawSperansky();
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
    public String submitFormC(@ModelAttribute Circus circus, Model model)
    {

        circus.drawCircFract();
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
    public String submitFormТ(@ModelAttribute Tfractal tfractal, Model model)
    {

        tfractal.drawTFract();
        model.addAttribute("addInfo"," "+ tfractal.getIteration());
        model.addAttribute("imgname","tfract.bmp");

        return "add_tfract";
    }


    @RequestMapping(value = "tfractal",method = RequestMethod.GET)
    public String showFormТ(@ModelAttribute Tfractal tfractal, Model model)
    {
        model.addAttribute("tfractal",new Tfractal());

        return "add_tfract";

    }
    /////////////////////------------------------------------------------

}
