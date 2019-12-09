/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.TrainerDao;
import java.util.List;
import model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author omiro
 */
@Controller
@RequestMapping(value = "trainer")
public class TrainerCon {

    // otan 8eloume na ftiaksoume "dao", de kanoume New dao, klp, vazoume:
    @Autowired
    TrainerDao td; // auto einai gia na mi to zitame se ka8e method edw mesa ksexwrista

    @RequestMapping(value = "insert.htm", method = RequestMethod.GET)
    public String insert1(ModelMap mm) {
        Trainer trainer = new Trainer();
        mm.addAttribute("trainer", trainer);
        return "trainer-insert-form";
    }

    @RequestMapping(value = "insert-form.htm", method = RequestMethod.POST)
    public String insert2(ModelMap mm, @ModelAttribute("trainer") Trainer trainer) {
        td.insert(trainer);
        return "forward:/trainer/findall.htm";
    }

    @RequestMapping(value = "findall.htm", method = {RequestMethod.POST, RequestMethod.GET})
    public String insert3(ModelMap mm) {
        List<Trainer> result_show = td.findAll();
        mm.addAttribute("result_show", result_show);
        Trainer trainer = new Trainer();
        mm.addAttribute("trainer", trainer);
        return "showall";
    }

    @RequestMapping(value = "/delete/{someID}.htm", method = RequestMethod.GET)
    public String delete1(ModelMap mm, @PathVariable("someID") String id) {
        int intID = Integer.parseInt(id);
        td.delete(intID);
        List<Trainer> result_show = td.findAll();
        mm.addAttribute("result_show", result_show);
        Trainer trainer = new Trainer();
        mm.addAttribute("trainer", trainer);
        return "showall";
    }

    @RequestMapping(value = "/update/{someID}.htm", method = RequestMethod.GET)
    public String update1(ModelMap mm, @PathVariable("someID") String id) {
        int intID = Integer.parseInt(id);
        Trainer trainerToBeUpdated = new Trainer();
        trainerToBeUpdated = td.getTrainerToBeUpdated(intID);
        mm.addAttribute("trainerToBeUpdated", trainerToBeUpdated);
        List<Trainer> result_show = td.findAll();
        mm.addAttribute("result_show", result_show);
        return "update";
    }

    @RequestMapping(value = "update-form/{someID}.htm", method = RequestMethod.POST)
    public String update2(ModelMap mm, @PathVariable("someID") String id, @ModelAttribute("trainer") Trainer trainer) {
        int intID = Integer.parseInt(id);
        trainer.setTrainerId(intID);
        td.update(trainer);
        return "forward:/trainer/findall.htm";
    }

}
