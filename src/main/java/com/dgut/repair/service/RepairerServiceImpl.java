package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Repairer;
import com.dgut.repair.dao.RepairerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairerServiceImpl implements RepairerService{
    @Autowired
    private RepairerRepository repairerRepository;
    public Response getRepairer(String name){
        return Response.newSuccess(repairerRepository.findByName(name));
    }
    public Response commentRepairer(int id,int num){
        System.out.println("11111");
        Repairer repairer = repairerRepository.findById(id).orElse(null);
        System.out.println(repairer);
        if(num==0){
            repairer.setPositive_reviews(repairer.getNegative_reviews()+1);
        }else if(num==1){
            repairer.setNeutral_reviews(repairer.getNeutral_reviews()+1);
        }else{
            repairer.setNegative_reviews(repairer.getNegative_reviews()+1);
        }
        repairerRepository.save(repairer);
        return Response.newSuccess(repairer);
    }

}
