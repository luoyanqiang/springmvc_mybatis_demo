package cn.fish.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse, Object o, Exception e) {

        CustomException customException = null;
        if(e instanceof CustomException) {
            customException = (CustomException) e;
        } else {
            customException = new CustomException("未知错误");
        }

        String message = customException.getMessage();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
