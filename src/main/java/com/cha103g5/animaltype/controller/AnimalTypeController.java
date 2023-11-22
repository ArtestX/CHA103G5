package com.cha103g5.animaltype.controller;

import com.cha103g5.animaltype.Service.AnimalTypeService;
import com.cha103g5.animaltype.model.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/animalType")
public class AnimalTypeController {

    @Autowired
    AnimalTypeService animalTypeService;

    @GetMapping("/add")
    public String addAnimalType(ModelMap model) {
        AnimalType animalType = new AnimalType();
        model.addAttribute("animalType", animalType);
        return "back-end/animaltype/add";
    }

    @PostMapping("/insert")
    public String insert(@Valid AnimalType animalType,
                         BindingResult result,
                         ModelMap model) {

        if (result.hasErrors()) {
            return "back-end/animaltype/add";
        }

        animalTypeService.addAnimalType(animalType);
        List<AnimalType> list = animalTypeService.getAll();
        model.addAttribute("animalTypeListData", list);
        model.addAttribute("success", "- (新增成功)");
        return "redirect:/animalType/listAll";
    }

    @PostMapping("getOneForUpdate")
    public String getOneForUpdate(@RequestParam("animalTypeNo") String animalTypeNo, ModelMap model) {
        AnimalType animalType = animalTypeService.getOneAnimalType(Integer.valueOf(animalTypeNo));
        model.addAttribute("animalType", animalType);
        return "back-end/animaltype/update";
    }

    @PostMapping("/update")
    public String update(@Valid AnimalType animalType,
                         BindingResult result,
                         ModelMap model) {

        if (result.hasErrors()) {
            return "back-end/animaltype/update";
        }

        animalTypeService.updateAnimalType(animalType);
        model.addAttribute("success", "- (修改成功)");
        animalType = animalTypeService.getOneAnimalType(animalType.getAnimalTypeNo());
        model.addAttribute("animalType", animalType);

        return "back-end/animaltype/listOne";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("animalTypeNo") String animalTypeNo, ModelMap model) {
        animalTypeService.deleteAnimalType(Integer.valueOf(animalTypeNo));
        List<AnimalType> list = animalTypeService.getAll();
        model.addAttribute("animalTypeListData", list);
        model.addAttribute("success", "- (刪除成功)");
        return "back-end/animaltype/listAll";
    }

    @PostMapping("/listByCompositeQuery")
    public String listAllAnimalType(HttpServletRequest req , Model model) {
        Map<String, String[]> map = req.getParameterMap();
        List<AnimalType> list  = animalTypeService.getAll(map);
        model.addAttribute("animalTypeListData", list);
        return "back-end/animaltype/listAll";
    }

}
