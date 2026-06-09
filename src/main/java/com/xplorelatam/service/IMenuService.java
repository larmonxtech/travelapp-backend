package com.xplorelatam.service;

import com.xplorelatam.model.Menu;

import java.util.List;

public interface IMenuService extends IGenericService<Menu, Integer> {
    List<Menu> getMenusByUsername();
}
