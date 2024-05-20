package com.dgut.repair.service;

import com.dgut.repair.Response;

public interface RepairerService {
    public Response getRepairer(String name);
    public Response commentRepairer(int id,int num);
}
