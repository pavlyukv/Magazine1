package ua.lviv.pancha.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.pancha.entity.Group;
import ua.lviv.pancha.repository.GroupRepo;
import ua.lviv.pancha.services.GroupService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
@Service
public class GroupServiceImpl implements GroupService
{
    @Autowired
    private GroupRepo groupRepo;

    public List<Group> findAllByGroup(Group group)
    {
        List<Group> groupList = groupRepo.findByGroup(group);

        // Sort by Name
        Collections.sort(groupList, new Comparator<Group>()
        {
            @Override
            public int compare(Group o1, Group o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return groupList;
    }

    public void add(String name, String id)
    {
        Group group = new Group();
        group.setName(name);
        int i = Integer.parseInt(id);
        if (i > 0)
            group.setGroup(findOne(i));
        groupRepo.save(group);
    }

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
