import RDS.RdsConnector;

public class RdsWorld {
    public static void main(String[] args) {

        RdsConnector rdsConnector = new RdsConnector();
        rdsConnector.connect();
        /* QUERY 처리 */
        rdsConnector.disconnect();
    }
}
