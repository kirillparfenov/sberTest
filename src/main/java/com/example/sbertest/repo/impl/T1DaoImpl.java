package com.example.sbertest.repo.impl;

import com.example.sbertest.model.T1;
import com.example.sbertest.repo.abstr.SberRepoAbstract;
import com.example.sbertest.repo.abstr.T1Dao;
import org.springframework.stereotype.Repository;

@Repository
public class T1DaoImpl extends SberRepoAbstract<T1, Long> implements T1Dao {
}
