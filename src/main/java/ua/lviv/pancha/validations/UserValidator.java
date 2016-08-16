package ua.lviv.pancha.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.pancha.entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vasyl.Pavlyuk on 16.08.2016.
 */
@Component
public class UserValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");

        // TODO check all validation!
//        errors.hasFieldErrors("password")
        boolean passwordSwitcher = true;
        if (user.getPassword().length() < 8)
        {
            errors.rejectValue("password", "password.too.short");
            passwordSwitcher = false;
        }
        if (passwordSwitcher)
        {
            if (!user.getPassword().equals(user.getPasswordConfirm()))
            {
                errors.rejectValue("password", "bad.password");
            }
        }

        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher;
        if (!(matcher = pattern.matcher(user.getEmail())).matches())
        {
            errors.rejectValue("email", "bad.email");
        }
    }
}
