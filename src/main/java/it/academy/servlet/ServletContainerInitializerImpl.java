package it.academy.servlet;

import java.util.Set;
import it.academy.DataConfig;
import it.academy.service.ServiceContextConfig;
import it.academy.web.WebConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);
        context.register(DataConfig.class);
        context.register(ServiceContextConfig.class);

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("*.html");
        servletRegistration.addMapping("*.jpg");
//        servletRegistration.addMapping("/");
        // *.view - GET
        // *.action - POST

    }
}


