package com.leeyou.generator;

import com.leeyou.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.leeyou.generator.DynamicGenerator.doGenerate;
import static com.leeyou.generator.StaticGenerator.copyFilesByHutool;

public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        System.out.println("当前项目路径："+projectPath);
//        String inputPath = projectPath + File.separator+ "lyou-generator-demo-projects"+ File.separator+ "acm-template";
        String inputPath = new File(parentFile, "lyou-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = projectPath;

        copyFilesByHutool(inputPath,outputPath);

//        String dynamicProjectPath = System.getProperty("user.dir") + File.separator + "lyou-generator-basic";
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath+ File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";


        DynamicGenerator.doGenerate( dynamicInputPath, dynamicOutputPath, model);
    }
    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}
