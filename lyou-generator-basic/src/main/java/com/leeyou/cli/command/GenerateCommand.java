package com.leeyou.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.leeyou.generator.MainGenerator;
import com.leeyou.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;
@Data
@CommandLine.Command(name = "generate", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable {
    /**
     * 是否生成循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, arity="0..1",description = "是否循环", interactive = true,echo = true)
    private boolean loop = false;

    /**
     * 作者注释
     */
    @CommandLine.Option(names = {"-a", "--author"}, arity="0..1",description = "作者名称", interactive = true,echo = true)
    private String author ="leeyou";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--outputText"}, arity="0..1",description = "输出文本", interactive = true,echo = true)
    private String outputText = "输出结果";



    @Override
    public Object call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
