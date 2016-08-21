package ua.lviv.pancha.services;

import ua.lviv.pancha.entity.Group;

import java.util.List;

/**
 * Created by Vasyl.Pavlyuk on 17.08.2016.
 */
public interface GroupService
{
    List<Group> findAllByGroup(Group group);

    void add(String name, String id);

    void addOrEdit(Group group);

    void delete(int id);

    List<Group> findAll();

    Group findOne(int id);
}
