package project7.website.Validtion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;
import project7.website.Database.Repository.member.Member;

@Slf4j
@Component
public class SignupFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member form = (Member) target;

        // email 검증
        if (StringUtils.isEmpty(form.getEmail())) {
            errors.rejectValue("email", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getEmail().length() < 4 || form.getEmail().length() > 100) {
            errors.rejectValue("email", "length", "100자 이내로 입력해주세요.");
        }

        // loginId 검증
        if (StringUtils.isEmpty(form.getLoginId())) {
            errors.rejectValue("loginId", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getLoginId().length() < 4 || form.getLoginId().length() > 30) {
            errors.rejectValue("loginId", "length", "4~30자로 입력해주세요.");
        }

        // name 검증
        if (StringUtils.isEmpty(form.getName())) {
            errors.rejectValue("name", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getName().length() < 4 || form.getName().length() > 20) {
            errors.rejectValue("name", "length", "4~20자로 입력해주세요.");
        }

        // password 검증
        if (StringUtils.isEmpty(form.getPassword())) {
            errors.rejectValue("password", "empty", "공백은 입력할 수 없습니다.");
        } else if (form.getPassword().length() < 4 || form.getPassword().length() > 61) {
            errors.rejectValue("password", "length", "4~61자로 입력해주세요.");
        }
    }
}
