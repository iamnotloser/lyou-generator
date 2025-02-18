package com.leeyou.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {

    public static void main(String[] args){
        String projectPath = System.getProperty("user.dir");
        System.out.println("当前项目路径："+projectPath);
        String inputPath = projectPath + File.separator+ "lyou-generator-demo-projects"+ File.separator+ "acm-template";

        //输出路径
        String outputPath = projectPath;

        copyFilesByHutool(inputPath,outputPath);


    }

    /**
     * 拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath , String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

}
