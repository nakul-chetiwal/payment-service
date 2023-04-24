package com.learning.paymentservice.utils;


import com.learning.paymentservice.business.repository.documents.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public Long getSequenceNumber(String sequenceName) {
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        DbSequence counter = mongoOperations
                .findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
