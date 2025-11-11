package project7.website.Validtion;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;
import project7.website.login.LoginForm;

@Component
public class LoginFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm form = (LoginForm) target;

        // loginId 검증
        if (StringUtils.isEmpty(form.getLoginId())) {
            errors.rejectValue("loginId", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getLoginId().length() < 4 || form.getLoginId().length() > 20) {
            errors.rejectValue("loginId", "length", "4~20자로 입력해주세요.");
        }

        // password 검증
        if (StringUtils.isEmpty(form.getPassword())) {
            errors.rejectValue("password", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getPassword().length() < 4 || form.getPassword().length() > 40) {
            errors.rejectValue("password", "length", "4~40자로 입력해주세요.");
        }
    }
}
