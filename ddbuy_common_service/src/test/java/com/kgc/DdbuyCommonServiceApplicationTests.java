package com.kgc;

import com.kgc.entity.TbContentCategory;
import com.kgc.mapper.TbContentCategoryMapper;
import com.kgc.service.SolrService;
import com.kgc.service.TbContentCategoryService;
import com.kgc.service.TbItemService;
import com.kgc.util.DataGridResult;
import com.kgc.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DdbuyCommonServiceApplicationTests {
    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Autowired
    private TbContentCategoryService tbContentCategoryService;
    @Autowired
    private SolrService solrService;
    @Autowired
    private TbItemService tbItemService;

    @Test
    public void contextLoads() {
      /*  List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(null);
        for (TbContentCategory t :tbContentCategories) {
            System.out.println(t);
        }*/
        Page page = new Page();
        DataGridResult<TbContentCategory> allTbContentCategory = tbContentCategoryService.getAllTbContentCategory(page);
        List<TbContentCategory> rows = allTbContentCategory.getRows();
        System.out.println("================"+allTbContentCategory.getTotal());
        for (TbContentCategory tbContentCategory : rows) {
            System.out.println(tbContentCategory);
        }

    }
    @Test
    public void solrTest(){
        boolean f = solrService.importIndex();
        System.out.println(f);
    }
    @Test
    public void freemarkerTest(){
        boolean b = tbItemService.processHtml();
        System.out.println(b);
    }
}
