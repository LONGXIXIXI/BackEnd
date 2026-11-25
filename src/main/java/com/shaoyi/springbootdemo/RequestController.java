package com.shaoyi.springbootdemo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    /**
     * 传递单个参数
     * 使用基本类型来接收参数时，参数必须传，否则会报500错误
     * 类型不匹配时，会报400错误
     * 对于参数肯能为空的数据，建议使用包装类型
     */
    @RequestMapping("/m1")
    public String method1(String name) {
        return "接受到参数name:" + name;
    }

    /**
     * 传递多个参数
     * 当有多个参数时，前后端进行参数匹配时。是以参数名称进行匹配的，因此参数的位置事
     * 不影响后端获取参数的结果的
     */
    @RequestMapping("/m2")
    public String method2(String name, String password) {
        return "接受到参数name:" + name + ", password:" + password;
    }

    /**
     * 传递对象
     * spring会根据参数名称自动绑定到对象的各个属性上，如果某个属性未传递，则赋值为null
     */
    @RequestMapping("/m3")
    public String method3(Person p) {
        return p.toString();
    }

    /**
     * 后端参数重命名
     * 前端传递的参数key和后端接收的key可以不一致，使用@RequestParam来重命名前后端的参数值
     * 使用@RequestParam进行参数重命名时，请求参数只能和@RequestParam中的参数key一致，才能获取到参数值
     * 使用@RequestParam进行参数重命名时，参数值不能为空，否则会报400错误，可以通过设置required来指定参数是否必须
     */
    @RequestMapping("/m4")
    public String method4(@RequestParam(value = "time",required = false) String createTime) {
        return "接受到参数createTime: "+ createTime;
    }

    /**
     * 传递数组
     */
    @RequestMapping("/m5")
    public String method5(String[] arrayParam) {
        return Arrays.toString(arrayParam);
    }

    /**
     * 传递集合
     * 默认情况下，请求中参数名相同的多个值，是封装到数组，如果要封装到集合，要使用@RequestParam绑定参数关系
     */
    @RequestMapping("/m6")
    public String method6(@RequestParam(required = false) List<String> listParam) {
        return listParam.toString();
    }

    /**
     * 传递JSON数据
     * 接收JSON对象，需要使用@RequestBody注解来绑定参数关系
     */
    @RequestMapping("/m7")
    public String method7(@RequestBody Person p) {
        return p.toString();
    }

    /**
     * 获取url中参数
     */
    @RequestMapping("/m8/{id}/{name}")
    public String method8(@PathVariable Integer id, @PathVariable String name) {
        return "解析参数id: " + id + ", name: " + name;
    }

    /**
     * 上传文件
     */
    @RequestMapping("/m9")
    public String method9(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File("E:\\Java\\tmp",filename));

        return "接收到文件名称为: " + file.getOriginalFilename();
    }

}
