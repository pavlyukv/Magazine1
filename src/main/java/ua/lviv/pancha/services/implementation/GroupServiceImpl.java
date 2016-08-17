package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.repository.GroupRepo;
import ua.lviv.pancha.services.GroupService;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Service
public class GroupServiceImpl implements GroupService
{
    @Autowired
    private GroupRepo groupRepo;

    public void addOrEdit(Group group)
    {
        groupRepo.save(group);
    }

    public void delete(int id)
    {
        groupRepo.delete(id);
    }

    public List<Group> findAll()
    {
        return groupRepo.findAll();
    }

    public Group findOne(int id)
    {
        return groupRepo.findOne(id);
    }
}
