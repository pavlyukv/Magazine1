package ua.lviv.pancha.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.pancha.entity.User;
import ua.lviv.pancha.repository.UserRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vasyl.Pavlyuk on 16.08.2016.
 */
@Component
public class UserValidator implements Validator
{
    @Autowired
    private UserRepo userRepo;

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

        // check e-mail
        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = pattern.matcher(user.getEmail());
        if (!matcher.matches() && !errors.hasFieldErrors("email"))
            errors.rejectValue("email", "bad.email");
        else if (userRepo.findByLogin(user.getEmail()) != null)
            errors.rejectValue("email", "email.used");

        // check phone
        pattern = Pattern.compile("^(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*$");
        matcher = pattern.matcher(user.getPhone());
        if (!matcher.matches() && !errors.hasFieldErrors("phone"))
            errors.rejectValue("phone", "bad.phone");
        else if (userRepo.findByLogin(user.getPhone()) != null)
            errors.rejectValue("phone", "phone.used");

        // check password
        if ((user.getPassword().length() > 0) && (user.getPassword().length() < 6))
        {
            errors.rejectValue("password", "password.short");
        }
        if (!user.getPassword().equals(user.getPasswordConfirm()) && !errors.hasFieldErrors("password"))
        {
            errors.rejectValue("password", "bad.password");
        }
    }
}
