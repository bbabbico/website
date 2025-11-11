package project7.website.Validtion;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;
import project7.website.Validtion.ValidationGroups.*;

// Default.class 는 그룹에 속하지않은 Bean Validation 의 그룹임. // 모든 클래스의 조상 클래스인 object 와 비슷함.
@GroupSequence({Default.class ,NotEmptyGroup.class, NotBlankGroup.class, PatternGroup.class,  SizeGroup.class,  LengthGroup.class, })
public interface ValidationSequence {
}
