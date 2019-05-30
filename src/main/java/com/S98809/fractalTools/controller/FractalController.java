package com.S98809.fractalTools.controller;
import com.S98809.fractalTools.entity.Speransky;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FractalController {



    @RequestMapping(value = "/speransky/add",method = RequestMethod.POST)
    public String showFractalSperansky(@RequestParam(name = "iteration",required=true, defaultValue = "1") String iteration,
                                Model model)
    {
//        Speransky speransky=new Speransky();
//        speransky.setIteration(nn);
//        speransky.drawSperansky();
//        System.out.println("нажал");

        model.addAttribute("addInfo","количество итераций = "+iteration);
        return "add_speransky";
    }

    @RequestMapping(value = "/speransky/add",method = RequestMethod.GET)
    public String showForm(@ModelAttribute Speransky speransky, Model model)
    {
        model.addAttribute("speransky",new Speransky());
        return "add_speransky";

    }


}
