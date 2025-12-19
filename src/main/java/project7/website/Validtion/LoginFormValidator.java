package project7.website.Validtion;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm form = (LoginForm) target;

        if (StringUtils.isEmpty(form.getLoginId())) {
            errors.rejectValue("loginId", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getLoginId().length() < 4 || form.getLoginId().length() > 30) {
            errors.rejectValue("loginId", "length", "4~30자로 입력해주세요.");
        }

        if (StringUtils.isEmpty(form.getPassword())) {
            errors.rejectValue("password", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getPassword().length() < 4 || form.getPassword().length() > 61) {
            errors.rejectValue("password", "length", "4~61자로 입력해주세요.");
        }
    }
}
