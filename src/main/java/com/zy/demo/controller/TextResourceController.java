package com.zy.demo.controller;

import com.github.pagehelper.Page;
import com.zy.demo.common.CommonResponse;
import com.zy.demo.entity.TextResource;
import com.zy.demo.service.TextResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource/texts")
public class TextResourceController {

    @Autowired
    TextResourceService textResourceService;

    @PostMapping
    public CommonResponse create(@RequestBody TextResource textResource){
        textResourceService.insert(textResource);
        return new CommonResponse();
    }

    @PutMapping
    public CommonResponse update(@RequestBody TextResource textResource){
        textResourceService.update(textResource);
        return new CommonResponse();
    }

    @DeleteMapping(value = "{id}")
    public CommonResponse delete(@PathVariable(value = "id") Integer id){
        textResourceService.delete(id);
        return new CommonResponse();
    }

    @GetMapping
    public CommonResponse get(Integer current, Integer pageSize){
        Page result = textResourceService.get(current, pageSize);
        return new CommonResponse(result);
    }

    @GetMapping(value = "{id}")
    public CommonResponse get(@PathVariable(value = "id") Integer id){
        TextResource textResource = textResourceService.get(id);
        return new CommonResponse(textResource);
    }
}
