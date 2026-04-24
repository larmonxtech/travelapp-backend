package com.xplorelatam.service;

import com.xplorelatam.model.Tag;

import java.util.List;

public interface ITagService {
    Tag save(Tag tag) throws Exception;
    Tag update(Tag tag, Integer id) throws Exception;
    List<Tag> findAll() throws Exception;
    Tag findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
