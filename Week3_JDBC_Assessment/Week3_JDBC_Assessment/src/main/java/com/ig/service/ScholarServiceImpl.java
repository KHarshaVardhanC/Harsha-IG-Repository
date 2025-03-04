package com.ig.service;

import com.ig.dao.ScholarDao;
import com.ig.dao.ScholarDaoImpl;
import com.ig.exception.ScholarNotFoundException;
import com.ig.model.Scholar;
import java.util.List;

public class ScholarServiceImpl implements ScholarService {
    private ScholarDao scholarDao = new ScholarDaoImpl();

    @Override
    public void addScholar(Scholar scholar) {
        scholarDao.addScholar(scholar);
    }

    @Override
    public List<Scholar> listAllScholars() {
        return scholarDao.listAllScholars();
    }

    @Override
    public Scholar getOneScholar(int scholarId) throws ScholarNotFoundException {
        return scholarDao.getOneScholar(scholarId);
    }

    @Override
    public void updateScholarEmail(int scholarId, String email) throws ScholarNotFoundException {
        scholarDao.updateScholarEmail(scholarId, email);
    }

    @Override
    public void deleteScholarById(int scholarId) throws ScholarNotFoundException {
        scholarDao.deleteScholarById(scholarId);
    }
}
