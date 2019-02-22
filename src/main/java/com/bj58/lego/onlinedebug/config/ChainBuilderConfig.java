package com.bj58.lego.onlinedebug.config;

import com.bj58.lego.onlinedebug.builder.impl.BaseChainBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 17:20
 */

@Configuration
public class ChainBuilderConfig {

    @Bean
    public BaseChainBuilder getBaseChainBuilder(){
        BaseChainBuilder baseChainBuilder = new BaseChainBuilder(null);
        return baseChainBuilder;
    }
}
