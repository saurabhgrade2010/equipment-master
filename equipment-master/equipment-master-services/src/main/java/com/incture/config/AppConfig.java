package com.incture.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;
import java.util.Properties;

@Configuration
@PropertySource("classpath:app.properties")
@EnableWebMvc
@ComponentScan(basePackages = "com.incture")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer  {

	@Autowired
    private Environment environment;
    
    //data source
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(environment.getProperty("spring.jdbc.driverClassName"));
        ds.setUrl(environment.getProperty("spring.jdbc.url"));
        ds.setUsername(environment.getProperty("spring.jdbc.username"));
        ds.setPassword(environment.getProperty("spring.jdbc.password"));
        return ds;
    }

    //hibernate properties
    @Bean
    public Properties props() {
        Properties p = new Properties();
        p.put("hibernate.dialect", environment.getProperty("spring.hibernate.dialect"));
        p.put("hibernate.show_sql", environment.getProperty("spring.hibernate.showsql"));
        p.put("hibernate.format_sql", environment.getProperty("spring.hibernate.fmtsql"));
        p.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.hibernate.ddlauto"));
        return p;
    }

    //session factory
    @Bean
    public LocalSessionFactoryBean sf() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        //factoryBean.setAnnotatedClasses();
        factoryBean.setPackagesToScan("com.incture.model");
        factoryBean.setHibernateProperties(props());
        return factoryBean;
    }


    //hibernate template
    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sf().getObject());
        return hibernateTemplate;
    }

    //hibernate transaction manager
    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager htm = new HibernateTransactionManager();
        htm.setSessionFactory(sf().getObject());
        return htm;
    }

    //view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver i = new InternalResourceViewResolver();
        i.setPrefix(environment.getProperty("spring.mvc.prefix"));
        i.setSuffix(environment.getProperty("spring.mvc.suffix"));
        return i;
    }

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFormatters(FormatterRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}
}
