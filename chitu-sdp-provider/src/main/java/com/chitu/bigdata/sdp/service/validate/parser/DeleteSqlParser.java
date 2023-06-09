package com.chitu.bigdata.sdp.service.validate.parser;

import com.chitu.bigdata.sdp.service.validate.domain.SqlSegment;

/**
 * DeleteSqlParser
 *
 * @author wenmo
 * @since 2021/6/14 16:51
 */
public class DeleteSqlParser extends BaseSingleSqlParser {

    public DeleteSqlParser(String originalSql) {
        super(originalSql);
    }

    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(delete\\s+from)(.+)( where | ENDOFSQL)", "[,]"));
        segments.add(new SqlSegment("(where)(.+)( ENDOFSQL)", "(and|or)"));
    }

}
