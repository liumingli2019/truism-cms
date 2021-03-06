package site.liuming.truismcms.web.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.bo.BlogBo;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.vo.PageConditionVo;
import site.liuming.truismcms.web.pojo.Blog;
import site.liuming.truismcms.web.service.BlogService;

import java.util.List;


@RestController
@RequestMapping("/blog")
@Api(value = "博客管理", tags = {"博客管理"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/list")
    public UnifyResponse<PagePojoDto<Blog>> getBlogList(@RequestBody PageConditionVo<BlogBo> pcv) {
        return blogService.getBlogList(pcv);
    }

    @PostMapping("/")
    public UnifyResponse<String> addBlog(@RequestBody BlogBo blogBo){
        return blogService.addBlog(blogBo);
    }

    @PutMapping("/")
    public UnifyResponse<String> updateBlog(@RequestBody BlogBo blogBo) {
        return blogService.updateById(blogBo);
    }

    @PostMapping("/save")
    public UnifyResponse<String> saveDraft(@RequestBody BlogBo blogBo) {
        return blogService.saveDraft(blogBo);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteBlog(@PathVariable("id") Long id) {
        return blogService.deleteBlog(id);
    }

    @GetMapping("/detail/{id}")
    public UnifyResponse<BlogBo> getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("/list/{page}")
    public UnifyResponse<List<Blog>> getBlogListByPage(@PathVariable("page") int page) {
        return blogService.getBlogListByPage(page);
    }

    @GetMapping("/{id}")
    public UnifyResponse<BlogBo> getBlogByIdCMS(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

}
