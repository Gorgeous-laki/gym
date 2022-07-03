//package com.laki.gymdemo.controller;
//
//import com.laki.gymdemo.entity.Result;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * 前端控制器
// */
//@Controller
//@RequestMapping("/admin")
//public class WebController {
//    /**
//     * 如果满足权限则跳转到这个页面
//     * @param id
//     * @return
//     */
//    @GetMapping("/{id}")
//    @ResponseBody
//    @RequiresPermissions("sys:user:info")
//    public Result get(@PathVariable Integer id) {
//        return Result.ok();
//    }
//
//
//}
