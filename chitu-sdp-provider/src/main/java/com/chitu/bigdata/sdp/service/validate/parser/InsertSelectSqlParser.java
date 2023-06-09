package com.chitu.bigdata.sdp.service.validate.parser;

import com.chitu.bigdata.sdp.service.validate.domain.SqlSegment;

/**
 * InsertSelectSqlParser
 *
 * @author wenmo
 * @since 2021/6/14 16:53
 */
public class InsertSelectSqlParser extends BaseSingleSqlParser {

    public InsertSelectSqlParser(String originalSql) {
        super(originalSql);
    }

    @Override
    protected void initializeSegments() {
        segments.add(new SqlSegment("(insert\\s+into)(.+)( select )", "[,]"));
        segments.add(new SqlSegment("(select)(.+)(from)", "[,]"));
        segments.add(new SqlSegment("(from)(.+?)( where | on | having | group\\s+by | order\\s+by | ENDOFSQL)", "(,|\\s+left\\s+join\\s+|\\s+right\\s+join\\s+|\\s+inner\\s+join\\s+)"));
        segments.add(new SqlSegment("(where|on|having)(.+?)( group\\s+by | order\\s+by | ENDOFSQL)", "(and|or)"));
        segments.add(new SqlSegment("(group\\s+by)(.+?)( order\\s+by| ENDOFSQL)", "[,]"));
        segments.add(new SqlSegment("(order\\s+by)(.+?)( ENDOFSQL)", "[,]"));
    }
}
