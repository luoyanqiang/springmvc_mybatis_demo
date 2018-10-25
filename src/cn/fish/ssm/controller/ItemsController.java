package cn.fish.ssm.controller;

import cn.fish.ssm.po.ItemsCustom;
import cn.fish.ssm.po.ItemsQueryVo;
import cn.fish.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value="/queryItems", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody String queryItems(ItemsQueryVo itemsQueryVo) throws Exception {
        System.out.println("ssbbbs");

        List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
        System.out.println("==========");
        System.out.println(list.size());
        System.out.println(list);

        return "SSSS";
    }

    @PostMapping(value="editItems")
    public @ResponseBody String editItems(ServletWebRequest servletWebRequest, Integer id, @Validated ItemsCustom itemsCustom
    , BindingResult bindingResult,  MultipartFile items_pic) throws Exception {
        System.out.println("=======2222222223332222--------");
        if(bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError oe : errors) {
                System.out.println(oe.getDefaultMessage());
            }
            return null;
        }
        System.out.println(id);
        System.out.println(itemsCustom.getName());
        Map map = servletWebRequest.getParameterMap();
        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }
        
        System.out.println(map);

        if(items_pic != null) {
            String fileDir = "E:\\jtest\\pic\\";
            String originalFileName = items_pic.getOriginalFilename();
            String newName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));

            File file = new File(fileDir + newName);
            items_pic.transferTo(file);

            itemsCustom.setPic(newName);
        }

        // ItemsCustom itemsCustom = itemsService.findItemsById(id);
        // itemsCustom.setName("pc");
        // if(createtime != null) {
        //     itemsCustom.setCreatetime(createtime);
        // }
        Integer rs = itemsService.updateItems(itemsCustom.getId(), itemsCustom);
        System.out.println(rs);
        return "success";
    }

    @PostMapping(value = "testJson")
    public @ResponseBody List testJson(@RequestBody ItemsCustom itemsCustom) throws Exception {

        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        itemsQueryVo.setItemsCustom(itemsCustom);
        List list = itemsService.findItemsList(itemsQueryVo);
        return list;
    }

    @PostMapping(value = "testResponseJson")
    public @ResponseBody List testResponseJson(ItemsCustom itemsCustom) throws Exception {

        ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
        itemsQueryVo.setItemsCustom(itemsCustom);
        List list = itemsService.findItemsList(itemsQueryVo);
        return list;
    }


}
