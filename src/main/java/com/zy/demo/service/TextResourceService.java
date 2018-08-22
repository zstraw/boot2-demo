package com.zy.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zy.demo.constant.Constant;
import com.zy.demo.constant.GrowthErrorEnum;
import com.zy.demo.dao.TextResourceMapper;
import com.zy.demo.entity.TextResource;
import com.zy.demo.exception.GrowthBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TextResourceService {

    private static Logger logger = LoggerFactory.getLogger(TextResourceService.class);

    @Autowired
    TextResourceMapper textResourceMapper;

    public Page get(Integer start, Integer pageSize){
        if (start == null) {
            start = 0;
        }
        if (pageSize == null) {
            pageSize = Constant.PAGE_SIZE;
        }
        PageHelper.startPage(start, pageSize);
        List<TextResource> textResources = textResourceMapper.selectAll();

        return ((Page<TextResource>) textResources);
    }

    public TextResource get(Integer id){
        if (id == null) {
            return null;
        }
        return textResourceMapper.selectByPrimaryKey(id);
    }

    public void insert(TextResource textResource) {
        logger.info("insert TextResource: {}", textResource);
        if (textResource == null) {
            throw new GrowthBaseException(GrowthErrorEnum.DATA_ERROR);
        }

        textResourceMapper.insert(textResource);
        logger.info("insert TextResource succeed");
    }

    public void update(TextResource textResource) {
        logger.info("update TextResource: {}", textResource);
        if (textResource == null || textResource.getId() == null) {
            throw new GrowthBaseException(GrowthErrorEnum.DATA_ERROR);
        }
        textResourceMapper.updateByPrimaryKey(textResource);
        logger.info("update TextResource succeed.");
    }

    public void delete(Integer id) {
        logger.info("delete TextResource id: {}", id);
        if (id == null) {
            return;
        }
        textResourceMapper.deleteByPrimaryKey(id);
        logger.info("delete TextResource succeed");
    }


}
