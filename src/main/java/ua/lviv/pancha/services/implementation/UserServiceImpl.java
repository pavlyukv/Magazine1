package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.User;
import ua.lviv.pancha.repository.UserRepo;
import ua.lviv.pancha.services.UserService;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 10.08.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {
        User user;

        try
        {
            user = userRepo.findByLogin(login);
        }
        catch (NoResultException e)
        {
            return null;
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), authorities);
    }

    public void addOrEdit(User user)
    {
        userRepo.save(user);
    }

    public void delete(int id)
    {
        userRepo.delete(id);
    }

    public List<User> findAll()
    {
        return userRepo.findAll();
    }

    public User findOne(int id)
    {
        return userRepo.findOne(id);
    }
}
