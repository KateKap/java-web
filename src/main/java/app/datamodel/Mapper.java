package app.datamodel;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Mapper {

    @Select("SELECT * FROM shop")
    public List<Shop> selectAllShops();
}
