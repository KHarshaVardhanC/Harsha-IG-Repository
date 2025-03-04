package com.ig.dao;

import java.util.List;
import com.ig.model.Scholar;
import com.ig.exception.ScholarNotFoundException;

public interface ScholarDao {
    void addScholar(Scholar scholar);
    List<Scholar> listAllScholars();
    Scholar getOneScholar(int scholarId) throws ScholarNotFoundException;
    void updateScholarEmail(int scholarId, String email) throws ScholarNotFoundException;
    void deleteScholarById(int scholarId) throws ScholarNotFoundException;
}
