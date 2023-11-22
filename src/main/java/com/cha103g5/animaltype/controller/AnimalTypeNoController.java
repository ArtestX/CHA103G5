package com.cha103g5.animaltype.controller;

import com.cha103g5.animaltype.Service.AnimalTypeService;
import com.cha103g5.animaltype.model.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Controller
@Validated
@RequestMapping("/animalType")
public class AnimalTypeNoController {

    @Autowired
    AnimalTypeService animalTypeService;

    @PostMapping("/getOneForDisplay")
    public String getOneForDisplay(
            @NotEmpty(message="動物寵類編號: 請勿空白")
            @Digits(integer = 1, fraction = 0, message = "動物寵類編號: 請填數字-請勿超過{integer}位數")
            @Min(value = 1, message = "動物寵類編號: 不能小於{value}")
            @Max(value = 2, message = "動物寵類編號: 不能超過{value}")
            @RequestParam("empno") String animalTypeNo,
            ModelMap model) {

        AnimalType animalType= animalTypeService.getOneAnimalType(Integer.valueOf(animalTypeNo));

        List<AnimalType> list = animalTypeService.getAll();
        model.addAttribute("animalTypeListData", list);
        model.addAttribute("animalType", new AnimalType());

        if (animalType == null) {
            model.addAttribute("errorMessage", "查無資料");
            return "back-end/animaltype/select_page";
        }

        model.addAttribute("animalType", animalType);
        model.addAttribute("getOneForDisplay", "true");

        return "back-end/animaltype/select_page";
    }


    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView handleError(HttpServletRequest req, ConstraintViolationException e, Model model) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations ) {
            strBuilder.append(violation.getMessage() + "<br>");
        }
        List<AnimalType> list = animalTypeService.getAll();
        model.addAttribute("animalTypeListData", list);
        model.addAttribute("animalType", new AnimalType());
        String message = strBuilder.toString();
        return new ModelAndView(
                "back-end/animaltype/select_page",
                "errorMessage",
                "請修正以下錯誤:<br>" + message);
    }

}
