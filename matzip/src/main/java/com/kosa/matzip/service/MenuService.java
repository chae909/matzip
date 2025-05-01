package com.kosa.matzip.service;

import com.kosa.matzip.domain.Menu;
import com.kosa.matzip.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<Menu> selectById(int id) {
        List<Menu> menus = menuMapper.findByRestaurantId(id);
        System.out.println("불러온 메뉴 수: " + menus.size());
        for (Menu menu : menus) {
            System.out.println(menu);
        }
        return menus;
    }
}
