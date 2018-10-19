package com.example.springalltest.common.aspect;

import com.example.springalltest.business.bean.User;
import com.example.springalltest.common.annotation.Log;
import com.example.springalltest.business.bean.SysLog;
import com.example.springalltest.common.util.IPUtils;
import com.example.springalltest.business.service.SysLogService;
import com.example.springalltest.common.util.HttpContextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName LogAspect
 * @Description TODO
 * @Author byp
 * @Date 2018/10/16 13:19
 * @Verison 0.0.1
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.example.springalltest.common.annotation.Log)")
    public void logPointcut() {
    }

    @Around("logPointcut()")
    public Object aroundHandler(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
            // 执行方法
        Object object = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        SysLog sysLog = new SysLog();
        setSysLog(point, (int) time, sysLog);
        // 保存系统日志
        sysLogService.insert(sysLog);
        return object;
    }

    @AfterThrowing(value = "logPointcut()", throwing = "e")
    public void afterThrowingHandler(JoinPoint point, Throwable e) {
        // 保存日志
        String eMsg = "异常：" + AopUtil.getClassNameByJP(point) + "类中的"
                + AopUtil.getMethodNameByJP(point) + "()方法抛出"
                + e.getClass().getName() + "异常";
        // 保存系统日志
        SysLog sysLog = new SysLog();
        setSysLog(point, 0, sysLog);
        sysLog.setContent(eMsg);
        sysLogService.insert(sysLog);
    }

    private void setSysLog(JoinPoint joinPoint, int time, SysLog sysLog) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        sysLog.setContent(AopUtil.getMethodType(methodName));
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append("  ").append(paramNames[i]).append(": ").append(args[i]);
            }
            sysLog.setParams(params.toString());
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 模拟一个用户名
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            sysLog.setUsername(user.getId().toString());
        }
        sysLog.setTime(time);
        Date date = new Date();
        sysLog.setCreateTime(date);
    }
}
