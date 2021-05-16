package com.baomidou.samples.injector;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.samples.injector.entity.Student;
import com.baomidou.samples.injector.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping("test")
    public void test() {
        List<Student> arrayList = new ArrayList<>();
        Student e = new Student();
        e.setUAge(123);
        e.setUName("32432");
        arrayList.add(e);

        Student e1 = new Student();
        e1.setUAge(23);
        e1.setUName("54");
        arrayList.add(e);

        UpdateWrapper<Student> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("u_age", 10)
        ;
        String sqlSegment = updateWrapper.getSqlSegment();


//        studentMapper.update(e, updateWrapper);
        studentMapper.updateBatch(arrayList, updateWrapper);

    }

}
