package ua.lviv.pancha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.pancha.entity.Group;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
public interface GroupRepo extends JpaRepository<Group, Integer>
{
    List<Group> findByGroup (Group group);
}
