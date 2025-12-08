package project7.website.Database.Repository.member;

import lombok.Getter;

// 회원 가입시 중복 회원가입을 방지 하기위한 예외
@Getter
public class DuplicateMemberException extends RuntimeException {
    private final String field; // "email" 또는 "loginId"

    public DuplicateMemberException(String field, String message) {
        super(message);
        this.field = field;
    }

}