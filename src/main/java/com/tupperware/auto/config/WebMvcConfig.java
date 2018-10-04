package com.tupperware.auto.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot自定义的web配置
 *
 * @author 梦境迷离
 * @version V1.0
 * @time 2018年4月10日 下午4:57:30.
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
//
//        registry.addResourceHandler("/assets/**")
//                .addResourceLocations("classpath:/static/assets/");
//
//        registry.addResourceHandler("/scss/**")
//                .addResourceLocations("classpath:/static/assets/scss/");
//
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("classpath:/static/assets/js/");
//
//        registry.addResourceHandler("/css/**")
//                .addResourceLocations("classpath:/static/assets/css/");
//
//        registry.addResourceHandler("/dark/**")
//                .addResourceLocations("classpath:/static/dark/");
//
//        registry.addResourceHandler("/horizontal/**")
//                .addResourceLocations("classpath:/static/horizontal/");
//
//        registry.addResourceHandler("/material/**")
//                .addResourceLocations("classpath:/static/material/");
//
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/")
                ;



    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * fastJson相关设置
     *
     * @return FastJsonConfig
     * @time 2018年4月10日 下午4:57:40.
     * @version V1.0
     */
    private FastJsonConfig getFastJsonConfig() {

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        List<SerializerFeature> serializerFeatureList = new ArrayList<SerializerFeature>();
        serializerFeatureList.add(SerializerFeature.PrettyFormat);
        serializerFeatureList.add(SerializerFeature.WriteMapNullValue);
        serializerFeatureList.add(SerializerFeature.WriteNullStringAsEmpty);
        serializerFeatureList.add(SerializerFeature.WriteNullListAsEmpty);
        serializerFeatureList.add(SerializerFeature.DisableCircularReferenceDetect);
        SerializerFeature[] serializerFeatures = serializerFeatureList
                .toArray(new SerializerFeature[serializerFeatureList.size()]);
        fastJsonConfig.setSerializerFeatures(serializerFeatures);

        return fastJsonConfig;
    }

    /**
     * fastJson相关设置
     *
     * @return FastJsonHttpMessageConverter4
     * @time 2018年4月10日 下午4:57:52.
     * @version V1.0
     */
    private FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter() {

        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.parseMediaType("application/json"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(getFastJsonConfig());

        return fastJsonHttpMessageConverter;
    }

    /**
     * 添加fastJsonHttpMessageConverter到converters
     *
     * @param converters 消息转化器
     * @time 2018年4月10日 下午4:58:02.
     * @version V1.0
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverter());
    }


}
