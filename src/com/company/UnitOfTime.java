package com.company;

import java.util.*;

public class UnitOfTime {

    //Поля класса: индикатор существования, константна ли задача, индекс задачи
    Boolean bool=false;
    Boolean constt;
    Integer index;

    //Заполнение
    public boolean add(Integer index, Boolean constt) {
        this.constt=constt;
        this.index=index;
        this.bool=true;
        return true;
    }

    //Очистка
    public boolean delete() {
        this.index=null;
        this.bool=false;
        return true;
    }
}
