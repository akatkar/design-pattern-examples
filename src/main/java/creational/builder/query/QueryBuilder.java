package creational.builder.query;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QueryBuilder {

    private static final String ORDER_BY = " ORDER BY time DESC";
    private static final String JOB_NAME = "jobName";
    private static final String JOB_NAME_TEMPLATE = "jobName =~ /(?i)^%s\\W/";
    private static final String SPLIT_REGEX = "\\s*(/|\\.|\\s)\\s*";
    private static final String CI_VALUE = "[cC]ontinuous[\\W|_]integration|[cC][iI][\\W|_][bB]uilds|CI";
    private static final String RC_VALUE = "[rR]elease[\\W|_][cC]andidate|[rR][cC][\\W|_][bB]uilds|RC";
    private static final String SECURITY_SCAN = "[sS]ecurity[\\W|_][sS]can|[sS]ecurity[\\W|_][cC]heck|[sS]ecurity";
    private static final String LAST_WEEK = "time > now() - 1w";
    private static final String SPACE = " ";
    private static final String AND = " AND ";

    private final StringBuilder queryBuffer = new StringBuilder(1024);
    private String orderClause = "";
    private String limit = "";
    private String timeCondition = "";

    private QueryBuilder(String project) {
        queryBuffer.append(processProjectName(project));
    }

    private String processProjectName(String project) {
        String[] results = project.split(SPLIT_REGEX);        
        String projetName = Arrays.stream(results)
                .collect(Collectors.joining("[\\W]*"));
        return String.format(JOB_NAME_TEMPLATE, projetName);
    }

    public static QueryBuilder project(String project) {
        return new QueryBuilder(project);
    }

    public QueryBuilder lastWeek() {
        timeCondition = LAST_WEEK;
        return this;
    }

    public QueryBuilder lastWeek(int week) {
        timeCondition = "time > now() - " + week + "w";
        return this;
    }

    public QueryBuilder tag(String tag, String value) {
        queryBuffer.append(AND)
                .append(tag)
                //                .append(" =~ /(?i)")
                .append(" =~ /")
                .append(value)
                .append('/');
        return this;
    }

    public QueryBuilder desc() {
        orderClause = ORDER_BY;
        return this;
    }

    public QueryBuilder limit(int n) {
        limit = "LIMIT " + n;
        return this;
    }

    private boolean isEmpty(String str){
        return str == null || "".equals(str);
    }
    
    private void addTag(String value, String defaultValue) {
        this.tag(JOB_NAME, isEmpty(value) ? defaultValue : value);
    }

    public QueryBuilder ci(String value) {
        addTag(value, CI_VALUE);
        return this;
    }

    public QueryBuilder rc(String value) {
        addTag(value, RC_VALUE);
        return this;
    }

    public QueryBuilder ss(String value) {
        addTag(value, SECURITY_SCAN);
        return this;
    }

    public String build() {

        if (!orderClause.isEmpty()) {
            queryBuffer.append(SPACE)
                    .append(orderClause);
        }

        if (!limit.isEmpty()) {
            queryBuffer.append(SPACE)
                    .append(limit);
        }

        if (timeCondition.isEmpty()) {
            return queryBuffer.toString();
        } else {
            return timeCondition + AND + queryBuffer.toString();
        }
    }

    @Override
    public String toString() {
        return build();
    }
}
