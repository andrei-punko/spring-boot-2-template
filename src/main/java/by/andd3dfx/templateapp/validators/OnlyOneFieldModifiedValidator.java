package by.andd3dfx.templateapp.validators;

import by.andd3dfx.templateapp.dto.ArticleUpdateDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class OnlyOneFieldModifiedValidator implements ConstraintValidator<OnlyOneFieldModified, ArticleUpdateDto> {

    @Override
    public boolean isValid(ArticleUpdateDto articleUpdateDto, ConstraintValidatorContext context) {
        int count = 0;
        for (Field field : ArticleUpdateDto.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                final Object o = field.get(articleUpdateDto);
                if (o != null) {
                    count++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return count == 1;
    }
}
