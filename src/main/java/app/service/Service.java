package app.service;

import app.datamodel.Mapper;
import app.datamodel.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Service {

    @Autowired
    private Mapper mapper;

    public List<Shop> selectAllShops() {
        return mapper.selectAllShops();
    }

}