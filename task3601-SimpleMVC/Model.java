package com.codegym.task.task36.task3601;

import java.util.List;

public class Model {

    Service service = new Service();

    public Model() {

    }

    public List<String> getStringDataList() {
        return service.getData();
    }


}
