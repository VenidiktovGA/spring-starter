package ru.venidiktov.bpp;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AuditBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class<?>> auditBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Transaction.class)) {
            auditBeans.put(beanName, bean.getClass());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = auditBeans.get(beanName);
        if(beanClass != null) {
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("Audit method: " + method.getName());
                        var startTime = System.nanoTime();
                        try {
                            return method.invoke(bean, args);
                        } finally {
                            System.out.println("Time execution: " + (System.nanoTime() - startTime));
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
