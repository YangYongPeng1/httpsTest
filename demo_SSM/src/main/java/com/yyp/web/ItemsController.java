package com.yyp.web;



import com.yyp.domain.Items;
import com.yyp.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yang
 * @version V 1.0
 * @date 2018-11-07
 */
@Controller
@RequestMapping("items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("findById")
    public String findById(Integer id, Model model) {
        Items items = itemsService.findById(id);
        model.addAttribute("items",items);
        return "items";

    }
}
