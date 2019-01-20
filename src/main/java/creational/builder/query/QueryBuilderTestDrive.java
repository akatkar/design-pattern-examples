package creational.builder.query;

/**
 *
 * @author Ali Katkar
 */
public class QueryBuilderTestDrive {

    public static void main(String[] args) {
        String query = QueryBuilder.project("project")
                .tag("jobName", "thisJob")
                .lastWeek()
                .desc()
                .build();
        System.out.println("Query is: " + query);
        
        query = QueryBuilder.project("project")
                .ci("continus_integration")
                .build();
        System.out.println("Query is: " + query);
        
    }
}
