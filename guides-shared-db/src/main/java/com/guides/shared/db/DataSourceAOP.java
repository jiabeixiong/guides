package com.guides.shared.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.guides.shared.db.annotations.TargetDataSource;

@Aspect
@Component
@Order(-1)
public class DataSourceAOP {

	@Pointcut("@annotation(com.guides.shared.db.annotations.TargetDataSource)")
	public void targetDataSourcePointcut() {
		
	}

	@Before(value="execution(* com.guides.shared.db.service.impl..*.*(..))")
	public void before(JoinPoint   joinPoint) throws NoSuchMethodException, SecurityException {
		System.out.println("--------------before method-----------------");
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		// 代理目标对象Class
		Class targetClazz = joinPoint.getTarget().getClass();

		Method method = targetClazz.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

		Annotation[] annotations = method.getAnnotations();
		
		List<Annotation> annoList = Arrays.asList(annotations);
		Class<TargetDataSource> o = TargetDataSource.class;
		annoList.forEach(anno ->{
			if(anno.annotationType().getName().equals(TargetDataSource.class.getName())) {
				TargetDataSource targetDataSource = (TargetDataSource) anno;
				DataSourceHandler.putDataSourceTarget(targetDataSource.value());
			}
		});
		
		
	}

}
